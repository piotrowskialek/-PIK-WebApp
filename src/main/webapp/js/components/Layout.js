/**
 * Created by bartek on 30.05.17.
 */
import React from "react"

import Title from './Title'
import ChartComponent from './ChartComponent'
import Input from "./Input";
import DatePicker from './DatePicker'

export default class Layout extends React.Component {
    constructor() {
        super();
        this.state = {
            startDate: "",
            endDate: ""
        }
        this.setStartDate = this.setStartDate.bind(this);
        this.setEndDate = this.setEndDate.bind(this);

    }

    setStartDate(date) {
        console.log("start" + date)
        this.setState({startDate: date});
    }

    setEndDate(date) {
        console.log("end" + date)
        this.setState({endDate: date});
        console.log(this.state.endDate);
    }

    render() {
        return (
            <div>
                <Title word1="Peak" word2="Advisor"/>
                <Input changeSDate={this.setStartDate.bind(this)} changeEDate={this.setEndDate.bind(this)}/>
                <ChartComponent startDate={this.state.startDate} endDate={this.state.endDate}/>
            </div>
        );
    }
}