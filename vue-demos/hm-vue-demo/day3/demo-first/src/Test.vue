<template>
  <div>
    <div class="test-box">
      <h3>这是用户自定义的 Test.vue --- {{ username }}</h3>
      <button @click="chagneName">修改用户名</button>
    </div>
    <div>123</div>
  </div>
</template>

<script>
// 默认导出。这是固定写法！
export default {
  // data 数据源
  // 注意：.vue 组件中的 data 不能像之前一样，不能指向对象。
  // 注意：组件中的 data 必须是一个函数
  data() {
    // 这个 return 出去的 { } 中，可以定义数据
    return {
      username: 'admin'
    }
  },
  methods: {
    chagneName() {
      // 在组件中， this 就表示当前组件的实例对象
      console.log(this)
      this.username = '哇哈哈'
    }
  },
  // 当前组件中的侦听器
  watch: {},
  // 当前组件中的计算属性
  computed: {},
  // 当前组件中的过滤器
  filters: {}
}
</script>

<style lang="less">
.test-box {
  background-color: pink;
  h3 {
    color: red;
  }
}
</style>
