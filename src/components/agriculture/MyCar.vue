<template>
  <el-table
      :data="tableData"
      border
      style="width: 100%">
    <el-table-column
        prop="name"
        label="商品名称"
        width="180">
    </el-table-column>
    <el-table-column label="商品图片">
      <el-image
          style="width: 100px; height: 100px"
          :src="image"
      ></el-image>
    </el-table-column>
    <el-table-column
        prop="des"
        label="商品描述"
        width="180">
    </el-table-column>
    <el-table-column
        prop="type"
        label="商品款式">
    </el-table-column>
    <el-table-column
        prop="store"
        label="所属店铺">
    </el-table-column>
    <el-table-column
        label="购买数量">
      <el-button type="danger" icon="minus" circle size="small" @click="remove"></el-button>
      <el-input v-model="num" style="width: 40px;margin-left: 10px"></el-input>
      <el-button type="primary" icon="plus" circle size="small" style="margin-left: 10px;" @click="plus"></el-button>
    </el-table-column>
    <el-table-column label="操作">
      <el-button  type="danger" size="small" @click="jump(row)">删除</el-button>
    </el-table-column>
  </el-table>
  <el-checkbox v-model="checked">全选</el-checkbox>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        name: '华为平板matepad11',
        image: 'https://i.postimg.cc/ZRnnRxsp/5.jpg',
        des: '青春版8英寸平板电脑 安卓WiFi/4G通话智能游戏学习平板商务',
        type: '金色',
        store:'店铺a',
        num: 3
      }
      ],
      image:"https://i.postimg.cc/ZRnnRxsp/5.jpg",
      num:3
    }
  }
}
</script>
