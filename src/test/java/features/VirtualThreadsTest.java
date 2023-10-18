package features;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class VirtualThreadsTest {
    final AtomicInteger atomicInteger = new AtomicInteger();
    final int sleepDurationInMilliseconds = 1000;

    final int fixedThreadPool = 100;

    Runnable runnable = () -> {
        try {
            Thread.sleep(Duration.ofMillis(sleepDurationInMilliseconds));
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println(STR."Task erledigt: \{atomicInteger.incrementAndGet()}");
    };
    @Test
    void platformThreadTest(){
        Instant start = Instant.now();

        try (var executor = Executors.newFixedThreadPool(fixedThreadPool)) {
            for(int i = 0; i < 10_000; i++) {
                executor.submit(runnable);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(STR."Insgesamt vergangene Zeit : \{timeElapsed}");
    }

    @Test
    void virtualThreadTest(){
        Instant start = Instant.now();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for(int i = 0; i < 10_000; i++) {
                executor.submit(runnable);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(STR."Insgesamt vergangene Zeit : \{timeElapsed}");
    }
}
