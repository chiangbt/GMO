<template>
  <div>
    <div>
      <el-input v-model="jl.name" placeholder="添加职称等级...." class="joblevel" size="small"></el-input>
      <el-select v-model="jl.titlelevel" placeholder="职称等级" size="small" style="margin-right: 10px">
        <el-option v-for="item in titleLevels" :key="item" :label="item" :value="item"></el-option>
      </el-select>
      <el-button type="primary" icon="el-icon-plus" size="small" @click="addJobLevel">添加</el-button>
    </div>
    <div>
      <el-table :data="jls" stripe style="width: 100%" border @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column type='index' label="编号" align="center" width="50" :index='(index)=>{return (index+1)}'/>
        <el-table-column prop="name" label="职称"/>
        <el-table-column prop="titlelevel" label="职称等级" width="130"/>
        <el-table-column prop="createdat" label="创建日期" width="150"/>
        <el-table-column prop="enabled" label="是否启用" width="150">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.enabled" type="success">已启用</el-tag>
            <el-tag v-else type="danger">未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" width="180">
          <template slot-scope="scope">
            <el-button size="mini" @click="showEditView(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-button type="danger" size="small" style="margin-top: 10px" :disabled="this.multipleSelection.length == 0" @click="deleteMany">批量删除</el-button>
    <el-dialog title="更新" :visible.sync="dialogVisible" width="30%">
      <el-form :model="updatejl" ref="updatejl" label-width="80px" label-position="right">
        <el-form-item label="名称" prop="name">
          <el-input v-model="updatejl.name"/>
        </el-form-item>
        <el-form-item label="职称等级" prop="titlelevel">
          <el-select v-model="updatejl.titlelevel" style="width: 100%;">
            <el-option v-for="item in titleLevels" :key="item" :label="item" :value="item"/>
          </el-select>
        </el-form-item>
        <el-form-item label="是否启用" prop="enabled">
          <el-switch
            v-model="updatejl.enabled"
            active-color="#13ce66"
            inactive-color="#ff4949"
          />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="doUpdate">确定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "JoblevelMana",
  data() {
    return {
      jl: {
        name: "",
        titlelevel: ""
      },
      updatejl: {
        name: "",
        titlelevel: "",
        enabled: false
      },
      titleLevels: ["正高级", "副高级", "中级", "初级", "未评级"],
      jls: [],
      dialogVisible: false,
      multipleSelection: []
    };
  },
  mounted() {
    this.initJls();
  },
  methods: {
    // 删除多条数据
    deleteMany() {
      this.$confirm("此操作将删除[" + this.multipleSelection.length + "]条记录,提示",{
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let ids = "?ids=";
        this.multipleSelection.forEach((item) => {
          ids += item.id + ",";
        });
        this.deleteRequest("/system/basic/joblevel" + ids).then((resp) => {
          if (resp) {
            this.initJls();
          }
        });
      }).catch(() => {
        this.$message({
          type: "info",
          message: "已取消操作",
        });
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    // 删除指定id的jobLevel
    handleDelete(index, data) {
      this.$confirm("此操作将删除[" + data.name + "]职称,提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.deleteRequest("/system/basic/joblevel/" + data.id).then((resp) => {
          if (resp) {
            this.initJls();
          }
        });
      })
      .catch(() => {
        this.$message({
          type: "info",
          message: "已取消操作",
        });
      });
    },
    // 更新指定id的jobLevel
    doUpdate() {
      this.patchRequest("/system/basic/joblevel/" + this.updatejl.id , this.updatejl).then((resp) => {
        if (resp) {
          this.initJls();
          this.dialogVisible = false;
        }
      });
    },
    showEditView(index, data) {
      Object.assign(this.updatejl, data);
      this.dialogVisible = true;
    },
    // 添加jobLevel
    addJobLevel() {
      if (this.jl.name && this.jl.titlelevel) {
        this.postRequest("/system/basic/joblevel", this.jl).then((resp) => {
          if (resp) {
            this.initJls();
          }
        });
      } else {
        this.$message.console.error("字段不能为空!");
      }
    },
    // 初始化jobLevel数据
    initJls() {
      this.getRequest("/system/basic/joblevel").then((resp) => {
        if (resp) {
          this.jls = resp;
          this.jl.name = "";
          this.jl.titlelevel = "";
        }
      });
    },
  },
};
</script>

<style>
.joblevel {
  width: 220px;
  margin-right: 10px;
  margin-bottom: 10px;
}
</style>