<template>
    <div>
        <div style="text-align: right; margin-top: 30px; margin-bottom:20px;">
            <el-row :gutter="20">
                <el-col :sm="12" :md="12">
                    <el-input Placeholder="Search..." clearable @clear="onClearSearch"
                        v-model="searchVal" @keyup.enter.native="onEnterSearch">
                        <i slot="prefix" class="el-input__icon el-icon-search"></i>
                    </el-input>
                </el-col>
                <el-col :sm="6" :md="6">
                    <RoleSelect v-model="searchRole"></RoleSelect>
                </el-col>
                <el-col :sm="6" :md="6" style="text-align:right;">
                    <el-button type="primary" icon="el-icon-plus" @click="dialogFormVisible = true">添加</el-button>
                </el-col>
            </el-row>
        </div>
        <el-card class="box-card" shadow="always">
            <el-table :data="adminusersList" stripe border style="width: 100%">
                <el-table-column type='index' label="编号" align="center" width="50" :index='(index)=>{return (index+1)}'/>
                <el-table-column prop="username" label="姓名"></el-table-column>
                <el-table-column prop="email" label="邮件" ></el-table-column>
                <el-table-column prop="phone" label="电话" width="100"></el-table-column>
                <el-table-column prop="nation_name" label="民族"></el-table-column>
                <el-table-column prop="politics" label="政治面貌" width="110"></el-table-column>
                <el-table-column prop="role_name" label="角色"></el-table-column>
                <el-table-column prop="enabled" label="是否有效" width="80">
                    <template slot-scope="scope">
                        <el-tag v-if="scope.row.enabled" type="success">已启用</el-tag>
                        <el-tag v-else type="danger">未启用</el-tag>
                    </template>
                </el-table-column>
                <el-table-column label="操作" align="center" width="180">
                    <template slot-scope="scope">
                        <el-button size="mini" @click="handleEdit(scope.row)" class="el-icon-edit">编辑</el-button>
                        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)" class="el-icon-delete">失效</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-card>
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
            <el-form :model="userForm" ref="userForm" :rules="rules" label-width="80px" label-position="right">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="userForm.username"></el-input>
                </el-form-item>
                <el-form-item label="电子邮件" prop="email">
                    <el-input v-model="userForm.email"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="userForm.password" type="password"></el-input>
                </el-form-item>
                <el-form-item label="姓名" prop="name">
                    <el-input v-model="userForm.name"></el-input>
                </el-form-item>
                <el-form-item label="电话" prop="phone">
                    <el-input v-model="userForm.phone"></el-input>
                </el-form-item>
                <el-form-item label="角色" prop="roleIds">
                    <RoleNoAdminSelect v-model="userForm.roleIds"></RoleNoAdminSelect>
                </el-form-item>
                <el-form-item label="民族" prop="nationId">
                    <NationSelect v-model="userForm.nationId"></NationSelect>
                </el-form-item>
                <el-form-item label="政治面貌" prop="politicId">
                    <PoliticsSelect v-model="userForm.politicId"></PoliticsSelect>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="clearAddForm('userForm')">取消</el-button>
                <el-button type="primary" @click="add(userForm)">确定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import RoleSelect from './../../components/search/RoleSelect.vue';
import RoleNoAdminSelect from './../../components/search/RoleNoAdminSelect.vue';
import NationSelect from './../../components/search/NationSelect.vue';
import PoliticsSelect from './../../components/search/PoliticsSelect.vue';

export default {
    name: "SysAdmin",
    components:{
        RoleSelect,
        RoleNoAdminSelect,
        NationSelect,
        PoliticsSelect
    },
    data() {
        var checkEmail = (rule, value, callback) => {
            const mailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
            if (!value) {
                return callback(new Error('邮箱不能为空'))
            }
            setTimeout(() => {
                if (mailReg.test(value)) {
                    callback()
                } else {
                    callback(new Error('请输入正确的邮箱格式'))
                }
            }, 100)
        };
        return{
            adminusersList:[],
            multipleSelection: [],
            searchVal: '',
            searchRole: 2,
            total: 0,
            queryInfo: {
                query: "",
                pageNo: 1,
                pageSize: 15
            },
            dialogFormVisible: false,
            userForm: {
                roleIds: [2],
                nationId: 1,
                politicId: 1
            },
            rules: {   //表单验证
                username: [{ required: true, message: "请输入用户名", trigger: "blur" }],
                email: [{ required: true, validator:checkEmail, trigger: "blur" }],
                password: [{ required: true, message: "请设置密码", trigger: "blur" }],
                name: [{ required: true, message: "请输入用户姓名", trigger: "blur" }],
                phone: [{ required: true, message: "请输入电话", trigger: "blur" }]
            },
            
        }
    },
    mounted() {
        this.getAdminUserList();
    },
    methods:{
        // ---------------------------------------------------------------------------------------------
        async getAdminUserList() {
            const { data, code, message } = await this.getRequest("/api/system/admin?query=" + 
                this.queryInfo.query + "&pageNo=" + 
                this.queryInfo.pageNo + "&pageSize=" + this.queryInfo.pageSize);
            if (code !== 200) {
                return this.$message.error(message);
            }
            this.adminusersList = data.records;
            this.total = data.total;
        },
        handleSizeChange(newSize) {
            this.queryInfo.pageSize = newSize;
            this.getAdminUserList();
        },
        handleCurrentChange(newPage) {
            this.queryInfo.pageNo = newPage;
            this.getAdminUserList();
        },
        onEnterSearch(e,searchVal) {
            this.queryInfo.query = this.searchVal;
            this.getAdminUserList();
        },
        onClearSearch(){
            this.queryInfo.query = '';
            this.getAdminUserList();
        },
        // ---------------------------------------------------------------------------------------------
        add(form) {
            this.$refs.userForm.validate(valid => {
                if (valid) {
                    form.roleIds = form.roleIds.toString();
                    this.postRequest("/api/system/admin", form).then((resp) => {
                        if (resp.code == 200) {
                            this.getAdminUserList();
                            this.userForm = {
                                roleIds: [2],
                                nationId: 1,
                                politicId: 1
                            };
                            this.dialogFormVisible = false;
                        }
                    });
                }
            });
        },
        clearAddForm(form){
            this.$refs[form].resetFields();
            this.dialogFormVisible = false;
        },
    }
}
</script>

<style>

</style>