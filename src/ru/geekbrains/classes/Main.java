package ru.geekbrains.classes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1
        String[] words = {"Заяц", "Учетчик", "Заяц", "Сено", "Учетчик", "Заяц", "Скрипка", "Мяч", "Собака", "Дельтаплан",
                "Автомобиль", "Автомобиль", "Лесополоса", "Рыбалка", "Чемпион"};

        System.out.println("Исходный массив: " + Arrays.toString(words));

        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Первый способ.
        Set<String> set = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова: " + set);

        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Второй способ.
        List<String> unicWords = getUniqueWords(words);
        System.out.println("Уникальные слова 2: " + unicWords + "\n");

        // Посчитать, сколько раз встречается каждое слово.
        System.out.println("Посчитать, сколько раз встречается каждое слово: ");
        printNumDuplication(words);

        //2
        System.out.println("Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров: ");
        PhoneBook.add("Иван", "+77899874774");
        PhoneBook.add("Елена", "89878744878");
        PhoneBook.add("Елена", "89888888888");
        PhoneBook.add("Петр", "89777777777");
        PhoneBook.add("Петр", "89666666666");
        PhoneBook.add("Петр", "89555555555");

        PhoneBook.print();// Тест
        System.out.println();

        // По заданию:
        PhoneBook.get("Иван");
        PhoneBook.get("Елена");
        PhoneBook.get("Петр");
    }

    private static void printNumDuplication(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            int count = 1;
            for (int j = 0; j < words.length; j++) {
                if (j != i) {
                    if (words[i].equals(words[j])) {
                        count++;
                    }
                }
            }
            map.put(words[i], count);
        }
        // Или добавить слова в map: if (!map.containsKey(word)){map.put(word, 1);} else {map.put(word, map.get(word) + 1);}

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
