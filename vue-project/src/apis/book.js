//書本相關接口
import request from "@/utils/http";

//查書
export const bookAPI = ({ page = 1, pageSize = 5, name, statusId, categoryId, createTime }) => {
    return request({
        url: 'books',
        method: 'GET',
        params: {
            page,
            pageSize,
            name,
            statusId,
            categoryId,
            createTime
        }
    })
}
//在書單借書更改狀況(借書)
export const putBookAPI = ({ bookName, bookId, userId, statusId }) => {
    return request({
        url: 'books',
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