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

    render() {
        return (
            <div>
                <div>start: {this.startDate}</div>
                <div>end: {this.endDate}</div>
                <div>curency: {this.currency}</div>
                <Title word1="Peak" word2="Advisor"/>

                <Input changeSDate={this.setStartDate.bind(this)} changeEDate={this.setEndDate.bind(this)} setCur={this.setCur.bind(this)}/>
                <ChartComponent startDate={this.startDate} endDate={this.endDate} currency={this.currency}/>
            </div>
        );
    }
}