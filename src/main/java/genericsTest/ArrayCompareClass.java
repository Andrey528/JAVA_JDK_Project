package genericsTest;

/**
 * Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые, и false в противном случае.
 * Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */

public class ArrayCompareClass {
    public <E> boolean compareArray(E[] arrayA, E[] arrayB) {
        if (arrayA.length != arrayB.length) {
            return false;
        } else {
            for (int i = 0; i < arrayA.length; i++) {
                if (!arrayA[i].equals(arrayB[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
