<template>
  <div style="width: 500px">
    <div>
      <el-input placeholder="输入部门名称进行搜索" v-model="filterText"></el-input>
      <el-tree
        :data="deps"
        :props="defaultProps"
        :filter-node-method="filterNode"
        ref="tree"
        :expand-on-click-node="false"
      >
        <span
          class="custom-tree-node"
          slot-scope="{ node, data }"
          style="display: flex; justify-content: space-between; width: 100%"
        >
          <span>{{ node.label }}</span>
          <span>
            <el-button
              type="primary"
              size="mini"
              class="depBtn"
              @click="() => showAddDep(data)"
            >
              添加
            </el-button>
            <el-button
              type="danger"
              size="mini"
              class="depBtn"
              @click="() => deleteDep(data)"
            >
              删除
            </el-button>
          </span>
        </span>
      </el-tree>

      <el-dialog title="添加部门" :visible.sync="dialogVisible" width="30%">
        <div>
          <table>
            <tr>
              <td><el-tag>上级部门</el-tag></td>
              <td>{{ pname }}</td>
            </tr>
            <tr>
              <td><el-tag>部门名称</el-tag></td>
              <td>
                <el-input
                  v-model="dep.name"
                  placeholder="请输入部门名称..."
                ></el-input>
              </td>
            </tr>
          </table>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button type="danger" @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="doAddDep">确定</el-button>
        </span>
      </el-dialog>
    </div>
    <div></div>
  </div>
</template>

<script>
export default {
  name: "DepMana",
  data() {
    return {
      deps: [],
      defaultProps: {
        children: "children",
        label: "name",
      },
      filterText: "",
      dialogVisible: false,
      pname: "",
      dep: {
        parentid: -1,
        name: "",
        enabled: true
      },
    };
  },
  watch: {
    filterText(val) {
      this.$refs.tree.filter(val);
    },
  },
  mounted() {
    this.initDeps();
  },
  methods: {
    initDep() {
      (this.dep = {
        name: "",
        parentid: -1,
        enabled: true
      }),
        (this.pname = "");
    },
    addDep2Deps(deps, dep) {
      for (let i = 0; i < deps.length; i++) {
        let d = deps[i];
        if (d.id == dep.parentid) {
          d.children = d.children.concat(dep);
          return;
        } else {
          this.addDep2Deps(d.children, dep);
        }
      }
    },
    doAddDep() {
      this.postRequest("/system/basic/department/", this.dep).then((resp) => {
        if (resp) {
          this.addDep2Deps(this.deps, resp.obj);
          this.dialogVisible = false;
          this.initDep();
        }
      });
    },
    showAddDep(data) {
      this.dialogVisible = true;
      this.pname = data.name;
      this.dep.parentid = data.id;
    },
    removeDepFromDeps(deps, id) {
      for (let i = 0; i < deps.length; i++) {
        let d = deps[i];
        if (d.id == id) {
          deps.splice(i, 1);
          return;
        } else {
          this.removeDepFromDeps(d.children,id);
        }
      }
    },
    deleteDep(data) {
      this.$confirm("此操作将删除该[" + data.name + "]部门,提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.deleteRequest("/system/basic/department/" + data.id).then(
            (resp) => {
              if (resp) {
                this.removeDepFromDeps(this.deps, data.id);
                //this.initDeps();
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
    filterNode(value, data) {
      if (!value) return true;
      return data.name.indexOf(value) !== -1;
    },
    initDeps() {
      this.getRequest("/system/basic/department/").then((resp) => {
        if (resp) {
          this.deps = resp;
        }
      });
    },
  },
};
</script>

<style>
.depBtn {
  padding: 2px;
}
</style>