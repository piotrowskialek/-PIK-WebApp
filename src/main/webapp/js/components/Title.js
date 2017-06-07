/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';

export default class Title extends React.Component{
    render(){
        const containerStyle = {
            color: "#7FFFD4"
        }
        return(
            <div style={containerStyle}>
                <p>
                    <h1 class="logo">
                        <span> {this.props.title} </span>

                    </h1>
                </p>
            </div>
        )
}
}