<template>
  <h3>选购商品</h3>
  <el-table :data="pageInfo.list" stripe border>
    <el-table-column prop="productId" label="商品id"></el-table-column>
    <el-table-column prop="productNo" label="商品编号"></el-table-column>
    <el-table-column prop="productName" label="商品名称"></el-table-column>
    <el-table-column  label="图片">
      <template #default="{row}">
        <el-image
            style="width: 100px; height: 100px"
            :src="row.image"

            ></el-image>
      </template>
    </el-table-column>
    <el-table-column prop="productDes" label="商品描述"></el-table-column>
    <el-table-column prop="productType" label="商品类型"></el-table-column>
    <el-table-column prop="productPrice" label="商品价格"></el-table-column>
    <el-table-column prop="stock" label="库存"></el-table-column>
    <el-table-column prop="commit" label="评论"></el-table-column>
    <el-table-column prop="store" label="店铺"></el-table-column>
    <el-table-column  label="操作">
      <template #default="{row}">
          <el-button  type="primary" size="small" @click="jump(row)">详情</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
      style="margin-left: 1050px"
      layout="prev,pager,next,total,jumper,sizes"
      :total="pageInfo.total"
      v-model:currentPage="pageInfo.pageNum"
      v-model:page-size="pageInfo.pageSize"
      :page-sizes="[1,3,5]"
      background
      @current-change="handleCurrentChange"
      @size-change="handleSizeChange"
  >
  </el-pagination>
</template>
<script>
export default {
  name: "MyShop",
  methods:{
    showDate(){
      let params = {
        pageNum:this.pageInfo.pageNum,
        pageSize:this.pageInfo.pageSize
      }
      this.$http.get("product/getPaged",{params:params}).then(resp=>{
        // console.log(resp.data)
        this.pageInfo = resp.data;
      });
    },
    handleCurrentChange(){
      this.showDate();
    },
    jump(row){
      this.$router.push({name:'myproduct',params:{productId:row.productId}})
    }
  },
  created(){
    this.showDate();
  },
  data(){
    return {
      pageInfo:{
        pageNum:1,
        pageSize:3
      }
    }
  }

}
</script>

<style scoped>

</style>