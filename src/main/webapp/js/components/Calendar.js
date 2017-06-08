/**
 * Created by bartek on 08.06.17.
 */
import React from 'react';
import Datepicker from './Datepicker';

export default class Calendar extends React.Component {
    componentDidMount() {
        $('.datepicker').datepicker({
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            yearRange: "-116:+34",
            dateFormat: 'dd/mm/yy'
        });
    }
    render() {
        return (
            <Datepicker />
        );
    }
}