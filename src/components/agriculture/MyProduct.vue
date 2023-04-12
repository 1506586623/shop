<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="6">
          <span class="main_title">电商平台</span>
        </el-col>
        <el-col :span="2" :offset="16" class="user_title">
          ADMIN
        </el-col>
      </el-row>
    </el-header>
    <el-container>
      <el-aside width="800px">
        <el-image
            style="width: 300px; height: 400px;margin-left: 300px;margin-top: 150px"
            :src="product.image"
        ></el-image>
      </el-aside>
      <el-main class="main">
        <el-descriptions style="margin-top: 90px" class="margin-top" title="商品信息" :column="3" :size="size" border>
          <el-descriptions-item>
            <template v-slot:label>
              <i class="el-icon-user"></i>
              商品名称
            </template>
            {{this.product.productName}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template v-slot:label>
              <i class="el-icon-mobile-phone"></i>
              商品描述
            </template>
            {{this.product.productDes}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template v-slot:label>
              <i class="el-icon-location-outline"></i>
              商品类型
            </template>
            {{this.product.productType}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template v-slot:label>
              商品价格
            </template>
            {{this.product.productPrice}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template v-slot:label>
              <i class="el-icon-office-building"></i>
              库存
            </template>
            {{this.product.stock}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template v-slot:label>
              <i class="el-icon-office-building"></i>
              店铺
            </template>
            {{this.product.store}}
          </el-descriptions-item>
        </el-descriptions><br><br>
        <div>
          <el-button @click="show3 = !show3">查看评论</el-button>

          <div style="margin-top: 20px; height: 200px;">
            <el-collapse-transition>
              <div v-show="show3">
                <div class="transition-box">评论一</div>
                <div class="transition-box">评论二</div>
              </div>
            </el-collapse-transition>
          </div>
        </div><br><br>
        <el-button  type="danger"  icon="shop" @click="dialogFormVisible2 = true">加入购物车</el-button>
        <el-button  type="primary"  icon="check" @click="dialogFormVisible = true">购买商品</el-button>
        <el-button  type="primary"  icon="promotion" @click="return1" style="background-color: #cac6c6">返回</el-button>


        <el-dialog title="填写订单" v-model="dialogFormVisible">
          <el-form :model="form" >
            <el-form-item label="商品图片" :label-width="formLabelWidth">
              <el-image
                  style="width: 60px; height: 90px"
                  :src="product.image"
              ></el-image>
            </el-form-item>
            <el-form-item label="商品单价" :label-width="formLabelWidth">
              <el-input v-model="product.productPrice" :disabled="true" style="width: 220px"></el-input>
            </el-form-item>
            <el-form-item label="商品名称" :label-width="formLabelWidth">
              <el-input v-model="product.productName" :disabled="true" style="width: 220px"></el-input>
            </el-form-item>
            <el-form-item label="商品描述" :label-width="formLabelWidth">
              <el-input v-model="product.productDes" :disabled="true" style="width: 220px"></el-input>
            </el-form-item>
            <el-form-item label="选择颜色" :label-width="formLabelWidth">
              <el-select v-model="form.region" placeholder="请选择颜色">
                <el-option label="黑色" value="black"></el-option>
                <el-option label="银色" value="sliver"></el-option>
                <el-option label="金色" value="gold"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="选择数量" :label-width="formLabelWidth">
                <el-button type="danger" icon="minus" circle size="small" @click="remove"></el-button>
                <el-input v-model="num" style="width: 40px;margin-left: 10px"></el-input>
                <el-button type="primary" icon="plus" circle size="small" style="margin-left: 10px;" @click="plus"></el-button>
            </el-form-item>
            <el-form-item label="需付款" :label-width="formLabelWidth">
              <el-input v-model="total" :disabled="true" style="width: 220px"></el-input>
            </el-form-item>
          </el-form>
          <div style="margin-left: 600px">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
          </div>
        </el-dialog>


        <el-dialog title="填写订单" v-model="dialogFormVisible2">
          <el-form :model="form" >
            <el-form-item label="商品图片" :label-width="formLabelWidth">
              <el-image
                  style="width: 60px; height: 90px"
                  :src="product.image"
              ></el-image>
            </el-form-item>
            <el-form-item label="商品单价" :label-width="formLabelWidth">
              <el-input v-model="product.productPrice" :disabled="true" style="width: 220px"></el-input>
            </el-form-item>
            <el-form-item label="商品名称" :label-width="formLabelWidth">
              <el-input v-model="product.productName" :disabled="true" style="width: 220px"></el-input>
            </el-form-item>
            <el-form-item label="商品描述" :label-width="formLabelWidth">
              <el-input v-model="product.productDes" :disabled="true" style="width: 220px"></el-input>
            </el-form-item>
            <el-form-item label="选择颜色" :label-width="formLabelWidth">
              <el-select v-model="form.region" placeholder="请选择颜色">
                <el-option label="黑色" value="black"></el-option>
                <el-option label="银色" value="sliver"></el-option>
                <el-option label="金色" value="gold"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="选择数量" :label-width="formLabelWidth">
              <el-button type="danger" icon="minus" circle size="small" @click="remove"></el-button>
              <el-input v-model="num" style="width: 40px;margin-left: 10px"></el-input>
              <el-button type="primary" icon="plus" circle size="small" style="margin-left: 10px;" @click="plus"></el-button>
            </el-form-item>
            <el-form-item label="需付款" :label-width="formLabelWidth">
              <el-input v-model="total" :disabled="true" style="width: 220px"></el-input>
            </el-form-item>
          </el-form>
          <div style="margin-left: 600px">
            <el-button @click="dialogFormVisible2 = false">取 消</el-button>
            <el-button type="primary" @click="success">加入购物车</el-button>
          </div>
        </el-dialog>
      </el-main>
    </el-container>
    <el-footer class="el-footer"></el-footer>
  </el-container>
</template>

<script>
export default {
  name: "MyProduct",
  data() {
    return {
      num: 0,
      total: 0,
      product: {},
      cart:{},
      show3: true,
      dialogTableVisible: false,
      dialogFormVisible: false,
      dialogFormVisible2: false,
      form: {
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '120px'
    }
  },
  created() {
    let productId = this.$route.params.productId;
    let url = `product/${productId}`;
    this.$http.get(url).then(resp => {
      this.product = resp.data;
    });

  },
  methods: {
    plus() {
      this.num++;
      this.total = this.product.productPrice * this.num
    },
    remove() {
      this.num--;
      this.total = this.product.productPrice * this.num
    },
    return1() {
      this.$router.push({name: 'myshop'})
    },
    success() {
      // this.dialogFormVisible2 = false
      // this.cart.productid = this.product.productId;
      // this.cart.number = this.num;
      // this.cart.userid = 1
      // let url = "cart";
      // this.$http.post(url,this.cart).then(resp=>{
      //   if(resp.data == 1){
          this.$message({
            message: '添加成功',
            type: 'success'
          });
      //   }else {
      //     this.$message.error('添加失败');
      //   }
      // })
    }
  }
}
</script>

<style scoped>
.el-header,
.el-footer {
  height: 60px;
  background-color: grey;
}

a {
  text-decoration: none;
}

.main_title {
  font-size: 22px;
  color: #fff;
  height: 60px;
  line-height: 60px;
}

.main {
  min-height: 790px;
}

.user_title {
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.transition-box {
  margin-bottom: 10px;
  width: 800px;
  height: 100px;
  border-radius: 4px;
  background-color: bisque;
  text-align: center;
  color: #fff;
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}
</style>