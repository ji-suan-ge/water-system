<template>
  <div>
    <div class="col-lg-9">

      <div class="card">
        <div class="card-title">
          <label>添加矿泉水</label>
        </div>
        <div class="card-body">
          <div class="form-inline">
            <div class="form-group">
              <label>矿泉水名字</label>
              <input type="text" class="form-control col-lg-2" v-model="waterToAdd.name">
              <label>规格(mL)</label>
              <input type="text" class="form-control col-lg-1" v-model="waterToAdd.size">
              <label>成本(分)</label>
              <input type="text" class="form-control col-lg-1" v-model="waterToAdd.cost">
              <label>售价(分)</label>
              <input type="text" class="form-control col-lg-1" v-model="waterToAdd.price">
              <button class="btn btn-primary" @click="addWater">添加矿泉水</button>
            </div>
          </div>

        </div>
      </div>

      <div class="card">
        <div class="card-title">
          矿泉水列表
        </div>
        <div class="card-body">
          <div>
            <table class="table">
              <thead>
              <tr>
                <th>编号</th>
                <th>矿泉水名字</th>
                <th>规格(L)</th>
                <th>成本(元)</th>
                <th>售价(元)</th>
                <th>数量(瓶)</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="item in waterList" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.name }}</td>
                <td>{{ item.size / 1000 }}</td>
                <td>{{ item.cost / 100 }}</td>
                <td>{{ item.price / 100 }}</td>
                <td>{{ item.quantity }}</td>
                <td>
                  <a href="#" @click="deleteWater(item.id)">删除矿泉水</a>
                  <a data-toggle="modal" data-target="#purchaseModal"
                     @click="clickPurchase(item.id)">
                    进货
                  </a>
                  <a data-toggle="modal" data-target="#supplierModal"
                     @click="clickAddSupplier(item.id)">
                    添加供应商
                  </a>

                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <div class="modal fade" id="purchaseModal" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
         aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">进货----矿泉水ID: {{ waterToPurchase.waterID }}</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="form-group" style="display: inline-block;">
              <label>供应商</label>
              <select class="form-control" v-model="waterToPurchase.supplierID">
                <option v-for="supplier in waterToPurchase.supplierList" :key="supplier.id"
                        :value="supplier.id">
                  {{ supplier.id }}--{{ supplier.name }}
                </option>
              </select>
              <label>员工</label>
              <select class="form-control" v-model="waterToPurchase.staffID">
                <option v-for="staff in waterToPurchase.staffList" :key="staff.id" :value="staff.id">
                  {{ staff.id }}--{{ staff.name }}
                </option>
              </select>
            </div>
            <br />
            <label style="font-size: 20px;">数&nbsp;&nbsp;&nbsp;&nbsp;量&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input type="text" v-model="waterToPurchase.quantity" placeholder="1" class="form-control col-lg-5"
                   style="display: inline-block;">
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary" data-dismiss="modal" @click="purchase">进货</button>
          </div>
        </div>
      </div>
    </div>

    <div class="modal fade" id="supplierModal" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
         aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" style="font-size: 20px;">添加供应商----矿泉水ID: {{ supplierToAdd.waterID }}</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="form-group" style="display: inline-block;">
              <label>供应商</label>
              <select class="form-control" v-model="supplierToAdd.supplierID">
                <option v-for="supplier in supplierToAdd.supplierList" :key="supplier.id"
                        :value="supplier.id">
                  {{ supplier.id }}--{{ supplier.name }}
                </option>
              </select>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary" data-dismiss="modal"
                    @click="addSupplier">添加</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'water',
  data: function () {
    return {
      waterList: null,
      waterToAdd: {
        name: null,
        size: null,
        cost: null,
        price: null
      },
      supplierToAdd: {
        waterID: null,
        supplierID: null,
        supplierList: null
      },
      waterToPurchase: {
        waterID: null,
        staffID: null,
        supplierID: null,
        quantity: null,
        supplierList: null,
        staffList: null
      }
    }
  },
  methods: {
    getAllList () {
      let that = this
      that.axios.post('/water/getAll')
        .then(function (response) {
          that.waterList = response.data.data.waterList
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    deleteWater (waterID) {
      let that = this
      console.log('要删除的ID' + waterID)
      that.axios.post('/water/delete', {
        waterID: waterID
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            console.log('删除矿泉水成功')
          }
          that.getAllList()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    addWater () {
      let that = this
      let water = that.waterToAdd
      that.axios.post('/water/add', {
        name: water.name,
        size: water.size,
        price: water.price,
        cost: water.cost
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            console.log('修改成功')
          }
          that.getAllList()
          that.waterToAdd.name = null
          that.waterToAdd.size = null
          that.waterToAdd.cost = null
          that.waterToAdd.price = null
        })
        .catch(function (error) {
          that.waterToAdd.name = null
          that.waterToAdd.size = null
          that.waterToAdd.cost = null
          that.waterToAdd.price = null
          alert('您输入的数据有错误，请重新输入！')
          console.log(error)
        })
    },
    clickPurchase (waterID) {
      let that = this
      that.waterToPurchase.waterID = waterID
      that.waterToPurchase.supplierID = null
      that.waterToPurchase.staffID = null
      that.waterToPurchase.quantity = null
      that.axios.post('/supplier/getYetSupplier', {
        waterID: that.waterToPurchase.waterID
      })
        .then(function (response) {
          that.waterToPurchase.supplierList = response.data.data.supplierList
        })
        .catch(function (error) {
          console.log(error)
        })

      that.axios.post('/staff/getAll')
        .then(function (response) {
          that.waterToPurchase.staffList = response.data.data.staffList
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    purchase () {
      let that = this
      console.log('waterID: ' + that.waterToPurchase.waterID +
        ', quantityID: ' + that.waterToPurchase.quantity +
        ', staffID: ' + that.waterToPurchase.staffID +
        ', supplierID: ' + that.waterToPurchase.supplierID)
      that.axios.post('/purchase/add', {
        supplierID: that.waterToPurchase.supplierID,
        waterID: that.waterToPurchase.waterID,
        staffID: that.waterToPurchase.staffID,
        quantity: that.waterToPurchase.quantity
      })
        .then(function (response) {
          that.getAllList()
          console.log('进货成功')
        })
        .catch(function (error) {
          alert('您输入的数据有错误，请重新输入！')
          console.log(error)
        })
    },
    clickAddSupplier (waterID) {
      let that = this
      that.supplierToAdd.waterID = waterID
      that.supplierToAdd.supplierID = null
      that.axios.post('/supplier/getNotSupplier', {
        waterID: waterID
      })
        .then(function (response) {
          that.supplierToAdd.supplierList = response.data.data.supplierList
          console.log(that.supplierToAdd.supplierList)
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    addSupplier () {
      let that = this
      console.log(this.supplierToAdd.waterID + '------' + this.supplierToAdd.supplierID)
      that.axios.post('/supplierWater/add', {
        supplierID: this.supplierToAdd.supplierID,
        waterID: this.supplierToAdd.waterID
      })
        .then(function (response) {
          that.getAllList()
        })
        .catch(function (error) {
          alert('您输入的数据有错误，请重新输入！')
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
