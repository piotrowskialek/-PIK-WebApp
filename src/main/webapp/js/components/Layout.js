/**
 * Created by bartek on 30.05.17.
 */
import React from "react"

import Title from './Title'
import ChartComponent from './ChartComponent'
import Input from "./Input";
import DatePicker from './DatePicker'

export default class Layout extends React.Component {
     render(){
        return (
            <div>
                <DatePicker
                    value="2015-01-01"
                    onChange={(evt)=>console.log('new date', evt.target.value)}
                />
                <Title word1="Peak" word2="Advisor"/>
                <Input/>
                <ChartComponent/>
            </div>
        );
    }
}