const path = require('path');//node.js中专门操作路径的模块

//1.导入 html-webpack-plugin 插件,得到构造函数
const HtmlPlugin =require('html-webpack-plugin')
//2. new 构造函数,创建插件实例对象
const htmlPlugin = new HtmlPlugin({
    //指定要复制哪个页面
    template: './src/index.html',
    //指定复制出来的文件名和存放路径
    filename: './index.html'
})

//使用Node.js中的导出语法,向外导出一个webpack的配置对象
module.exports = {
    //运行模式 development production
    mode: 'development',
    //入口，默认为./src/index.js 不用配置
    entry: path.join(__dirname,'./src/index.js'),
    //出口,默认为./dist/main.js
    output: {
        path: path.join(__dirname,'./dist'),
        filename: 'bundle.js'
    },
    //插件数组，webpack运行时会调用这些插件
    plugins: [htmlPlugin],
    //devServer节点进行更多配置
    devServer: {
        //首次打包成功自动打开浏览器
        open: true,
        //端口
        port: 80,
        //指定运行的地址
        host: '127.0.0.1'
    }
}


