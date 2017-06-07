/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';


export default class Input extends React.Component {

    constructor() {
        super();
        this.state = {currency: ""};
    }

    handleClick() {
        console.log("handleClick")
        this.props.changeTitle()
    }

    _handleChange(e) {
        const currency = e.target.value;
        this.setState({currency: currency});
    }


    _handleForm(e) {
        e.preventDefault();
        console.log("submited")
        this.props.changeTitle()
    }

    render() {
        return (
            <div>
                <div>
                    Wpisz walute:
                   <form onSubmit={this._handleForm.bind(this)}>
                       <label>
                           Currency
                        <input  value={this.state.currency} onChange={this._handleChange.bind(this)}/>
                       </label>
                       <input type="submit" value="Submit"/>
                   </form>
                    <button onClick={this.handleClick.bind(this)}>Change Title!</button>
                </div>
                <div>
                    Wpisana waluta: {this.state.currency}
                </div>
            </div>

        )
    }

}