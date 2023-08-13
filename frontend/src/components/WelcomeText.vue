<script setup></script>

<template>
  <div v-for="paragraph in paragraphs" class="welcome-aboard-paragraphs">
    <p>
      {{ paragraph.text }}
    </p>
  </div>
</template>

<style scoped>
.welcome-aboard-paragraphs {
  width: 100%;
  height: min-content;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  max-width: 600px;
  padding: 0px;
  align-content: center;
  flex-wrap: nowrap;
  gap: 40px;
}

.welcome-aboard-paragraphs p {
  width: 100%;
  height: auto;
  white-space: pre-wrap;
  word-wrap: break-word;
  word-break: break-word;
  overflow: visible;
  font-weight: 400;
  font-style: normal;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #03071e;
  font-size: 20px;
  letter-spacing: 0em;
  line-height: 1.5;
  text-align: left;
}
</style>

<script>
export default {
  data() {
    return {
      paragraphs: [
        {
          id: 1,
          text:
            'Step into the world of Futurama, where the future is wilder than you could have ever' +
            'imagined! Join Fry, Leela, and Bender on their absurd adventures around the universe.'
        },
        {
          id: 2,
          text:
            'This fan site celebrates the hilarity, complexity, and genius of Futurama. Discover' +
            'episode guides, character profiles, and exclusive content. It’s everything you need to' +
            'fuel your love for this animated classic.'
        },
        {
          id: 3,
          text:
            'So buckle up, because it’s time to blast off into the bizarre and hilarious universe of' +
            'Futurama! You won’t believe what lies ahead on this totally tubular trip through the year 3000 and beyond.'
        }
      ]
    }
  }
}
</script>
