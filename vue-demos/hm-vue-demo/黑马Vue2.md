# 1.webpack

vue-cli中会自动配置webpack，了解即可

## 1.1 基础

1. 安装webpack

   ```
   npm install webpack@5.42.1 webpack-cli@4.9.0 -D
   ```

2. webpack配置：执行`webpack`命令会生成`main.js`文件

   ```
   //使用Node.js中的导出语法,向外导出一个webpack的配置对象
   module.exports = {
       //运行模式 development production(压缩) 
       mode: 'development'
   }
   ```

3. entry：打包入口，output：打包出口

4. 插件：配置在`webpack.config.js`

   - `npm install webpack-dev-server@3.11.2 -D`：修改源代码时自动打包
     - `devServer`节点可以对`webpack-dev-server`进行更多配置
   - `npm i -D html-webpack-plugin@5.3.2`：可自定义 index.html 内容
     - 复制`index.html`页面，自动注入打包的js文件

## 1.2 Loader 加载器

webpack只能默认打包处理`.js`结尾的模块，其他文件需要调用`loader加载器`才能正常打包

- `css-loader`：打包处理`.css`相关的文件，需要在`webpack` rules中配置
  - `npm i style-loader@3.0.0 css-loader@5.2.6 -D`
- `less-loader`：打包处理`.less`相关的文件
  - `npm i less-loader@10.0.1 less@4.1.1 -D`
- `url-loader`：打包与url路径相关的文件
  - `npm i url-loader@4.1.1 file-loader@6.2.0 -D`
- `babel-loader`：打包处理 `webpack` 无法处理的高级js语法
  - `npm i babel-loader@8.2.2 @babel/core@7.14.6 @babel/plugin-proposal-decorators@7.14.5 -D`
  - 需要添加`babel.config.js`进行配置

## 1.3 发布

1. package.json下新建bulid脚本
2. `clean-webpack-plugin`：自动清理掉 dist 目录中的旧文件
   - `npmjs.com`中搜索插件安装

## 1.4 SourceMap

1. 存储着源代码位置信息，打包后也能看见

   ```
   module.exports = {
       //开发调试阶段使用
       devtool: 'eval-source-map',
       ...
   }
   ```

2. 生产环境下，如果只想定位报错的具体行数，且不想暴露源码：`nosources-source-map`

3. 生产环境下，定位报错行数的同时，展示具体报错的源码：`source-map`
