import Vue from 'vue'
import Router from 'vue-router'
import login from '@/pages/login'
import custom from '@/pages/custom'
import order from '@/components/order'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: login
    }, {
      path: '/',
      name: 'index',
      redirect: '/custom/order',
      meta: {
        requireAuth: true
      }
    }, {
      path: '/custom',
      name: 'custom',
      component: custom,
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: 'order',
          name: 'order',
          component: order
        }
      ]
    }
  ]
})
