package com.analyzer.data;

import com.analyzer.data.inner.Heading;
import com.analyzer.data.inner.HtmlVersion;
import com.analyzer.data.inner.PageTitle;

public class ResponseData {
	HtmlVersion htmlVersion;
	PageTitle pageTitle;
	Heading heading;

	public HtmlVersion getHtmlVersion() { return htmlVersion; }
	public void setHtmlVersion(HtmlVersion htmlVersion) { this.htmlVersion = htmlVersion; }
	public PageTitle getPageTitle() { return pageTitle; }
	public void setPageTitle(PageTitle pageTitle) { this.pageTitle = pageTitle; }
	public Heading getHeading() { return heading; }
	public void setHeading(Heading heading) { this.heading = heading; }
}
