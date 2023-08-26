<script setup>
import { ref, onMounted } from 'vue'
import AboutService from "@/services/AboutService";
const users = ref([])

onMounted(() => {
  AboutService.getAbout()
      .then((response) => {
        users.value = response.data
      })
      .catch((error) => {
        console.log('Error loading users:', error)
      })
})

const getUserImage = (user) => {
  if (user.email === 'v.kostenko@knubisoft.com') {
    return `/src/assets/vadym.jpeg`;
  } else if (user.email === 'v.kolesnyk@knubisoft.com') {
    return `/src/assets/vlad.jpeg`;
  } else if (user.email === 'n.shumsky@knubisoft.com') {
    return `/src/assets/nikita.jpeg`;
  }
  else if (user.email === 'n.koliadin@knubisoft.com') {
    return `/src/assets/mentor.png`;
  }
  else {
    return `/src/assets/bender.png`;
  }
}
</script>


<template>
  <div class="top-toolbar">
    <div class="user-list">
      <div v-for="user in users" :key="user.id" class="user-card">
        <div class="user-developers-image">
          <img :src="getUserImage(user)" alt="User Photo">
        </div>
        <div class="user-info">
          <p><strong>Name:</strong> {{ user.name }}</p>
          <p><strong>Surname:</strong> {{ user.surname }}</p>
          <p><strong>Date of Birth:</strong> {{ user.dateOfBirth }}</p>
          <p><strong>Email:</strong> {{ user.email }}</p>
          <p><strong>Phone Number:</strong> {{ user.phoneNumber }}</p>
        </div>
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

.user-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
  background-color: #faa307;
}

.user-card {
  text-align: center;
  margin: 20px;
}

.user-developers-image img {
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

.user-info p {
  font-size: 18px;
  margin: 5px 0;
}

.go-back {
  margin-top: auto;
  text-align: center;
}

.go-back-link {
  background-color: #007bff;
  color: #fff;
}

.go-back-link:hover {
  background-color: #0056b3;
}
</style>
