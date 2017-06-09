/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';
// import Calendar from './Calendar'
import DatePicker from 'react-datepicker';
import moment from 'moment';

export default class Input extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            currency: "AED",
            start: "",
            end: "",
            power : "",

            startDate: moment(),
            endDate: moment()
        };
    }

    _handleDateStartSelect(date) {
        this.setState({
            startDate: date
        });
        console.log("START")

    }

    _handleDateEndSelect(date) {
        this.setState({
            endDate: date
        });
        console.log("END")
    }

    _handleDateEChange(date) {
        console.log(date)
        console.log("chEND")

    }

    _handleDateSChange(date) {
        console.log(date)
        console.log("chSTART")

    }

    _handleChangePower(e) {
        const power = e.target.value;
        console.log("handling power")
        this.setState({power: power});
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
        this.props.downloadData(this.state.currency, this.state.startDate.unix(), this.state.endDate.unix(), this.state.power)
    }

    render() {
        return (
            <div>
                <div>
                    <form  class="form-inline" onSubmit={this._handleForm.bind(this)}>
                        <label class="sr-only" for="sel1">Currency:</label>
                        <select value={this.state.currency} onChange={this._handleChangeCur.bind(this)}
                                class="form-control" class="form-control mb-2 mr-sm-2 mb-sm-0" id="sel1">
                            <option>AED</option>
                            <option>AFN</option>
                            <option>ALL</option>
                            <option>AMD</option>
                            <option>ANG</option>
                            <option>AOA</option>
                            <option>ARS</option>
                            <option>AUD</option>
                            <option>AWG</option>
                            <option>AZN</option>
                            <option>BAM</option>
                            <option>BBD</option>
                            <option>BDT</option>
                            <option>BGN</option>
                            <option>BHD</option>
                            <option>BIF</option>
                            <option>BMD</option>
                            <option>BND</option>
                            <option>BOB</option>
                            <option>BRL</option>
                            <option>BSD</option>
                            <option>BTC</option>
                            <option>BTN</option>
                            <option>BWP</option>
                            <option>BYN</option>
                            <option>BZD</option>
                            <option>CAD</option>
                            <option>CDF</option>
                            <option>CHF</option>
                            <option>CLF</option>
                            <option>CLP</option>
                            <option>CNH</option>
                            <option>CNY</option>
                            <option>COP</option>
                            <option>CRC</option>
                            <option>CUC</option>
                            <option>CUP</option>
                            <option>CVE</option>
                            <option>CZK</option>
                            <option>DJF</option>
                            <option>DKK</option>
                            <option>DOP</option>
                            <option>DZD</option>
                            <option>EGP</option>
                            <option>ERN</option>
                            <option>ETB</option>
                            <option>EUR</option>
                            <option>FJD</option>
                            <option>FKP</option>
                            <option>GBP</option>
                            <option>GEL</option>
                            <option>GGP</option>
                            <option>GHS</option>
                            <option>GIP</option>
                            <option>GMD</option>
                            <option>GNF</option>
                            <option>GTQ</option>
                            <option>GYD</option>
                            <option>HKD</option>
                            <option>HNL</option>
                            <option>HRK</option>
                            <option>HTG</option>
                            <option>HUF</option>
                            <option>IDR</option>
                            <option>ILS</option>
                            <option>IMP</option>
                            <option>INR</option>
                            <option>IQD</option>
                            <option>IRR</option>
                            <option>ISK</option>
                            <option>JEP</option>
                            <option>JMD</option>
                            <option>JOD</option>
                            <option>JPY</option>
                            <option>KES</option>
                            <option>KGS</option>
                            <option>KHR</option>
                            <option>KMF</option>
                            <option>KPW</option>
                            <option>KRW</option>
                            <option>KWD</option>
                            <option>KYD</option>
                            <option>KZT</option>
                            <option>LAK</option>
                            <option>LBP</option>
                            <option>LKR</option>
                            <option>LRD</option>
                            <option>LSL</option>
                            <option>LYD</option>
                            <option>MAD</option>
                            <option>MDL</option>
                            <option>MGA</option>
                            <option>MKD</option>
                            <option>MMK</option>
                            <option>MNT</option>
                            <option>MOP</option>
                            <option>MRO</option>
                            <option>MUR</option>
                            <option>MVR</option>
                            <option>MWK</option>
                            <option>MXN</option>
                            <option>MYR</option>
                            <option>MZN</option>
                            <option>NAD</option>
                            <option>NGN</option>
                            <option>NIO</option>
                            <option>NOK</option>
                            <option>NPR</option>
                            <option>NZD</option>
                            <option>OMR</option>
                            <option>PAB</option>
                            <option>PEN</option>
                            <option>PGK</option>
                            <option>PHP</option>
                            <option>PKR</option>
                            <option>PLN</option>
                            <option>PYG</option>
                            <option>QAR</option>
                            <option>RON</option>
                            <option>RSD</option>
                            <option>RUB</option>
                            <option>RWF</option>
                            <option>SAR</option>
                            <option>SBD</option>
                            <option>SCR</option>
                            <option>SDG</option>
                            <option>PLN</option>
                            <option>PYG</option>
                            <option>QAR</option>
                            <option>RON</option>
                            <option>RSD</option>
                            <option>RUB</option>
                            <option>RWF</option>
                            <option>SAR</option>
                            <option>SBD</option>
                            <option>SCR</option>
                            <option>SDG</option>
                            <option>SHP</option>
                            <option>SLL</option>
                            <option>SOS</option>
                            <option>SRD</option>
                            <option>SSP</option>
                            <option>STD</option>
                            <option>SVC</option>
                            <option>SYP</option>
                            <option>SZL</option>
                            <option>THB</option>
                            <option>TJS</option>
                            <option>TMT</option>
                            <option>TND</option>
                            <option>TOP</option>
                            <option>TRY</option>
                            <option>TTD</option>
                            <option>TWD</option>
                            <option>TZS</option>
                            <option>UAH</option>
                            <option>UGX</option>
                            <option>USD</option>
                            <option>UYU</option>
                            <option>UZS</option>
                            <option>VEF</option>
                            <option>VND</option>
                            <option>VUV</option>
                            <option>WST</option>
                            <option>XAF</option>
                            <option>XAG</option>
                            <option>XAU</option>
                            <option>XCD</option>
                            <option>XDR</option>
                            <option>XOF</option>
                            <option>XPD</option>
                            <option>XPF</option>
                            <option>XPT</option>
                            <option>YER</option>
                            <option>ZAR</option>
                            <option>ZMW</option>
                            <option>ZWL</option>
                        </select>
                        <label classID="sr-only">
                            Start</label>
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <DatePicker selected={this.state.startDate}
                                        onSelect={this._handleDateStartSelect.bind(this)}
                                        onChange={this._handleDateSChange.bind(this)}

                        />
                        </div>
                        <label classID="sr-only">
                            End</label>
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <DatePicker selected={this.state.endDate} onSelect={this._handleDateEndSelect.bind(this)}
                                        onChange={this._handleDateEChange.bind(this)}

                            />
                        </div>
                        <label for="sel1">Power</label>
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <select value={this.state.power} onChange={this._handleChangePower.bind(this)}
                                    class="form-control" id="sel1">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                            </select>
                        </div>

                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <button class="form-control" type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>
                </div>

            </div>

        )
    }

}