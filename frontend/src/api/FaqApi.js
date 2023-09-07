import BaseApi from './BaseApi'

export default class FaqApi extends BaseApi {
  constructor() {
    super()
  }

  getFaq() {
    return this.instance.get('/faq').catch((error) => {
      console.error(error)
    })
  }
}
