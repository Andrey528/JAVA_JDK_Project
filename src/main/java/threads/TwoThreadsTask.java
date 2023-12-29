package threads;

/**
 * Создайте два потока A и B.
 * ● Поток A меняет значение Boolean переменной switcher с задержкой 1000
 * миллисекунд (true в состояние false и наоборот).
 * ● Поток B ожидает состояния true переменной switcher и выводит на консоль
 * обратный отсчет от 100 с задержкой 100 миллисекунд и приостанавливает свое
 * действие, как только поток A переключит switcher в состояние false.
 * ● Условием завершения работы потоков является достижение отсчета нулевой
 * отметки.
 * ● Можно воспользоваться синхронизацией для управления значения переменной или
 * volatile
 */

public class TwoThreadsTask {
    public static boolean switcher = true;
    public static int count = 100;

    public static void main(String[] args) throws InterruptedException {

        Thread A = new Thread(() -> {
            while (count > 0) {
                switcher = !switcher;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread B = new Thread(() -> {
            while (count > 0) {
                while (!switcher) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Count: " + count--);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        A.start();
        B.start();

    }
}
