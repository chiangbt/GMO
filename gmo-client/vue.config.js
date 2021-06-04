let proxyObj = {}

proxyObj['/'] = {
  //websocket
  ws: false,
  //目标地址
  target: 'http://localhost:3000',
  //发送请求头中host会设置成target
  changeOrigin: true,
  //不重写请求地址
  pathRewrite: {
    '^/': '/'
  }
}
module.exports = {
  devServer: {
    host: '127.0.0.1',
    port: 4000,
    proxy: proxyObj
  },
  configureWebpack: {
    devtool: 'source-map'
  }
}