<template>
  <div class="left-container">
    <h3>Left 组件</h3>
    <hr />
    <!-- 声明一个插槽区域 -->
    <!-- vue 官方规定：每一个 slot 插槽，都要有一个 name 名称 -->
    <!-- 如果省略了 slot 的 name 属性，则有一个默认名称叫做 default -->
    <slot name="default">
      <h6>这是 default 插槽的后备内容</h6>
    </slot>
  </div>
</template>

<script>
export default {}
</script>

<style lang="less">
.left-container {
  padding: 0 20px 20px;
  background-color: orange;
  min-height: 250px;
  flex: 1;
}
</style>
