<template>
    <div>
        <div style="text-align: right; margin-top: 30px; margin-bottom:20px;">
            <el-row :gutter="20">
                <el-col :sm="24" :md="24" style="text-align:right;">
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
                <el-table-column prop="nation.name" label="民族"></el-table-column>
                <el-table-column prop="politicsStatus.name" label="政治面貌"></el-table-column>
                <el-table-column prop="roles[0].namezh" label="角色"></el-table-column>
                <el-table-column label="操作" align="center" width="180">
                    <template slot-scope="scope">
                        <el-button size="mini" @click="handleEdit(scope.row)" class="el-icon-edit">编辑</el-button>
                        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)" class="el-icon-delete">失效</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-card>
        <el-dialog title="添加" :visible.sync="dialogFormVisible" width="30%">
            <el-form :model="userForm" ref="userForm" :rules="rules" label-width="80px" label-position="right">
                <el-form-item label="名称" prop="name">
                    <el-input v-model="userForm.name"></el-input>
                </el-form-item>
                <el-form-item label="年龄" prop="age">
                    <el-input v-model="userForm.age"></el-input>
                </el-form-item>
                <el-form-item label="地址" prop="address">
                    <el-input v-model="userForm.address"></el-input>
                </el-form-item>
                <el-form-item label="民族" prop="nation">
                    <NationSelect v-model="userForm.nation"></NationSelect>
                </el-form-item>
                <el-form-item label="政治面貌" prop="politicstatus">
                    <PoliticsSelect v-model="userForm.politicstatus"></PoliticsSelect>
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
import NationSelect from './../../components/search/NationSelect.vue';
import PoliticsSelect from './../../components/search/PoliticsSelect.vue';

export default {
    name: "SysAdmin",
    components:{
        NationSelect,
        PoliticsSelect
    },
    data() {
        return{
            adminusersList:[],
            multipleSelection: [],
            searchVal: '',
            queryInfo: {
                query: "",
                pageNo: 1,
                pageSize: 15
            },
            dialogFormVisible: false,
            userForm: {
                nation: 1,
                politicstatus: 1
            },
            rules: {   //表单验证
                name: [{ required: true, message: "请输入名称", trigger: "blur" }],
                address: [{ required: true, message: "请选择地址", trigger: "blur" }]
            },
            
        }
    },
    mounted() {
        this.getAdminUserList();
    },
    methods:{
        async getAdminUserList() {
            const data = await this.getRequest("/api/system/admin?keywords=" +  this.queryInfo.query);
            this.adminusersList = data;
        },
        add(form) {
            this.$refs.userForm.validate(valid => {
                console.log(form);
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