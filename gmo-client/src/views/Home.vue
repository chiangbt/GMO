<template>
  <div>
    <el-container>
      <el-header class="homeHeader" style="padding-Left: 20px;padding-right:0px;height:60px;">
        <div class="title">
          <div v-if="!isCollapse">GeoMO</div>
          <i v-else style="font-size:40px;" class="fa fa-snowflake-o" ></i>
        </div>
        <div class="toggleBtn" ref="toggleBtn" @click="collapseChage">
            <i v-if="isCollapse" style="font-size:24px;" class="el-icon-s-unfold"></i>
            <i v-else style="font-size:24px;" class="el-icon-s-fold"></i>
        </div>
        <el-menu class="el-menu-demo" mode="horizontal" @select="handleSelect"
          background-color="#409EFF" text-color="#FFFFFF">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-user" style="color:#ffffff"/>&nbsp;{{ user.username }}</template>
            <el-menu-item index="userinfo">个人中心</el-menu-item>
            <el-menu-item index="setting">设置</el-menu-item>
            <el-menu-item index="logout">注销登录</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-header>
      <el-container>
        <el-aside class="elaside" :width="aside_width">
          <el-menu :collapse="isCollapse" router unique-opened>
            <el-submenu
              :index="index + ''"
              v-for="(item, index) in routes"
              :key="index"
              v-if="!item.hidden"
            >
              <template slot="title">
                <i :class="item.iconcls" style="color: #laccff; margin-right: 5px"></i>
                <span>{{ item.name }}</span>
              </template>
              <el-menu-item
                :index="children.path"
                v-for="(children, indexj) in item.children"
                :key="indexj">
                {{ children.name }}
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-container>
          <el-main>
            <el-card class="box-card">
              <el-breadcrumb v-if="this.$router.currentRoute.path != '/home'" separator="/">
                <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>{{
                  this.$router.currentRoute.name
                }}</el-breadcrumb-item>
              </el-breadcrumb>
              <el-breadcrumb v-else>
                <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
              </el-breadcrumb>
            </el-card>
            <div class="homeWelcome" v-if="this.$router.currentRoute.path == '/home'">
              欢迎来到GMO系统
            </div>
            <el-container>
              <router-view class="homeRouterView"/>
            </el-container>
          </el-main>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>

export default {
  name: 'Home',
  data() {
    return {
      aside_width: '200px',
      collpaseBtn_width: '200px',
      user: JSON.parse(window.sessionStorage.getItem("user")),
      isCollapse: false
    };
  },
  computed: {
    routes() {
      return this.$store.state.routes;
    },
  },
  methods:{
    collapseChage() {
      this.isCollapse = !this.isCollapse;
      if(this.isCollapse){
        this.aside_width = 'auto';
        this.$refs.toggleBtn.style.left = '-130px';
      }else{
        this.aside_width = '200px';
        this.$refs.toggleBtn.style.left = '0px'
      }
    },
    handleSelect(key, keyPath) {
      console.log(key);
      if (key == "logout") {
        this.$confirm("你确定要注销吗?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }).then(() => {
            this.postRequest("/api/auth/logout");
            window.sessionStorage.removeItem("tokenStr");
            window.sessionStorage.removeItem("user");
            this.$store.commit("initRoutes", []);
            this.$router.replace("/");
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消操作",
            });
          });
      }else if(key == "setting"){
        
      }
    }
  }
}
</script>

<style scope>
.homeHeader {
  background: #409EFF;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 0px;
  box-sizing: border-box;
}
.homeHeader .title {
  font-size: 30px;
  color: white;
}
.el-dropdown-link img {
  width: 48px;
  height: 48px;
  border-radius: 24px;
  margin-left: 8px;
}
.homeWelcome {
  text-align: center;
  font-size: 30px;
  font-family: 华文楷体;
  color: #409eff;
  padding-top: 200px;
}
.homeRouterView{
  margin-top:20px ;
  width: 100%;
}
.elaside {
  width: 200px;
  transition: width 0.25s;
  -webkit-transition: width 0.25s;
  -moz-transition: width 0.25s;
  -webkit-transition: width 0.25s;
  -o-transition: width 0.25s;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
}
.toggleBtn {
  color: white;
  position: absolute;
  padding-left: 200px;
}
</style>
