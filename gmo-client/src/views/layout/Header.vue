<template>
    <el-header class="homeHeader" style="padding-Left: 20px; padding-right:0px; height:60px;">
        <div class="title">
            <div v-if="!this.$store.state.isCollapse">GeoMO&nbsp;&nbsp;<i style="font-size:34px;" class="fa fa-globe" ></i></div>
            <i v-else style="font-size:34px;" class="fa fa-globe" ></i>
        </div>
        <div class="toggleBtn" ref="toggleBtn" @click="collapseChage">
            <i v-if="this.$store.state.isCollapse" style="font-size:16px;" class="el-icon-s-unfold"></i>
            <i v-else style="font-size:16px;" class="el-icon-s-fold"></i>
        </div>
        <el-menu class="el-menu-demo" mode="horizontal" @select="handleSelect"
            background-color="#2490FF" text-color="#FFFFFF">
            <el-submenu index="1">
                <template slot="title">
                    <i class="el-icon-user" style="color:#ffffff"/>&nbsp;{{ user.username }}
                </template>
                <el-menu-item index="userinfo">个人中心</el-menu-item>
                <el-menu-item index="setting">设置</el-menu-item>
                <el-menu-item index="logout">注销登录</el-menu-item>
            </el-submenu>
        </el-menu>
    </el-header>    
</template>

<script>

export default {
    name: 'Header',
    data() {
        return {
            user: JSON.parse(window.sessionStorage.getItem("user")),
        };
    },
    methods:{
        collapseChage() {
            this.$store.state.isCollapse = !this.$store.state.isCollapse;
            if(this.$store.state.isCollapse){
                this.$store.state.aside_width = 'auto';
                this.$refs.toggleBtn.style.left = '-130px';
            }else{
                this.$store.state.aside_width = '200px';
                this.$refs.toggleBtn.style.left = '0px'
            }
        },
        handleSelect(key, keyPath) {
            if (key == "logout") {
                this.$confirm("你确定要注销吗?", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
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
                        message: "已取消操作"
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
    background: #1864b1;
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
.toggleBtn {
    color: white;
    position: absolute;
    padding-left: 200px;
}
.el-dropdown-link img {
    width: 48px;
    height: 48px;
    border-radius: 24px;
    margin-left: 8px;
}
</style>