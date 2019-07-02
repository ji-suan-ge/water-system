<template>
  <div>
    <div class="card">
      <div class="card-title">
        收支报表
      </div>
      <div class="card-body">
        <div>
          <table class="table">
            <thead>
            <tr>
              <th>年月</th>
              <th>月度总销售额</th>
              <th>月度总进货价</th>
              <th>月度总工资</th>
              <th>月度总利润</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="item in monthlyProfitList" :key="item.yearmonth">
              <td>{{ item.yearmonth }}</td>
              <td>{{ item.totalSales }}</td>
              <td>{{ item.totalPurchase}}</td>
              <td>{{ item.totalSalary }}</td>
              <td>{{ item.totalProfit }}</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'profit',
  data: function () {
    return {
      monthlyProfitList: null,
      year: null,
      month: null
    }
  },
  methods: {
    getAllList () {
      let that = this
      that.axios.post('/monthlyProfit/getAll')
        .then(function (response) {
          that.monthlyProfitList = response.data.data.monthlyProfitList
          console.log(response.data.data)
          console.log(that.monthlyProfitList)
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
