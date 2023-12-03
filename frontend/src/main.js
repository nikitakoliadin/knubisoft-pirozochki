import './assets/main.css'
import PrimeVue from 'primevue/config'
import 'primevue/resources/primevue.min.css' // Import PrimeVue CSS
import 'primeicons/primeicons.css'
import 'primeflex/primeflex.css'
// theme
import 'primevue/resources/themes/lara-light-green/theme.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(PrimeVue)

app.mount('#app')
