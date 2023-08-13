<template>
  <PageFooter msg="This is footer"/>
</template>

<script>
import PageFooter from './components/LandingFooter.vue'

export default {
  name: 'App',
  components: {
    PageFooter
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
