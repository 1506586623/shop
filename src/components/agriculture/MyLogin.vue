<template>
    <el-form class="login-container" :model="user" :rules="rules" ref="loginForm">
      <h3 class="login-title">系统登陆</h3>
      <el-form-item prop="username">
        <el-input type="text" placeholder="用户名" v-model="user.username"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" placeholder="密码" v-model="user.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width: 100%" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
</template>

<script>
export default {
  name: "MyLogin",
  data(){
    return{
      user:{},
      rules:{
        username:[
          {required:true,message:'请输入用户名',trigger:['blur','change']},
          {min:2,max:10,message:'用户名长度必须在2-10个字符之间',trigger:['blur','change']}
        ],
        password:[
          {required:true,message:'请输入密码',trigger:['blur','change']},
          {min:2,max:10,message:'密码长度必须在2-10个字符之间',trigger:['blur','change']}
        ]

      }
    }
  },
  methods:{
    login(){
      this.$router.push({name:'shoppingmain'})
    }
  }
}

</script>

<style scoped>
.login-container{
  width:350px;
  margin:100px auto 10px;
  border:1px solid #eaeaea;
  padding:35px 35px 15px 35px;
  border-radius: 15px;
  box-shadow:0 0 25px #cac6c6;
}
.login-title{
  text-align: center;
  color:#505458;
  margin:0px auto 40px;
}
</style>