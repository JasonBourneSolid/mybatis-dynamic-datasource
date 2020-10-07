package com.company.project.core;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PrintInfoListen implements ApplicationListener<PrintInfoEvent> {
    @Override
    public void onApplicationEvent(PrintInfoEvent printInfoEvent) {
        System.out.println("打印监听时间触发");
    }
}
