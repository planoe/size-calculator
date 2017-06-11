const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const loaders = [
  {
    test: /(\.js$)|(\.jsx$)/,
    exclude: /node_modules/,
    loader: 'babel-loader'
  }
];

module.exports = {
  entry: './index.js',
  devtool: 'source-map',
  plugins: [
    new HtmlWebpackPlugin({
      title: 'Size Calculator',
      template: './index.ejs'
    })
  ],
  module: {
    loaders: [
      {
        test: /(\.js$)/,
        exclude: /node_modules/,
        loader: 'babel-loader'
      }, {
        test: /(\.css$)/,
        exclude: /node_modules/,
        loader: 'style-loader!css-loader'
      }]
  },
  output: {
    path: `${__dirname}/../java-api/src/main/resources/hehe`,
    publicPath: '/',
    filename: 'size-calculator.js'
  },
  devServer: {
    port: 8888
  }
};
