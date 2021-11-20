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

# 2.Vue简介及基本使用

## 2.1 简介

1. 一套用于构建用户界面的前端框架

   - ① 数据驱动视图
   - ② 双向数据绑定

2. MVVM：vue 实现数据驱动视图和双向数据绑定的核心原理

   - Model 表示当前页面渲染时所依赖的数据源。

   - View 表示当前页面所渲染的 DOM 结构。

   - ViewModel 表示 vue 的实例，它是 MVVM 的核心

## 2.2 基本使用

1. Vue基本使用：

   - 导入 vue.js 的 script 脚本文件

   - 在页面中声明一个将要被 vue 所控制的 DOM 区域

   - 创建 vm 实例对象（vue 实例对象）

## 2.3 Vue指令

指令（Directives）是 vue 为开发者提供的模板语法，用于辅助开发者渲染页面的基本结构。

#### 1. 内容渲染指令

1. `v-text` 指令的缺点：会覆盖元素内部原有的内容！
2. `{{ }}` 插值表达式：在实际开发中用的最多，只是内容的占位符，不会覆盖原有的内容！
   - 除了支持绑定简单的数据值之外，还支持 Javascript 表达式的运算
3. `v-html` 指令的作用：可以把带有标签的字符串，渲染成真正的 HTML 内容！



#### 2. 属性绑定指令

>  注意：插值表达式只能用在元素的**内容节点**中，不能用在元素的**属性节点**中！

+ 在 vue 中，可以使用 `v-bind:` 指令，为元素的属性动态绑定值；

+ 简写是英文的 `:`

+ 在使用 v-bind 属性绑定期间，如果绑定内容需要进行动态拼接，则字符串的外面应该包裹单引号，例如：

  ```xml
  <div :title="'box' + index">这是一个 div</div>
  ```



#### 3. 事件绑定

1. `v-on:` 简写是 `@`

2. 语法格式为：

   ```
   <button @click="add"></button>
   methods: {
      add() {
   		// 如果在方法中要修改 data 中的数据，可以通过 this 访问到
   		this.count += 1
      }
   }
   ```

3. `$event` 的应用场景：如果默认的事件对象 e 被覆盖了，则可以手动传递一个  $event。例如：

   ```
   <button @click="add(3, $event)"></button>
   methods: {
      add(n, e) {
   			// 如果在方法中要修改 data 中的数据，可以通过 this 访问到
   			this.count += 1
      }
   }
   ```

4. 事件修饰符：

   + `.prevent`：阻止默认行为（例如：阻止 a 连接的跳转、阻止表单的提交等）

     ```
     <a @click.prevent="xxx">链接</a>
     ```

   + `.stop`：阻止事件冒泡

     ```
     <button @click.stop="xxx">按钮</button>
     ```

   + `.capture `：以捕获模式触发当前的事件处理函数
   
   + `.once `：绑定的事件只触发1次
   
   + `.self`：只有在 `event.target` 是当前元素自身时触发事件处理函数
   
5. 按键修饰符：`@keyup.esc="clearInput"`在案esc键时触发方法

#### 4. v-model 双向绑定指令

1. input 输入框
   + type="radio"
   + type="checkbox"
   + type="xxxx"
2. textarea
3. select
4. 修饰符：
   - `.number`：自动将用户的输入值转为数值类型
   - `.trim`：自动过滤用户输入的首尾空白字符
   - `.lazy `：在“change”时而非“input”时更新



#### 5. 条件渲染指令

`v-if`与`v-for`：

1. `v-show` 的原理是：动态为元素添加或移除 `display: none` 样式，来实现元素的显示和隐藏
   + 如果要频繁的切换元素的显示状态，用 v-show 性能会更好
2. `v-if` 的原理是：每次动态创建或移除元素，实现元素的显示和隐藏
   + 如果刚进入页面的时候，某些元素默认不需要被展示，而且后期这个元素很可能也不需要被展示出来，此时 v-if 性能更好

>  在实际开发中，绝大多数情况，不用考虑性能问题，直接使用 v-if 就好了！！！

v-if 指令在使用的时候，有两种方式：

1. 直接给定一个布尔值 true 或 false

   ```xml
   <p v-if="true">被 v-if 控制的元素</p>
   ```

2. 给 v-if 提供一个判断条件，根据判断的结果是 true 或 false，来控制元素的显示和隐藏

   ```xml
   <p v-if="type === 'A'">良好</p>
   ```

其他指令：`v-else`，`v-else-if`



#### 6.列表渲染指令

- vue 提供了`v-for`列表渲染指令，用来辅助开发者基于一个数组来循环渲染一个列表结构
- v-for 指令需要使用 `item in items` 形式的特殊语法：
  - items 是待循环的数组
  - item 是被循环的每一项
- v-for 中的索引：可选的第二个参数
  - 语法格式为 ：`(item, index) in items`







