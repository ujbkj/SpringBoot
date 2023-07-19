package com.cjj.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjj.Mapper.BookUserplusMapper;
import com.cjj.Pojo.BookUser;;
import com.cjj.Service.BookUserplusService;
import org.springframework.stereotype.Service;

@Service
public class BookUserplusImpl extends ServiceImpl<BookUserplusMapper, BookUser> implements BookUserplusService {
}
