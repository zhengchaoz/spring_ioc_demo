<template>
  <div>
    <!-- 导航栏（面包屑） -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{path: '/home'}">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
      <el-breadcrumb-item>用户列表</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card class="box-card">
      <el-row :gutter="20">
        <el-col :span="9">
          <el-input placeholder="请输入内容" v-model="queryInfo.query" class="input-with-select"
                    clearable @clear="search">
            <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="addDialog">新增按钮</el-button>
        </el-col>
      </el-row>
      <template>
        <el-table :data="tableData" border stripe style="width: 100%">
          <el-table-column prop="username" label="用户名称"></el-table-column>
          <el-table-column prop="phone" label="电话"></el-table-column>
          <el-table-column prop="email" label="邮箱"></el-table-column>
          <el-table-column prop="status" label="状态">
            <template slot-scope="scope"><!-- 作用域插槽，用于在循环遍历的表格中获取当前行元素 -->
              <el-switch v-model="scope.row.status" @change="statusChange(scope.row)"
                         active-color="#13ce66" inactive-color="#ff4949"></el-switch>
            </template>
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button size="small" type="primary" icon="el-icon-edit"
                         @click="dialogEdit(scope.$index, scope.row)"></el-button>
              <el-button size="small" type="danger" icon="el-icon-delete"
                         @click="userDelete(scope.$index, scope.row)"></el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
      <!--
        size-change:页面显示条数发生变化时触发
        current-change:当前页数发生变化时触发
        current-page:当前页数
        page-size:每页显示条数
        total:总条数
      -->
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                     :current-page="this.queryInfo.pageNum" :page-sizes="[5, 10, 25, 50]"
                     :page-size="this.queryInfo.pageSize" :total="this.total"
                     layout="total, sizes, prev, pager, next, jumper">
      </el-pagination>
    </el-card>
    <el-dialog :title="title?'用户新增':'用户修改'" :visible.sync="dialogVisible" width="50%" @close="closeUser">
      <el-form :model="userForm" :rules="rules" ref="userForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名称" prop="username" v-show="show">
          <el-input v-model="userForm.username"></el-input>
        </el-form-item>
        <el-form-item label="用户密码" prop="password" v-show="show">
          <el-input v-model="userForm.password" show-password></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="confirmPassword" v-show="show">
          <el-input v-model="userForm.confirmPassword" show-password></el-input>
        </el-form-item>
        <el-form-item label="用户邮箱" prop="email">
          <el-input v-model="userForm.email"></el-input>
        </el-form-item>
        <el-form-item label="用户电话" prop="phone">
          <el-input v-model="userForm.phone"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible=false">取 消</el-button>
        <el-button type="primary" @click="addOrEditUser">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  // created() {
  //   this.search();
  // },
  name: "User",
  data() {
    const validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.userForm.password) {
        callback(new Error('两次输入密码不一致'));
      } else {
        callback();
      }
    };
    const checkPhone = (rule, value, callback) => {
      const phoneRegex = /^1[3456789][0-9]{9}$/
      if (phoneRegex.test(value)) {
        return callback()
      }
      callback(new Error('请填写正确的手机号'))
    };
    return {
      queryInfo: {
        query: '',
        pageNum: 1,
        pageSize: 5
      },
      userForm: {
        username: '',
        password: '',
        confirmPassword: '',
        email: '',
        phone: ''
      },
      rules: {
        username: [
          {required: true, message: '请输入用户名称', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入用户密码', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur'}
        ],
        confirmPassword: [
          {required: true, validator: validatePass2, trigger: 'blur'}
        ],
        email: [
          {required: true, message: '请输入邮箱地址', trigger: 'blur'},
          {type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change']}
        ],
        phone: [
          {required: true, validator: checkPhone, trigger: 'blur'}
        ],
      },
      tableData: [],
      total: 0,
      dialogVisible: false,
      title: true,
      show: true
    }
  },
  methods: {
    search: async function () {
      const {data: result} = await this.$http.get('/user/list', {params: this.queryInfo})
      if (result.status !== 200) return this.$message.error('获取列表数据失败！');
      this.tableData = result.data.rows;
      this.total = result.data.total;
    },
    addDialog() {
      this.dialogVisible = true;
      this.title = true;
      this.show = true;
    },
    dialogEdit(id, row) {
      Object.assign(this.userForm, row);
      this.userForm.confirmPassword = this.userForm.password;
      this.show = false;
      this.dialogVisible = true;
      this.title = false;
    },
    addOrEditUser() {
      if (this.title)
        this.addUser();
      else
        this.userEdit();
    },
    addUser() {
      this.$refs['userForm'].validate(async valid => {
        if (!valid) return this.$message.error('请输入正确的格式！');
        const {data: result} = await this.$http.post('/user/add', this.userForm);
        await this.flush(result, '新增用户');
        this.dialogVisible = false;
      });
    },
    async userEdit() {
      const {data: result} = await this.$http.put('/user/edit', this.userForm);
      await this.flush(result, '修改用户');
      this.dialogVisible = false;
    },
    async userDelete(id, row) {
      const result1 = await this.$confirm(`此操作将永久删除该用户：${row.username}, 是否继续?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).catch(error => error);
      if (result1 === 'config') return this.$message.info('已取消删除');
      const {data: result} = await this.$http.delete(`/user/del/${row.id}`);
      await this.flush(result, '删除用户');
    },
    handleSizeChange(pageSize) {//每页条数
      this.queryInfo.pageSize = pageSize;
      this.search();
    },
    handleCurrentChange(pageNum) {//当前页数
      this.queryInfo.pageNum = pageNum;
      this.search();
    },
    async statusChange(row) {
      // const {data: result} = await this.$http.put('/user/status/' + id + '/' + row.status);
      const {data: result} = await this.$http.put(`/user/status/${row.id}/${row.status}`);
      await this.flush(result, '修改用户状态');
    },
    async flush(result, text) {
      if (result.status !== 200) return this.$message.error(text + '失败！');
      await this.search();
      return this.$message.info(text + '成功！');
    },
    closeUser() {
      this.$refs['userForm'].resetFields();
    }
  },
  mounted() {
    this.search();
  }
}
</script>
<!-- scoped使样式只在当前组件内生效 -->
<style lang="less" scoped>

</style>
