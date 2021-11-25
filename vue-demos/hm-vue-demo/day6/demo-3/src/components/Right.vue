<template>
  <div class="right-container">
    <h3>Right 组件</h3>
    <button @click="postInfo">发起 POST 请求</button>
    <button @click="btnGetBooks">获取图书列表的数据</button>
  </div>
</template>

<script>
// import axios from 'axios'
export default {
  methods: {
    async postInfo() {
      const { data: res } = await this.$http.post('/api/post', {
        name: 'zs',
        age: 20
      })
      console.log(res)
    },
    // 点击按钮，获取图书列表的数据
    async btnGetBooks() {
      const { data: res } = await this.$http.get('/api/getbooks')
      console.log(res)
    }
  }
}
</script>

<style lang="less" scoped>
.right-container {
  background-color: skyblue;
  min-height: 200px;
  flex: 1;
}
</style>
