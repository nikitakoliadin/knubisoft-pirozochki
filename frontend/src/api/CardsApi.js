import BaseApi from './BaseApi'

export default class CardsApi extends BaseApi {
  constructor() {
    super()
  }

  getCards() {
    return this.instance.get('/cards').catch((error) => {
      console.error(error)
    })
  }
}
