<template>
    <div>
        <div>
            <el-input size="small" class="addPosInput" placeholder="添加职位" suffix-icon="el-icon-plus"
                v-model="pos.name" @keydown.enter.native="addPosition"></el-input>
            <el-button type="primary" icon="el-icon-plus" size="small" @click="addPosition">添加</el-button>
        </div>
        <div class="posMain">
            <el-table :data="positions" stripe border="" style="width: 100%" @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="40"/>
                <el-table-column type="index" label="编号" align="center" width="55" :index='(index)=>{return (index+1)}' />
                <el-table-column prop="name" label="职位"></el-table-column>
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
        <el-button type="danger" size="small" style="margin-top: 10px" :disabled="this.multipleSelection.length == 0"
            @click="deleteMany">批量删除</el-button>
        <el-dialog title="编辑职位" :visible.sync="dialogVisible" width="25%">
            <el-form ref="updatePos" :model="updatePos" label-width="70px" label-position="right">
                <el-form-item label="名称" prop="name">
                    <el-input v-model="updatePos.name"/>
                </el-form-item>
                <el-form-item label="是否启用" prop="enabled">
                    <el-switch v-model="updatePos.enabled" active-color="#13ce66" inactive-color="#ff4949"/>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false" size="small">取消</el-button>
                <el-button type="primary" @click="updatePosition" size="small">确定</el-button>
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
                name: ""
            },
            updatePos: {
                name: "",
                enabled: false
            },
            positions: [],
            dialogVisible: false,
            multipleSelection: []
        };
    },
    async mounted() {
        this.initPositions();
    },
    methods: {
        // 初始化
        initPositions() {
            this.getRequest("/api/system/basic/position").then((resp) => {
                if (resp) {
                  this.positions = resp;
                }
            });
        },
        showEditView(index, data) {
            Object.assign(this.updatePos, data);
            this.dialogVisible = true;
        },
        // 添加职位
        addPosition() {
            if (this.pos.name) {
                this.postRequest("/api/system/basic/position", this.pos).then((resp) => {
                    if (resp) {
                        this.initPositions();
                        this.pos.name = "";
                    }
                });
            } else {
                this.$message.error("职位名称不能为空!");
            }
        },
        // 更新指定职位
        updatePosition() {
            this.patchRequest("/api/system/basic/position/" + this.updatePos.id, this.updatePos).then((resp) => {
                if (resp) {
                    this.initPositions();
                    this.dialogVisible = false;
                }
            });
        },
        // 删除记录
        handleDelete(index, data) {
            this.$confirm("此操作将删除[" + data.name + "]职位", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
            }).then(() => {
                this.deleteRequest("/api/system/basic/position/" + data.id).then((resp) => {
                    if (resp) {
                        this.initPositions();
                    }
                });
            })
            .catch(() => {
                this.$message({
                    type: "info",
                    message: "已取消操作"
                });
            });
        },
        // 多项选择
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        // 删除多条记录
        deleteMany() {
            this.$confirm("此操作将删除[" + this.multipleSelection.length + "]条记录",{
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
            })
            .then(() => {
                let ids = "?ids=";
                this.multipleSelection.forEach((item) => {
                    ids += item.id + ",";
                });
                this.deleteRequest("/api/system/basic/position" + ids).then((resp) => {
                    if (resp) {
                        this.initPositions();
                    }
                });
            })
            .catch(() => {
                this.$message({
                    type: "info",
                    message: "已取消操作"
                });
            });
        }
    },
};
</script>

<style scoped lang="less" >
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
/deep/ .el-switch__core {
    margin-top: 10px;
}
</style>