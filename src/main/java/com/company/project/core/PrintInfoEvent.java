package com.company.project.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


/**
 * 添加打印事件监听
 *
 * @author LJX
 */
@Component
public class PrintInfoEvent extends ApplicationEvent {

    public PrintInfoEvent(ApplicationContext source) {
        super(source);
    }
}
