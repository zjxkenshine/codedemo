<template>
  <div class="left-container">
    <h3>Left 组件 --- {{ count }}</h3>
    <button @click="count += 1">+1</button>
  </div>
</template>

<script>
export default {
  name: 'MyLeft',
  data() {
    return {
      count: 0
    }
  },
  created() {
    console.log('Left 组件被创建了！')
  },
  destroyed() {
    console.log('Left 组件被销毁了~~~')
  },

  // 当组件第一次被创建的时候，既会执行 created 生命周期，也会执行 activated 生命周期
  // 当时，当组件被激活的时候，只会触发 activated 生命周期，不再触发 created。因为组件没有被重新创建
  activated() {
    console.log('组件被激活了，activated')
  },
  deactivated() {
    console.log('组件被缓存了，deactivated')
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
