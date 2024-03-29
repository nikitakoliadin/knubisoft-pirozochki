import axios from 'axios'

export default class BaseApi {
  constructor() {
    this.instance = axios.create({
      baseURL: 'http://localhost:9090/api',
      withCredentials: false,
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json'
      }
    })
  }

  setCustomHeaders(headers) {
    this.instance.defaults.headers.common = headers
  }
}
