<template>
  <div class="right-container">
    <h3>Right 组件 --- {{ count }}</h3>
    <button @click="add">+1</button>
    <hr />
    <p>{{ msgFromLeft }}</p>
  </div>
</template>

<script>
// 1. 导入 eventBus.js 模块
import bus from './eventBus.js'

export default {
  data() {
    return {
      // 子组件自己的数据，将来希望把 count 值传给父组件
      count: 0,
      msgFromLeft: ''
    }
  },
  created() {
    // 2. 为 bus 绑定自定义事件
    bus.$on('share', val => {
      console.log('在 Right 组件中定义的 share 被触发了！', val)
      this.msgFromLeft = val
    })
  },
  methods: {
    add() {
      // 让子组件的 count 值自增 +1
      this.count += 1
      // 把自增的结果，传给父组件
      this.$emit('numchange', this.count)
    }
  }
}
</script>

<style lang="less">
.right-container {
  padding: 0 20px 20px;
  background-color: lightskyblue;
  min-height: 250px;
  flex: 1;
}
</style>
