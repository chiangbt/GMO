<template>
    <el-tabs type="border-card" v-model="activeName" @tab-click="handleClick">
        <el-tab-pane name="first">
            <span slot="label"><i class="el-icon-office-building"></i> 部门管理</span>
            <DepMana></DepMana>
        </el-tab-pane>
        <el-tab-pane name="second">
            <span slot="label"><i class="el-icon-bangzhu"></i> 职位管理</span>
            <component :detail='b' :is="PosMana"></component>
        </el-tab-pane>
        <el-tab-pane name="third">
            <span slot="label"><i class="el-icon-date"></i> 职称管理</span>
            <component :detail='c' :is="JoblevelMana"></component>
        </el-tab-pane>
    </el-tabs>
</template>

<script>
// 懒加载
const PosMana = resolve => require(['../../components/sys/basic/PosMana.vue'], resolve);
const DepMana = resolve => require(['../../components/sys/basic/DepMana.vue'], resolve);
const JoblevelMana = resolve => require(['../../components/sys/basic/JoblevelMana.vue'], resolve);

export default {
    components: { DepMana },
    name: "SysBasic",
    data() {
        return {
            activeName: 'first'
        }
    },
    methods: {
        handleClick (tab, event) {
            this.$store.commit('changeapplyTab', tab.name);
            this.checkVue(tab.name);
        },
        checkVue (name) {
            switch (name) {
                case 'first' :
                    this.DepMana = DepMana
                    break
                case 'second' :
                    this.PosMana = PosMana
                    break
                case 'third' :
                    this.JoblevelMana = JoblevelMana
                    break
                }
        }
    }
}
</script>

<style>

</style>