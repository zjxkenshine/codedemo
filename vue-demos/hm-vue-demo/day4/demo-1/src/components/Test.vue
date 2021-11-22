<template>
  <div class="test-container">
    <h3 id="myh3">Test.vue 组件 --- {{ books.length }} 本图书</h3>
    <p id="pppp">message 的值是：{{ message }}</p>
    <button @click="message += '~'">修改 message 的值</button>
  </div>
</template>

<script>
export default {
  props: ['info'],
  data() {
    return {
      message: 'hello vue.js',
      // 定义 books 数组，存储的是所有图书的列表数据。默认为空数组！
      books: []
    }
  },
  watch: {
    message(newVal) {
      console.log('监视到了 message 的变化：' + newVal)
    }
  },
  methods: {
    show() {
      console.log('调用了 Test 组件的 show 方法！')
    },
    // 使用 Ajax 请求图书列表的数据
    initBookList() {
      const xhr = new XMLHttpRequest()
      xhr.addEventListener('load', () => {
        const result = JSON.parse(xhr.responseText)
        console.log(result)
        this.books = result.data
      })
      xhr.open('GET', 'http://www.liulongbin.top:3006/api/getbooks')
      xhr.send()
    }
  },
  // 创建阶段的第1个生命周期函数
  beforeCreate() {
    // console.log(this.info)
    // console.log(this.message)
    // this.show()
  },
  created() {
    // created 生命周期函数，非常常用。
    // 经常在它里面，调用 methods 中的方法，请求服务器的数据。
    // 并且，把请求到的数据，转存到 data 中，供 template 模板渲染的时候使用！
    this.initBookList()
  },
  beforeMount() {
    // console.log('beforeMount')
    // const dom = document.querySelector('#myh3')
    // console.log(dom)
  },
  // 如果要操作当前组件的 DOM，最早，只能在 mounted 阶段执行
  mounted() {
    // console.log(this.$el)
    // const dom = document.querySelector('#myh3')
    // console.log(dom)
  },
  beforeUpdate() {
    // console.log('beforeUpdate')
    // console.log(this.message)
    // const dom = document.querySelector('#pppp')
    // console.log(dom.innerHTML)
  },
  // 当数据变化之后，为了能够操作到最新的 DOM 结构，必须把代码写到 updated 生命周期函数中
  updated() {
    // console.log('updated')
    // console.log(this.message)
    // const dom = document.querySelector('#pppp')
    // console.log(dom.innerHTML)
  },
  beforeDestroy() {
    console.log('beforeDestroy')
    this.message = 'aaa'
    console.log(this.message)
  },
  destroyed() {
    console.log('destroyed')
    // this.message = 'aaa'
  }
}
</script>

<style lang="less" scoped>
.test-container {
  background-color: pink;
  height: 200px;
}
</style>
