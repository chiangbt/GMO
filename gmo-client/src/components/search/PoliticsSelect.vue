<template>
    <el-select v-model="svalue" filterable placeholder="请选择政治面貌" style="width:100%;">
        <el-option
            v-for="item in nations"
            :key="item.id"
            :label="item.name"
            :value="item.id">
        </el-option>
    </el-select>
</template>

<script>
export default {
    name: 'PoliticsSelect',
    props: {
        value: {
            type: Number,
            required: true
        }
    },
    data() {
        return {
            nations: [],
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
            this.getRequest("/api/system/politicstatus").then((resp) => {
                if (resp) {
                    this.nations = resp.data;
                }
            });
        },
        sChange() {
            this.$emit("sChange");
        }
    }
}
</script>