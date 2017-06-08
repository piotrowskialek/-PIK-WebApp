/**
 * Created by bartek on 08.06.17.
 */
import React from "react"

// Load the charts module
import ReactFC from 'react-fusioncharts';
export default class Chart extends React.Component{
constructor() {
    super();
    this.state = {
        myDataSource: {
            "chart": {
                "caption": "Actual Revenues, Targeted Revenues & Profits",
                "subcaption": "Last year",
                "xaxisname": "Month",
                "yaxisname": "Amount (In USD)",
                "numberprefix": "$",
                "theme": "ocean"
            },
            "categories": [{
                "category": [{
                    "label": "Jan"
                }, {
                    "label": "Feb"
                }, {
                    "label": "Mar"
                }, {
                    "label": "Apr"
                }, {
                    "label": "May"
                }, {
                    "label": "Jun"
                }, {
                    "label": "Jul"
                }, {
                    "label": "Aug"
                }, {
                    "label": "Sep"
                }, {
                    "label": "Oct"
                }, {
                    "label": "Nov"
                }, {
                    "label": "Dec"
                }]
            }],
            "dataset": [{
                "seriesname": "Actual Revenue",
                "data": [{
                    "value": "16000"
                }, {
                    "value": "20000"
                }, {
                    "value": "18000"
                }, {
                    "value": "19000"
                }, {
                    "value": "15000"
                }, {
                    "value": "21000"
                }, {
                    "value": "16000"
                }, {
                    "value": "20000"
                }, {
                    "value": "17000"
                }, {
                    "value": "25000"
                }, {
                    "value": "19000"
                }, {
                    "value": "23000"
                }]
            }, {
                "seriesname": "Projected Revenue",
                "renderas": "line",
                "showvalues": "0",
                "data": [{
                    "value": ""
                }, {
                    "value": ""
                }, {
                    "value": ""
                }, {
                    "value": ""
                }, {
                    "value": "19000"
                }, {
                    "value": "19000"
                }, {
                    "value": "19000"
                }, {
                    "value": "19000"
                }, {
                    "value": "20000"
                }, {
                    "value": "21000"
                }, {
                    "value": "22000"
                }, {
                    "value": "23000"
                }]
            }, {
                "seriesname": "Profit",
                "renderas": "line",
                "showvalues": "0",
                "data": [{
                    "value": "14000"
                }, {
                    "value": "15000"
                }, {
                    "value": "13000"
                }, {
                    "value": "14000"
                }]
            }]
        }
    };

    this.state = {
        chartConfigs: {
            id: "revenue-profits-chart",
            renderAt: "revenue-profits-chart-container",
            type: "mscombi2d",
            width: 600,
            height: 400,
            dataFormat: "json",
            dataSource: this.state.myDataSource
        }
    };
}
        render(){
            return(
                < ReactFC {...this.state.chartConfigs}/>);
        }


}