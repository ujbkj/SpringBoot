package com.cjj.Mapper;

import com.cjj.Pojo.BookUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface BookUseMapper {
    //注解版
    @Select("select * from user where user_id=#{id} ")
    public BookUser getBookUserId(Integer id);
    @Select("select user_name,user_password from user where user_name=#{userName} and user_password=#{userPassword}")
    public BookUser login(BookUser bookUser);
    //注解混合版
//    @Insert("insert into user(`user_name`,`user_password`,`user_email`,`user_role`,`user_status`)value (#{userName},#{userPassword},#{userEmail},#{userRole},#{userStatus})")
//    @Options(useGeneratedKeys = true,keyProperty = "userId") //xml的insert的配置,keyProperty设置主键,防止为null
    public  void insert(BookUser bookUser);
    @Insert("insert into user(user_id,user_name,user_password,user_email,user_status,user_role)\n" +
            "     values (default,#{userName},#{userPassword},#{userEmail},0,#{userRole})")
    void insertuser(BookUser bookUser);
}
