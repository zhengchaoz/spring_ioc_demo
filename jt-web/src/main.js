import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import './assets/css/global.css'
import './assets/ali-icon/iconfont.css'

/* 导入富文本编辑器 */
import VueQuillEditor from 'vue-quill-editor'
/* 导入富文本编辑器对应的样式 */
import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme
/* 将富文本编辑器注册为全局可用的组件 */
Vue.use(VueQuillEditor)

/* 导入axios包 */
import axios from 'axios'
/* 设定axios的请求根目录 */
axios.defaults.baseURL = 'http://manage.jt.com:8091/'
/* 向vue对象中添加全局对象 以后发送ajax请求使用$http对象 */
Vue.prototype.$http = axios

Vue.config.productionTip = false
/* 过滤器 */
Vue.filter('priceFormat', price => (price / 100).toFixed(2));

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
