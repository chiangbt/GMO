import { camelCase } from 'lodash';
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);


export default new Vuex.Store({
    state: {
        routes: [],
        isCollapse: false,
        aside_width: '200px',
    },
    mutations: {
        initRoutes(state, data) {
            state.routes = data
        }
    }
})