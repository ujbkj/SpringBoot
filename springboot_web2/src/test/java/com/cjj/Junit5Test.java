package com.cjj;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})
 */
@SpringBootTest
@DisplayName("Junit5测试")
public class Junit5Test {

    @Resource
    JdbcTemplate jdbcTemplate;

    @BeforeAll
    static void  BeforeAll(){
        System.out.println(".........所有测试执行前.........");
    }
    @BeforeEach
    void BeforeEach(){
        System.out.println(".........测试执行前.........");
    }

    @DisplayName("测试1开始测试")
    @Test
    void test1(){
        System.out.println(".........测试1开始了.........");
    }

    @DisplayName("测试2开始测试")
    @Test
    void test2(){
        System.out.println(".........测试2开始了.........");
    }

    @AfterEach
    void AfterEach (){
        System.out.println(".........测试执行后.........");
    }

    @AfterAll
    static  void AfterAll(){
        System.out.println(".........所有测试执行后.........");
    }


    @DisplayName("测试3开始测试")
    @Disabled//禁用Test
    @Test
    void test3(){
        System.out.println(".........测试3开始了.........");
    }

    /**
     * Timeout规定超过多少秒就会抛出异常
     * @throws InterruptedException
     */
    @DisplayName("测试4开始测试")
    @Timeout(value = 1,unit = TimeUnit.SECONDS)//使用的是秒的单位
    @Test
    void test4() throws InterruptedException {
        Thread.sleep(1200);//毫秒单位
        System.out.println(".........测试4开始了.........");
    }


    @DisplayName("@ExtendWith 开始测试")
    @Test
    void ExtendWith()  {

        System.out.println("........"+jdbcTemplate+".........");
    }
}
