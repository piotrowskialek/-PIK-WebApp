/**
 * Created by bartek on 30.05.17.
 */
import React from "react"

import Title from './Title'
import ChartComponent from './ChartComponent'
import Input from "./Input";

export default class Layout extends React.Component {
     render(){
        return (
            <div>
                <Title word1="Peak" word2="Advisor"/>
                <Input/>
                <ChartComponent/>
            </div>
        );
    }
}