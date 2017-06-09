/**
 * Created by bartek on 30.05.17.
 */
import Chart from 'chart.js';
import React from 'react';
import moment from 'moment';

export default class ChartComponent extends React.Component {
    constructor(props) {
        super(props);

        this.data = {};

        this.dataa = [];
        this.times = [];
        this.predTimes = [];
        this.predData = [];
        this.currency = "";

    }

    componentDidMount() {
        let chartCanvas = this.refs.chart;
        let myChart = new Chart(chartCanvas, {
            type: 'line',
            data: this.data,
            options: {
                responsive: true,
                maintainAspectRatio: false
            }
        });

        this.setState({chart: myChart});
    }

    componentDidUpdate() {
        function formatTime(timestamp) {
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

        if (typeof this.dataa !== 'undefined') {
            console.log("Data undefined")
        }
        if (typeof this.times !== 'undefined') {
            console.log("times undefined")
        }
        if (typeof this.predData !== 'undefined') {
            console.log("preddata undefined")
        }
        if (typeof this.predTimes !== 'undefined') {
            console.log("predtimes undefined")
        }

        if (typeof this.dataa !== 'undefined' && typeof this.times !== 'undefined' && typeof this.currency !== 'undefined' && typeof this.predData !== 'undefined' && typeof this.predData !== 'undefined') {
            // console.log("will did props", {
            //     dataa: this.dataa,
            //     times: this.times,
            //     currency: this.currency,
            //     predTimes: this.predTimes,
            //     predData: this.predData
            // });

            let labels = this.times.concat(this.predTimes).map(formatTime);

            let datHist = []
            for (var i = 0; i < this.times.length; i++) {
                datHist.push({x: formatTime(this.times[i]), y: this.dataa[i]})
            }

            console.log({datH: this.times});
            console.log({datHist: datHist});

            let datPred = [];
            for (var i = 0; i < this.predTimes.length; i++) {
                datPred.push({x: formatTime(this.predTimes[i]), y: this.predData[i]})
            }
            console.log({datH: this.predTimes});
            console.log({datPred: datPred});
            console.log({labels: labels});


            this.data = {
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
                    borderWidth: 0.1,
                    pointHooverRadius: 0,
                },
                    {
                        label: this.currency + "Predicted",
                        data: datPred,
                        fill: true,
                        backgroundColor: [
                            'rgba(215, 158, 44, 0.4)'
                        ],
                        borderColor: [
                            'rgba(215, 158, 44, 0.9)'
                        ],
                        borderWidth: 0.1,
                        pointHooverRadius: 0,
                    }]
            }
            let chart = this.state.chart;
            chart.data = this.data
            chart.data.labels = this.data.labels;
            chart.update()

        }
        // zmiany
    }

    render() {
        return (
            <div>
                <div>
                    <canvas ref={'chart'} height={'400'} width={'700'}/>
                </div>
            </div>
        )
    }
    ;
}


