import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import Login from '@/components/Login'
import Menu from '@/components/Menu'
import User from '@/components/User'
import Role from '@/components/Role'
import Test from '@/components/Test'
import Log from '@/components/Log'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: {
        name: 'login'
      }
    },
    {
      path: '/index',
      name: 'index',
      component: Index
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/permission',
      name: 'permission',
      component: Menu
    },
    {
      path: '/user',
      name: 'user',
      component: User
    },
    {
      path: '/role',
      name: 'role',
      component: Role
    },
    {
      path: '/test',
      name: 'test',
      component: Test
    },
    {
      path: '/log',
      name: 'log',
      component: Log
    }
  ],
  mode: 'history'
})
