import BaseApi from './BaseApi'

export default class AboutApi extends BaseApi {
  constructor() {
    super()
  }

  getAbout() {
    return this.instance.get('/about').catch((error) => {
      console.error(error)
    })
  }
}
