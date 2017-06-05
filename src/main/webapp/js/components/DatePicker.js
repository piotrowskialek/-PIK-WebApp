/**
 * Created by bartek on 05.06.17.
 */
import React from 'react';
var $ = require('jquery');

export default class DatePicker extends React.Component {
    componentDidMount() {
        $(this.refs.input).datepicker();
    }

    componentWillUnmount() {
        $(this.refs.input).datepicker('destroy');
    }

    render() {
        const props = this.props;
        return(<input ref="input" type="date" {...props} />)
    }
}