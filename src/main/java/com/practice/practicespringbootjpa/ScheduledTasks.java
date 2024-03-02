package com.practice.practicespringbootjpa;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000) // 每5秒执行一次
    public void reportCurrentTime() {
        System.out.println("当前时间：" + System.currentTimeMillis());
    }

    @Scheduled(cron = "0 * * * * ?") // 每分钟的0秒执行
    public void performTaskUsingCron() {
        System.out.println("执行任务：" + System.currentTimeMillis());
    }
}