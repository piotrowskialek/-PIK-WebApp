/**
 * Created by bartek on 30.05.17.
 */
import Chart from 'chart.js';
import React from 'react';



export default class ChartComponent extends React.Component {
    constructor(props) {
        super(props);
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


        this.state = {currency : [],
                        times: [],
        values : []};


        this.updateData = this.updateData.bind(this);
        this.renderChart = this.renderChart.bind(this);

        this.values = [];
        this.timestamps = [];
        this.getValues();

    }

    getValues() {
        this.currency = this.data['currency'];
        for (var key in this.data['times']) {
            // console.log(key)
            this.timestamps.push(key);
            this.values.push(this.data['times'][key]);
        }
    }


    updateData(){
        let times = this.state.times;
        console.log(times);
        console.log(this.state.values);
        console.log(this.state.currency);
        // this.values = this.state.values;
        this.currency = this.state.currency;
        // this.timestamps = this.state.times;
    }

    renderChart(){
        let chartCanvas = this.refs.chart;


        let myChart = new Chart(chartCanvas, {type: 'line',
                data: {
                    // labels: this.state.times,
                    labels: this.timestamps,
                    datasets: [{
                        // label: this.state.currency,
                        label: this.currency,
                        // data: [12, 20, 3, 5, 3, 4, 5, 6],
                        // data: this.state.values,
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
    componentDidMount(){
        var rest, mime, client;

        rest = require('rest'),
            mime = require('rest/interceptor/mime');

        client = rest.wrap(mime);
        client({ path: 'http://localhost:8080/PIK-WebApp-0.0.1-SNAPSHOT/getValue?currency=ZWL&start=0&end=68400' }).then(response => {
            console.log(response);
            // var a = JSON.parse(response['entity']);


            // this.setState({currency : a['currency']});
            // for (let key in a['times']){
            //    console.log(key)
            // }

        });
        // this.updateData();
        // console.log(this.state.currency);
        // console.log(this.currency);


    }

    componentWillReceiveProps(){
        var rest, mime, client;

        rest = require('rest'),
            mime = require('rest/interceptor/mime');

        let start = this.props.startDate;
        let end = this.props.endDate;
        client = rest.wrap(mime);
        client({ path: 'http://localhost:8080/PIK-WebApp-0.0.1-SNAPSHOT/getValue?currency=ZWL&start=' + start + '&end=' + end}).then(response => {
            console.log(response);
            // var a = JSON.parse(response['entity']);
            //
            //
            // this.setState({currency : a['currency']});
            // for (let key in a['times']){
            //     console.log(key)
            // }

        });
        this.renderChart();
    }


    handleChange(e){
       const currency = e.target.value;
       this.setState({currency})
    }

    render() {
        return (
            <div>
                <canvas ref={'chart'} height={'400'} width={'600'}/>
            </div>

        )
    };
}


