/**
 * Created by bartek on 08.06.17.
 */
import React from 'react';

export default class Datepicker extends React.Component {
    render() {
        return (
            <input class="form-control" type="text" id="id_field_dateofbirth" className="datepicker form-control" placeholder="DD-MM-YYYY"/>
        );
    }
}