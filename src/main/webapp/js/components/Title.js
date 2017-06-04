/**
 * Created by bartek on 02.06.17.
 */
import React from 'react';

export default class Title extends React.Component{
    render(){
        return(
            <div>
                <p>
                    <h1 class="logo">
                        <span class="word1">{this.props.word1}</span>
                        <span class="word2">{this.props.word2}</span>
                    </h1>
                </p>
            </div>
        )
}
}