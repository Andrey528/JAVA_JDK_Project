package threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 3 бегуна должны прийти к старту гонки
 * Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
 * Программа должна отсчитать “На старт”, “Внимание”, “Марш”
 * Программа должна завершиться когда все участники закончат гонку.
 */

public class ThreeRunnerTask {
    public static void main(String[] args) {
        CountDownLatch allStart = new CountDownLatch(3);
        CountDownLatch startRace = new CountDownLatch(1);
        try {
            Thread runnerThread1 = new Thread(new Runner(allStart, startRace));
            Thread runnerThread2 = new Thread(new Runner(allStart, startRace));
            Thread runnerThread3 = new Thread(new Runner(allStart, startRace));
            runnerThread3.start();
            runnerThread2.start();
            runnerThread1.start();
            allStart.await();
            System.out.println("На старт");
            Thread.sleep(500);
            System.out.println("Внимание");
            Thread.sleep(500);
            System.out.println("Марш");
            Thread.sleep(500);
            startRace.countDown();
            runnerThread1.join();
            runnerThread2.join();
            runnerThread3.join();
            System.out.println("Гонка завершена!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Runner implements Runnable {
        CountDownLatch readyToStart;
        CountDownLatch raceStart;

        public Runner(CountDownLatch readyToStart, CountDownLatch raceStart) {
            this.readyToStart = readyToStart;
            this.raceStart = raceStart;
        }

        @Override
        public void run() {
            try {
                System.out.println("Иду на старт... " + Thread.currentThread().getName());
                Thread.sleep(new Random().nextInt(500, 2000));
                readyToStart.countDown();
                raceStart.await();
                System.out.println("Бегу... " + Thread.currentThread().getName());
                Thread.sleep(new Random().nextInt(3000, 5000));
                System.out.println("Прибежал " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
