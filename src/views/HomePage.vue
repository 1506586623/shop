<!--<template>-->
<!--  <div class="home">-->
<!--    <div id="mychart" :style="{width: '700px', height: '700px'}"></div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import * as echarts from 'echarts';-->
<!--import JSON from '../assets/map.json'; // 引入json文件-->

<!--export default {-->
<!--  name: 'AreaEchart',-->
<!--  data() {-->
<!--    return {-->
<!--      tableData: [],-->
<!--      multipleSelection: [],-->
<!--      formLabelWidth: '120px',-->
<!--      form: {},-->
<!--      param: '',-->
<!--      city: '',-->
<!--      data:[],-->
<!--      mapData: [-->
<!--        {name: '浑江区', adcode: '1'},-->
<!--        {name: '江源区', adcode: '2'},-->
<!--        {name: '抚松县', adcode: '3'},-->
<!--        {name: '靖宇县', adcode: '4'},-->
<!--        {name: '长白朝鲜族自治县', adcode: '5'},-->
<!--        {name: '临江市', adcode: '6'},-->
<!--      ],-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    this.initChart();-->
<!--  },-->
<!--  methods: {-->
<!--    initChart() {-->
<!--      this.mychart = echarts.init(document.getElementById('mychart'));-->
<!--      echarts.registerMap('地图', JSON, {}); // 引入地图文件-->
<!--      var option = {-->
<!--        series: [-->
<!--          {-->
<!--            type: 'map',-->
<!--            mapType: '地图', // 地图名称-->
<!--            data: this.mapData.map((item) => ({-->
<!--              name: item.name,-->
<!--              value: item.adcode,-->
<!--            })),-->
<!--            label: {-->
<!--              show: true,-->
<!--              color: '#333',-->
<!--            },-->
<!--            emphasis: {-->
<!--              label: {-->
<!--                show: true,-->
<!--                color: '#333',-->
<!--              },-->
<!--            },-->
<!--          },-->
<!--        ],-->
<!--      };-->
<!--      this.mychart.setOption(option);-->

<!--      // 点击事件-->
<!--      this.mychart.on('click', (params) => {-->
<!--        const clickedName = params.name;-->
<!--        const clickedArea = this.mapData.find(-->
<!--            (item) => item.name === clickedName-->
<!--        );-->
<!--        console.log(clickedArea.adcode);-->
<!--        this.data = [];-->

<!--        this.$http.get("knife/" + clickedArea.adcode).then(resp => {-->
<!--          this.tableData = resp.data;-->
<!--          for(var i = 0; i < this.tableData.length; i++) {-->
<!--            var d = {name: '', value: 0}-->
<!--            d.name = this.tableData[i].id-->
<!--            d.value = this.tableData[i].name-->
<!--            // 往data数组中添加数据-->
<!--            this.data.push(d)-->
<!--            console.log(this.data);-->
<!--          }-->
<!--        });-->
<!--      });-->
<!--    },-->

<!--  },-->
<!--};-->
<!--</script>-->



