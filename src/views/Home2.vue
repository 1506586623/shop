<template>
  <div class="home">
    <div id="mychart" :style="{width: '700px', height: '700px'}"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import chila from "../assets/china.json"
export default {

  name: 'HomePages2',
  data(){
    return{
      tableData:[],
      data:[],
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.mychart = echarts.init(document.getElementById('mychart'))

      echarts.registerMap("china", chila);

      var features = chila.features;
      var empty = [];
      features.forEach((item, i) => {
        empty.push({
          id: i + 1,
          name: item.properties.name,
        });
      })
      var markPointData = [{
        name: "四川移动",
        coord: [
          108.393982, 31.175037 //坐标，通过高德
        ],
        selected: false,
      }, {
        name: "河南电信",
        coord: [
          108.391429, 31.177332
        ],
        selected: false,

      }];
      let option = {
        backgroundColor: "#404a59",
        tooltip: {
          trigger: "item",
          formatter: function(val) {
            return "人数: 人";
          },
        },
        toolbox: {
          show: true,
          orient: "vertical",
          left: "right",
          top: "center",
          feature: {
            dataView: {
              readOnly: false
            },
            restore: {},
            saveAsImage: {},
          },
        },
        series: [{
          type: "map",
          mapType: "china", // 自定义扩展图表类型
          label: {
            show: true,
          },
          center: [108.412361, 31.170204], //当前视角的中心点
          zoom: 250, //当前视角的缩放比例
          itemStyle: {
            normal: {
              areaColor: "#323c48",
              borderColor: "white",
              label: {
                show: true,
                color: "white",
              },
              shadowColor: 'rgba(0, 120, 255, 0.5)', //外发光
              shadowBlur: 15
            },
            emphasis: {
              borderColor: "blue",
              areaColor: "red",
              label: {
                show: true,
                color: "white",
              },
            },
          },
          roam: true,
          data: empty,
          markPoint: { //图标标注。
            label: {
              normal: {
                show: true,
                formatter: function(params) { //标签内容       如果只显示图片则隐藏
                  return params.name;
                },
              },
            },
            itemStyle: {
              normal: {
                color: 'none'
              },
            },
            data: markPointData
          },
        },
          {
            name: 'mark',
            type: 'map',
            mapType: 'china',
            hoverable: false,
            roam: true,
            data: [],
            markPoint: { //图标标注。
              label: {
                normal: {
                  show: true,
                  formatter: function(params) { //标签内容       如果只显示图片则隐藏
                    return params.name;
                  },
                },
              },
              itemStyle: {
                normal: {
                  color: 'none'
                },
              },
              data: markPointData
            }
          }
        ],
      };
      this.mychart.on("click", function(params) { //单击
        console.log(params);
      });
      this.mychart.setOption(option);
    })
  }
}
</script>


<style scoped>

</style>