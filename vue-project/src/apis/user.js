//用戶接口
import request from "@/utils/http";


export const userAPI = id => {
    return request({
        url: 'user/' + id,
        method: 'GET',

    })
}

//在個人書本狀態更改狀況(還書)
export const putUserBookAPI = ({ bookName, bookId, userId, statusId }) => {
    return request({
        url: 'user',
        method: 'PUT',
        data: {
            bookName,
            bookId,
            userId,
            statusId
        },

    }
    )
}