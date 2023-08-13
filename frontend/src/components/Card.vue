<script setup></script>

<template>
  <div class="card"></div>
</template>

<style scoped>
.card {
  box-sizing: border-box;
  width: 30%;
  min-width: 225px;
  max-width: 400px;
  height: 400px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-start;
  padding: 40px;
  background-color: #e39505;
  align-content: flex-start;
  flex-wrap: wrap;
  border-radius: 20px;
}

@media screen and (max-width: 809px) {
  .card {
    width: 100%;
  }
}
</style>
