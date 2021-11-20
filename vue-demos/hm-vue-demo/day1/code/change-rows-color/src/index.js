//1.使用ES6导入语法
import $ from 'jquery'
//导入样式(在webpack中,一切皆模块,都可以通过ES6导入和使用)
import '@/css/index.css'
import '@/css/index.less'

//logo图片文件
import logo from '@/images/logo.jpg'
// 2. 给 img 标签的 src 动态赋值
$('.box').attr('src', logo)

//2.定义jquery的入口函数
$(function(){
    //3.实现奇偶行变色
    $('li:odd').css('background-color','red');
    $('li:even').css('background-color','pink');
})

// 定义装饰器函数 ES6高级语法，需要babel-loader
function info(target) {
    target.info = 'Person info.'
}

// 定义一个普通的类
@info
class Person {}
console.log(Person.info)

