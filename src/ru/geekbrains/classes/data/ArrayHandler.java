package ru.geekbrains.classes.data;


import ru.geekbrains.classes.data.exceptions.MyArrayDataException;
import ru.geekbrains.classes.data.exceptions.MySizeArrayException;

public class ArrayHandler {
    public int process(String[][] array) throws MySizeArrayException, MyArrayDataException {

        /**
         * Если массив верхнего уровня имеет размер отличный от 4, то выбрасываем исключение
         */
        if (array.length != 4) {
            throw new MySizeArrayException("Переданный массив имеет неправильный размер");
        }

        /**
         * Если массив второго уровня имеет размер отличный от 4, то выбрасываем исключение
         */
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MySizeArrayException("Переданный массив имеет неправильный размер");
            }
        }

        /**
         * Если размер массива правильный (4), обрабатываем его
         */
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    String num = array[i][j];
                    sum += Integer.parseInt(num);
                } catch (NumberFormatException e) {
//                    e.printStackTrace();
                    throw new MyArrayDataException("Переданный массив хранит недопустимый тип данных: ", i, j);
                }
            }
        }

        return sum;
    }
}