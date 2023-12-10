import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import "element-plus/dist/index.css"
import * as ElementPlusIconsVue from "@element-plus/icons-vue";
import store from './store'
import router from './router'

import Cookies from 'js-cookie'

import 'normalize.css/normalize.css' // a modern alternative to CSS resets

import '@/styles/index.scss' // global css

import './icons' // icon
import './permission' // permission control
import './utils/error-log' // error log

import SvgIcon from '@/components/SvgIcon'// svg component

/**
 * If you don't want to use mock-server
 * you want to use MockJs for mock api
 * you can execute: mockXHR()
 *
 * Currently MockJs will be used in the production environment,
 * please remove it before going online ! ! !
 */
if (process.env.NODE_ENV === 'production') {
  const { mockXHR } = require('../mock')
  mockXHR()
}

const app = createApp(App)

app.config.productionTip = false

// register globally
app.component('SvgIcon', SvgIcon)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}
app.use(ElementPlus, {
  size: Cookies.get('size') || 'medium', // set element-ui default size
})
app.use(store)
app.use(router)
app.mount('#app')

export default app
