<template>
  <div class="header-container">{{ title }}</div>
</template>

<script>
export default {
  props: {
    // 声明 title 自定义属性，允许使用者自定义标题的内容
    title: {
      default: '',
      type: String
    }
  }
}
</script>

<style lang="less" scoped>
.header-container {
  font-size: 12px;
  height: 45px;
  width: 100%;
  background-color: #1d7bff;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #fff;
  position: fixed;
  top: 0;
  z-index: 999;
}
</style>
