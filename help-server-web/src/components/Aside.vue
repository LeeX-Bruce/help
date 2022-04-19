<template>
  <div>
    <el-menu
        style="min-height: calc(100vh - 50px);"
        default-active="2"
        class="el-menu-vertical-demo"
    >
      <el-sub-menu index="1">
        <template #title>
          <el-icon><location /></el-icon>
          <span>管理员管理</span>
        </template>
        <el-menu-item index="1-1">item one</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <span>用户管理</span>
      </el-menu-item>
      <el-menu-item index="3">
        <el-icon><document /></el-icon>
        <span>订单管理</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>系统管理</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
export default {
  name: "Aside",
  components: {
    Document,
    IconMenu,
    Location,
    Setting,
  }
}
</script>

<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>