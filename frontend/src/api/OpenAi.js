import BaseApi from './BaseApi'

export default class OpenApi extends BaseApi {
    constructor() {
        super()
    }

    sendPrompt(promptText) {
        return this.instance.post('/openAi/prompt', promptText)
            .catch((error) => {
                console.error('Error', error)
            })
    }
}
