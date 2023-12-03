import axios, { AxiosInstance, AxiosResponse } from 'axios';
import BaseApi from "@/api/BaseApi.js"
import AIRequest from "@/api/AIRequest";

export default class CodemirrorApi extends BaseApi{
    private instance: AxiosInstance;

    constructor() {
        super()
    }

    getAiAutocompletion = async (request: AIRequest): Promise<AIResponse | undefined> => {
        try {
            const response: AxiosResponse<AIResponse> = await this.instance.post('/codemirror/code', request)
            return response.data;
        } catch (error) {
            if (axios.isAxiosError(error)) {
                console.error('Axios Error:', error.message);
            } else {
                console.error('Non-Axios Error:', error);
            }
        }
    };
}

interface AIResponse {
    statusCode: number
    suggestions: string[]
}
