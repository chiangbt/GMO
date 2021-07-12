<template>
    <el-select v-model="svalue" placeholder="请选择用户角色" style="width:100%;">
        <el-option
            v-for="item in roles"
            :key="item.id"
            :label="item.namezh"
            :value="item.id">
        </el-option>
    </el-select>
</template>

<script>
export default {
    name: 'RoleSelect',
    props: {
        value: {
            type: Number,
            required: true
        }
    },
    data() {
        return {
            roles: [],
            svalue: this.value
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
            this.getRequest("/api/system/admin/roles").then((resp) => {
                if (resp) {
                    this.roles = resp;
                }
            });
        },
        sChange() {
            this.$emit("sChange");
        }
    }
}
</script>