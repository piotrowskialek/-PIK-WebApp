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
            currency: "",
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
                    {this.state.startDate.unix()}
                    <form onSubmit={this._handleForm.bind(this)}>
                        <label for="sel1">Currency:</label>
                        <select value={this.state.currency} onChange={this._handleChangeCur.bind(this)}
                                class="form-control" id="sel1">
                            <option>aed</option>
                            <option>afn</option>
                            <option>all</option>
                            <option>amd</option>
                            <option>ang</option>
                            <option>aoa</option>
                            <option>ars</option>
                            <option>aud</option>
                            <option>awg</option>
                            <option>azn</option>
                            <option>bam</option>
                            <option>bbd</option>
                            <option>bdt</option>
                            <option>bgn</option>
                            <option>bhd</option>
                            <option>bif</option>
                            <option>bmd</option>
                            <option>bnd</option>
                            <option>bob</option>
                            <option>brl</option>
                            <option>bsd</option>
                            <option>btc</option>
                            <option>btn</option>
                            <option>bwp</option>
                            <option>byn</option>
                            <option>bzd</option>
                            <option>cad</option>
                            <option>cdf</option>
                            <option>chf</option>
                            <option>clf</option>
                            <option>clp</option>
                            <option>cnh</option>
                            <option>cny</option>
                            <option>cop</option>
                            <option>crc</option>
                            <option>cuc</option>
                            <option>cup</option>
                            <option>cve</option>
                            <option>czk</option>
                            <option>djf</option>
                            <option>dkk</option>
                            <option>dop</option>
                            <option>dzd</option>
                            <option>egp</option>
                            <option>ern</option>
                            <option>etb</option>
                            <option>eur</option>
                            <option>fjd</option>
                            <option>fkp</option>
                            <option>gbp</option>
                            <option>gel</option>
                            <option>ggp</option>
                            <option>ghs</option>
                            <option>gip</option>
                            <option>gmd</option>
                            <option>gnf</option>
                            <option>gtq</option>
                            <option>gyd</option>
                            <option>hkd</option>
                            <option>hnl</option>
                            <option>hrk</option>
                            <option>htg</option>
                            <option>huf</option>
                            <option>idr</option>
                            <option>ils</option>
                            <option>imp</option>
                            <option>inr</option>
                            <option>iqd</option>
                            <option>irr</option>
                            <option>isk</option>
                            <option>jep</option>
                            <option>jmd</option>
                            <option>jod</option>
                            <option>jpy</option>
                            <option>kes</option>
                            <option>kgs</option>
                            <option>khr</option>
                            <option>kmf</option>
                            <option>kpw</option>
                            <option>krw</option>
                            <option>kwd</option>
                            <option>kyd</option>
                            <option>kzt</option>
                            <option>lak</option>
                            <option>lbp</option>
                            <option>lkr</option>
                            <option>lrd</option>
                            <option>lsl</option>
                            <option>lyd</option>
                            <option>mad</option>
                            <option>mdl</option>
                            <option>mga</option>
                            <option>mkd</option>
                            <option>mmk</option>
                            <option>mnt</option>
                            <option>mop</option>
                            <option>mro</option>
                            <option>mur</option>
                            <option>mvr</option>
                            <option>mwk</option>
                            <option>mxn</option>
                            <option>myr</option>
                            <option>mzn</option>
                            <option>nad</option>
                            <option>ngn</option>
                            <option>nio</option>
                            <option>nok</option>
                            <option>npr</option>
                            <option>nzd</option>
                            <option>omr</option>
                            <option>pab</option>
                            <option>pen</option>
                            <option>pgk</option>
                            <option>php</option>
                            <option>pkr</option>
                            <option>pln</option>
                            <option>pyg</option>
                            <option>qar</option>
                            <option>ron</option>
                            <option>rsd</option>
                            <option>rub</option>
                            <option>rwf</option>
                            <option>sar</option>
                            <option>sbd</option>
                            <option>scr</option>
                            <option>sdg</option>
                            <option>pln</option>
                            <option>pyg</option>
                            <option>qar</option>
                            <option>ron</option>
                            <option>rsd</option>
                            <option>rub</option>
                            <option>rwf</option>
                            <option>sar</option>
                            <option>sbd</option>
                            <option>scr</option>
                            <option>sdg</option>
                            <option>shp</option>
                            <option>sll</option>
                            <option>sos</option>
                            <option>srd</option>
                            <option>ssp</option>
                            <option>std</option>
                            <option>svc</option>
                            <option>syp</option>
                            <option>szl</option>
                            <option>thb</option>
                            <option>tjs</option>
                            <option>tmt</option>
                            <option>tnd</option>
                            <option>top</option>
                            <option>try</option>
                            <option>ttd</option>
                            <option>twd</option>
                            <option>tzs</option>
                            <option>uah</option>
                            <option>ugx</option>
                            <option>usd</option>
                            <option>uyu</option>
                            <option>uzs</option>
                            <option>vef</option>
                            <option>vnd</option>
                            <option>vuv</option>
                            <option>wst</option>
                            <option>xaf</option>
                            <option>xag</option>
                            <option>xau</option>
                            <option>xcd</option>
                            <option>xdr</option>
                            <option>xof</option>
                            <option>xpd</option>
                            <option>xpf</option>
                            <option>xpt</option>
                            <option>yer</option>
                            <option>zar</option>
                            <option>zmw</option>
                            <option>zwl</option>
                        </select>
                        <label>Power
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
                        </label>
                        <label>
                            Start
                            <DatePicker selected={this.state.startDate}
                                        onSelect={this._handleDateStartSelect.bind(this)}
                                        onChange={this._handleDateSChange.bind(this)}/>

                            {/*<input value={this.state.start} onChange={this._handleChangeStart.bind(this)}/>*/}
                        </label>
                        <label>
                            End
                            <DatePicker selected={this.state.endDate} onSelect={this._handleDateEndSelect.bind(this)}
                                        onChange={this._handleDateEChange.bind(this)}/>
                            {/*<input value={this.state.end} onChange={this._handleChangeEnd.bind(this)}/>*/}
                        </label>
                        <input type="submit" value="Submit"/>
                    </form>
                </div>

            </div>

        )
    }

}