/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';

export default class PredictionButton extends React.Component{
    render(){
        return(
            <div class="checkbox">
                <label><input type="checkbox" value=""/>Predict</label>
            </div>
        )
    }
}