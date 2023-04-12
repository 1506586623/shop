<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="6">
          <span class="main_title">可视化工厂管理系统</span>
        </el-col>
        <el-col :span="2" :offset="16" class="user_title">
          ADMIN
        </el-col>
      </el-row>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu>
          <el-sub-menu index="1">
            <template #title>
              <el-icon><promotion/></el-icon>
              <span><font size="4px" color="black">设备管理</font></span>
            </template>
            <el-menu-item index="1-1">
              <span><router-link to="/mydept">可视化呈现</router-link></span>
            </el-menu-item>
            <el-menu-item index="1-2">
              <span><router-link to="/equipment">设备管理</router-link></span>
            </el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><message /></el-icon>
              <span><font size="4px" color="black">订单管理</font></span>
            </template>
            <el-menu-item index="2-1">
              <router-link to="/mydept">未读消息</router-link>
            </el-menu-item>
            <el-menu-item index="2-2">
              <span><router-link to="/report">历史消息</router-link></span>
            </el-menu-item>
          </el-sub-menu>
          <el-menu-item index="3">
            <el-icon><document /></el-icon>
            <span><router-link to="/myshop"><font size="4px" color="black">排污管理</font></router-link></span>
          </el-menu-item>
          <el-menu-item index="4">
            <el-icon><shop /></el-icon>
            <span><router-link to="/mycar"><font size="4px" color="black">库存管理</font></router-link></span>
          </el-menu-item>
          <el-sub-menu index="5">
            <template #title>
              <el-icon><management /></el-icon>
              <span><font size="4px" color="black">我的订单</font></span>
            </template>
            <el-menu-item index="5-1">
              <router-link to="/mydept">待付款</router-link>
            </el-menu-item>
            <el-menu-item index="5-2">
              <span><router-link to="/report">待发货</router-link></span>
            </el-menu-item>
            <el-menu-item index="5-3">
              <span><router-link to="/report">待收货</router-link></span>
            </el-menu-item>
            <el-menu-item index="5-4">
              <span><router-link to="/report">待评价</router-link></span>
            </el-menu-item>
            <el-menu-item index="5-5">
              <span><router-link to="/report">退款/售后</router-link></span>
            </el-menu-item>
            <el-menu-item index="5-6">
              <span><router-link to="/report">全部</router-link></span>
            </el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-aside>
      <el-main class="main">
        <router-view></router-view>
      </el-main>
    </el-container>
    <el-footer class="el-footer"></el-footer>
  </el-container>
</template>

<script>
export default {
  name: "MyMain"
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
</style>
