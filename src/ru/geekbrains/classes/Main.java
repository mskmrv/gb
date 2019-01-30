package ru.geekbrains.classes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[15];
        words[0] = "Заяц"; // 1 Встречается трижды
        words[1] = "Учетчик"; // 2 Встречается дважды
        words[2] = "Заяц"; // 1.2 Дублирование
        words[3] = "Сено";
        words[4] = "Учетчик"; // 2.2 Дублирование
        words[5] = "Заяц"; // 1.2 Дублирование
        words[6] = "Скрипка";
        words[7] = "Мяч";
        words[8] = "Собака";
        words[9] = "Дельтаплан";
        words[10] = "Автомобиль"; // 3 Встречается дважды
        words[11] = "Автомобиль"; // 3.2 Дублирование
        words[12] = "Лесополоса";
        words[13] = "Рыбалка";
        words[14] = "Чемпион";

        // Создание ArrayList из массива: ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        System.out.println(Arrays.toString(words));

        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Первый способ.
        Set<String> set = new HashSet<>(Arrays.asList(words));
        System.out.println(set + "\n");

        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Второй способ.
        List<String> unicWords = getUniqueWords(words);
        System.out.println(unicWords + "\n");

        // Посчитать, сколько раз встречается каждое слово.
        printNumDuplication(words);
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
