/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';


export default class Input extends React.Component {

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

    }

    setEnd(time) {
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

    }

    render() {
        return (
            <div>
                <div class="col-lg-6">
                    <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Go!</button>
                    </span>
                        <input type="text" class="form-control" placeholder="Search for currency"/>
                    </div>
                </div>
            </div>
        )
    }
}