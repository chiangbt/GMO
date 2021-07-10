import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import store from './store';
import 'font-awesome/css/font-awesome.css';
import 'element-ui/lib/theme-chalk/index.css';
import 'font-awesome/css/font-awesome.css';
import '@arcgis/core/assets/esri/themes/light/main.css';

import { postRequest, patchRequest, deleteRequest, getRequest } from './utils/api'
import { initMenu } from './utils/menu'
Vue.config.productionTip = false
Vue.use(ElementUI, { size: 'small' })

//插件形式使用请求
Vue.prototype.postRequest = postRequest;
Vue.prototype.getRequest = getRequest;
Vue.prototype.patchRequest = patchRequest;
Vue.prototype.deleteRequest = deleteRequest;

// 路由导航
router.beforeEach((to, from, next) => {
    // 获取登录用户token
    if (window.sessionStorage.getItem('tokenStr')) {
        initMenu(router, store);
        if (!window.sessionStorage.getItem('user')) {
            //判断用户信息是否存在
            return getRequest('/api/auth/user/info').then(resp => {
                if (resp) {
                    // console.log(resp);
                    //存入用户信息
                    window.sessionStorage.setItem('user', JSON.stringify(resp));
                    next();
                }
            })
        }
        next();
    } else {
        if (to.path == '/') {
            next();
        } else {
            //next('/')
            next('/?redirect=' + to.path);
        }
    }
})

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
