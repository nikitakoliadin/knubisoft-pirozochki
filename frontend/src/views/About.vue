<script setup>
import { RouterLink } from 'vue-router'
</script>


<template>
  <div class="top-toolbar">
    <div class="user-row">
      <div v-for="person in about" :key="person.id" class="about-person">
        <img :src="person.photo" alt="User Photo" class="user-photo">
        <h1>{{ person.name }}</h1>
        <p>Date of Birth: {{ person.date_of_birth }}</p>
        <p>Email: {{ person.email }}</p>
        <p>Phone Number: {{ person.phone_number }}</p>
      </div>
    </div>
  </div>
  <div class="go-back">
    <RouterLink :to="{ name: 'home' }" class="go-back-link">Go back</RouterLink>
  </div>
</template>

<style scoped>
.top-toolbar {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
  background-color: #e39505;
  height: 100%;
}

.user-row {
  display: unset;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  padding: 100px;
  background-color: #faa307;
}

.about-person {
  text-align: center;
}

.user-photo {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  object-fit: cover;
  border: 2px solid #333;
}

h1 {
  font-size: 24px;
  margin-top: 10px;
}

p {
  font-size: 18px;
  margin: 5px 0;
}

.go-back {
  margin-top: auto;
  text-align: center;
}

.go-back-link {
  /*text-decoration: none;*/
  /*background-color: #007bff;*/
  /*color: #fff;*/
  /*padding: 10px 20px;*/
  /*border-radius: 5px;*/
  /*font-size: 18px;*/
  /*transition: background-color 0.3s;*/
  /*cursor: pointer;*/
}

.go-back-link:hover {
  background-color: #0056b3;
}
</style>

<script>
export default {
  data() {
    return {
      about: [
        {
          id: 1,
          name: 'Vladyslav Kolesnyk',
          date_of_birth: '20 February',
          email: 'v.kolesnyk@knubisoft.com',
          phone_number: '+380635922372',
          photo: '/src/assets/vlad.jpeg'
        },
        {
          id: 2,
          name: 'Nikita Shumsky',
          date_of_birth: '9 January',
          email: 'n.shumsky@knubisoft.com',
          phone_number: '+380633036736',
          photo: '/src/assets/nikita.jpeg'
        },
        {
          id: 3,
          name: 'Vadym Kostenko',
          date_of_birth: '27 September',
          email: 'v.kostenko@knubisoft.com',
          phone_number: '+380663396268',
          photo: '/src/assets/vadym.jpeg'
        },
        {
          id: 4,
          name: 'Nikita Koliadin',
          date_of_birth: '11 January',
          email: 'n.koliadin@knubisoft.com',
          phone_number: '+380951114332',
          photo: '/src/assets/mentor.png'
        }
      ]
    }
  }
}
</script>
