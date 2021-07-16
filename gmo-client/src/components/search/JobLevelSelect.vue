<template>
    <el-select v-model="svalue" placeholder="请选择用户职称" style="width:100%;">
        <el-option
            v-for="item in joblevels"
            :key="item.id"
            :label="item.name + ' - ' + item.titlelevel"
            :value="item.id">
        </el-option>
    </el-select>
</template>

<script>
export default {
    name: 'JobLevelSelect',
    props: {
        value: {
            type: Number,
            required: true
        }
    },
    data() {
        return {
            joblevels: [],
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
            this.getRequest("/api/system/basic/joblevel/valid").then((resp) => {
                if (resp) {
                    this.joblevels = resp;
                }
            });
        },
        sChange() {
            this.$emit("sChange");
        }
    }
}
</script>