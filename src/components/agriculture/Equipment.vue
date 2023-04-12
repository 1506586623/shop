<template>
  <el-input v-model="param" placeholder="Please input name" style="width: 300px;margin-left: 30px"/>
      <el-button type="primary" style="margin-left: 5px"  @click="SearchById">
        <el-icon style="vertical-align: middle">
          <Search />
        </el-icon> <span style=";vertical-align: middle"  >搜索</span>
      </el-button>
      <el-button type="warning" >
        <el-icon style="vertical-align: middle">
          <RefreshLeft />
        </el-icon> <span style="vertical-align: middle">重置</span>
      </el-button>
      <el-button type="success" @click="dialogFormVisible = true">
        <el-icon style="vertical-align: middle">
          <Plus />
        </el-icon> <span style="vertical-align: middle">新增</span>
      </el-button>
  <el-table
      :data="tableData"
      style="width: 50%; margin-left: 300px; margin-top: 200px">
    <el-table-column
        prop="equipmentNumber"
        label="设备编号"
        width="180">
    </el-table-column>
    <el-table-column
        prop="equipmentType"
        label="设备类型"
        width="180">
    </el-table-column>
    <el-table-column
        prop="equipmentProduct"
        label="生产产品">
    </el-table-column>
    <el-table-column
        prop="equipmentWear"
        label="磨损程度">
    </el-table-column>
  </el-table>
  <el-dialog  v-model="dialogFormVisible" label-width="80px" >
    <el-form v-model="form" >
    <el-form-item label="设备编号">
      <el-input v-model="form.equipmentNumber"></el-input>
    </el-form-item>
    <el-form-item label="设备类型">
      <el-input v-model="form.equipmentType"></el-input>
    </el-form-item>
    <el-form-item label="生产产品">
      <el-input v-model="form.equipmentProduct"></el-input>
    </el-form-item>
    <el-form-item label="磨损程度">
      <el-input v-model="form.equipmentWear"></el-input>
    </el-form-item>
    <el-form-item label="设备介绍">
      <el-input v-model="form.equipmentIntroduction"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即创建</el-button>
      <el-button>取消</el-button>
    </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>

export default {
  name: "EquipmentManage",
  data() {
    return {
      tableData: [],
      multipleSelection: [],
      formLabelWidth: '120px',
      dialogFormVisible: false,
      form: {},
      param:'',
    }
  },
  created() {
    this.showData();
  },
 methods:{
    showData(){
      this.$http.get("equipment/getAll").then(resp=>{
        console.log(resp.data)
        this.tableData = resp.data;
      });
    },
   onSubmit() {
     this.$http.post("equipment/insert",this.form).then(resp=>{
       // console.log(resp.data)
       if(resp.data){
         this.$message({
           message: '添加成功',
           type: 'success'
         });
         this.showData();
         this.dialogFormVisible=false;
       }
     });
   },
   SearchById(){
     this.$http.get("equipment/"+this.param).then(resp=>{
       this.tableData = resp.data;
     });
   }
   },



}
</script>