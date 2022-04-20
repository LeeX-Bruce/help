<template>
  <div style="padding: 10px">
    <!--  功能区  -->
    <div style="margin: 10px 0px">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">删除</el-button>
    </div>

    <!--  搜索区  -->
    <div style="margin: 10px 0px">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable />
      <el-button type="primary" style="margin-left: 5px" @click="load">搜索</el-button>
    </div>

    <!--  数据展示区  -->
    <el-table :data="tableData" border  stripe style="width: 100%">
      <el-table-column prop="user_id" label="id" sortable />
      <el-table-column prop="user_name" label="管理员" sortable />
      <el-table-column prop="email" label="邮箱" />
      <el-table-column prop="mobile" label="手机号" />
      <el-table-column prop="status" label="状态" />
      <el-table-column prop="create_time" label="创建时间" />
      <el-table-column fixed="right" label="操作">
        <template #default="scope">
          <el-button type="default" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确认删除?">
            <template #reference>
              <el-button type="danger" @click="handleDelete">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0px">
      <el-pagination
          v-model:currentPage="currentPage"
          :page-sizes="pageSizes"
          :page-size="pageSize"
          :background="true"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
      <el-dialog v-model="dialogVisible" title="新增" width="30%" draggable center>
        <el-form :model="form" label-width="120px">
          <el-form-item label="用户名">
            <el-input v-model="form.user_name" placeholder="登陆账号" />
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.password" placeholder="密码" />
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="form.email" placeholder="邮箱" />
          </el-form-item>
          <el-form-item label="手机号">
            <el-input v-model="form.mobile" placeholder="手机号" />
          </el-form-item>
          <el-form-item label="状态">
            <el-radio-group v-model="form.status">
              <el-radio :label="1">正常</el-radio>
              <el-radio :label="0">禁用</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
          <el-button @click="dialogVisible = false">返回</el-button>
          <el-button type="primary" @click="save">确认
          </el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: 'HomeView',
  components: {
  },

  data(){
    return{
      form:{
        user_name: "",
        password: "",
        email: "",
        mobile: "",
        status: "",
      },
      dialogVisible: false,
      search: '',
      currentPage: 1,
      pageSize: 15,
      pageSizes: [10, 15, 20],
      total: 0,
      tableData: []
    }
  },

  created() { //页面加载
    this.load()
  },

  methods: {
    load(){
      request.get("/sys_user/getSysUser", {
        params: {
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res => {
        // console.log(res)
        this.total = res.data.total
        this.tableData = res.data.records
      })
    },
    add() {
      this.dialogVisible = true
      this.form = {}
      this.form.status = 1
    },
    save() {
      if(this.form.user_id) {  //更新
        request.put("/sys_user/updateSysUser", this.form).then(res => {
          if(res.code === 200) {
            this.$message({
              type: "success",
              message: "修改成功"
            })

            this.load() //刷新表格
            this.dialogVisible = false  //关闭弹窗
          }
          else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      }
      else {  //新增
        request.post("/sys_user/save", this.form).then(res => {
          if(res.code === 200) {
            this.$message({
              type: "success",
              message: "新增成功"
            })

            this.load() //刷新表格
            this.dialogVisible = false  //关闭弹窗
          }
          else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      }
    },

    handleEdit(row) {
      //对row对象进行深拷贝，此时form对象就和表格里对应的row对象隔离开来
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },

    handleDelete() {

    },

    handleSizeChange () {

    },

    handleCurrentChange() {

    }
  }
}
</script>
