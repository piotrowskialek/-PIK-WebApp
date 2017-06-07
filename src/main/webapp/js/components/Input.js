/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';

import Datetime from 'react-datetime';

export default class Input extends React.Component {
    constructor(){
        super();
        this.state = {start: [],
        end : [],
        currency : []}
    }

    setCurrency(e){
        this.setState({currency: e.target.value})
    }

    setStart(time){
        this.setState({start : time.unix()});

    }

    setEnd(time) {
        this.setState({end : time.unix()});
    }
    sendData(){
        this.props.changeSDate(this.state.start);
        this.props.changeEDate(this.state.end);
    }

    render() {

        return (
        <div>
            <div id="1"><Datetime onChange={this.setStart.bind(this)} /></div>
            <div id="2"><Datetime onChange={this.setEnd.bind(this)}/></div>
            <input onChange={this.setCurrency.bind(this)}/>
            <button onClick={this.sendData.bind(this)}>Go</button>
        </div>
    )
    }
    }