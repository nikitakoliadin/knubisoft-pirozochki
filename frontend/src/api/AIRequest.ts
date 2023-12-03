export default class AIRequest {
  language: string | undefined
  prompt: string

  constructor(language: string | undefined, prompt: string) {
    this.language = language
    this.prompt = prompt
  }
}
