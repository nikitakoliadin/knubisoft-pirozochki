<script setup></script>

<template>
  <div v-for="question_answer in questions_answers" class="question-answer">
    <h1>{{ question_answer.question }}</h1>
    <p>{{ question_answer.answer }}</p>
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
<script>
export default {
  data() {
    return {
      questions_answers: [
        {
          id: 1,
          question: 'What year does Futurama take place?',
          answer:
            'Futurama primarily takes place in the year 3000, but expect lots of time-travel shenanigans!'
        },
        {
          id: 2,
          question: 'Who created Futurama?',
          answer: 'Futurama was created by Matt Groening, the mastermind behind The Simpsons.'
        },
        {
          id: 3,
          question: 'Is the Hypnotoad real?',
          answer:
            'No, the Hypnotoad is a fictional character from the show—but do not underestimate its power!'
        }
      ]
    }
  }
}
</script>
