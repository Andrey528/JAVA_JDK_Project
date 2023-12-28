package genericsTest;

import java.util.Iterator;

/**
 * Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
 * возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
 * @param <E>
 *
 * Написать итератор по массиву. Итератор – это объект, осуществляющий движение по коллекциям любого типа, содержащим любые типы данных.
 * Итераторы обычно имеют только два метода – проверка на наличие следующего элемента и переход к следующему элементу. Но также, особенно
 * в других языках программирования, возможно встретить итераторы, реализующие дополнительную логику.
 */

public class Task2<E> implements Iterable<E> {
    Object[] initialArray = {};

    private E[] array;
    private int size;

    public Task2(E[] baseArray) {
        this.array = baseArray;
        size = array.length;
    }

    public Task2() {
        this.array = (E[]) initialArray;
        size = 0;
    }

    public <T extends E> void addElement(T element) {
        if (size == array.length) {
            Object[] newArray = new Object[(array.length + 1) * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[size] = element;
            array = (E[]) newArray;
        } else {
            array[size] = element;
        }
        size++;
    }

    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    public int getArrayLength() {
        return array.length;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        for (E element :
                array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    class MyListIterator implements Iterator<E> {
        int index;

        public MyListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return array[index++];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }
}
