package com.company.project.core;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 添加系统启动监听，可以在系统启动后做一些初始化操作。
 *
 * @author LJX
 */
@Component
public class ApplicationContextStartedListener  implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("系统启动");
    }
}
