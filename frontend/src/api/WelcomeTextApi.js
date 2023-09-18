import BaseApi from './BaseApi'

export default class WelcomeTextApi extends BaseApi {
  constructor() {
    super()
  }

  getTexts() {
    return this.instance.get('/welcomeTexts')
  }
}
