package com.cjj.Service;

import com.cjj.Pojo.BookUser;

public interface BookUserService {

    public BookUser getBookUserId(Integer id);

    public void insert(BookUser bookUser);

    public BookUser login(BookUser bookUser);

    public  void  insertuser(BookUser bookUser);

}
