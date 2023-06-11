import Vue from 'vue'
import App from './App.vue'
import router from './router'
import request from './utils/http'
import { createPinia, PiniaVuePlugin  } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import { useUserStore } from './stores/user'

Vue.use(PiniaVuePlugin)
const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)

Vue.config.productionTip = false

//axios請求攔截器
request.interceptors.request.use(config => {
  //1.從pinia獲得token,得到實例對象
  const userStore =  useUserStore()
  //2.按後端要求拼接token
  const token = userStore.userInfo.data
  if(token){
    config.headers.token = token
  }
  return config
})

new Vue({
  router,
  pinia,
  render: h => h(App)
}).$mount('#app')
