<script setup>
import { ref } from 'vue'

import CodeMirror from 'vue-codemirror6'
import { java } from '@codemirror/lang-java'
import { RouterLink } from 'vue-router'

/** Demo code */
const value =
  ref(`OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        try {
            Thread.sleep(FIVE_SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture(bean.getProcessCpuLoad());`)
</script>

<template>
  <div class="codemirror-component">
    <RouterLink :to="{ name: 'home' }">Go back</RouterLink>
    <div class="codemirror-input-output">
      <code-mirror class="js-input" v-model="value" :lang="java()" basic />
    </div>
    <div class="codemirror-input-output">
      <textarea v-model="value" rows="10" class="form-control"></textarea>
    </div>
  </div>
</template>

<style>
.codemirror-component {
}

.codemirror-component .js-input {
  color: black;
  background-color: white;
}

.codemirror-input-output {
  display: flex;
  width: 100%;
}
</style>
