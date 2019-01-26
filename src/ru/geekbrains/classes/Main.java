package ru.geekbrains.classes;

import ru.geekbrains.classes.data.ArrayHandler;
import ru.geekbrains.classes.data.ArrayMaker;
import ru.geekbrains.classes.data.exceptions.MyArrayDataException;
import ru.geekbrains.classes.data.exceptions.MySizeArrayException;

public class Main {

    public static void main(String[] args) {
        ArrayMaker arrayMaker = new ArrayMaker();
        ArrayHandler handler = new ArrayHandler();

        String[][] arrayFour = arrayMaker.getArrayFour(); // Правильный массив
//        String[][] arrayFourWithWrongString = arrayMaker.getArrayFourWithWrongString(); // Массив с неправильным типом данных
//        String[][] arrayFive = arrayMaker.getArrayFive(); // Массив с неправильным размером

        int sum = 0;
        try {
            // Проверка правильного массива
            sum = handler.process(arrayFour);
            System.out.println("Сумма элементов массива: " + sum);

            // Проверка массива с неправильным типом данных
//            sum = handler.process(arrayFourWithWrongString);
//            System.out.println(sum);

            // Проверка массива с неправильным размером
//            sum = handler.process(arrayFive);
//            System.out.println(sum);
        } catch (MySizeArrayException ex){
            System.out.println(ex.getMessage());
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Программа завершила свою работу");
        }


    }
}
