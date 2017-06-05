/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';

import PredictionButton from "./PredictionButton";

export default class Input extends React.Component {
    render() {
        return (
        <div>    <div class="col-lg-6">
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
    }
    }