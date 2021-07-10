<template>
    <div id="app">
        <router-view/>
    </div>
</template>
<script>
export default {
    name: 'app'
}
</script>
<style>
#app {
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    margin: 0;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}

body {
    margin: 0;
    padding: 0;
    height: 100vh;
    font-family: 'Avenir,Helvetica,Arial,sans-serif';
    font-size: 14px;
    color: #2c3e50;
    background-color: #f6f8f9;
}
</style>
