<template>
    <el-aside class="elaside" :width="asideWidth">
        <el-menu :collapse="isToggle" router unique-opened style="height:100%;">
          <el-menu-item index="/home" key="Home">
            <i class="el-icon-s-home" style="color: #f56c6c; margin-right: 5px"></i><span slot="title">首页</span>
          </el-menu-item>
          <el-submenu :index="index + ''" v-for="(item, index) in routes" :key="index" v-if="!item.hidden" >
            <template slot="title">
              <i :class="item.iconcls" style="color: #f56c6c; margin-right: 5px"></i>
              <span>{{ item.name }}</span>
            </template>
            <el-menu-item :index="children.path" v-for="(children, indexj) in item.children" :key="indexj">
              {{ children.name }}
            </el-menu-item>
          </el-submenu>
        </el-menu>
    </el-aside>    
</template>

<script>

export default {
  name: 'SiderMenu',
  computed: {
    routes() {
      return this.$store.state.routes;
    },
    isToggle(){
      return this.$store.state.isCollapse;
    },
    asideWidth(){
      return this.$store.state.aside_width;
    }
  },
}
</script>

<style scope>
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
  background-color: #ebeef5;
}
</style>
