<script setup lang="ts">
import {computed, ref} from 'vue'

import CodeMirror from 'vue-codemirror6'
import {java} from '@codemirror/lang-java'
import {RouterLink} from 'vue-router'
import {Extension} from '@codemirror/state'
import {codemirrorAutocompletionExtension, loading} from '@/shared/codemirrorAutocompletionExtension'
import ProgressSpinner from 'primevue/progressspinner'

async function getAiStream() {

  await fetch('http://127.0.0.1:8080/api/codemirror/stream', {
    method: 'POST',
    headers: {'Content-Type': 'text/event-stream'},
    body: initValue.value
      .substring(initValue.value.indexOf("@AI_START"), initValue.value.indexOf("@AI_END"))
      .replace("@AI_START", "").trim(),
  })
    .then(async (response) => {
      const reader = response.body.pipeThrough(new TextDecoderStream()).getReader();
      initValue.value += "\n\n";

      while (true) {
        const {value, done} = await reader.read();
        if (done) break;

        const splitChunks = value.toString().split('data:');

        for (let i = 0; i < splitChunks.length; i++) {
          const piece = splitChunks[i].trim();
          if (piece !== "[DONE]" && piece.length > 0) {
            initValue.value += JSON.parse(piece).choices[0].delta?.content || "";
          }
        }
      }
    })
    .catch((error) => {
      console.error(error);
    });
}

const extensions = computed(() => {
  const extensionList: Extension[] = []
  extensionList.push(codemirrorAutocompletionExtension)
  return extensionList
})

/** Demo code */
const initValue =
  ref(`OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        try {
            Thread.sleep(FIVE_SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture(bean.getProcessCpuLoad());`)
</script>

<template>
  <header class="header">
    <RouterLink class="logo" :to="{ name: 'home' }">futurama</RouterLink>
    <div class="burger-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 28 28" fill="none">
        <path
          d="M4 7C4 6.44771 4.44772 6 5 6H24C24.5523 6 25 6.44771 25 7C25 7.55229 24.5523 8 24 8H5C4.44772 8 4 7.55229 4 7Z"
          fill="#000000"
        />
        <path
          d="M4 13.9998C4 13.4475 4.44772 12.9997 5 12.9997L16 13C16.5523 13 17 13.4477 17 14C17 14.5523 16.5523 15 16 15L5 14.9998C4.44772 14.9998 4 14.552 4 13.9998Z"
          fill="#000000"
        />
        <path
          d="M5 19.9998C4.44772 19.9998 4 20.4475 4 20.9998C4 21.552 4.44772 21.9997 5 21.9997H22C22.5523 21.9997 23 21.552 23 20.9998C23 20.4475 22.5523 19.9998 22 19.9998H5Z"
          fill="#000000"
        />
      </svg>
    </div>
  </header>
  <div class="codemirror-component">
    <div class="loading" v-show="loading">
      <ProgressSpinner class="spinner" />
    </div>
    <div>
      <code-mirror
        class="codemirror"
        v-model="initValue"
        :lang="java()"
        basic
        :extensions="extensions"
        @keydown.shift.space="getAiStream()"
      />
    </div>
  </div>
</template>

<style>
.header {
  height: 50px;
  background-color: #faa307;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  color: #181818;
  font-size: 25px;
  font-weight: 400;
  font-family: 'Fascinate Inline', sans-serif;
  text-transform: uppercase;
  margin-left: 10px;
}

.loading {
  position: fixed;
  top: 18%;
  left: 43%;
  width: 200px;
  height: 200px;

  .spinner {
    width: 100%;
    height: 100%;
  }
}

.burger-icon {
  margin-right: 5px;
  transform: scale(-1, 1);
  width: 50px;
  height: 50px;
}

.codemirror-component {
  width: 100vw;
  min-height: 800px;
  background: #faa307;
}

.codemirror {
  color: #181818;
  background-color: #e7e7e7;
}
</style>
