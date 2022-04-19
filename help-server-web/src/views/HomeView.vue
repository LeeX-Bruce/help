<template>
  <div style="padding: 10px">
    <!--  功能区  -->
    <div style="margin: 10px 0px">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">删除</el-button>
    </div>

    <!--  搜索区  -->
    <div style="margin: 10px 0px">
      <el-input v-model="search" placeholder="请输入要搜索的管理员名字" style="width: 20%" />
      <el-button type="primary" style="margin-left: 5px">搜索</el-button>
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
        <template #default>
          <el-button type="default" @click="handleEdit">编辑</el-button>
          <el-popconfirm title="确认删除?">
            <template #reference>
              <el-button type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0px">
      <el-pagination
          v-model:currentPage="currentPage"
          :page-sizes="[10, 15, 20]"
          :page-size="15"
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
        user_name:"",
        password:"",
        email:"",
        mobile:"",
        status:"",
      },
      dialogVisible: false,
      search: '',
      currentPage: 1,
      total:4,
      tableData:[]
    }
  },
  methods: {
    add() {
      this.dialogVisible = true
      this.form = {}
      this.form.status = 1
    },
    save() {
      // post(后台端口url, 传入的参数)
      // .then：链式操作，前一步执行完成之后，会把返回的结果放到.then里
      request.post("/sys_user/save", this.form).then(res => {
        console.log(res)
      })

      this.dialogVisible = false
    },
    handleEdit() {

    },
    handleSizeChange () {

    },
    handleCurrentChange() {

    }
  }
}
</script>
