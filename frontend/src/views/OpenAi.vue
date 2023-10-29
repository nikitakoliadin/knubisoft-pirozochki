<template>
  <div id="app">
    <OpenAiInputForm @updateResponse="updateResponse" />
    <OpenAiOutputForm :response="response" />
  </div>
</template>


<script>
import OpenAiInputForm from '@/components/OpenAiInputForm.vue';
import OpenAiOutputForm from '@/components/OpenAiOutputForm.vue';

export default {
  components: {
    OpenAiInputForm,
    OpenAiOutputForm
  },
  data() {
    return {
      response: null
    };
  },
  methods: {
    updateResponse(newResponse) {
      this.response = newResponse;
    }
  }
}
</script>

<style scoped>
#app {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  min-height: 100vh;
  padding-top: 5%;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
}
</style>
