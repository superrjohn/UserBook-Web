package com.itheima.mapper;

import com.itheima.pojo.Book;
import com.itheima.pojo.UserBorrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BookMapper {

    //XML映射動態查詢所有數據,並封裝到List<Book>集合
    List<Book> list(String name, Integer statusId, Integer categoryId,  LocalDate createTime);

    //修改書本出借狀態(用戶借書)
    @Update("update book set status_id = #{statusId}, update_time = #{updateTime} where id = #{bookId}")
    void updateStatus(UserBorrow userBorrow);

}
