// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.config.productionTip = false

Vue.use(VueAxios, axios)
axios.defaults.baseURL = 'http://47.101.53.141:6080'
axios.defaults.withCredentials = true

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  render: h => h(App),
  created () {
    let that = this
    that.axios.post('/admin/isLogin')
      .then(function (response) {
        if (response.data.code !== '0000') {
          localStorage.setItem('isLogin', 'no')
          console.log('未登录')
          that.$router.push({name: 'login'})
        }
      })
    router.beforeEach((to, from, next) => {
      let login = localStorage.getItem('isLogin')
      if (to.meta.requireAuth) {
        if (login === 'yes') {
          // console.log('已经登陆')
          next()
        } else {
          next({
            name: 'login',
            query: {redirect: to.fullPath}
          })
        }
      } else {
        next()
      }
    })
  }
})
