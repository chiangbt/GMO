<template>
    <el-select v-model="svalue" placeholder="请选择职务" style="width:100%;">
        <el-option
            v-for="item in positions"
            :key="item.id"
            :label="item.name"
            :value="item.id">
        </el-option>
    </el-select>
</template>

<script>
export default {
    name: 'PositionSelect',
    props: {
        value: {
            type: Number,
            required: true
        }
    },
    data() {
        return {
            positions: [],
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
            this.getRequest("/api/system/basic/position/valid").then((resp) => {
                if (resp) {
                    this.positions = resp;
                }
            });
        },
        sChange() {
            this.$emit("sChange");
        }
    }
}
</script>