<script setup>
import { RouterLink } from 'vue-router'
import Card from '@/components/Card.vue'
import Footer from '../components/Footer.vue'
import WelcomeText from '@/components/WelcomeText.vue'
import QuestionsAnswers from '@/components/QuestionsAnswers.vue'
</script>

<template>
  <div class="top-toolbar">
    <div class="background-content">
      <h1>Futurama</h1>
      <div class="wrapper">
        <nav>
          <RouterLink :to="{ name: 'episodes' }">
            <span class="custom-link"> Episodes </span>
          </RouterLink>
          <RouterLink :to="{ name: 'characters' }">
            <span class="custom-link"> Characters </span>
          </RouterLink>
          <RouterLink :to="{ name: 'shop' }">
            <span class="custom-link"> Shop </span>
          </RouterLink>
          <RouterLink :to="{ name: 'codemirror' }">
            <span class="custom-link"> Codemirror </span>
          </RouterLink>
        </nav>
      </div>
    </div>
  </div>
  <div class="welcome">
    <div class="welcome-aboard">
      <h1>Welcome aboard!</h1>
      <WelcomeText />
    </div>
  </div>
  <div class="crew">
    <h1>Planet Express Crew</h1>
    <div class="images-greed">
      <img src="@/assets/bender.png" alt="" />
      <img src="@/assets/bender.png" alt="" />
      <img src="@/assets/bender.png" alt="" />
      <img src="@/assets/bender.png" alt="" />
    </div>
  </div>
  <div class="comments">
    <Card />
  </div>
  <div class="questions">
    <h1>Frequently asked questions</h1>
    <div class="questions-row">
      <QuestionsAnswers />
    </div>
  </div>
  <footer>
    <Footer />
  </footer>
</template>

<style>
.top-toolbar {
  width: 100vw;
  height: 800px;
  display: flex;
  align-content: center;
  justify-content: center;
  align-items: center;
  background: #f48c06;
}

.top-toolbar h1 {
  font-weight: 400;
  font-family: 'Fascinate Inline', sans-serif;
  color: #000000;
  text-transform: uppercase;
  line-height: 1;
  text-align: center;
}

.wrapper nav {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
  padding-top: 30px;
}

.wrapper nav span {
  white-space: pre;
  font-weight: 700;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #000000;
  font-size: 16px;
  line-height: 1.2;
}

.welcome {
  box-sizing: border-box;
  width: 100vw;
  display: flex;
  align-items: center;
  background-color: #faa307;
}

.welcome-aboard {
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 40px;
}

.welcome-aboard h1 {
  font-weight: 400;
  font-family: 'Fascinate Inline', sans-serif;
  color: #03071e;
  font-size: 48px;
  line-height: 1.2;
}

.crew {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  padding: 100px;
  background-color: #faa307;
}
.crew h1 {
  font-weight: 400;
  font-family: 'Fascinate Inline', sans-serif;
  color: #6a040f;
  font-size: 48px;
  line-height: 1.2;
  padding-bottom: 30px;
}
.images-greed {
  width: 100%;
  display: grid;
  mix-blend-mode: luminosity;
  grid-template-columns: repeat(2, min-content);
  justify-content: center;
  align-items: center;
  grid-template-rows: repeat(2, min-content);
  gap: 20px;
}
.images-greed img {
  width: auto;
  height: 500px;
  display: block;
  aspect-ratio: 0.98 / 1;
  border-radius: 40px;
}
.comments {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 100px;
  background-color: #faa307;
  align-content: center;
  flex-wrap: wrap;
  gap: 20px;
}
.questions {
  display: block;
  padding: 100px;
  background-color: #faa307;
}
.questions h1 {
  font-weight: 400;
  font-family: 'Fascinate Inline', sans-serif;
  color: #03071e;
  font-size: 48px;
  line-height: 1.2;
}
.questions-row {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  gap: 100px;
  padding-top: 100px;
}

/* Desktop styles */
@media screen and (min-width: 1200px) {
  /* Your desktop styles here */
  .top-toolbar h1 {
    font-size: 180px;
  }

  .welcome-aboard h1 {
    padding-bottom: 40px;
  }

  .welcome {
    padding: 100px;
  }
}

/* Tablet styles */
@media screen and (max-width: 1199px) and (min-width: 810px) {
  /* Your tablet styles here */
  .top-toolbar h1 {
    font-size: 140px;
  }

  .welcome-aboard h1 {
    padding: 20px 0 50px 0;
  }

  .welcome {
    padding: 50px;
  }

  .crew {
    padding: 50px;
    gap: 20px;
  }

  .crew h1 {
    font-size: 40px;
  }

  .images-greed {
    padding-bottom: 40px;
  }

  .images-greed img {
    height: 352px;
  }

  .comments {
    padding: 50px;
    justify-content: space-around;
  }

  .questions {
    padding: 50px;
  }
}

/* Phone styles */
@media screen and (max-width: 809px) {
  /* Your phone styles here */
  .top-toolbar {
    height: 500px;
  }

  .top-toolbar h1 {
    font-size: 50px;
  }
  .wrapper nav {
    flex-direction: column;
  }

  .welcome-aboard h1 {
    padding: 20px 0 20px 0;
  }

  .welcome {
    padding: 15px;
  }

  .crew {
    padding: 40px 15px 40px 15px;
    gap: 0;
  }

  .crew h1 {
    font-size: 28px;
  }

  .images-greed {
    padding-bottom: 20px;
  }

  .images-greed img {
    height: 168px;
  }

  .comments {
    padding: 15px;
    justify-content: space-around;
  }

  .questions {
    padding: 15px;
  }

  .questions h1 {
    font-size: 30px;
  }
}
</style>
