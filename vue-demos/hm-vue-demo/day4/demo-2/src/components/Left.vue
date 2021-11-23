<template>
  <div class="left-container">
    <h3>Left 组件</h3>
    <p>msg 的值是：{{ msg }}</p>
    <p>user 的值是：{{ user }}</p>
    <!--不建议修改props的值-->
    <button @click="msg = 'abc'">修改 msg</button>
    <button @click="user.name = 'zs'">修改 user</button>
    <hr />

    <button @click="send">把好诗发给 Right</button>

    <hr />
  </div>
</template>

<script>
// 1. 导入 eventBus.js 模块
import bus from './eventBus.js'

export default {
  props: ['msg', 'user'],
  data() {
    return {
      str: `黑云压城城欲摧，渚青沙白鸟飞回。借问酒家何处是，半江瑟瑟半江红！`,
      arr: [
        { id: 1, name: 'zs' },
        { id: 2, name: 'ls' }
      ]
    }
  },
  methods: {
    send() {
      // 2. 通过 eventBus 来发送数据
      bus.$emit('share', this.str)
    }
  }
}
</script>

<style lang="less">
.left-container {
  padding: 0 20px 20px;
  background-color: orange;
  min-height: 250px;
  flex: 1;
}
</style>
