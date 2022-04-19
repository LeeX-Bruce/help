<template>
  <div style="height: 50px; border-bottom: 1px solid #ccc; display: flex; background-color: #3c8dbc">
    <div style="width: 200px; padding-left: 30px;line-height: 50px; font-weight: bold; color: #fff; font-size: 1.5em">后台管理</div>
    <div style="flex: 1"></div>
    <div style="width: 100px">
      <el-dropdown style="line-height: 50px">
        <span class="el-dropdown-link" style="color: #fff">
          菜单
          <el-icon class="el-icon--right">
            <arrow-down/>
          </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>修改密码</el-dropdown-item>
            <el-dropdown-item>退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import { ArrowDown } from '@element-plus/icons-vue'
export default {
  name: "header",
  components: { ArrowDown }
}
</script>

<style scoped>

</style>