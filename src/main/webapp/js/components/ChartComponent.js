/**
 * Created by bartek on 30.05.17.
 */
import Chart from 'chart.js';
import React from 'react';


export default class ChartComponent extends React.Component {
    constructor(props) {
        super(props);

        this.data = {
            "currency": "USD",
            "times": {
                "0": "3.0",
                "3600": "4.0",
                "7200": "5.0",
                "10800": "6.0",
                "14400": "7.0",
                "18000": "23.0",
                "21600": "9.0",
                "25200": "230.0",
                "28800": "11.0",
                "32400": "12.0",
                "36000": "233.0",
                "39600": "14.0",
                "43200": "715.0",
                "46800": "16.0",
                "50400": "17.0",
                "54000": "18.0",
                "57600": "19.0",
                "61200": "20.0",
                "64800": "21.0",
                "68400": "22.0"
            }
        }

    }

    renderChart() {
        let chartCanvas = this.refs.chart;


        let myChart = new Chart(chartCanvas, {
                type: 'line',
                data: {

                    // labels: [new Date(86400000).toDateString(), new Date(86400030).toDateString(), new Date(86400020).toDateString(), new Date(86400040).toDateString(),
                    //     new Date(86400000).toDateString(), new Date(86400030).toDateString(), new Date(86400020).toDateString(), new Date(86400040).toDateString()],
                    labels: this.times,
                    // labels: this.timestamps,
                    datasets: [{
                        label: this.currency,
                        // label: this.currency,
                        // data: [12, 20, 3, 5, 3, 4, 5, 6],
                        // data: this.state.values,
                        data: this.values,
                        // data: this.values,
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


    componentWillReceiveProps() {
        console.log("will receive props", this.props.currency)
    }


    render() {
        return (
            <div>
                Waluta w charcie: {this.props.currency}
                <canvas ref={'chart'} height={'400'} width={'600'}/>
            </div>

        )
    }
    ;
}


