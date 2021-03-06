import React, {Component} from 'react';

class MyTable extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <h3>{this.props.title}</h3>
                <div className="container">
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                {this.props.headers.map((header, i) => (
                                        <th scope="col" key={i}>{header}</th>
                                    ))}
                            </tr>
                        </thead>
                        <tbody>
                        {this.props.isObject && Object.entries(this.props.data).map((item, i) => (
                                    <tr key={i}>
                                        {item.map((cell,j) => (
                                            <td key={j}>{cell}</td>
                                        ))}
                                    </tr>
                                ))}
                        {!this.props.isObject && this.props.data.linksData.map((item, i) => (
                                <tr key={"links-" + i}>
                                    <td key={"cell-" + i}>{item.link}</td>
                                    <td>{item.available ? "Yes" : "No"}</td>
                                    <td>{item.message}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default MyTable;