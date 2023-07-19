package com.cjj.Service;

import com.cjj.Mapper.BookUseMapper;
import com.cjj.Pojo.Book;
import com.cjj.Pojo.BookUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface BookService {
    public Book getBookId(Integer bookId);

    public BookUser getBookUserId(Integer id);
}
