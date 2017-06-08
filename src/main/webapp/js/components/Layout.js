/**
 * Created by bartek on 30.05.17.
 */
import React from "react"

import Title from './Title';
import ChartComponent from './ChartComponent';
import Input from "./Input";
// import Calendar from "./Calendar";

export default class Layout extends React.Component {
    constructor() {
        super();
        this.state = {title: "Peak Advisor"}
    }


    changeTitle() {
        console.log("CHanging title")
        this.setState({title: "PeaknieAdbisor"})
    }

    downloadData(currency, start, end) {
        var rest, mime, client;
        rest = require('rest'),
            mime = require('rest/interceptor/mime');
        console.log(currency, start, end)

        let a;
        client = rest.wrap(mime);
        client({path: 'http://localhost:8080/PIK-WebApp-0.0.1-SNAPSHOT/getValue?currency=' + currency + '&start=' + start + '&end=' + end + "&power=3"}).then(response => {
                console.log(response)
                a = JSON.parse(response['entity']);
                console.log("waluta", a['currency'])
                this.setState({currency: a['currency']})
                let data = [];
                let times = [];
                for (let key in a['history']) {
                    times.push(key);
                    data.push(a['history'][key]);
                }
                this.setState({times: times})
                this.setState({data: data})
                let predData = [];
                let predTimes = [];
                for (let key in a['predicted']) {
                    predTimes.push(key);
                    predData.push(a['predicted'][key]);
                 }
                this.setState({predTimes: predTimes})
                this.setState({predData: predData})
            }
        );

        // let predTimes = ['1496933390', '1496933490', '1496933590', '1496933690', '1496933790', '1496933890', '1496933990', '1496934090', '1496934190', '1496934290', '1496934390', '1496934490', '1496934590', '1496934690', '1496934790', '1496934890', '1496934990', '1496935090', '1496935190', '1496935290', '1496935390', '1496935490', '1496935590', '1496935690', '1496935790', '1496935890', '1496935990', '1496936090', '1496936190', '1496936290', '1496936390', '1496936490', '1496936590', '1496936690', '1496936790', '1496936890', '1496936990', '1496937090', '1496937190', '1496937290']
        // let times = ['1496929390', '1496929490', '1496929590', '1496929690', '1496929790', '1496929890', '1496929990', '1496930090', '1496930190', '1496930290', '1496930390', '1496930490', '1496930590', '1496930690', '1496930790', '1496930890', '1496930990', '1496931090', '1496931190', '1496931290', '1496931390', '1496931490', '1496931590', '1496931690', '1496931790', '1496931890', '1496931990', '1496932090', '1496932190', '1496932290', '1496932390', '1496932490', '1496932590', '1496932690', '1496932790', '1496932890', '1496932990', '1496933090', '1496933190', '1496933290']
        // let predData = ['0.0', '0.841470984808', '0.909297426826', '0.14112000806', '-0.756802495308', '-0.958924274663', '-0.279415498199', '0.656986598719', '0.989358246623', '0.412118485242', '-0.544021110889', '-0.999990206551', '-0.536572918', '0.420167036827', '0.990607355695', '0.650287840157', '-0.287903316665', '-0.96139749188', '-0.750987246772', '0.149877209663', '0.912945250728', '0.836655638536', '-0.0088513092904', '-0.846220404175', '-0.905578362007', '-0.132351750098', '0.76255845048', '0.956375928405', '0.270905788308', '-0.663633884213', '-0.988031624093', '-0.404037645323', '0.551426681242', '0.999911860107', '0.52908268612', '-0.428182669496', '-0.991778853443', '-0.643538133357', '0.296368578709', '0.963795386284'];
        // let data = ['1.0', '-0.416146836547', '-0.653643620864', '0.96017028665', '-0.145500033809', '-0.839071529076', '0.843853958732', '0.136737218208', '-0.957659480323', '0.660316708244', '0.408082061813', '-0.999960826395', '0.424179007337', '0.646919322329', '-0.962605866314', '0.154251449888', '0.834223360507', '-0.848570274785', '-0.127963689627', '0.955073644047', '-0.666938061652', '-0.399985314988', '0.999843308648', '-0.432177944885', '-0.640144339469', '0.964966028492', '-0.162990780796', '-0.829309832863', '0.853220107723', '0.119180135449', '-0.952412980415', '0.673507162324', '0.39185723043', '-0.999647455966', '0.440143022496', '0.633319203086', '-0.967250588274', '0.171717341831', '0.824331331108', '-0.857803093245'];
        //
        //
        //
        // this.setState({times: times});
        // this.setState({data: data});
        // this.setState({predTimes: predTimes});
        // this.setState({predData: predData});
        // this.setState({currency: "USD"})
    }

    render() {
        return (
            <div>
                {/*<Calendar/>*/}
                <Title title={this.state.title}/>
                <Input changeTitle={this.changeTitle.bind(this)} downloadData={this.downloadData.bind(this)}/>
                {/*<Input changeSDate={this.setStartDate.bind(this)} changeEDate={this.setEndDate.bind(this)} setCur={this.setCur.bind(this)}/>*/}
                {/*<ChartComponent startDate={this.startDate} endDate={this.endDate} currency={this.currency}/>*/}
                <ChartComponent currency={this.state.currency} data={this.state.data} times={this.state.times}
                                predData={this.state.predData} predTimes={this.state.predTimes}/>
                                {/*<div>*/}
                    {/*<canvas ref={'chart'} height={'400'} width={'600'}/>*/}
                {/*</div>*/}
            </div>
        );
    }
}
