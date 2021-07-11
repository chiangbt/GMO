<template>
    <div>
        <div style="text-align: right; margin-top: 30px; margin-bottom:20px;">
            <el-row :gutter="20">
                <el-col :sm="12" :md="12" style="text-align:left;">
                    <nation-select></nation-select>
                    <politics-select></politics-select>
                </el-col>
                <el-col :sm="12" :md="12">
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
                <el-table-column prop="roles[0].name" label="角色名"></el-table-column>
                <el-table-column prop="updatedat" label="录入时间"></el-table-column>
                <el-table-column label="操作" align="center" width="180">
                    <template slot-scope="scope">
                        <el-button size="mini" @click="handleEdit(scope.row)" class="el-icon-edit">编辑</el-button>
                        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)" class="el-icon-delete">失效</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-card>
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
        }
    },
    mounted() {
        this.getAdminUserList();
    },
    methods:{
        async getAdminUserList() {
            const data = await this.getRequest("/api/system/admin?keywords=" +  this.queryInfo.query);
            console.log(data)
            this.adminusersList = data;
        },
    }
}
</script>

<style>

</style>