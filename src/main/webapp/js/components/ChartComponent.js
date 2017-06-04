/**
 * Created by bartek on 30.05.17.
 */
import Chart from 'chart.js';
import React from 'react';

export default class ChartComponent extends React.Component {
    constructor() {
        super();
        this.data = {
            "currency": "ZWL",
            "times": {
                "0": "3.0",
                "3600": "4.0",
                "7200": "5.0",
                "10800": "6.0",
                "14400": "7.0",
                "18000": "8.0",
                "21600": "9.0",
                "25200": "10.0",
                "28800": "11.0",
                "32400": "12.0",
                "36000": "13.0",
                "39600": "14.0",
                "43200": "15.0",
                "46800": "16.0",
                "50400": "17.0",
                "54000": "18.0",
                "57600": "19.0",
                "61200": "20.0",
                "64800": "21.0",
                "68400": "22.0"
            }
        }
        this.values = [];
        this.timestamps = [];
        this.getValues();
    }
    getValues(){
        for (var key in this.data['times']){
            console.log(key)
            this.timestamps.push(key);
            this.values.push(this.data['times'][key]);
        }
        // alert(this.data['times']['0'])
        // console.log(this.timestamps[0])
        // this.renderChart();
        // alert(this.values[2])
    }
    // componentDidMount() {
    //     // let xmlHttp = new XMLHttpRequest();
    //     // xmlHttp.open("GET", 'http://localhost:8080/PIK-WebApp-0.0.1-SNAPSHOT/getValue?currency=ZWL&start=0&end=68400'); // false for synchronous request
    //     // xmlHttp.send(null);
    //     // console.log(xmlHttp.responseText);
    //     //
    //
    //
    // };
    componentDidMount(){
        let chartCanvas = this.refs.chart;
        // alert(this.timestamps.length);

        let myChart = new Chart(chartCanvas, {type: 'line',
                data: {
                    // labels: [new Date(86400000).toDateString(), new Date(86400030).toDateString(), new Date(86400020).toDateString(), new Date(86400040).toDateString(),
                    //     new Date(86400000).toDateString(), new Date(86400030).toDateString(), new Date(86400020).toDateString(), new Date(86400040).toDateString()],
                    labels: this.timestamps,
                    datasets: [{
                        label: this.data['currency'],
                        // data: [12, 20, 3, 5, 3, 4, 5, 6],
                        data: this.values,
                        fill: false,
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255,99,132,1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 3
                    }]
                }
            }
            // {
            //     label: "USD",
            //     data: [5, 2, 4, 12, 4, 2, 1, 12],
            //     fill: false,
            //     backgroundColor: [
            //         'rgba(255, 99, 132, 0.2)',
            //         'rgba(54, 162, 235, 0.2)',
            //         'rgba(255, 206, 86, 0.2)',
            //         'rgba(75, 192, 192, 0.2)',
            //         'rgba(153, 102, 255, 0.2)',
            //         'rgba(255, 159, 64, 0.2)'
            //     ],
            //     borderColor: [
            //         // 'rgba(255,99,132,1)',
            //         // 'rgba(54, 162, 235, 1)',
            //         'rgba(255, 206, 86, 1)',
            //         'rgba(75, 192, 192, 1)',
            //         'rgba(153, 102, 255, 1)',
            //         'rgba(255, 159, 64, 1)'
            //     ],
            //     borderWidth: 3
            // }]

        );

        this.setState({chart: myChart});
    }
    render() {

        // this.renderChart();

        return (
            <div>
                <canvas ref={'chart'} height={'400'} width={'600'}/>
            </div>
        )
    };
}


