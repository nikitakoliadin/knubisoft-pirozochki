<script setup>
import { ref, onMounted } from 'vue'
import FaqApi from '../api/FaqApi'

const faqApi = new FaqApi()

const faqs = ref(null)
onMounted(async () => {
  try {
    const response = await faqApi.getFaq()
    faqs.value = response.data
  } catch (error) {
    console.log(error)
  }
})
</script>

<template>
  <div v-for="faq in faqs" class="question-answer">
    <h1>{{ faq.question }}</h1>
    <p>{{ faq.answer }}</p>
  </div>
</template>

<style scoped>
.question-answer {
  flex: 1;
  width: 1px;
  height: min-content;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  max-width: 100%;
  overflow: visible;
  align-content: flex-start;
  flex-wrap: nowrap;
  gap: 10px;
}

.question-answer h1 {
  width: 100%;
  height: auto;
  white-space: pre-wrap;
  word-wrap: break-word;
  word-break: break-word;
  overflow: visible;
  font-weight: 700;
  font-style: normal;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #03071e;
  font-size: 20px;
  letter-spacing: -0.025em;
  line-height: 1.5;
  text-align: left;
}

.question-answer p {
  width: 100%;
  height: auto;
  white-space: pre-wrap;
  word-wrap: break-word;
  word-break: break-word;
  max-width: 400px;
  overflow: visible;
  font-weight: 400;
  font-style: normal;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #370617;
  font-size: 16px;
  line-height: 1.5;
  text-align: left;
}

@media screen and (max-width: 809px) {
  .question-answer {
    flex: unset;
    width: unset;
  }
}
</style>
