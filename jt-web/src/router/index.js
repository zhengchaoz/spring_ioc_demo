import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home'
import Welcome from '../components/Welcome'
import User from '../components/user/User'
import Item from "../components/items/Item";
import addItem from "../components/items/addItem";
import ItemCat from "../components/items/ItemCat";
import ItemCatParam from "../components/items/ItemCatParam";

Vue.use(VueRouter)
const routes = [
  {path: '/', redirect: '/login'},
  {path: '/login', component: Login},
  {
    path: '/home', component: Home, redirect: "/welcome", children: [
      {path: '/welcome', component: Welcome},
      {path: '/user', component: User},
      {path: '/item', component: Item},
      {path: '/item/addItem', component: addItem},
      {path: '/itemCat', component: ItemCat},
      {path: '/itemCatParam', component: ItemCatParam}
    ]
  }
]
// 路由对象
const router = new VueRouter({
  routes
})
// 导航守卫
// beforeEach：循环拦截用户所有请求
// 参数：to（要访问的请求路径） / from（从哪个请求路径跳转过来） / next（放行请求）
router.beforeEach((to, from, next) => {
  // 如果是去登录页面就直接放行，结束本方法
  if (to.path === '/login') return next();
  // 若果没有token就跳转登录页面，结束本方法
  let token = sessionStorage.getItem('token');
  if (!token) return next('/login');
  // 有token就放行
  next();
});

export default router
