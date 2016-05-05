/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , http = require('http')
  , path = require('path')
  , bodyParser = require('body-parser')
  , favicon = require('serve-favicon')
  , logger = require('morgan')
  , methodOverride = require('method-override');

var app = express();

var data = require('./data.json');
console.log(data)
//for(i = 0; i < data.length; i++){
//  data[i]["testcode"] = data[i]["testcode"].replace(/;/g,";\n <br>");
//}

app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(favicon(__dirname + '/public/images/favicon.png'));
app.use(logger('dev'));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(methodOverride('_method'));
app.use(require('stylus').middleware(__dirname + '/public'));
app.use(express.static(path.join(__dirname, 'public')));


if (app.get('env') == 'development') {
	app.locals.pretty = true;
}
app.get('/', function(req, res){
  var dat = JSON.stringify(data)
	res.render('index', {
    data: data,
    data2: dat
});
});

http.createServer(app).listen(app.get('port'), function(){
  console.log("Express server listening on port " + app.get('port'));
});