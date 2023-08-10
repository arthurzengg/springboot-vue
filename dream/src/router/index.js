import Vue from 'vue'
import VueRouter from 'vue-router'
import PaiHangView from '../views/PaiHangView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'PaiHang',
    component: PaiHangView
  },
  {
    path: '/ZuiXin',
    name: 'ZuiXin',
    // route level code-splitting
    // this generates a separate chunk (ZuiXin.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "ZuiXin" */ '../views/ZuiXinView.vue')
  },
  {
    path: '/SuiJi',
    name: 'SuiJi',
    component: () => import('../views/SuiJiView.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
