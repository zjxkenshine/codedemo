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

const { CleanWebpackPlugin } = require('clean-webpack-plugin');


//使用Node.js中的导出语法,向外导出一个webpack的配置对象
module.exports = {
    //开发调试阶段使用
    devtool: 'eval-source-map',

    //运行模式 development production
    mode: 'development',

    //入口，默认为./src/index.js 不用配置
    entry: path.join(__dirname,'./src/index.js'),
    //出口,默认为./dist/main.js
    output: {
        // 存放的目录
        path: path.join(__dirname, 'dist'),
        // 生成的文件名
        filename: 'js/bundle.js'
    },
    //插件数组，webpack运行时会调用这些插件
    plugins: [htmlPlugin,new CleanWebpackPlugin()],
    //devServer节点进行更多配置
    devServer: {
        //首次打包成功自动打开浏览器
        open: true,
        //端口
        port: 80,
        //指定运行的地址
        host: '127.0.0.1'
    },
    module: {
        rules: [
            //定义不同模块的loader
            {test:/\.css$/,use: ['style-loader','css-loader']},
            {test:/\.less$/,use: ['style-loader','css-loader','less-loader']},
            // 处理图片文件的 loader
            // 如果需要调用的 loader 只有一个，则只传递一个字符串也行，如果有多个loader，则必须指定数组
            // 在配置 url-loader 的时候，多个参数之间，使用 & 符号进行分隔
            // 小于limit(字节)则变为base64编码
            { test: /\.jpg|png|gif$/, use: 'url-loader?limit=470&outputPath=images' },
            //处理高级js语法，一定要排除 node_modules 目录中的 JS 文件
            { test: /\.js$/, use: 'babel-loader', exclude: /node_modules/ }
        ]
    },  
    resolve: {
        alias: {
          // 告诉 webpack，程序员写的代码中，@ 符号表示 src 这一层目录
          '@': path.join(__dirname, './src/')
        }
    }
}


