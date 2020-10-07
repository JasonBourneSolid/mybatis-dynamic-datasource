package com.company.project.core;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author LJX
 */
public class SimpleThreadPool {
    BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>(30);
    List<Thread> workers = new ArrayList<>(4);

    public SimpleThreadPool(){
        for (int i = 0; i < 5; i++) {
            new Thread(()->{

                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        tasks.take().run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"Thread-name-"+i).start();
        }
    }

    public void submit(Runnable task){
        try {
            tasks.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
