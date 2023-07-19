package com.cjj.Service.impl;

import com.cjj.Mapper.BookUseMapper;
import com.cjj.Pojo.BookUser;
import com.cjj.Service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookUserImpl implements BookUserService {

    @Autowired
    BookUseMapper bookUseMapper;
    public BookUser getBookUserId(Integer id){
        return  bookUseMapper.getBookUserId(id);
    }

    public void insert(BookUser bookUser){
        bookUseMapper.insert(bookUser);
    }

    @Override
    public BookUser login(BookUser bookUser) {
        return bookUseMapper.login(bookUser);
    }

    @Override
    public void insertuser(BookUser bookUser) {
        bookUseMapper.insertuser(bookUser);
    }
}
