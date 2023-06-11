import { defineStore } from 'pinia'
import { loginAPI } from '@/apis/login'

export const useUserStore = defineStore('user', {
    state: () => ({
        userInfo: {},
        id: '',
        name: '',
        username: ''
    }),
    actions: {
        async getUserInfo({ username, password }) {
            const res = await loginAPI({ username, password })
            this.userInfo = res.data
            const jwt = res.data.data
            const jwtParts = jwt.split(".");
            const payload = JSON.parse(atob(jwtParts[1]));
            this.id = payload.id
            this.name = payload.name
            this.username = payload.username
            console.log(payload)
        },
        clearUserInfo() {
            this.userInfo = {}
            this.id = {}
            this.name = {}
            this.username = {}
        }
    },
    persist: true
})