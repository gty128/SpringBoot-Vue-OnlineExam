// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import echarts from 'echarts'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueCookies from 'vue-cookies'
import VideoPlayer from 'vue-video-player'
import Ant from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
Vue.use(ElementUI)
Vue.use(VueCookies)
Vue.use(Ant)
require('video.js/dist/video-js.css')
require('vue-video-player/src/custom-theme.css')

Vue.use(VideoPlayer)
Vue.config.productionTip = false
Vue.prototype.bus = new Vue()
Vue.prototype.$echarts = echarts
Vue.prototype.$axios = axios

new Vue({
  el: '#app',
  router,
  render: h => h(App),
  components: { App },
  template: '<App/>'
})
