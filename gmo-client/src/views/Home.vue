<template>
    <el-container style="height: 100%; display: block;">
        <Header></Header>
        <el-container style="display:flex; height: 93.5vh;">
            <SiderMenu></SiderMenu>
            <el-main>
                <el-card>
                    <el-breadcrumb v-if="this.$router.currentRoute.path != '/home'" separator="/">
                        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                        <el-breadcrumb-item>{{ this.$router.currentRoute.name }}</el-breadcrumb-item>
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
</template>

<script>
import Header from './layout/Header.vue';
import SiderMenu from './layout/SiderMenu.vue';

export default {
    name: 'Home',
    components: {
        Header,
        SiderMenu
    }
}
</script>

<style scope>
.homeWelcome {
    text-align: center;
    font-size: 30px;
    color: #409eff;
    padding-top: 200px;
}
.homeRouterView{
    margin-top:20px ;
    width: 100%;
}
</style>
