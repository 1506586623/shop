<template>
  <router-view></router-view>
</template>

<script>
import {provide} from "vue"
import * as echarts from "echarts"
import axios from "axios"

export default {
  name: 'App',
  components: {

  },
  setup(){
    // provide("名字随便"，“传递的内容”）
    provide("echarts",echarts)
    provide("axios",axios)
  }
}
</script>

<style>
body{
  /*background:url("~@/assets/123.png") top center no-repeat;*/
}
</style>
