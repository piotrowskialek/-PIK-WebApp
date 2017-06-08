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
                    data.push(parseFloat(a['history'][key]));
                }
                this.setState({times: times})
                this.setState({data: data})
            }
        )

        // let chartCanvas = this.refs.chart;
        //
        //
        // let myChart = new Chart(chartCanvas, {
        //     type: 'line',
        //     data: {
        //         labels: a['history'],
        //         // labels: this.timestamps,
        //         datasets: [{
        //             label: a['currency'],
        //             data: a['history'],
        //             fill: false,
        //             backgroundColor: [
        //                 'rgba(255, 99, 132, 0.2)',
        //                 'rgba(54, 162, 235, 0.2)',
        //                 'rgba(255, 206, 86, 0.2)',
        //                 'rgba(75, 192, 192, 0.2)',
        //                 'rgba(153, 102, 255, 0.2)',
        //                 'rgba(255, 159, 64, 0.2)'
        //             ],
        //             borderColor: [
        //                 'rgba(255,99,132,1)',
        //                 'rgba(54, 162, 235, 1)',
        //                 'rgba(255, 206, 86, 1)',
        //                 'rgba(75, 192, 192, 1)',
        //                 'rgba(153, 102, 255, 1)',
        //                 'rgba(255, 159, 64, 1)'
        //             ],
        //             borderWidth: 3
        //         }]
        //     }
        // })
        // this.setState({chart: myChart});
    }

    render() {
        return (
            <div>
                {this.state.currency}
                <Title title={this.state.title}/>
                <Input changeTitle={this.changeTitle.bind(this)} downloadData={this.downloadData.bind(this)}/>
                {/*<Input changeSDate={this.setStartDate.bind(this)} changeEDate={this.setEndDate.bind(this)} setCur={this.setCur.bind(this)}/>*/}
                {/*<ChartComponent startDate={this.startDate} endDate={this.endDate} currency={this.currency}/>*/}
                <ChartComponent currency={this.state.currency} data={this.state.data} times={this.state.times}/>
                <div>
                    <canvas ref={'chart'} height={'400'} width={'600'}/>
                </div>

            </div>
        );
    }
}
