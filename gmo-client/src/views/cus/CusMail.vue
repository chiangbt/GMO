<template>
  <el-row :gutter="20">
    <el-col :span="12">
      <el-table :data="mailList" stripe border style="width: 100%" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column type='index' label="编号" align="center" width="50" :index='(index)=>{return (index+1)}'/>
        <el-table-column prop="mailto" label="收件人" width="180"></el-table-column>
        <el-table-column prop="content" label="内容" ></el-table-column>
        <el-table-column label="操作" align="center" width="90">
          <template slot-scope="scope">
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
    </el-col>
    <el-col :span="12">
      <el-card class="box-card" shadow="always">
        <div slot="header" class="clearfix">
          <span>发送邮件</span>
        </div>
        <el-form :model="emailForm" ref="emailForm" :rules="rules">
          <el-form-item label="收件人" prop="to">
            <el-input  v-model="emailForm.to"></el-input>
          </el-form-item>
          <el-form-item>
            <vue-editor v-model="emailForm.content" :editor-toolbar="customToolbar" style="width: 100%;"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="add(emailForm)">发送</el-button>
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
    return {
      customToolbar: [
        ["bold", "italic", "underline"],
        [{ list: "ordered" }, { list: "bullet" }],
        ["image", "code-block"]
      ],
      mailList:[],
      multipleSelection: [],
      searchVal: '',
      queryInfo: {
        query: "",
        pageNo: 1,
        pageSize: 15
      },
      total: 0,
      emailForm: {
        to: '',
        content: "测试邮件",
      },
      rules: {
        to: [
          {required: true, message: '请输入收件人', trigger: 'blur'},
          {validator: checkEmail, trigger: 'blur'}
        ]
      },
    }
  },
  components: { 
    VueEditor 
  },
  mounted() {
    this.getMailList();
  },
  methods: {
    async getMailList() {
      const { data, code, message } = await this.getRequest("/api/send/maillist?query=" + 
        this.queryInfo.query + "&pageNo=" + 
        this.queryInfo.pageNo + "&pageSize=" + this.queryInfo.pageSize);

      if (code !== 200) {
        return this.$message.error(message);
      }
      this.mailList = data.records;
      this.total = data.total;
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(newSize) {
      this.queryInfo.pageSize = newSize;
      this.getMailList();
    },
    handleCurrentChange(newPage) {
      this.queryInfo.pageNo = newPage;
      this.getMailList();
    },
    handleDelete(key, data){
      this.$confirm("此操作将删除记录,提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.deleteRequest("/api/send/maillist/" + data.id).then((resp) => {
          if (resp) {
            this.getMailList();
          }
        });
      }).catch(() => {
        this.$message({
          type: "info",
          message: "已取消操作",
        });
      });
    },
    add(form){
      this.$refs.emailForm.validate(valid => {
        if (valid) { //表单验证通过
          this.postRequest("/api/send/mail", form).then((resp) => {
            if (resp.code == 200) {
              this.pageNo = 1;
              this.getMailList();
              this.emailForm = {
                to: '',
                content: "测试邮件",
              };
              this.$message({
                type: "success",
                message: "邮件发送成功!",
              });
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    }
  }
}
</script>

<style>

</style>