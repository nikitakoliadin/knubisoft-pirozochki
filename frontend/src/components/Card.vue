<script setup></script>

<template>
  <div v-for="comment in comments" :key="comment.id" class="card">
    <img :src="comment.image" alt="" />
    <h3>{{ comment.comment }}}</h3>
    <p>{{ comment.name }}</p>
  </div>
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
.card img {
  width: 50px;
  height: 50px;
  display: block;
  overflow: hidden;
  aspect-ratio: 1 / 1;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  border-radius: 100px;
}
.card h3 {
  width: 100%;
  flex: 1;
  height: 1px;
  white-space: pre-wrap;
  word-wrap: break-word;
  word-break: break-word;
  overflow: visible;
  font-weight: 700;
  font-style: normal;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #370617;
  font-size: 20px;
  letter-spacing: -0.025em;
  line-height: 1.5;
  text-align: left;
  padding-top: 50px;
}

.card p {
  width: auto;
  height: auto;
  white-space: pre;
  overflow: visible;
  font-weight: 400;
  font-style: normal;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #370617;
  font-size: 14px;
  letter-spacing: 0em;
  line-height: 1.5;
  text-align: center;
}

@media screen and (max-width: 809px) {
  .card {
    width: 100%;
  }
}
</style>
<script>
export default {
  data() {
    return {
      comments: [
        {
          id: 1,
          name: 'Phillip J. Fly',
          comment: 'Futurama is the space-faring comedy I didn’t know I needed in my life!',
          image: '/src/assets/img.png'
        },
        {
          id: 2,
          name: 'Turanga Leela',
          comment: 'I laugh, I cry, I kick alien butt—Futurama has it all!',
          image: '/src/assets/logo.svg'
        },
        {
          id: 3,
          name: 'Phillip J. Fly',
          comment: 'Futurama is the space-faring comedy I didn’t know I needed in my life!',
          image: '/src/assets/img.png'
        },
        {
          id: 4,
          name: 'Turanga Leela',
          comment: 'I laugh, I cry, I kick alien butt—Futurama has it all!',
          image: '/src/assets/logo.svg'
        }
      ]
    }
  }
}
</script>
