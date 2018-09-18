package com.customs.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class TestJob {

    @Scheduled(cron = "0/1 * * * * ?")
    public void jobA() {
	System.out.println("jobA......");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void jobB() throws InterruptedException {
	System.out.println("jobB......");
    }
}
