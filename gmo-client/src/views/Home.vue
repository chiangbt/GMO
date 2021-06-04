<template>
  <div>
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu router unique-opened>
            <el-submenu
              :index="index + ''"
              v-for="(item, index) in routes"
              :key="index"
              v-if="!item.hidden"
            >
              <template slot="title">
                <i :class="item.iconcls" style="color: #laccff; margin-right: 5px"></i>
                <span>{{ item.name }}</span>
              </template>
              <el-menu-item
                :index="children.path"
                v-for="(children, indexj) in item.children"
                :key="indexj">
                {{ children.name }}
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-container>
          <el-main>
            <router-view/>
          </el-main>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>

export default {
  name: 'Home',
  computed: {
    routes() {
      return this.$store.state.routes;
    },
  },
  methods:{

  },
  components: {
    
  }
}
</script>
