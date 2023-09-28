<script setup>

</script>
<script>
export default {
  data() {
    return {
      // Initialize data properties as needed
    }
  },
  computed: {
    currentMode() {
      // Calculate the current mode based on window.innerWidth
      const screenWidth = window.innerWidth
      if (screenWidth >= 1200) {
        return 'desktop'
      } else if (screenWidth >= 810) {
        return 'tablet'
      } else {
        return 'phone'
      }
    },
    isDesktop() {
      return this.currentMode === 'desktop'
    },
    isTablet() {
      return this.currentMode === 'tablet'
    },
    isPhone() {
      return this.currentMode === 'phone'
    }
  },
  created() {
    // Add a listener to window resize event
    window.addEventListener('resize', this.updateMode)
  },
  beforeDestroy() {
    // Clean up the listener when the component is destroyed
    window.removeEventListener('resize', this.updateMode)
  },
  methods: {
    updateMode() {
      // Call this method to update currentMode when needed
    }
  }
}
</script>

<template>
  <div class="wrapper">
    <router-view />
  </div>
</template>

<style>
#app {
  max-width: 1920px;
  padding: 0 0;
  margin: 0;
}

#app a {
  text-decoration: none;
}

body {
  place-items: unset;
}
/* Desktop styles */
@media screen and (min-width: 1200px) {
  /* Your desktop styles here */
}

/* Tablet styles */
@media screen and (max-width: 1199px) and (min-width: 810px) {
  /* Your tablet styles here */
}

/* Phone styles */
@media screen and (max-width: 809px) {
  /* Your phone styles here */
}
</style>
