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
        this.state = {
            startDate: "0",
            endDate: "68000",
            currency: "USD"
        }

        this.startDate ="0"
        this.endDate ="68000"
        this.currency ="USD"

        this.setStartDate = this.setStartDate.bind(this);
        this.setEndDate = this.setEndDate.bind(this);


        this.state ={title : "Peak Advisor"}
    }

    setStartDate(date) {
        this.startDate = date;
        console.log("start" + date)
        this.setState({startDate: date});
    }

    setEndDate(date) {
        console.log("end" + date)
        this.endDate = date;
        this.setState({endDate: date},this.sendStateToParent);
    }
    setCur(cur) {
        this.currency = cur;
        this.setState({currency : cur},this.sendStateToParent);
    }
    setTitle(){
        console.log("CHanging title")
        this.setState({title : "PeaknieAdbisor"})
    }

    render() {
        return (
            <div>
                <div>start: {this.startDate}</div>
                <div>end: {this.endDate}</div>
                <div>curency: {this.currency}</div>
                <Title title={this.state.title}/>
                <button onClick={this.setTitle}>Change title</button>
                {/*<Input changeSDate={this.setStartDate.bind(this)} changeEDate={this.setEndDate.bind(this)} setCur={this.setCur.bind(this)}/>*/}
                <ChartComponent startDate={this.startDate} endDate={this.endDate} currency={this.currency}/>
            </div>
        );
    }
}
