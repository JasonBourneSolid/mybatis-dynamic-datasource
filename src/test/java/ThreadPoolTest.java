import com.company.project.core.SimpleThreadPool;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
//        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
//        for (int i = 0; i < 100; i++) {
//            simpleThreadPool.submit(()->{
//                LocalTime localDateTime = LocalTime.now();
//                System.out.println(Thread.currentThread().getName()+"--"+ localDateTime);
//            });
//            Thread.sleep(500);
//        }

        ExecutorService executorService =  Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                LocalTime localDateTime = LocalTime.now();
                System.out.println(Thread.currentThread().getName() + "--" + localDateTime);
            });
        }
    }

}
