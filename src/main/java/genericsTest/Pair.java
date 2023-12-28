package genericsTest;

/**
 * Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен иметь методы getFirst(), getSecond()
 * для получения значений пары, а также переопределение метода toString(), возвращающее строковое представление пары.
 */

public class Pair<E, T> {
    private E valueE;
    private T valueT;

    public Pair(E valueE, T valueT) {
        this.valueE = valueE;
        this.valueT = valueT;
    }

    @Override
    public String toString() {
        return "Pair{" + "Class: " +
                valueE.getClass().getSimpleName() +
                " value:  " + valueE +
                " Class: " + valueT.getClass().getSimpleName() +
                " value:  " + valueT + '}';
    }

    public E getValueE() {
        return valueE;
    }

    public T getValueT() {
        return valueT;
    }
}
