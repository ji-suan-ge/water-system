<template>
  <div>
    <div class="col-lg-12">
      <div class="card">
        <div class="card-title">
          <label>添加客户</label>
        </div>
        <div class="card-body">
          <div class="form-inline">
            <div class="form-group">
              <label>姓名</label>
              <input type="text" class="form-control" v-model="custom.name">
              <label>性别</label>
              <input type="text" class="form-control" v-model="custom.gender">
              <label>地址</label>
              <input type="text" class="form-control" v-model="custom.address">
              <label>电话</label>
              <input type="text" class="form-control" v-model="custom.phoneNumber">
              <button class="btn btn-primary" @click="addCustom">添加顾客</button>
            </div>
          </div>
        </div>
      </div>
      <div class="card">
        <div class="card-title">
          客户列表
        </div>
        <div class="card-body">
          <div>
            <table class="table">
              <thead>
              <tr>
                <th>客户编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>联系地址</th>
                <th>联系电话</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="item in customList" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.name }}</td>
                <td>{{ item.gender == 0 ? '男' : '女' }}</td>
                <td>{{ item.address }}</td>
                <td>{{ item.phoneNumber }}</td>
                <td>
                  <a href="#" @click="deleteCustom(item.id)">删除客户</a>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'custom',
  data: function () {
    return {
      customList: null,
      custom: {
        name: null,
        gender: null,
        address: null,
        phoneNumber: null
      }
    }
  },
  methods: {
    getAllList () {
      let that = this
      this.axios.post('/custom/getAll')
        .then(function (response) {
          that.customList = response.data.data.customList
          console.log(that.customList)
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    deleteCustom (customID) {
      let that = this
      console.log('要删除的ID')
      console.log(customID)
      this.axios.post('/custom/delete', {
        customID: customID
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            console.log('删除客户成功')
          }
          that.getAllList()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    addCustom () {
      console.log(this.custom)
      let that = this
      let custom = that.custom
      this.axios.post('/custom/add', {
        name: custom.name,
        gender: custom.gender === '男' ? 0 : 1,
        address: custom.address,
        phoneNumber: custom.phoneNumber
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            console.log('修改成功')
          }
          that.getAllList()
          that.custom.name = null
          that.custom.gender = null
          that.custom.address = null
          that.custom.phoneNumber = null
        })
        .catch(function (error) {
          that.custom.name = null
          that.custom.gender = null
          that.custom.address = null
          that.custom.phoneNumber = null
          alert('输入的参数有错误！')
          console.log(error)
        })
    }
  },
  created () {
    this.getAllList()
  }
}
</script>

<style scoped>
  label {
    font-size: 20px;
  }
</style>
