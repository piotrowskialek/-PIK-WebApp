/**
 * Created by bartek on 30.05.17.
 */
import Chart from 'chart.js';
import React from 'react';
import moment from 'moment';

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
        };

        this.dataa = [];
        this.times = [];
        this.predTimes = [];
        this.predData = [];
        this.currency = "";

    }

    // componentDidMount() {
    //     // this.getValues();
    //     //     this.setState({chartData :  {
    //     //
    //     //         labels: [new Date(86400000).toDateString(), new Date(86400030).toDateString(), new Date(86400020).toDateString(), new Date(86400040).toDateString(),
    //     //             new Date(86400000).toDateString(), new Date(86400030).toDateString(), new Date(86400020).toDateString(), new Date(86400040).toDateString()],
    //     //         // labels: this.times,
    //     //         // labels: this.timestamps,
    //     //         datasets: [{
    //     //             label: this.currency,
    //     //             data: [12, 20, 3, 5, 3, 4, 5, 6],
    //     //             // data: this.values,
    //     //             fill: false,
    //     //             backgroundColor: [
    //     //                 'rgba(255, 99, 132, 0.2)',
    //     //                 'rgba(54, 162, 235, 0.2)',
    //     //                 'rgba(255, 206, 86, 0.2)',
    //     //                 'rgba(75, 192, 192, 0.2)',
    //     //                 'rgba(153, 102, 255, 0.2)',
    //     //                 'rgba(255, 159, 64, 0.2)'
    //     //             ],
    //     //             borderColor: [
    //     //                 'rgba(255,99,132,1)',
    //     //                 'rgba(54, 162, 235, 1)',
    //     //                 'rgba(255, 206, 86, 1)',
    //     //                 'rgba(75, 192, 192, 1)',
    //     //                 'rgba(153, 102, 255, 1)',
    //     //                 'rgba(255, 159, 64, 1)'
    //     //             ],
    //     //             borderWidth: 3
    //     //         }]
    //     //     },
    //     //         options: {}})
    //     // }//
    //
    //     let chartCanvas = this.refs.chart;
    //     console.log({cur: this.currency, dat: this.values, t: this.timestamps})
    //
    //     let myChart = new Chart(chartCanvas, {
    //             type: 'line',
    //             data: {
    //
    //                 labels: [new Date(86400000).toDateString(), new Date(86400030).toDateString(), new Date(86400020).toDateString(), new Date(86400040).toDateString(),
    //                     new Date(86400000).toDateString(), new Date(86400030).toDateString(), new Date(86400020).toDateString(), new Date(86400040).toDateString()],
    //                 // labels: this.times,
    //                 // labels: this.timestamps,
    //                 datasets: [{
    //                     label: this.currency,
    //                     data: [12, 20, 3, 5, 3, 4, 5, 6],
    //                     // data: this.values,
    //                     fill: false,
    //                     backgroundColor: [
    //                         'rgba(255, 99, 132, 0.2)',
    //                         'rgba(54, 162, 235, 0.2)',
    //                         'rgba(255, 206, 86, 0.2)',
    //                         'rgba(75, 192, 192, 0.2)',
    //                         'rgba(153, 102, 255, 0.2)',
    //                         'rgba(255, 159, 64, 0.2)'
    //                     ],
    //                     borderColor: [
    //                         'rgba(255,99,132,1)',
    //                         'rgba(54, 162, 235, 1)',
    //                         'rgba(255, 206, 86, 1)',
    //                         'rgba(75, 192, 192, 1)',
    //                         'rgba(153, 102, 255, 1)',
    //                         'rgba(255, 159, 64, 1)'
    //                     ],
    //                     borderWidth: 3
    //                 }]
    //             }
    //         }
    //         // {
    //         //     label: "USD",
    //         //     data: [5, 2, 4, 12, 4, 2, 1, 12],
    //         //     fill: false,
    //         //     backgroundColor: [
    //         //         'rgba(255, 99, 132, 0.2)',
    //         //         'rgba(54, 162, 235, 0.2)',
    //         //         'rgba(255, 206, 86, 0.2)',
    //         //         'rgba(75, 192, 192, 0.2)',
    //         //         'rgba(153, 102, 255, 0.2)',
    //         //         'rgba(255, 159, 64, 0.2)'
    //         //     ],
    //         //     borderColor: [
    //         //         // 'rgba(255,99,132,1)',
    //         //         // 'rgba(54, 162, 235, 1)',
    //         //         'rgba(255, 206, 86, 1)',
    //         //         'rgba(75, 192, 192, 1)',
    //         //         'rgba(153, 102, 255, 1)',
    //         //         'rgba(255, 159, 64, 1)'
    //         //     ],
    //         //     borderWidth: 3
    //         // }]
    //
    //     );
    //
    //     this.setState({chart: myChart});
    // }

    
    componentDidUpdate() {
        function formatTime(timestamp){
            return moment.unix(timestamp).format("YYYY:M:D H:m:s")
        }
        

        console.log((this.props));
        if (this.dataa === this.props.data && this.times === this.props.times && this.currency === this.props.currency && this.predData === this.props.predData && this.predTimes === this.props.predTimes) {
            return
        }
        this.dataa = this.props.data;
        this.times = this.props.times;
        this.currency = this.props.currency;
        this.predData = this.props.predData;
        this.predTimes = this.props.predTimes;

        if(typeof this.dataa !== 'undefined'){
            console.log("Data undefined")
        }
        if(typeof this.times !== 'undefined'){
            console.log("times undefined")
        }
        if(typeof this.predData !== 'undefined'){
            console.log("preddata undefined")
        }
        if(typeof this.predTimes !== 'undefined'){
            console.log("predtimes undefined")
        }

        if (typeof this.dataa !== 'undefined' && typeof this.times !== 'undefined' && typeof this.currency !== 'undefined' && typeof this.predData !== 'undefined' && typeof this.predData !== 'undefined') {
            console.log("will did props", {
                dataa: this.dataa,
                times: this.times,
                currency: this.currency,
                predTimes: this.predTimes,
                predData: this.predData
            });

            let labels = this.times.concat(this.predTimes).map(formatTime);

            let datHist = []
            for(var i=0; i < this.times.length; i++){
                datHist.push({x : formatTime(this.times[i]), y: this.dataa[i]})
            }

            console.log({datH : this.times});
            console.log({datHist: datHist});

            let datPred = [];
            for(var i=0; i < this.predTimes.length; i++){
                datPred.push({x : formatTime(this.predTimes[i]), y: this.predData[i]})
            }
            console.log({datH : this.predTimes});
            console.log({datPred : datPred});
            console.log({labels : labels});
            let chartCanvas = this.refs.chart;
            let myChart = new Chart(chartCanvas, {
                type: 'line',
                data: {
                    labels: labels,
                    datasets: [{
                        label: this.currency,
                        data: datHist,
                        fill: true,
                        backgroundColor: [
                            'rgba(215, 78, 66, 0.4)',

                        ],
                        borderColor: [
                            'rgba(215, 78, 66, 0.9)'
                        ],
                        borderWidth: 3
                    },
                        {
                            label: this.currency  + "Predicted",
                            data: datPred,
                            fill: true,
                            backgroundColor: [
                                'rgba(215, 158, 44, 0.4)'
                            ],
                            borderColor: [
                                'rgba(215, 158, 44, 0.9)'
                            ],
                            borderWidth: 3
                        }]
                },
                options : {
                    responsive: true,
                    maintainAspectRatio: false
                }
            });

            this.setState({chart: myChart});
        }

    }


    render() {
        return (
            <div>
                {/*<LineChart data={this.state.chartData} options={this.state.options} width="600" height="250"/>*/}

                <div>
                    <canvas ref={'chart'} height={'400'} width={'700'}/>
                </div>
            </div>
        )
    }
    ;
}


