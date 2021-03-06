package com.analyzer;

import com.analyzer.data.ResponseData;
import com.analyzer.data.inner.HtmlVersion;
import com.analyzer.data.inner.PageTitle;
import com.analyzer.workers.HeadingWorker;
import com.analyzer.workers.LinksWorker;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.util.List;

public class Analyzer {
	public static final String _HTML_5_DOCTYPE = "<!doctype html>";
	public static final String _PUBLICID = "publicid";
	private static ResponseData responseData;


	public static ResponseData analyze(String url){
		init();
		try {
			Document doc = Jsoup.connect(url).get();
			calculateHtmlVersion(doc);
			calculatePageTitle(doc);
			calculateIsLoginForm(doc);
			responseData.setHeading(HeadingWorker.getData(doc));
			responseData.setLinks(LinksWorker.getData(doc));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseData;
	}

	private static void calculateIsLoginForm(Document doc) {
		boolean isLogin = !doc.select("input[type=password]").isEmpty();
		responseData.setLoginForm(isLogin);
	}

	private static void calculatePageTitle(Document doc) {
		String pageTitle = doc.getElementsByTag("title").text();
		responseData.setPageTitle(new PageTitle(pageTitle));
	}

	private static void init(){
		responseData = new ResponseData();
	}

	private static void calculateHtmlVersion(Document doc){
		DocumentType docType = getDocType(doc.childNodes());
		if (docType != null){
			if (docType.toString().equals(_HTML_5_DOCTYPE))
				responseData.setHtmlVersion(new HtmlVersion("5"));
			else{
				responseData.setHtmlVersion(new HtmlVersion(docType.attr(_PUBLICID)));
			}
		}
	}

	private static DocumentType getDocType(List<Node> nodeList){
		for (Node node : nodeList) {
			if (node instanceof DocumentType){
				return (DocumentType) node;
			}
		}
		return null;
	}
}
