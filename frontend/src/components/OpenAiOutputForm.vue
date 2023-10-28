<template>
  <div class="output-form">
    <div v-if="response">
      <pre>{{ response }}</pre>
    </div>
    <div v-else>
      <p>No response yet...</p>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    response: {
      type: String
    }
  }
}
</script>

<style>
.output-form {
  padding: 20px;
  background-color: #f8f8f8;
  border-radius: 8px;
  width: 100%;
  max-width: 600px;
  font-family: 'Roboto', sans-serif;
}

.output-form h3 {
  margin-top: 0;
  margin-bottom: 25px;
  color: #333;
  font-weight: 700;
}

.output-form pre {
  background-color: #f7f7f7;
  padding: 15px;
  border-radius: 8px;
  border: 1px solid #e1e1e1;
  font-size: 16px;
  white-space: pre-wrap;
}

.output-form p {
  color: #888;
  font-style: italic;
}
</style>