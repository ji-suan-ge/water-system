<template>
  <div>
    <div class="col-lg-9">
      <div class="card">
        <div class="card-title">
          <label>添加员工</label>
        </div>
        <div class="card-body">
          <div class="form-inline">
            <div class="form-group">
              <label>姓名</label>
              <input type="text" class="form-control" v-model="staff.name">
              <label>性别</label>
              <input type="text" class="form-control" v-model="staff.gender">
              <label>出生日期</label>
              <input type="text" class="form-control" v-model="staff.birthday">
              <label>工资</label>
              <input type="text" class="form-control" v-model="staff.salary">
              <button class="btn btn-primary" @click="addStaff">添加员工</button>
            </div>
          </div>
        </div>
      </div>

      <div class="card">
        <div class="card-title">
          员工列表
        </div>
        <div class="card-body">
          <div>
            <table class="table">
              <thead>
              <tr>
                <th>工号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>入职日期</th>
                <th>工资</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="item in staffList" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.name }}</td>
                <td>{{ item.gender == 0 ? '男' : '女' }}</td>
                <td>{{ item.birthday }}</td>
                <td>{{ item.dateOfEntry }}</td>
                <td>
                  {{ item.salary }}
                </td>
                <td>
                  <a data-toggle="modal" data-target="#modelId"
                     @click="clickEdit(item.id, item.salary)">
                    修改员工工资
                  </a>
                  <a href="#" @click="deleteStaff(item.id)">删除员工</a>

                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
         aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">修改员工工资</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label style="font-size: 20px;">请输入新工资</label>
              <input type="text" class="form-control" :placeholder="currentSalary" v-model="newSalary">
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary" data-dismiss="modal"
                    @click="editSalary(currentID, newSalary)">确定</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'staff',
  data: function () {
    return {
      staffList: null,
      newSalary: null,
      currentID: null,
      currentSalary: null,
      staff: {
        name: null,
        gender: null,
        birthday: null,
        salary: null
      }
    }
  },
  methods: {
    getAllList () {
      let that = this
      that.axios.post('/staff/getAll')
        .then(function (response) {
          that.staffList = response.data.data.staffList
          console.log(that.staffList)
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    deleteStaff (staffID) {
      let that = this
      console.log('要删除的ID')
      console.log(staffID)
      that.axios.post('/staff/delete', {
        staffID: staffID
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            console.log('删除员工成功')
          }
          that.getAllList()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    editSalary (staffID, newSalary) {
      console.log('要修改的ID')
      console.log(staffID)
      console.log('要修改为的工资')
      console.log(newSalary)
      if (this.newSalary == null) {
        return
      }
      let that = this
      that.axios.post('/staff/editSalary', {
        staffID: staffID,
        salary: newSalary
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            console.log('修改成功')
          }
          that.getAllList()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    clickEdit (ID, salary) {
      this.currentID = ID
      this.currentSalary = salary
      console.log('当前ID')
      console.log(this.currentID)
      console.log('当前工资')
      console.log(this.currentSalary)
      this.newSalary = null
    },
    addStaff () {
      console.log(this.staff)
      let that = this
      let staff = that.staff
      that.axios.post('/staff/add', {
        name: staff.name,
        gender: staff.gender === '男' ? 0 : 1,
        salary: staff.salary,
        birthday: staff.birthday
      })
        .then(function (response) {
          if (response.data.code === '0000') { console.log('修改成功') }
          that.getAllList()
          that.staff.name = null
          that.staff.gender = null
          that.staff.birthday = null
          that.staff.salary = null
        })
        .catch(function (error) {
          that.staff.name = null
          that.staff.gender = null
          that.staff.birthday = null
          that.staff.salary = null
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
