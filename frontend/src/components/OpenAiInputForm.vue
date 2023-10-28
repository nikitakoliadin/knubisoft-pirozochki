<template>
  <div class="input-form">
    <h3>OpenAi Prompts</h3>
    <textarea v-model="prompt" placeholder="Enter your prompts"></textarea>
    <button @click="submitPrompt">Send</button>
  </div>
</template>
<script>
import OpenAiApi from '../api/OpenAi'

export default {
  data() {
    return {
      prompt: '',
      api: new OpenAiApi()
    };
  },
  methods: {
    async submitPrompt() {
      try {
        const result = await this.api.sendPrompt(this.prompt);
        this.$emit('updateResponse', result.data);
      } catch (error) {
        console.error('error', error);
      }
    }
  }
}
</script>

<style scoped>
.input-form {
  display: flex;
  flex-direction: column;
  align-items: stretch;
  margin-bottom: 30px;
  font-family: 'Roboto', sans-serif;
}

.input-form textarea {
  width: 100%;
  min-height: 120px;
  padding: 15px;
  margin-bottom: 15px;
  border: 1px solid #e1e1e1;
  border-radius: 8px;
  font-size: 16px;
  transition: border-color 0.2s ease;
}

.input-form textarea:focus {
  border-color: #007BFF;
  outline: none;
}

.input-form button {
  align-self: center;
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  font-size: 16px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.2s ease;
}

.input-form button:hover {
  background-color: #0056b3;
}
</style>
