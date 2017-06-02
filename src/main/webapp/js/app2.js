/**
 * Created by bartek on 30.05.17.
 */
import Chart from 'chart.js';
import React from 'react';
import ReactDOM from 'react-dom'

export default class ChartComponent extends React.Component {
    constructor() {
        super();
    }
    componentDidMount() {
        let chartCanvas = this.refs.chart;

        let myChart = new Chart(chartCanvas, {
                type: 'line',
                data: {
                    labels: [new Date(86400000).toDateString(),new Date(86400030).toDateString(),new Date(86400020).toDateString(),new Date(86400040).toDateString(),
                        new Date(86400000).toDateString(),new Date(86400030).toDateString(),new Date(86400020).toDateString(),new Date(86400040).toDateString()],
                    datasets: [{
                        label: "PLN",
                        data: [12, 20, 3, 5,3,4,5,6],
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
                    },
                        {
                            label: "USD",
                            data: [5, 2, 4, 12,4,2,1,12],
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
                                // 'rgba(255,99,132,1)',
                                // 'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 3
                        }]
                },
            }
        );

        this.setState({chart: myChart});
    };

    render() {
        return (
            <div>
                <canvas ref={'chart'} height={'400'} width={'600'}/>
            </div>
        )
    };
}

const app = document.getElementById('chart');
ReactDOM.render(<ChartComponent/>, app);
