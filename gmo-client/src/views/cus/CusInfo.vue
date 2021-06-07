<template>
  <div>
    <div style="text-align: right; margin-top: 30px; margin-bottom:20px;">
      <el-row :gutter="20">
        <el-col :md="12">
          <el-input
            Placeholder="Search..." clearable @clear="onClearSearch"
            v-model="searchVal" @keyup.enter.native="onEnterSearch">
            <i slot="prefix" class="el-input__icon el-icon-search"></i>
          </el-input>
        </el-col>
        <el-col :md="12">
          <el-button type="primary" icon="el-icon-plus" @click="dialogFormVisible = true">添加</el-button>
          <el-button type="danger" icon="el-icon-circle-close"  @click="handleDeleteMany()">批量删除</el-button>
        </el-col>
      </el-row>
    </div>
    <el-table :data="menuList" stripe border style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="40"></el-table-column>
      <el-table-column type='index' label="编号" align="center" width="50" :index='(index)=>{return (index+1)}'/>
      <el-table-column prop="name" label="姓名"></el-table-column>
      <el-table-column prop="age" label="年龄" width="180"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column prop="updatedat" label="录入时间"></el-table-column>
      <el-table-column label="操作" align="center" width="180">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row)" class="el-icon-edit">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)" class="el-icon-delete">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="text-align: right; margin-top: 30px;">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pageNo"
        :page-sizes="[15, 25, 50]"
        :page-size="queryInfo.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        background
      >
      </el-pagination>
    </div>
    <el-dialog title="添加" :visible.sync="dialogFormVisible" width="30%">
      <el-form :model="userForm" ref="userForm" :rules="rules" label-position="left">
        <el-form-item label="名称" prop="name">
          <el-input v-model="userForm.name"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="userForm.age"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="userForm.address"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="clearAddForm('userForm')">取消</el-button>
        <el-button type="primary" @click="add(userForm)">确定</el-button>
      </div>
    </el-dialog>
    <el-dialog title="更新" :visible.sync="editDialogVisible" width="30%">
      <el-form :model="editForm" ref="editForm" :rules="rules" label-position="left">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="editForm.age"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="editForm.address"></el-input>
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
  name: "CusInfo",
  data() {
    var valiNumberPass2 = (rule, value, callback) => {//正整数
      let reg = /^[+]{0,1}(\d+)$/g;
      if (value === '') {
        callback(new Error('请输入年龄'));
      } else if (!reg.test(value)) {
        callback(new Error('请输入0及0以上的整数'));
      } else {
        callback();
      }
    };
    return {
      menuList:[],
      multipleSelection: [],
      searchVal: '',
      queryInfo: {
        query: "",
        pageNo: 1,
        pageSize: 15
      },
      total: 0,
      userForm: {},
      dialogFormVisible: false,
      rules: {   //表单验证
        name: [{ required: true, message: "请输入名称", trigger: "blur" }],
        age: [{ required: true, validator:valiNumberPass2, trigger: "blur" }],
        address: [{ required: true, message: "请选择地址", trigger: "blur" }]
      },
      editForm: {
        id:'',
        name:'',
        age: 0,
        address: ''
      },
      editDialogVisible: false
    }
  },
  mounted() {
    this.getCustomerList();
  },
  methods:{
    async getCustomerList() {
      const { data, code, message } = await this.getRequest("/api/customer?query=" + 
        this.queryInfo.query + "&pageNo=" + 
        this.queryInfo.pageNo + "&pageSize=" + this.queryInfo.pageSize);

      if (code !== 200) {
        return this.$message.error(message);
      }
      this.menuList = data.records;
      this.total = data.total;
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(newSize) {
      this.queryInfo.pageSize = newSize;
      this.getCustomerList();
    },
    handleCurrentChange(newPage) {
      this.queryInfo.pageNo = newPage;
      this.getCustomerList();
    },
    onEnterSearch(e,searchVal) {
      this.queryInfo.query = this.searchVal;
      this.getCustomerList();
    },
    onClearSearch(){
      this.queryInfo.query = '';
      this.getCustomerList();
    },
    add(form) {
      this.$refs.userForm.validate(valid => {
        if (valid) { //表单验证通过
          this.postRequest("/api/customer", form).then((resp) => {
            if (resp.code == 200) {
              this.pageNo = 1;
              this.getCustomerList();
              this.userForm = {};
              this.dialogFormVisible = false;
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    clearAddForm(form){
      this.$refs[form].resetFields();
      this.dialogFormVisible = false;
    },
    handleEdit(data){
      Object.assign(this.editForm, data);
      this.editDialogVisible = true;
    },
    update(form){
      console.log(form)
      this.patchRequest("/api/customer/" + form.id, form).then((resp) => {
        if (resp.code == 200) {
          this.pageNo = 1;
          this.getCustomerList();
          this.editDialogVisible = false;
        }
      });
    },
    handleDelete(key, data){
      console.log(data.id);
        this.$confirm("此操作将删除[" + data.name + "]记录,提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
      }).then(() => {
        this.deleteRequest("/api/customer/" + data.id).then((resp) => {
          if (resp) {
            this.getCustomerList();
          }
        });
      }).catch(() => {
        this.$message({
          type: "info",
          message: "已取消操作",
        });
      });
    },
    handleDeleteMany(){
      var sel = [];
      this.multipleSelection.map(item => {
        sel.push(item.id);
      });
      this.$confirm("此操作将删除多条记录,提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.deleteRequest("/api/customer?ids=" + sel.toString()).then((resp) => {
          if (resp) {
            this.getCustomerList();
          }
        });
      }).catch(() => {
        this.$message({
          type: "info",
          message: "已取消操作",
        });
      });
    }
  }
}
</script>

<style>

</style>