package com.example.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 应用启动做一个一次性事情调用MyCommandLineRunner
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner...........run");
    }
}
