<template>
    
</template>
<script>
export default {
    name: 'NationSelect',
    data() {
        return {
            nations: []
        }
    },
    mounted() {
        this.loadMore();
    },
    methods: {
        loadMore() {
            console.log("more")
        }
    }
}
</script>