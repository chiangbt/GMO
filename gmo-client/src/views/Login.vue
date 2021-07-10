<template>
    <div class="page">
        <el-form :model="loginForm" ref="form" :rules="loginRules" class="loginContainer" v-loading="loading"
          element-loading-text="正在登录..." element-loading-spinner="el-icon-loading" element-loading-background="rgba(0, 0, 0, 0.8)">
            <h3 class="loginTitle">
                <i class="el-icon-discover"/>&nbsp;&nbsp;GeoManagement
            </h3>
            <el-form-item prop="username">
                <el-input type="text" v-model="loginForm.username" placeholder="请输入用户名" clearable prefix-icon="fa fa-user" auto-complete="false"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input
                    type="password"
                    v-model="loginForm.password"
                    placeholder="请输入密码"
                    clearable
                    prefix-icon="fa fa-lock"
                    auto-complete="false"
                ></el-input>
            </el-form-item>
            <el-form-item prop="verifycode">
                <el-input
                    type="text"
                    v-model="loginForm.verifycode"
                    placeholder="点击图片更换验证码"
                    style="width: 250px; margin-right: 5px"
                    @keyup.enter.native="submitLogin"
                ></el-input>
                <img :src="captchaUrl" @click="updateCaptcha" />
            </el-form-item>
            <el-checkbox v-model="checked" class="loginRemember">记住我</el-checkbox>
            <el-button type="primary" style="width: 100%" @click="submitLogin">登录</el-button>
        </el-form>
    </div>
</template>

<script>
import { Message } from 'element-ui'
export default {
    name: "Login",
    data() {
        return {
            captchaUrl: "/api/auth/captcha?time=" + new Date(),
            loginForm: {
                username: "admin",
                password: "123",
                verifycode: ""
            },
            loading: false,
            checked: true,
            loginRules: {
                username: [{ required: true, message: "请输入用户名", trigger: "blur" }],
                password: [{ required: true, message: "请输入密码", trigger: "blur" }],
                verifycode: [{ required: true, message: "请输入验证码", trigger: "blur" }],
            }
        };
    },
    mounted() {
        this.checkStatus();
    },
    methods: {
      updateCaptcha() {
          this.captchaUrl = "/api/auth/captcha?time=" + new Date();
      },
      submitLogin() {
          this.$refs.form.validate((valid) => {
            if (valid) {
              this.postRequest("/api/auth/login", this.loginForm).then((resp) => {
                if (resp) {
                    if(resp.code === 500 || resp.code == 401 || resp.code == 403){
                        Message.error({ message: resp.message });
                        this.updateCaptcha();
                        return;
                    }
                    this.loading = false;
                    const tokenStr = resp.data.tokenHead + resp.data.token;
                    //存储用户token
                    window.sessionStorage.setItem("tokenStr", tokenStr);
                    //跳转页面
                    let path = this.$route.query.redirect;
                    this.$router.push(path=='/'||path==undefined?'/home':path);
                }
              });
            } else {
                this.$message.error("请输入所有字段");
                return false;
            }
        });
      },
      checkStatus() {
            if (window.sessionStorage.getItem('tokenStr')) {
                let path = this.$route.query.redirect;
                this.$router.push(path=='/'||path==undefined?'/home':path)
            } 
      }
    },
};
</script>

<style>
.page {
    background-image: url('./../assets/bg.jpg');
    background-repeat: round;
    width:100vw;
    height:100vh;
    display:flex;
    justify-content: center;
    align-items: center;
}
.loginContainer {
    opacity: 0.98;
    border-radius: 5px;
    background: padding-box;
    margin: 100px auto;
    width: 350px;
    margin-top: -10px;
    padding: 45px 35px 35px 35px;
    background: white;
    border: 1px solid #eeeaaa;
    box-shadow: 0 0 25px #cac6c6;
}
.loginTitle {
    margin: 0px auto 40px auto;
    text-align: center;
}
.loginRemember {
    text-align: center;
    margin: 0px 0px 15px 0px;
}
.el-form-item__content {
    display: flex;
    align-items: center;
}
</style>