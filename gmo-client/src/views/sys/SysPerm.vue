<template>
    <div>
        <div class="permissManaTool">
            <el-input placeholder="请输入角色英文名" v-model="role.name" size="small">
                <template slot="prepend">ROLE_</template>
            </el-input>
            <el-input placeholder="请输入角色中文名" v-model="role.namezh" size="small" @keydown.enter.native="doAddRole"></el-input>
            <el-button size="small" type="primary" icon="el-icon-plus" @click="doAddRole">添加角色</el-button>
        </div>
        <div class="permissManaMain">
            <el-card class="box-card" shadow="always">
                <el-collapse accordion @change="change" v-model="activeName">
                    <el-collapse-item :title="r.namezh" :name="r.id" v-for="(r, index) in roles" :key="index">
                        <el-card class="box-card">
                            <div slot="header" class="clearfix">
                                <span>可访问资源</span>
                                <el-button style="float: right; padding: 3px 0 color:#ff0000"
                                    type="text" icon="el-icon-delete" @click="doDeleteRole(r)"></el-button>
                            </div>
                            <div>
                                <el-tree show-checkbox :data="allMenus" :props="defaultProps" :default-checked-keys="selectedMenus"
                                    ref="tree" node-key="id" :key="index"></el-tree>
                                <div style="display: flex; justify-content: flex-end">
                                    <el-button size="mini" @click="cancelUpdate">取消修改</el-button>
                                    <el-button type="primary" size="mini" @click="doUpdate(r.id, index)">确认修改</el-button>
                                </div>
                            </div>
                        </el-card>
                    </el-collapse-item>
                </el-collapse>
            </el-card>
        </div>
    </div>
</template>

<script>
export default {
    name: "PermissMana",
    data() {
        return {
            role: {
                name: "",
                namezh: ""
            },
            roles: [],
            allMenus: [],
            defaultProps: {
                children: "children",
                label: "name",
            },
            selectedMenus: [],
            activeName: -1
        };
    },
    mounted() {
        this.initRoles();
    },
    methods: {
        doDeleteRole(r) {
            this.$confirm("此操作将删除[" + r.namezh + "]角色,提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
            })
            .then(() => {
                this.deleteRequest("/system/perm/role/" + r.id).then(
                    (resp) => {
                        if (resp) {
                            this.initRoles();
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
        doAddRole() {
            //console.log(this.role);
            if (this.role.name && this.role.namezh) {
                this.postRequest("/system/perm/role", this.role).then(
                    (resp) => {
                        if (resp) {
                            this.initRoles();
                            this.role.name = "";
                            this.role.namezh = "";
                        }
                    }
                );
            } else {
                this.$message.error("所有字段不能为空");
            }
        },
        cancelUpdate() {
            this.activeName = -1;
        },
        doUpdate(rid, index) {
            let tree = this.$refs.tree[index];
            let selectedKeys = tree.getCheckedKeys();
            let url = "/system/perm/menuid/" + rid;
            var mids = [];
            selectedKeys.map(item => {
                mids.push(item);
            });
            console.log("mids: " + mids.toString())
            this.patchRequest(url, {
                mids: mids.toString()
            }).then((resp) => {
                if (resp) {
                    this.activeName = -1;
                    this.$message({
                        type: "success",
                        message: "角色-菜单更新成功!",
                    });
                }
            });
        },
        initselectedMenus(rid) {
            this.getRequest("/system/perm/menuid/" + rid).then((resp) => {
                if (resp) {
                    this.selectedMenus = resp;
                }
            });
        },
        change(rid) {
            if (rid) {
                this.initAllMenus();
                this.initselectedMenus(rid);
            }
        },
        initAllMenus() {
            this.getRequest("/system/perm/menus").then((resp) => {
                if (resp) {
                    this.allMenus = resp;
                }
            });
        },
        initRoles() {
            this.getRequest("/system/perm/").then((resp) => {
                if (resp) {
                    this.roles = resp;
                }
            });
        },
    },
};
</script>

<style>
.permissManaTool {
    display: flex;
    justify-content: flex-start;
}
.permissManaTool .el-input {
    width: 300px;
    margin-left: 10px;
}
.permissManaMain {
    margin-top: 10px;
    width: 50%;
}
</style>