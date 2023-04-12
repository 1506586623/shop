<template>
  <el-input v-model="param" placeholder="请输入编号" style="width: 300px;margin-left: 30px"/>
  <el-button type="primary" style="margin-left: 5px"  @click="SearchById">
    <el-icon style="vertical-align: middle">
      <Search />
    </el-icon> <span style=";vertical-align: middle"  >搜索</span>
  </el-button>
  <el-table
      :data="tableData"
      style="width: 50%; margin-left: 300px; margin-top: 200px" >
    <el-table-column
        prop="id"
        label="刀具编号"
        width="180">
    </el-table-column>
    <el-table-column
        prop="name"
        label="刀具名称"
        width="180">
    </el-table-column>
    <el-table-column  label="图片" width="200px">
      <template #default="{row}">
        <el-image
            style="width: 200px; height: 200px"
            :src="row.pic1"
        ></el-image>
      </template>
    </el-table-column>
    <el-table-column  label="图纸" width="200px">
      <template #default="{row}">
        <el-image
            style="width: 200px; height: 200px"
            :src="row.pic2"
        ></el-image>
      </template>
    </el-table-column>
    <el-table-column
        prop="address"
        label="位置">
    </el-table-column>
    <el-table-column
        prop="number"
        label="数量">
    </el-table-column>
  </el-table>

</template>

<script>

export default {
  name: "KnifeManage",
  data() {
    return {
      tableData: [],
      multipleSelection: [],
      formLabelWidth: '120px',

      form: {},
      param:'',
    }
  },
  created() {
     // this.showData();
  },
  methods:{
    showData(){
      this.$http.get("knife/getAll").then(resp=>{
        console.log(resp.data)
        this.tableData = resp.data;
      });
    },
    // onSubmit() {
    //   this.$http.post("equipment/insert",this.form).then(resp=>{
    //     // console.log(resp.data)
    //     if(resp.data){
    //       this.$message({
    //         message: '添加成功',
    //         type: 'success'
    //       });
    //       this.showData();
    //       this.dialogFormVisible=false;
    //     }
    //   });
    // },
    SearchById(){
      this.$http.get("knife/"+this.param).then(resp=>{
        this.tableData = resp.data;
      });
    }
  },



}
</script>