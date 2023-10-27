package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> ageName = new HashMap<>();
        ageName.put(20, "Anton");
        ageName.put(30, "Ivan");
        ageName.put(40, "Elena");

        System.out.println("Age and Name: " + ageName);
        System.out.println("Name and Age: " + reverse(ageName));

        System.out.println("---------------------");

        list();

        System.out.println("---------------------");

        ArrayList<String> name = new ArrayList<>();
        name.add("Anton");
        name.add("Anton");
        name.add("Elena");
        name.add("Elena");
        name.add("Igor");
        name.add("Elena");
        removeDuplicate(name);
        System.out.println(name);
    }

    /* Задание 1: Реализуй метод, который поменяет ключи и значения в HashMap местами.
        На вход в метод поступает HashMap<Interger, String>, надо вернуть HashMap<String, Integer>.
        Выведи результат. */
    public static HashMap<String, Integer> reverse (HashMap<Integer, String> map) {
        HashMap<String, Integer> newMap = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            newMap.put(entry.getValue(), entry.getKey());
        }
        return newMap;
    }

    /*Задание 2: Реализуй метод, в котором создаются ArrayList, LinkedList
     и заполняются 1 000 000 случайными элементами одного и того же типа.
     После из ArrayList и LinkedList 1000 раз выбираем элемент по случайному индексу.
     Замерь время для ArrayList и LinkedList. Сравни результаты и предположи, почему они могут отличаться. */

    public static void list () {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 1000000; i++) {
            arrayList.add((int) (Math.random()*100));
            linkedList.add((int) (Math.random()*100));
        }

        // Вычисление времени выполнения у ArrayList (около 1 миллисекунды)
        long n = System.currentTimeMillis();
        for (int j = 0; j < 1000; j++) {
            arrayList.get((int) (Math.random() * 1000000));
        }
        System.out.println("ArrayList: " + (double) (System.currentTimeMillis() - n));

        // Вычисление времени выполнения у LinkedList (около 750 миллисекунд)
        long a = System.currentTimeMillis();
        for (int j = 0; j < 1000; j++) {
            linkedList.get((int) (Math.random() * 1000000));
        }
        System.out.println("LinkedList: " + (double) (System.currentTimeMillis() - a));

        /* Вывод: У ArrayList получение элемента по индексу всегда происходит примерно за одно время (около 1 миллисекунды),
         тк он реализован на базе массива, и у элементов есть индексы
         У LinkedList получение по индексу происходит дольше, тк для этого необходимо пройти список от начала до необходимого элемента,
         время зависит от того, насколько далеко находится элемент*/
    }

    /* Задание 3: Реализуй метод, который на вход примет ArrayList строк и удаляет из него все дубликаты,
        не используя метод contains(). Можно использовать другие коллекции, которые были изучены на уроке. */

    public static void removeDuplicate (ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            for(int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j))) {
                    arrayList.remove(j);
                }
            }
        }
    }
}