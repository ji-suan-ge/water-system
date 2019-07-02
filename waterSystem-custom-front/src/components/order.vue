<template>
  <div>
    <div class="col-lg-9">
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
                <th>售价(元)</th>
                <th>库存</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="item in waterList" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.name }}</td>
                <td>{{ item.size / 1000 }}</td>
                <td>{{ item.price / 100 }}</td>
                <td>{{ item.quantity }}</td>
                <td>
                  <a data-toggle="modal" data-target="#buyModal"
                     @click="clickBuy(item.id, item.quantity)" v-if="item.quantity > 0">
                    购买
                  </a>
                  <span v-else>缺货</span>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <div class="modal fade" id="buyModal" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
         aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">订单</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="form-group" style="display: inline-block;">
              <label>购买数量</label>
              <input type="text" class="form-control" v-model="currentQuantity">
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary" data-dismiss="modal" @click="buy">下单</button>
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
      waterList: null,
      currentQuantity: null,
      buyWaterID: null,
      supplierID: null,
      addSupplierWaterID: null,
      remainingQuantity: null
    }
  },
  methods: {
    getAllList () {
      let that = this
      that.axios.post('http://47.101.53.141:6080/water/getAll')
        .then(function (response) {
          that.waterList = response.data.data.waterList
          console.log(that.waterList)
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    clickBuy (waterID, remainingQuantity) {
      let that = this
      that.buyWaterID = waterID
      that.currentQuantity = null
      that.remainingQuantity = remainingQuantity
      console.log(that.remainingQuantity)
    },
    buy () {
      let that = this
      if (that.currentQuantity == null) {
        return
      }
      if (that.remainingQuantity < that.currentQuantity) {
        alert('数量过大')
        return
      }
      that.axios.post('/custom/order', {
        customID: localStorage.getItem('customID'),
        waterID: that.buyWaterID,
        number: that.currentQuantity
      })
        .then(function (response) {
          that.getAllList()
          console.log('添加成功')
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },
  created: function () {
    this.getAllList()
  }
}
</script>

<style scoped>

</style>
