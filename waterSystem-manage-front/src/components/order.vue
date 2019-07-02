<template>
  <div>
    <div class="col-lg-9">
      <div class="card">
        <div class="card-title">
          <label>选择订单类型</label>
        </div>
        <div class="card-body">
          <div class="form-inline">
            <div class="form-group">
              <button class="btn btn-primary" @click="changeStatus(1)">待处理</button>
              <button class="btn btn-primary" @click="changeStatus(2)">已完成</button>
              <button class="btn btn-primary" @click="changeStatus(0)">已取消</button>
            </div>
          </div>
        </div>
      </div>

      <div class="card" v-show="cardDisplay.handling">
        <div class="card-title">
          待处理订单
        </div>
        <div class="card-body">
          <div>
            <table class="table">
              <thead>
              <tr>
                <th>订单号</th>
                <th>客户姓名</th>
                <th>矿泉水名称</th>
                <th>数量</th>
                <th>下单时间</th>
                <th>订单状态</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="item in orderDetailList" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.customName }}</td>
                <td>{{ item.waterName}}</td>
                <td>{{ item.number }}</td>
                <td>{{ item.time }}</td>
                <td>{{ stateNameDictionary[item.state] }}</td>
                <td>
                  <a data-toggle="modal" data-target="#modelId"
                     @click="clickAcceptOrder(item.id)">
                    接单送货
                  </a>
                  <a href="#" @click="deleteOrder(item.id)">取消订单</a>

                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>

      <div class="card" v-show="cardDisplay.finished">
        <div class="card-title">
          已完成订单
        </div>
        <div class="card-body">
          <div>
            <table class="table">
              <thead>
              <tr>
                <th>订单号</th>
                <th>客户姓名</th>
                <th>矿泉水名称</th>
                <th>数量</th>
                <th>下单时间</th>
                <th>订单状态</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="item in orderDetailList" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.customName }}</td>
                <td>{{ item.waterName}}</td>
                <td>{{ item.number }}</td>
                <td>{{ item.time }}</td>
                <td>{{ stateNameDictionary[item.state] }}</td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>

      <div class="card" v-show="cardDisplay.cancelled">
        <div class="card-title">
          已取消订单
        </div>
        <div class="card-body">
          <div>
            <table class="table">
              <thead>
              <tr>
                <th>订单号</th>
                <th>客户姓名</th>
                <th>矿泉水名称</th>
                <th>数量</th>
                <th>下单时间</th>
                <th>订单状态</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="item in orderDetailList" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.customName }}</td>
                <td>{{ item.waterName}}</td>
                <td>{{ item.number }}</td>
                <td>{{ item.time }}</td>
                <td>{{ stateNameDictionary[item.state] }}</td>
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
            <h5 class="modal-title">接单送货</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>选择员工</label>
              <select class="form-control" v-model="selectStaffID">
                <option v-for="staff in staffList" :key="staff.id" :value="staff.id">
                  {{ staff.id }}--{{ staff.name }}
                </option>
              </select>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary" data-dismiss="modal"
                    @click="addDelivery(currentID,selectStaffID)">确定
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'order',
  data: function () {
    return {
      selectState: 1,
      cardDisplay: {
        handling: true,
        finished: false,
        cancelled: false
      },
      staffList: null,
      currentID: null,
      selectStaffID: null,
      orderDetailList: null,
      stateNameDictionary: [
        '已取消',
        '待处理',
        '已完成'
      ]
    }
  },
  methods: {
    getAllList () {
      let that = this
      console.log(that.selectState)
      that.axios.post('/orderDetail/getAll', {
        state: that.selectState
      })
        .then(function (response) {
          that.orderDetailList = response.data.data.orderDetailList
          console.log(response.data.data)
          console.log(that.orderDetailList)
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    changeStatus (tag) {
      let that = this
      that.selectState = tag
      switch (tag) {
        case 1:
          that.cardDisplay.handling = true
          that.cardDisplay.finished = false
          that.cardDisplay.cancelled = false
          break
        case 2:
          that.cardDisplay.handling = false
          that.cardDisplay.finished = true
          that.cardDisplay.cancelled = false
          break
        case 0:
          that.cardDisplay.handling = false
          that.cardDisplay.finished = false
          that.cardDisplay.cancelled = true
          break
        default:
          that.cardDisplay.handling = false
          that.cardDisplay.finished = false
          that.cardDisplay.cancelled = false
          that.selectState = -1
          console.log('ChangeStatus Error')
      }
      console.log('Change State to ' + tag)
      if (that.selectState !== -1) {
        that.getAllList()
      }
    },
    clickAcceptOrder (currentID) {
      let that = this
      that.currentID = currentID
      that.axios.post('/staff/getAll')
        .then(function (response) {
          that.staffList = response.data.data.staffList
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    deleteOrder (currentID) {
      let that = this
      that.axios.post('/orderDetail/delete', {
        orderDetailID: currentID
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            console.log('取消订单成功')
            alert('取消订单成功')
            that.getAllList()
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    addDelivery (currentID, staffID) {
      let that = this
      that.axios.post('orderDetail/deliver', {
        orderDetailID: currentID,
        staffID: staffID
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            console.log('送货成功')
            alert('送货成功')
          }
          that.getAllList()
        })
        .catch(function (error) {
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

</style>
