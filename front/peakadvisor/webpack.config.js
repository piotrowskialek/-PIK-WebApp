 module.exports = {
     entry: './src/app.js',
     output: {
         path: __dirname + '/bin',
         filename: 'app.bundle.js'
     },
     module: {
     	loaders: [{
     		test: /\.js$/,
     		exclude: /node_modules/, //do not compile external libs
     		loader: 'babel-loader',
            query: {
                presets: ['react', 'es2015', 'stage-0'],
                plugins: ['react-html-attrs', 'transform-decorators-legacy', 'transform-class-properties'],
            }
        }]
     }
 };