<template>
    <el-select v-model="value" filterable placeholder="请选择政治面貌">
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
    data() {
        return {
            nations: [],
            value: 1
        }
    },
    async mounted() {
        this.loadMore();
    },
    methods: {
        loadMore() {
            this.getRequest("/api/system/politicstatus").then((resp) => {
                console.log(resp)
                if (resp) {
                    this.nations = resp.data;
                }
            });
        }
    }
}
</script>