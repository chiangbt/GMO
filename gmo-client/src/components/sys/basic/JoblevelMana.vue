<template>
  <div>
    <div>
      <el-input
        v-model="jl.name"
        placeholder="添加职称等级...."
        class="joblevel"
        size="small"
      ></el-input>
      <el-select
        v-model="jl.titlelevel"
        placeholder="职称等级"
        size="small"
        style="margin-right: 10px"
      >
        <el-option
          v-for="item in titleLevels"
          :key="item"
          :label="item"
          :value="item"
        >
        </el-option>
      </el-select>
      <el-button
        type="primary"
        icon="el-icon-plus"
        size="small"
        @click="addJobLevel"
        >添加</el-button
      >
    </div>
    <div>
      <el-table
        :data="jls"
        stripe
        style="width: 100%"
        border
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column type='index' label="编号" align="center" width="50" :index='(index)=>{return (index+1)}'/>
        <el-table-column prop="name" label="职称">
        </el-table-column>
        <el-table-column prop="titlelevel" label="职称等级" width="130">
        </el-table-column>
        <el-table-column prop="createdat" label="创建日期" width="150">
        </el-table-column>
        <el-table-column prop="enabled" label="是否启用" width="150">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.enabled" type="success">已启用</el-tag>
            <el-tag v-else type="danger">未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" width="180">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="showEditView(scope.$index, scope.row)"
              >编辑</el-button
            >
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-button
      type="danger"
      size="small"
      style="margin-top: 10px"
      :disabled="this.multipleSelection.length == 0"
      @click="deleteMany"
      >批量删除</el-button
    >
    <el-dialog title="编辑职称" :visible.sync="dialogVisible" width="30%">
      <table>
        <tr>
          <td><el-tag>职称名称</el-tag></td>
          <td>
            <el-input v-model="updatejl.name" size="small"></el-input>
          </td>
        </tr>
        <tr>
          <td><el-tag>职称等级</el-tag></td>
          <td>
            <el-select
              v-model="updatejl.titlelevel"
              placeholder="职称等级"
              size="small"
              style="margin-right: 10px"
            >
              <el-option
                v-for="item in titleLevels"
                :key="item"
                :label="item"
                :value="item"
              >
              </el-option>
            </el-select>
          </td>
        </tr>
        <tr>
          <td><el-tag>是否启用</el-tag></td>
          <td>
            <el-switch
              v-model="updatejl.enabled"
              active-color="#13ce66"
              inactive-color="#ff4949"
              active-text="已启用"
              inactive-text="未启用"
            >
            </el-switch>
          </td>
        </tr>
      </table>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="doUpdate">确 定</el-button>
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
        titlelevel: "",
      },
      updatejl: {
        name: "",
        titlelevel: "",
        enabled: false,
      },
      titleLevels: ["正高级", "副高级", "中级", "初级", "员级"],
      jls: [],
      dialogVisible: false,
      multipleSelection: [],
    };
  },
  mounted() {
    this.initJls();
  },
  methods: {
    deleteMany() {
      this.$confirm(
        "此操作将删除[" + this.multipleSelection.length + "]条记录,提示",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(() => {
          let ids = "?";
          this.multipleSelection.forEach((item) => {
            ids += "ids=" + item.id + "&";
          });
          console.log(ids);
          this.deleteRequest("/system/basic/joblevel/" + ids).then((resp) => {
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
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
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
      this.updatejl.createdate = "";
      this.dialogVisible = true;
    },
    handleDelete(index, data) {
      this.$confirm("此操作将删除[" + data.name + "]职称,提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.deleteRequest("/system/basic/joblevel/" + data.id).then(
            (resp) => {
              if (resp) {
                this.initJls();
              }
            }
          );
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作",
          });
        });
    },
    addJobLevel() {
      if (this.jl.name && this.jl.titlelevel) {
        this.postRequest("/system/basic/joblevel/", this.jl).then((resp) => {
          if (resp) {
            this.initJls();
          }
        });
      } else {
        this.$message.console.error("字段不能为空!");
      }
    },
    initJls() {
      this.getRequest("/system/basic/joblevel/").then((resp) => {
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