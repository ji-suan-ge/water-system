import Vue from 'vue'
import Router from 'vue-router'
import manage from '@/pages/manage'
import login from '@/pages/login'
import custom from '@/components/custom'
import staff from '@/components/staff'
import water from '@/components/water'
import order from '@/components/order'
import profit from '@/components/profit'
import delivery from '@/components/delivery'
import sales from '@/components/sales'
import backup from '@/components/backup'

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
      redirect: 'manage',
      meta: {
        requireAuth: true
      }
    }, {
      path: '/manage',
      name: 'manage',
      component: manage,
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: 'custom',
          name: 'custom',
          component: custom,
          meta: {
            requireAuth: true
          }
        }, {
          path: 'staff',
          name: 'staff',
          component: staff,
          meta: {
            requireAuth: true
          }
        }, {
          path: 'water',
          name: 'water',
          component: water,
          meta: {
            requireAuth: true
          }
        }, {
          path: 'order',
          name: 'order',
          component: order,
          meta: {
            requireAuth: true
          }
        }, {
          path: 'profit',
          name: 'profit',
          component: profit,
          meta: {
            requireAuth: true
          }
        }, {
          path: 'delivery',
          name: 'delivery',
          component: delivery,
          meta: {
            requireAuth: true
          }
        }, {
          path: 'sales',
          name: 'sales',
          component: sales,
          meta: {
            requireAuth: true
          }
        }, {
          path: 'backup',
          name: 'backup',
          component: backup,
          meta: {
            requireAuth: true
          }
        }
      ]
    }
  ]
})
