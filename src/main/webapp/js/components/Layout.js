/**
 * Created by bartek on 30.05.17.
 */
import React from "react"

import Title from './Title'
import ChartComponent from './ChartComponent'
import Input from "./Input";

export default class Layout extends React.Component {
    constructor() {
        super();
        this.state = {title: "Peak Advisor"}
    }


    changeTitle() {
        console.log("CHanging title")
        this.setState({title: "PeaknieAdbisor"})
    }

    downloadData(currency, start, end) {
        var rest, mime, client;
        rest = require('rest'),
            mime = require('rest/interceptor/mime');
        console.log(currency, start, end)

        let a;
        client = rest.wrap(mime);
        client({path: 'http://localhost:8080/PIK-WebApp-0.0.1-SNAPSHOT/getValue?currency=' + currency + '&start=' + start + '&end=' + end}).then(response => {
                console.log(response);
                a = JSON.parse(response['entity']);
                console.log("waluta", a['currency'])
                this.setState({currency: a['currency']})
                let data = [];
                let times = [];
                for (let key in a['history']) {
                    times.push(key);
                    data.push(a['history'][key]);
                }
                this.setState({times: times})
                this.setState({data: data})
                let predData = [];
                let predTimes = [];
                for (let key in a['predicted']) {
                    predTimes.push(key);
                    predData.push(a['predicted'][key]);
                 }
                this.setState({predTimes: predTimes})
                this.setState({predData: predData})
            }
        )

    }

    render() {
        return (
            <div>
                {this.state.currency}
                <Title title={this.state.title}/>
                <Input changeTitle={this.changeTitle.bind(this)} downloadData={this.downloadData.bind(this)}/>
                {/*<Input changeSDate={this.setStartDate.bind(this)} changeEDate={this.setEndDate.bind(this)} setCur={this.setCur.bind(this)}/>*/}
                {/*<ChartComponent startDate={this.startDate} endDate={this.endDate} currency={this.currency}/>*/}
                <ChartComponent currency={this.state.currency} data={this.state.data} times={this.state.times} predData={this.state.predData} predTimes={this.state.predTimes}/>
                <div>
                    <canvas ref={'chart'} height={'400'} width={'600'}/>
                </div>
            </div>
        );
    }
}
