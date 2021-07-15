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
                <el-col :sm="12" :md="12">
                    <el-button type="primary" icon="el-icon-plus" @click="dialogFormVisible = true">添加</el-button>
                    <el-button type="danger" icon="el-icon-circle-close"  @click="handleDeleteMany()">批量删除</el-button>
                </el-col>
            </el-row>
        </div>
        <el-card class="box-card" shadow="always">
            <el-table :data="employeeList" stripe border style="width: 100%" @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="40"></el-table-column>
                <el-table-column type='index' label="编号" align="center" width="50" :index='(index)=>{return (index+1)}'/>
                <el-table-column prop="name" label="姓名"></el-table-column>
                <el-table-column prop="gender" label="性别" width="45"></el-table-column>
                <el-table-column prop="birthday" label="生日" width="90" :formatter="dateFormat"></el-table-column>
                <el-table-column prop="engageform" label="劳动合同" width="100"></el-table-column>
                <el-table-column prop="address" label="地址"></el-table-column>
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
        </el-card>
    </div>
</template>
<script>
import moment from 'moment';

export default {
    name: 'CusEmployee',
    data() {
        return {
            employeeList:[],
            multipleSelection: [],
            total: 0,
            searchVal: '',
            queryInfo: {
                query: "",
                pageNo: 1,
                pageSize: 15
            }
        }
    },
    mounted() {
        //this.getEmployeeList();
    },
    methods:{
        async getEmployeeList() {
            const { data, code, message } = await this.getRequest("/api/person/employee?query=" + 
                this.queryInfo.query + "&pageNo=" + 
                this.queryInfo.pageNo + "&pageSize=" + this.queryInfo.pageSize);

            if (code !== 200) {
                return this.$message.error(message);
            }
            this.employeeList = data.records;
            this.total = data.total;
        },
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        handleSizeChange(newSize) {
            this.queryInfo.pageSize = newSize;
            this.getEmployeeList();
        },
        handleCurrentChange(newPage) {
            this.queryInfo.pageNo = newPage;
            this.getEmployeeList();
        },
        dateFormat:function(row, column) {
            var date = row[column.property];  
            if (date == undefined) {  
                return "";  
            }  
            return moment(date).format("YYYY-MM-DD"); 
        },
        onClearSearch(){
            this.queryInfo.query = '';
            this.getEmployeeList();
        }
    }
}
</script>