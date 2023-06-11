import { defineStore } from 'pinia'
import { userAPI } from '@/apis/user'

//個人借書記錄
export const useBookStatus = defineStore('bookStatus', {
    state: () => ({
        bookStatus: []
    }),
    actions: {
        async getBookStatus(id) {
            const res = await userAPI(id)
            this.bookStatus = res.data.data
            console.log(this.bookStatus)
        },
        clearBookStatus() {
            this.bookStatus = []
        }
    },
    persist: true
})