package ru.geekbrains.classes.data;


import ru.geekbrains.classes.data.exceptions.MyArrayDataException;
import ru.geekbrains.classes.data.exceptions.MySizeArrayException;

public class ArrayHandler {
    public int process(String[][] array) throws MySizeArrayException, MyArrayDataException {

        /**
         * Если массив верхнего уровня имеет размер отличный от 4, то выбрасываем исключение
         */
        if (array.length != 4) {
            throw new MySizeArrayException("Переданый массив имеет неправильный размер");
        }

        /**
         * Если массив второго уровня имеет размер отличный от 4, то выбрасываем исключение
         */
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MySizeArrayException("Переданый массив имеет неправильный размер");
            }
        }

        /**
         * Если размер массива правильный (4), обрабатываем его
         */
        int sum = 0;
        for (String[] strings : array) {
            for (String string : strings) {
                try {
                    sum += Integer.parseInt(string);
                } catch (NumberFormatException e) {
//                    e.printStackTrace();
                    throw new MyArrayDataException("Переданный массив хранит недопустимый тип данных");
                }
            }
        }

        return sum;
    }
}
