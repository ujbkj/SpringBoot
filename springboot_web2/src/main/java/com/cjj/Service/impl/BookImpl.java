package com.cjj.Service.impl;
import com.cjj.Mapper.BookMapper;
import com.cjj.Mapper.BookUseMapper;
import com.cjj.Pojo.Book;
import com.cjj.Pojo.BookUser;
import com.cjj.Service.BookService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookImpl implements BookService {
    /**
     * 自定义Metrics
     * 统计访问book次数
     */
    Counter counter;
    Timer timer;
    public  BookImpl(MeterRegistry meterRegistry){
        counter=meterRegistry.counter("bookMapper.getBook");
        timer=meterRegistry.timer("bookMapper.getBook.time");
    }

    @Autowired
    BookMapper bookMapper;

    public Book getBookId(Integer bookId){
        //记录计数器
        counter.increment();
        //记录运行时间
        timer.record(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return bookMapper.getBook(bookId);
    }

    @Autowired
    BookUseMapper bookUseMapper;
    public BookUser getBookUserId(Integer id){
        return  bookUseMapper.getBookUserId(id);
    }
}
