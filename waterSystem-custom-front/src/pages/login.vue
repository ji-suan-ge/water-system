<template>
  <div>
    <div class="col-lg-5" style="margin: 0 auto">
      <div class="card">
        <div class="card-title" style="text-align: center">
          欢迎登录怡净矿泉水下单系统
        </div>
        <div class="card-body">
          <div class="form-inline">
            <div class="form-group" style="margin: 0 auto">
              <label style="font-size: 16px;">账号</label>
              <input type="text" class="form-control" v-model="account">
            </div>
          </div>
          <br/>
          <div class="form-inline">
            <div class="form-group" style="margin: 0 auto">
              <label style="font-size: 16px;">密码</label>
              <input type="password" class="form-control" v-model="password">
            </div>
          </div>
          <br/>
          <div class="form-inline">
            <div class="form-group" style="margin: 0 auto">
              <button class="btn btn-primary" @click="login">登录</button>
            </div>
          </div>
          <br/>
          <div class="form-inline">
            <div class="form-group" style="margin: 0 auto">
              <label style="font-size: 16px;">{{tips}}</label>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'login',
  data: function () {
    return {
      account: null,
      password: null,
      tips: null
    }
  },
  methods: {
    login () {
      let that = this
      console.log(that.account)
      console.log(that.password)
      that.axios.post('/custom/login', {
        customID: that.account,
        password: that.password
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            alert('登录成功')
            console.log('登录成功')
            that.tips = '登录成功'
            localStorage.setItem('customID', that.account)
            localStorage.setItem('isLogin', 'yes')
            that.$router.push({name: 'index'})
          } else {
            alert('账户名或密码错误')
            console.log('账户或密码错误')
            that.password = ''
            that.tips = '账户或密码错误'
          }
        })
        .catch(function (error) {
          alert('登录失败')
          that.tips = '登录失败'
          console.log('请求失败')
          console.log(error)
        })
    }
  },
  created () {
    let that = this
    that.axios.post('/custom/isLogin')
      .then(function (response) {
        if (response.data.code === '0000') {
          that.$router.push({name: 'index'})
        }
      })
  }
}
</script>

<style scoped>

</style>
