// 导入 vue 这个包，得到 Vue 构造函数
import Vue from 'vue'
// 导入 App.vue 根组件，将来要把 App.vue 中的模板结构，渲染到 HTML 页面中
// import App from './App.vue'
import Test from './Test.vue'

Vue.config.productionTip = false

// 创建 Vue 的实例对象
new Vue({
  // 把 render 函数指定的组件，渲染到 HTML 页面中
  render: h => h(Test)
}).$mount('#app')

// Vue 实例的 $mount() 方法，作用和 el 属性完全一样！