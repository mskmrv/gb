package ru.geekbrains.classes;

import java.util.*;

public class WordArrayTask {
    public static void main(String[] args) {
        String[] words = {"Заяц", "Учетчик", "Заяц", "Сено", "Учетчик", "Заяц", "Скрипка", "Мяч", "Собака", "Дельтаплан",
                "Автомобиль", "Автомобиль", "Лесополоса", "Рыбалка", "Чемпион"};

        System.out.println("Исходный массив: " + Arrays.toString(words));

        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        List<String> unicWords = getUniqueWords(words);
        System.out.println("Уникальные слова: " + unicWords + "\n");

        // Посчитать, сколько раз встречается каждое слово.
        System.out.println("Посчитать, сколько раз встречается каждое слово: ");
        printNumDuplication(words);
    }

    private static void printNumDuplication(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }
        System.out.println();
    }

    private static List<String> getUniqueWords(String[] words) {
        List<String> list = new ArrayList<>();

        for (String word : words) {
            if (!list.contains(word)) {
                list.add(word);
            }
        }
        return list;
    }

}
