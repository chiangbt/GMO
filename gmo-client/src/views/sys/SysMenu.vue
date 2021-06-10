<template>
  <div>
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
          <i :class="scope.row.iconcls" style="color: #f56c6c;"></i>
        </template>
      </el-table-column>
      <el-table-column prop="path" label="路径"></el-table-column>
      <el-table-column prop="url" label="导航"></el-table-column>
      <el-table-column prop="component" label="组件" width="180"></el-table-column>
      <el-table-column prop="orders" label="顺序" width="60"></el-table-column>
      <el-table-column label="操作" align="center" width="180">
        <template slot-scope="scope">
          <el-button size="mini" @click="showEditView(scope.$index, scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="更新" :visible.sync="editDialogVisible" width="30%">
      <el-form :model="editForm" ref="editForm" :rules="rules" label-position="left">
        <el-form-item label="菜单名称" prop="name">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>
        <el-form-item label="菜单顺序" prop="orders">
          <el-input v-model="editForm.orders"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false" size="small">取消</el-button>
        <el-button type="primary" @click="update(editForm)" size="small">更新</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "SysMenu",
  data() {
    return {
      menuList:[],
      editDialogVisible: false,
      rules: {   //表单验证
        name: [{ required: true, message: "请输入名称", trigger: "blur" }],
      },
      editForm: {
        id:'',
        name:'',
        orders: 0
      },
    }
  },
  mounted() {
    this.init();
  },
  methods:{
    init(){
      this.getRequest("/api/menu/menu").then((resp) => {
        if (resp) {
          this.menuList = resp;
        }
      });
    },
    showEditView(key, data){
      Object.assign(this.editForm, data);
      this.editDialogVisible = true;
    },
    update(form){
      console.log(form)
      this.patchRequest("/api/menu/" + form.id, { 
        name: form.name,
        orders: form.orders 
      }).then((resp) => {
        if (resp.code == 200) {
          // this.init();
          this.editDialogVisible = false;
          this.$router.go(0);
          this.$message({
            type: "success",
            message: "更新成功!",
          });
        }
      });
    },
  }
}
</script>

<style>

</style>