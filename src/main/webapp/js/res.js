/**
 * Created by bartek on 04.06.17.
 */
var rest, mime, client;

rest = require('rest'),
    mime = require('rest/interceptor/mime');

client = rest.wrap(mime);
client({ path: 'http://localhost:8080/PIK-WebApp-0.0.1-SNAPSHOT/getValue?currency=USD&start=0&end=68400' }).then(function(response) {
    let res = JSON.parse(response['entity'])
    console.log(res['currency'])
    for (let a in res['times']){
        console.log("a:" + a);
    }
});