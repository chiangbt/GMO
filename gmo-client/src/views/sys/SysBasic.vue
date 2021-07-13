<template>
    <el-tabs type="border-card" v-model="activeName" @tab-click="handleClick">
        <el-tab-pane name="first" :key="'first'">
            <span slot="label"><i class="el-icon-office-building"></i> 部门管理</span>
            <DepMana v-if="isFirst"></DepMana>
        </el-tab-pane>
        <el-tab-pane name="second" :key="'second'">
            <span slot="label"><i class="el-icon-bangzhu"></i> 职位管理</span>
            <PosMana v-if="isSecond"></PosMana>
        </el-tab-pane>
        <el-tab-pane name="third" :key="'third'">
            <span slot="label"><i class="el-icon-date"></i> 职称管理</span>
            <JoblevelMana  v-if="isThird"></JoblevelMana>
        </el-tab-pane>
    </el-tabs>
</template>

<script>
// 懒加载
const PosMana = resolve => require(['../../components/sys/basic/PosMana.vue'], resolve);
const DepMana = resolve => require(['../../components/sys/basic/DepMana.vue'], resolve);
const JoblevelMana = resolve => require(['../../components/sys/basic/JoblevelMana.vue'], resolve);

export default {
    name: "SysBasic",
    components: {
        PosMana,
        DepMana,
        JoblevelMana
    },
    data() {
        return {
            activeName: 'first',
            isFirst: true,
            isSecond: false,
            isThird: false
        }
    },
    methods: {
        handleClick (tab, event) {
            if (tab.name === 'first') {
                this.isFirst = true;
                this.isSecond = false;
                this.isThird = false;
            } else if (tab.name === 'second') {
                this.isFirst = false;
                this.isSecond = true;
                this.isThird = false;
            } else if (tab.name === 'third') {
                this.isFirst = false;
                this.isSecond = false;
                this.isThird = true;
            }
        }
    }
}
</script>

<style>

</style>