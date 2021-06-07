<template>
  <el-table
    :data="menuList"
    style="width: 100%;margin-bottom: 20px;"
    row-key="id"
    border
    default-expand-all
    :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
    <el-table-column prop="name" label="菜单名称" width="180"></el-table-column>
    <el-table-column prop="iconcls" label="图标" width="180">
      <template slot-scope="scope">
        <i :class="scope.row.iconcls"></i>
      </template>
    </el-table-column>
    <el-table-column prop="path" label="路径"></el-table-column>
    <el-table-column prop="url" label="导航"></el-table-column>
    <el-table-column prop="component" label="组件" width="180"></el-table-column>
    <el-table-column label="操作" align="center" width="180">
      <template slot-scope="scope">
        <el-button size="mini" @click="showEditView(scope.$index, scope.row)">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "SysMenu",
  data() {
    return {
      menuList:[],
    }
  },
  mounted() {
    this.init();
  },
  methods:{
    init(){
      this.getRequest("/api/menu/menu").then((resp) => {
        if (resp) {
          console.log(resp);
          this.menuList = resp;
        }
      });
    }
  }
}
</script>

<style>

</style>