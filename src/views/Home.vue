<template>
  <div class="home">
    <div id="myChart" :style="{width: '700px', height: '700px'}"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {

  name: 'HomePages',
  data(){
    return{
      tableData:[],
      data:[],
    }
  },
  mounted(){
    this.Draw()
    this.$http.get("equipment/getAll").then(resp=>{
      console.log(resp.data)
      this.tableData = resp.data;
      for(var i = 0; i < this.tableData.length; i++) {
        var d = {name: '', value: 0}
        d.name = this.tableData[i].equipmentType
        d.value = this.tableData[i].equipmentNumber
        // 往data数组中添加数据


        this.data.push(d)
      }

     //
     // this.data.sort((a , b) => b.value - a.value)
     //  // 覆盖data(){}中全局变量的数据
     //  this.data = data


      this.Draw()
    });
  },
  methods: {
    Draw() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = echarts.init(document.getElementById('myChart'))

      // 绘制图表
      myChart.setOption({
        // options配置项

          tooltip: {
            trigger: 'item'
          },
          legend: {
            top: '5%',
            left: 'center'
          },
          series: [
            {
              name: 'Access From',
              type: 'pie',
              radius: ['40%', '70%'],
              avoidLabelOverlap: false,
              itemStyle: {
                borderRadius: 10,
                borderColor: '#fff',
                borderWidth: 2
              },
              label: {
                show: false,
                position: 'center'
              },
              emphasis: {
                label: {
                  show: true,
                  fontSize: 40,
                  fontWeight: 'bold'
                }
              },
              labelLine: {
                show: false
              },
              data: this.data,
            }
          ]

      })
    }
  }
}
</script>

<style scoped>

</style>