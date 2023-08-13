<script setup>
import { RouterLink } from 'vue-router'
import Card from '@/components/Card.vue'
import Footer from '../components/Footer.vue'
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
            <span class="custom-link"> Characters </span></RouterLink
          >
          <RouterLink :to="{ name: 'shop' }"> <span class="custom-link"> Shop </span></RouterLink>
        </nav>
      </div>
    </div>
  </div>
  <div class="welcome">
    <div class="welcome-aboard">
      <h1>Welcome aboard!</h1>
      <div class="welcome-aboard-paragraphs">
        <p>
          Step into the world of Futurama, where the future is wilder than you could have ever
          imagined! Join Fry, Leela, and Bender on their absurd adventures around the universe.
        </p>
        <br />
        <p>
          This fan site celebrates the hilarity, complexity, and genius of Futurama. Discover
          episode guides, character profiles, and exclusive content. It’s everything you need to
          fuel your love for this animated classic.
        </p>
        <br />
        <p>
          So buckle up, because it’s time to blast off into the bizarre and hilarious universe of
          Futurama! You won’t believe what lies ahead on this totally tubular trip through the year
          3000 and beyond.
        </p>
      </div>
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
    <Card />
    <Card />
    <Card />
  </div>
  <div class="questions">
    <h1>Frequently asked questions</h1>
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
  width: 100%;
  height: auto;
  max-width: fit-content;
  font-weight: 400;
  font-style: normal;
  font-family: 'Fascinate Inline', sans-serif;
  color: #000000;
  letter-spacing: 0em;
  text-transform: uppercase;
  line-height: 1;
  text-align: center;
}
.wrapper nav {
  width: 100%;
  height: min-content;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  z-index: 1;
  align-content: center;
  flex-wrap: nowrap;
  gap: 20px;
}
.wrapper nav span {
  width: auto;
  height: auto;
  white-space: pre;
  font-weight: 700;
  font-style: normal;
  font-family: 'Archivo', 'Archivo Placeholder', sans-serif;
  color: #000000;
  font-size: 16px;
  letter-spacing: 0em;
  line-height: 1.2;
}
.welcome {
  box-sizing: border-box;
  width: 100vw;
  height: min-content;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  background-color: #faa307;
  align-content: center;
  flex-wrap: nowrap;
  gap: 0;
}

.welcome-aboard {
  width: 100%;
  height: min-content;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  z-index: 1;
  align-content: flex-start;
  flex-wrap: nowrap;
  gap: 40px;
}

.welcome-aboard h1 {
  width: 100%;
  height: auto;
  white-space: pre-wrap;
  word-wrap: break-word;
  word-break: break-word;
  overflow: visible;
  font-weight: 400;
  font-style: normal;
  font-family: 'Fascinate Inline', sans-serif;
  color: #03071e;
  font-size: 48px;
  letter-spacing: 0em;
  line-height: 1.2;
  text-align: left;
}

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
.crew {
  box-sizing: border-box;
  width: 100%;
  height: min-content;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  padding: 100px;
  background-color: #faa307;
  align-content: center;
  flex-wrap: nowrap;
  gap: 60px;
}
.crew h1 {
  width: 100%;
  height: auto;
  white-space: pre-wrap;
  word-wrap: break-word;
  word-break: break-word;
  overflow: visible;
  font-weight: 400;
  font-style: normal;
  font-family: 'Fascinate Inline', sans-serif;
  color: #6a040f;
  font-size: 48px;
  letter-spacing: 0em;
  line-height: 1.2;
  text-align: left;
  padding-bottom: 30px;
}
.images-greed {
  width: 100%;
  height: min-content;
  display: grid;
  mix-blend-mode: luminosity;
  grid-template-columns: repeat(2, 1fr);
  justify-content: center;
  grid-auto-rows: min-content;
  grid-template-rows: repeat(2, min-content);
  gap: 20px;
}
.images-greed img {
  width: auto;
  height: 500px;
  display: block;
  aspect-ratio: 0.98 / 1;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  border-radius: 40px;
}
.comments {
  box-sizing: border-box;
  width: 100%;
  height: min-content;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  padding: 100px;
  background-color: #faa307;
  align-content: center;
  flex-wrap: nowrap;
  gap: 20px;
}
.questions {
  box-sizing: border-box;
  width: 100%;
  height: min-content;
  display: flex;
  padding: 100px;
  background-color: #faa307;
  align-content: center;
  flex-wrap: nowrap;
  gap: 60px;
}
.questions h1 {
  width: 100%;
  height: auto;
  white-space: pre-wrap;
  word-wrap: break-word;
  word-break: break-word;
  max-width: 1000px;
  overflow: visible;
  font-weight: 400;
  font-style: normal;
  font-family: 'Fascinate Inline', sans-serif;
  color: #03071e;
  font-size: 48px;
  letter-spacing: 0em;
  line-height: 1.2;
  text-align: left;
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

  .welcome-aboard h1 {
    padding: 20px 0 20px 0;
  }

  .welcome {
    padding: 10px;
  }
}
</style>
