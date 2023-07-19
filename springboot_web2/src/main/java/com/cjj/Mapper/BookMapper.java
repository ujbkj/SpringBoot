package com.cjj.Mapper;

import com.cjj.Pojo.Book;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface BookMapper {

    public Book getBook(Integer bookId);
}
