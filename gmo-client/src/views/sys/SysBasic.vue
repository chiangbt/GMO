<template>
  <el-tabs type="border-card" v-model="activeName">
    <el-tab-pane label="部门管理" name="first">
      <DepMana></DepMana>
    </el-tab-pane>
    <el-tab-pane label="职位管理" name="second">
      <PosMana></PosMana>
    </el-tab-pane>
    <el-tab-pane label="职称管理" name="third">
      <JoblevelMana></JoblevelMana>
    </el-tab-pane>
    <el-tab-pane label="权限组" name="five">
      <PermissMana></PermissMana>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import PosMana from "../../components/sys/basic/PosMana";
import DepMana from "../../components/sys/basic/DepMana";
import JoblevelMana from "../../components/sys/basic/JoblevelMana";
import PermissMana from "../../components/sys/basic/PermissMana";

export default {
  components: { DepMana },
  name: "SysBasic",
  data() {
    return {
      activeName: 'first'
    }
  },
  components: {
    DepMana,
    JoblevelMana,
    PosMana,
    PermissMana,
  },
}
</script>

<style>

</style>