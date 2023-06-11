//註冊接口
import request from '@/utils/http'


export const registerAPI = ({ username, password, name }) => {
    return request({
        url: 'register',
        method: 'POST',
        data: {
            username,
            password,
            name
        }
    })
}