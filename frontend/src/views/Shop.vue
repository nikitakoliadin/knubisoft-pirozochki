<script setup>
import { RouterLink } from 'vue-router'
</script>

<template>
  <div>
    <h1>Shop</h1>
    <RouterLink :to="{ name: 'home' }">Go back</RouterLink>
  </div>
</template>

<style scoped></style>
