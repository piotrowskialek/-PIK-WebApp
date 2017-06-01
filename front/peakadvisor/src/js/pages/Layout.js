import React from "react";
import { Link } from "react-router";


export default class Layout extends React.Component {
  navigate() {
      this.props.history.pushState(null, "/");
  }

    render() {
   return(
       <div>
        <h1> Peak Advisor </h1>
           {this.props.children}
           <Link to="archives/:article"><button class="btn btn-success">archives</button></Link>
           <Link to="settings">settings</Link>
           <button onClick={this.navigate.bind(this)}>featured</button>
       </div>
           );
  }
}
