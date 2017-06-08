/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';


export default class Input extends React.Component {

    constructor() {
        super();
        this.state = {currency: "",
            start : "",
            end : ""};
    }


    _handleChangeCur(e) {
        const currency = e.target.value;
        console.log("handling cur")
        this.setState({currency: currency});
    }

    _handleChangeStart(e) {
        const start = e.target.value;
        console.log("handling start")
        this.setState({start: start});
    }

    _handleChangeEnd(e) {
        const end = e.target.value;
        console.log("handling end")
        this.setState({end: end});
    }


    _handleForm(e) {
        e.preventDefault();
        console.log("submitted")
        this.props.downloadData(this.state.currency, this.state.start, this.state.end)
    }

    render() {
        return (
            <div>
                <div>
                   <form onSubmit={this._handleForm.bind(this)}>
                       <label>
                           Currency
                        <input  value={this.state.currency} onChange={this._handleChangeCur.bind(this)}/>
                       </label>
                       <label>
                           Start
                           <input value={this.state.start} onChange={this._handleChangeStart.bind(this)}/>
                       </label>
                       <label>
                           End
                           <input value={this.state.end} onChange={this._handleChangeEnd.bind(this)}/>
                       </label>
                       <input type="submit" value="Submit"/>
                   </form>
                </div>
                <div>
                    <ul>
                        <li>Wpisana waluta: {this.state.currency}</li>
                    <li>Wpisana poczatek: {this.state.start}</li>
                    <li>Wpisany koniec {this.state.end}</li>
                    </ul>

                </div>
            </div>

        )
    }

}