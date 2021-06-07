<template>
  <el-row gutter="20">
    <el-col :span="12">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%">
        <el-table-column
          prop="date"
          label="日期"
          width="180">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="address"
          label="地址">
        </el-table-column>
      </el-table>
    </el-col>
    <el-col :span="12">
      <el-card class="box-card" shadow="always">
        <div slot="header" class="clearfix">
          <span>发送邮件</span>
        </div>
        <el-form>
          <el-form-item label="活动名称">
            <el-input></el-input>
          </el-form-item>
          <el-form-item>
            <vue-editor v-model="content" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" >立即创建</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
import { VueEditor } from "vue2-editor";

export default {
  name: "CusMail",
  data() {
    return {
      content: "<h1>Some initial content</h1>",
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }]
    }
  },
  components: { VueEditor }
}
</script>

<style>

</style>