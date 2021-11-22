<template>
  <div class="app-container">
    <h1>App 根组件</h1>

    <button @click="flag = !flag">Toggle Flag</button>
    <Test info="你好" v-if="flag"></Test>

    <hr />

    <div class="box">
      <!-- 渲染 Left 组件和 Right 组件 -->
      <!-- 3. 以标签形式，使用注册好的组件 -->
      <Left></Left>
      <Right></Right>
    </div>
  </div>
</template>

<script>
// 1. 导入需要使用的 .vue 组件
import Left from '@/components/Left.vue'
import Right from '@/components/Right.vue'
import Test from '@/components/Test.vue'

export default {
  data() {
    return {
      flag: true
    }
  },
  // 2. 注册组件
  components: {
    Left,
    Right,
    Test
  }
}
</script>

<style lang="less">
.app-container {
  padding: 1px 20px 20px;
  background-color: #efefef;
}
.box {
  display: flex;
}
</style>
