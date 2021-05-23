package cn.louguanyang.code.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author louguanyang
 * @createAt 2021/5/23 11:07 下午
 */
public class TestFuture {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Future Task DONE";
        });
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
