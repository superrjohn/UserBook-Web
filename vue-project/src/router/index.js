import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home'
import Login from '@/views/Login'
import User from '@/views/User'
import Book from '@/views/Book'
import Register from '@/views/Register'


Vue.use(VueRouter)

const routes = [
  { path: '/', component: Home },
  { path: '/home', component: Home },
  { path: '/login', component: Login },
  { path: '/books', name: 'books', component: Book },
  { path: '/register', component: Register },
  { path: '/user/:id?',name:'user' ,component: User }
]

const router = new VueRouter({
  routes
})

export default router
