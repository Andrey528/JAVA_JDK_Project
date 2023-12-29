package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PhilosopherTask extends Thread {
    static class Philosopher extends Thread {
        private final String philosopherName;

        Philosopher(String philosopherName) {
            this.philosopherName = philosopherName;
            start();
        }

        @Override
        public void run() {
            Thread.currentThread().setName(philosopherName);
            PhilosopherActions.startPhilosopherDay();
        }
    }

    static class PhilosopherActions {
        private static final int MEAL_QUANTITY = 3;
        private static Lock lock = new ReentrantLock();

        public static void startPhilosopherDay() {
            lock.lock();
            try {
                for (int i = 0; i < MEAL_QUANTITY; i++) {
                    eat();
                    Thread.sleep(500);
                    think();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

        public static void eat() {
            System.out.println("Сейчас " + Thread.currentThread().getName() + " ест");
        }

        public static void think() {
            System.out.println("Сейчас " + Thread.currentThread().getName() + " думает");
        }
    }

    @Override
    public void run() {
        Philosopher philosopher1 = new Philosopher("Ph1");
        Philosopher philosopher2 = new Philosopher("Ph2");
        Philosopher philosopher3 = new Philosopher("Ph3");
        Philosopher philosopher4 = new Philosopher("Ph4");
        Philosopher philosopher5 = new Philosopher("Ph5");

        try {
            philosopher1.join();
            philosopher2.join();
            philosopher3.join();
            philosopher4.join();
            philosopher5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Конец дня");
    }
}

