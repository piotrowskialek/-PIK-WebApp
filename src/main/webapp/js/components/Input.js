/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';

import Datetime from 'react-datetime';

export default class Input extends React.Component {
<<<<<<< HEAD

    constructor() {
        super();
        this.state = {
            start: [],
            end: [],
            currency: []
        }
    }

    setCurrency(e) {
        const cur = e.target.value;
        this.setState({currency: cur})
    }

    setStart(time) {
        const t = time.unix();
        this.setState({start: t});
=======
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
>>>>>>> d55f6bf17ea0889bbde6ef33e415fc333d2a1324

    }

    setEnd(time) {
<<<<<<< HEAD
        const t = time.unix();
        this.setState({end: t});
    }

    sendData() {
        const st = this.state.start;
        const et = this.state.end;
        const c = this.state.currency;
        this.props.setCur(c);
        this.props.changeSDate(st);
        this.props.changeEDate(et);

=======
        this.setState({end : time.unix()});
    }
    sendData(){
        this.props.changeSDate(this.state.start);
        this.props.changeEDate(this.state.end);
>>>>>>> d55f6bf17ea0889bbde6ef33e415fc333d2a1324
    }

    render() {

        return (
<<<<<<< HEAD
            <div>
                <div class="col-lg-6">
                    <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Go!</button>
                    </span>
                        <input type="text" class="form-control" placeholder="Search for currency"/>
                    </div>
                </div>
                <PredictionButton/>
            </div>
        )
=======
        <div>
            <div id="1"><Datetime onChange={this.setStart.bind(this)} /></div>
            <div id="2"><Datetime onChange={this.setEnd.bind(this)}/></div>
            <input onChange={this.setCurrency.bind(this)}/>
            <button onClick={this.sendData.bind(this)}>Go</button>
        </div>
    )
>>>>>>> d55f6bf17ea0889bbde6ef33e415fc333d2a1324
    }
}