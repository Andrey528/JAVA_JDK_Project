package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0,1000).forEach(i ->{
            Runnable task = ()->
                    atomicInteger.updateAndGet(n-> n+2);
            executor.submit(task);
        });
        executor.shutdown();
        System.out.println(atomicInteger.get());
    }
}
