<script setup>
import {ref, onMounted} from 'vue'
import CardsService from '@/services/CardsService'

const cards = ref(null)
onMounted(() => {
  CardsService.getCards()
      .then((response) => {
        cards.value = response.data
        console.log(cards);
      })
      .catch((error) => {
        console.log(error)
      })
})
</script>

<template>
  <div v-for="card in cards" :key="card.id" class="card">
    <img :src="card.imagePath" alt="" />
    <h3>{{ card.comment }}}</h3>
    <p>{{ card.name }}</p>
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
</script>
