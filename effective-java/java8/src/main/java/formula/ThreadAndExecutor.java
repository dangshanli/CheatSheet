package formula;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: luzj
 * @date: 2019-01-16
 * @description:
 */
public class ThreadAndExecutor {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadAndExecutor executor = new ThreadAndExecutor();
//        executor.simpleExecutor();
//        executor.simpleFuture();
//        executor.testInvokeAll();
        executor.testInvokeAny();
    }

    Callable<String> callable(String value,int second){
        return ()->{
          TimeUnit.SECONDS.sleep(second);
          return value;
        };
    }

    //取第一个返回的值
    void testInvokeAny() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                callable("task1",2),
                callable("task2",1),
                callable("task3",3)
        );

        String result = executorService.invokeAny(callables);
        System.out.println(result);
    }
    //invokeAll示例
    void testInvokeAll() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
    }

    //Callable -- Future
    void simpleFuture() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted");
            }
        });

        System.out.println("future done? " + future.isDone());
        Integer result = future.get(1, TimeUnit.SECONDS);
        System.out.println("future done? " + future.isDone());
        System.out.println("result: " + result);
    }

    //executor执行
    void simpleExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
        closeExecutor(executor);
    }

    void closeExecutor(ExecutorService executor) {
        try {
            //关闭executor的一个方式
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.out.println("cancel non-finished tasks");
            }
            executor.shutdown();
            System.out.println("shutdown finished");
        }
    }


}
