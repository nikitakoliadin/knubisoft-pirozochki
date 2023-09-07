<script setup>
import { ref, onMounted } from 'vue'
import WelcomeTextApi from '../api/WelcomeTextApi'

const welcomeTextApi = new WelcomeTextApi()

const texts = ref(null)
onMounted(async () => {
  try {
    const response = await welcomeTextApi.getTexts()
    texts.value = response.data
  } catch (error) {
    console.error(error)
  }
})
</script>

<template>
  <div v-for="paragraph in texts" class="welcome-aboard-paragraphs">
    <p>
      {{ paragraph.text }}
    </p>
  </div>
</template>

<style scoped>
.welcome-aboard-paragraphs {
  display: flex;
  max-width: 600px;
  gap: 40px;
}

.welcome-aboard-paragraphs p {
  font-weight: 400;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #03071e;
  font-size: 20px;
  line-height: 1.5;
}
</style>
