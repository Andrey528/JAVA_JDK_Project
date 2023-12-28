package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Создайте коллекцию мужских и женских имен с помощью интерфейса List
 * Отсортируйте коллекцию в алфавитном порядке
 * Отсортируйте коллекцию по количеству букв в слове
 * Разверните коллекцию
 */

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> peopleNames = new ArrayList<>();

        peopleNames.add("Александр");
        peopleNames.add("Мария");
        peopleNames.add("Денис");
        peopleNames.add("Юля");
        peopleNames.add("Михаил");
        peopleNames.add("Олег");
        System.out.println(peopleNames);
        Collections.sort(peopleNames);
        System.out.println(peopleNames);
        peopleNames.sort((s1,s2)->s1.length()-s2.length());

        peopleNames.sort(Comparator.comparingInt(String::length));
        System.out.println(peopleNames);
        Collections.reverse(peopleNames);
        System.out.println(peopleNames);
    }
}
