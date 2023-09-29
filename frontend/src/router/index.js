import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import Episodes from '@/views/Episodes.vue'
import Characters from '@/views/Characters.vue'
import Shop from '@/views/Shop.vue'
import About from '@/views/About.vue'
import Codemirror from '@/views/Codemirror.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/episodes',
      name: 'episodes',
      component: Episodes
    },
    {
      path: '/characters',
      name: 'characters',
      component: Characters
    },
    {
      path: '/shop',
      name: 'shop',
      component: Shop
    },
    {
      path: '/about',
      name: 'about',
      component: About
    },
    {
      path: '/codemirror',
      name: 'codemirror',
      component: Codemirror
    }
  ]
})

export default router
