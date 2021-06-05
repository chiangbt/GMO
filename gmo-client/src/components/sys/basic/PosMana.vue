<template>
  <div>
    <div>
      <el-input
        size="small"
        class="addPosInput"
        placeholder="添加职位"
        suffix-icon="el-icon-plus"
        v-model="pos.name"
        @keydown.enter.native="addPosition"
      >
      </el-input>
      <el-button
        type="primary"
        icon="el-icon-plus"
        size="small"
        @click="addPosition"
        >添加</el-button
      >
    </div>
    <div class="posMain">
      <el-table
        :data="positions"
        stripe
        border=""
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="id" label="编号" width="55"> </el-table-column>
        <el-table-column prop="name" label="职位" width="120"></el-table-column>
        <el-table-column prop="enabled" label="是否启用" width="150"></el-table-column>
        <el-table-column prop="createdat" label="创建时间" width="200"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="showEditView(scope.$index, scope.row)">编辑</el-button>
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
    <el-dialog title="编辑职位" :visible.sync="dialogVisible" width="30%">
      <div>
        <el-tag>职位名称</el-tag>
        <el-input v-model="updatePos.name" class="updatePos"></el-input>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small">取消</el-button>
        <el-button type="primary" @click="doUpdate" size="small"
          >确定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "PosMana",
  data() {
    return {
      pos: {
        name: "",
      },
      updatePos: {
        name: "",
      },
      positions: [],
      dialogVisible: false,
      multipleSelection: [],
    };
  },
  mounted() {
    this.initPositions();
  },
  methods: {
    initPositions() {
      this.getRequest("/system/basic/position/").then((resp) => {
        if (resp) {
          this.positions = resp;
        }
      });
    },
    showEditView(index, data) {
      Object.assign(this.updatePos, data);
      //this.updatePos = data;
      this.dialogVisible = true;
    },
    handleDelete(index, data) {
      this.$confirm("此操作将删除[" + data.name + "]职位,提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.deleteRequest("/system/basic/position/" + data.id).then((resp) => {
            if (resp) {
              this.initPositions();
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
    addPosition() {
      if (this.pos.name) {
        this.postRequest("/system/basic/position/", this.pos).then((resp) => {
          if (resp) {
            this.initPositions();
            this.pos.name = "";
          }
        });
      } else {
        this.$message.error("职位名称不能为空!");
      }
    },
    doUpdate() {
      this.putRequest("/system/basic/position/", this.updatePos).then((resp) => {
        if (resp) {
          this.initPositions();
          this.dialogVisible = false;
        }
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },

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
          this.deleteRequest("/system/basic/position/" + ids).then((resp) => {
            if (resp) {
              this.initPositions();
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
  },
};
</script>

<style scoped>
.addPosInput {
  width: 300px;
  margin-right: 8px;
}
.posMain {
  margin-top: 10px;
}
.updatePos {
  width: 200px;
  margin-left: 30px;
}
</style>