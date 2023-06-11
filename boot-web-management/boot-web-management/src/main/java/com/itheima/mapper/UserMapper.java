package com.itheima.mapper;

import com.itheima.pojo.User;
import com.itheima.pojo.UserBorrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    //根據用戶名和密碼找用戶
    @Select("select * from user where username = #{username} and password = #{password}")
    User getUserNameAndPassword(User user);

    //註冊
    @Insert("insert into user (username, password, name, create_time, update_time) value " +
            "(#{username}, #{password}, #{name}, #{createTime}, #{updateTime})")
    void register(User user);
    //新增用戶借書記錄
    @Insert("insert into user_borrow (user_id, book_name, book_id, status_id, update_time, create_time) value (#{userId}," +
            "#{bookName}, #{bookId}, #{statusId},#{updateTime}, #{createTime})")
    void insertRecord(UserBorrow userBorrow);
    //顯示用戶借書記錄
    @Select("select * from user_borrow where user_id = #{id}")
    List<UserBorrow> recordList(Integer id);
}
