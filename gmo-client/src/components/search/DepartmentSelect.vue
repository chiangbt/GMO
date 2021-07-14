<template>
    <el-select-tree style="width:100%;"
        :default-expand-all="defaultExpandAll"
        :multiple="multiple"
        placeholder="选择部门..."
        :disabled="disabled"
        :data="deps"
        :props="treeProps"
        :check-strictly="checkStrictly"
        :clearable="clearable"
        v-model="svalue"
    ></el-select-tree>
</template>

<script>
import ElSelectTree from 'el-select-tree';

export default {
    name: 'DepartmentSelect',
    components: {
        ElSelectTree
    },
    props: {
        value: {
            type: Number,
            required: true
        }
    },
    data() {
        return {
            deps: [],
            svalue: this.value,
            treeProps: {
                value: 'id',
                children: 'children',
                label: 'name'
            },
            popoverWidth: 0,
            clearable: true,
            defaultExpandAll: false,
            multiple: false,
            disabled: false,
            checkStrictly: false,
        }
    },
    watch: {
        value(newVal) {
            this.svalue = newVal;
        },
        svalue(newVal, oldVal) {
            if (newVal !== oldVal) {
                this.$emit("input", this.svalue);
            }
        }
    },
    async mounted() {
        this.loadMore();
    },
    methods: {
        loadMore() {
            this.getRequest("/api/system/basic/department").then((resp) => {
                if (resp) {
                    this.deps = resp;
                }
            });
        },
        sChange() {
            this.$emit("sChange");
        }
    }
}
</script>
<style lang="less" scoped>
/deep/ .el-popover {
    min-width: 320px;
}
</style>