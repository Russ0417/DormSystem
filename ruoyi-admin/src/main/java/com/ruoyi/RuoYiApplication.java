package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RuoYiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("   _                            _        _____                             \n" +
                " | |                          | |      / ____|                            \n" +
                " | |     __ _ _ __  _   _  ___| |__   | (___  _   _  ___ ___ ___  ___ ___ \n" +
                " | |    / _` | '_ \\| | | |/ __| '_ \\   \\___ \\| | | |/ __/ __/ _ \\/ __/ __|\n" +
                " | |___| (_| | | | | |_| | (__| | | |  ____) | |_| | (_| (_|  __/\\__ \\__ \\\n" +
                " |______\\__,_|_| |_|\\__,_|\\___|_| |_| |_____/ \\__,_|\\___\\___\\___||___/___/\n" +
                "                                                                          \n" +
                "                                                                          \n" +
                "\n");
    }
}