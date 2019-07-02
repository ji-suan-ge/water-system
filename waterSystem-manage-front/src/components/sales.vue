<template>
  <div>
    <div class="col-lg-12">
      <div class="card">
        <div class="card-title">
          查询年月
        </div>
        <div class="card-body">
          <div class="form-inline">
            <div class="form-group">
              <label style="font-size: 20px;">年份</label>
              <input type="text" class="form-control" v-model="year">
              <label style="font-size: 20px;">月份</label>
              <input type="text" class="form-control" v-model="month">
              <button class="btn btn-primary" @click="querySales(year,month)">查询销售</button>
            </div>
          </div>
        </div>
      </div>
      <div class="card">
        <div class="card-title">
          销售报表
        </div>
        <div class="card-body">
          <div>
            <table class="table">
              <thead>
              <tr>
                <th>年月</th>
                <th>客户姓名</th>
                <th>月度总订单数</th>
                <th>月度总用水量</th>
                <th>月度总销售额</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="item in monthlySalesList" :key="item.yearmonth + item.customName">
                <td>{{ item.yearmonth }}</td>
                <td>{{ item.customName }}</td>
                <td>{{ item.totalOrder}}</td>
                <td>{{ item.totalQuantity }}</td>
                <td>{{ item.totalSales }}</td>
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
  name: 'sales',
  data: function () {
    return {
      monthlySalesList: null,
      year: null,
      month: null
    }
  },
  methods: {
    querySales (_year, _month) {
      let that = this
      if (_year.length > 4 || _month > 12 || _month.length > 2) {
        alert('输入年月错误')
        if (_year.length > 4) {
          that.year = ''
        }
        if (_month > 12 || _month.length > 2) {
          that.month = ''
        }
        return
      }
      while (_year.length < 4) {
        _year = '0' + _year
      }
      while (_month.length < 2) {
        _month = '0' + _month
      }
      console.log('要查询的年月')
      console.log(_year)
      console.log(_month)
      that.axios.post('/monthlySales/getAll', {
        year: _year,
        month: _month
      })
        .then(function (response) {
          that.monthlySalesList = response.data.data.monthlySalesList
          console.log(that.monthlySalesList)
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },
  created () {
    this.querySales('0000', '00')
  }
}
</script>

<style scoped>

</style>
