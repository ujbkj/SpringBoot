package com.cjj;

import com.cjj.Mapper.BookMapper;
import com.cjj.Mapper.BookUserplusMapper;
import com.cjj.Pojo.Book;
import com.cjj.Pojo.BookUser;
import com.cjj.Service.BookUserService;
import com.cjj.Service.BookUserplusService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class SpringbootWeb2ApplicationTests {
    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    DataSource dataSource;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookUserplusMapper bookUserplusMapper;

    @Autowired
    BookUserplusService bookUserplusService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Autowired
    BookUserService bookUserService;

    @Test
    void contextLoads() {
//        jdbcTemplate.queryForObject("select * from book ")
        List<List> lists = jdbcTemplate.queryForList("select book_name from book", List.class);
        log.info("书名：{}",lists);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from book", Long.class);
        log.info("记录总数：{}",aLong);
        log.info("数据源类型是：{}",dataSource.getClass());
    }
    @Test
    public void BookMybtis(){

      Book book=bookMapper.getBook(1);
       log.info("数据为："+book);
    }
    @Test
    void BookRecordplus(){
        BookUser bookUser = bookUserplusMapper.selectById(1);
       log.info("用户信息：{}", bookUser);
    }

//    @Test
//    void BookaddUser(){
//        BookUser bookUser=new BookUser(6,"cjj","123456","2222","admin","1");
//        bookUserplusService.save(bookUser);
//    }

    @Test
    @Disabled
    void TestRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        System.out.println(hello);

       System.out.println(redisConnectionFactory.getClass());
    }

    @Test
    void login(){
        BookUser bookUser=new BookUser();
        bookUser.setUserName("蔡俊杰");
        bookUser.setUserPassword("123");
     bookUserService.login(bookUser);

    }
}
