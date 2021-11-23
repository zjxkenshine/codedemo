import Vue from 'vue'
import App from './App.vue'
// 导入 bootstrap 样式表
import 'bootstrap/dist/css/bootstrap.min.css'

Vue.config.productionTip = false

new Vue({
  render: h => h(App)
}).$mount('#app')
