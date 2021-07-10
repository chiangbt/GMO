import { getRequest } from './api'

export const initMenu = (router, store) => {
    if (store.state.routers && store.state.routers.length > 0) {
        return;
    }
    getRequest('/api/system/menu/menu').then(data => {
        if (data) {
            //格式化Router
            let fmtRoutes = formatRoutes(data);
            //添加到Router
            router.addRoutes(fmtRoutes);
            //将数据存入vuex
            store.commit('initRoutes', fmtRoutes);
        }
    })
}

export const formatRoutes = (routes) => {
    let fmtRoutes = [];
    routes.forEach(router => {
        let {
            path, component, name, iconcls, children
        } = router;
        if (children && children instanceof Array) {
            //递归
            children = formatRoutes(children);
        }

        let fmtRoute = {
            path: path,
            name: name,
            iconcls: iconcls,
            children: children,
            //懒加载路由
            component(resolve) {
                if (component.startsWith('Home')) {
                    require(['../views/' + component + '.vue'], resolve);
                } else if (component.startsWith('Cus')) {
                    require(['../views/cus/' + component + '.vue'], resolve);
                } else if (component.startsWith('SDB')) {
                    require(['../views/sdb/' + component + '.vue'], resolve);
                } else if (component.startsWith('Sal')) {
                    require(['../views/sal/' + component + '.vue'], resolve);
                } else if (component.startsWith('Sta')) {
                    require(['../views/sta/' + component + '.vue'], resolve);
                } else if (component.startsWith('Sys')) {
                    require(['../views/sys/' + component + '.vue'], resolve);
                }

            }
        }
        fmtRoutes.push(fmtRoute)
    });
    return fmtRoutes
}