<template>
  <div class="app-container">
    <h1 v-color="color">App 根组件</h1>
    <p v-color="'red'">测试</p>

    <button @click="color = 'green'">改变 color 的颜色值</button>
    <hr />

    <Article>
      <template #title>
        <h3>一首诗</h3>
      </template>

      <template #content="{ msg, user }">
        <div>
          <p>啊，大海，全是水。</p>
          <p>啊，蜈蚣，全是腿。</p>
          <p>啊，辣椒，净辣嘴。</p>
          <p>{{ msg }}</p>
          <p>{{ user.name }}</p>
        </div>
      </template>

      <template #author>
        <div>作者：彬果锅</div>
      </template>
    </Article>

    <hr />

    <div class="box" style="display: none;">
      <!-- 渲染 Left 组件和 Right 组件 -->
      <Left>
        <!-- 默认情况下，在使用组件的时候，提供的内容都会被填充到名字为 default 的插槽之中 -->
        <!-- 1. 如果要把内容填充到指定名称的插槽中，需要使用 v-slot: 这个指令 -->
        <!-- 2. v-slot: 后面要跟上插槽的名字 -->
        <!-- 3. v-slot: 指令不能直接用在元素身上，必须用在 template 标签上 -->
        <!-- 4. template 这个标签，它是一个虚拟的标签，只起到包裹性质的作用，但是，不会被渲染为任何实质性的 html 元素 -->
        <!-- 5. v-slot: 指令的简写形式是 # -->
        <template #default>
          <p>这是在 Left 组件的内容区域，声明的 p 标签</p>
        </template>
      </Left>
    </div>
  </div>
</template>

<script>
import Left from '@/components/Left.vue'
import Article from '@/components/Article.vue'

export default {
  data() {
    return {
      color: 'blue'
    }
  },
  components: {
    Left,
    Article
  },
  // 私有自定义指令的节点
  directives: {
    // 定义名为 color 的指令，指向一个配置对象
    /* color: {
      // 当指令第一次被绑定到元素上的时候，会立即触发 bind 函数
      // 形参中的 el 表示当前指令所绑定到的那个 DOM 对象
      bind(el, binding) {
        console.log('触发了 v-color 的 bind 函数')
        el.style.color = binding.value
      },
      // 在 DOM 更新的时候，会触发 update 函数
      update(el, binding) {
        console.log('触发了 v-color 的 update 函数')
        el.style.color = binding.value
      }
    } */
    color(el, binding) {
      el.style.color = binding.value
    }
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
