<script setup>
import { ref } from 'vue'

import CodeMirror from 'vue-codemirror6'
import {esLint, javascript} from "@codemirror/lang-javascript"
import eslint from 'eslint-linter-browserify';
import { RouterLink } from 'vue-router'

/** CodeMirror Instance */
const cm = ref()

/** Demo code */
const value = ref(`document.querySelectorAll('.btn').forEach(
  element => element.addEventListener('click', alert('Button clicked!')));
);`)

const linter_config = {
  // eslint configuration
  parserOptions: {
    ecmaVersion: 2023,
    sourceType: "module",
  },
  env: {
    browser: true,
    node: true,
  },
  rules: {
    semi: ["error", "never"],
  },
};

const linter = esLint(new eslint.Linter());
// Sync dark mode
defineProps({ dark: Boolean })
</script>

<template>
  <div class="codemirror-component">
    <RouterLink :to="{ name: 'home' }">Go back</RouterLink>
    <div class="codemirror-input-output">
      <code-mirror
          class="js-input"
          ref="cm"
          v-model="value"
          :dark="dark"
          :lang="javascript()"
          :linter="linter"
          :linterConfig="linter_config"
          basic
          gutter
      />
    </div>
    <div class="codemirror-input-output">
      <textarea v-model="value" class="form-control"></textarea>
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
