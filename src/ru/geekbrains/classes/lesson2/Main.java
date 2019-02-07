package ru.geekbrains.classes.lesson2;

import ru.geekbrains.classes.lesson2.data.ArrayHandler;
import ru.geekbrains.classes.lesson2.data.ArrayMaker;
import ru.geekbrains.classes.lesson2.data.exceptions.MyArrayDataException;
import ru.geekbrains.classes.lesson2.data.exceptions.MySizeArrayException;

public class Main {

    public static void main(String[] args) {
        ArrayHandler handler = new ArrayHandler();

//        String[][] arrayFour = ArrayMaker.getArrayFour(); // Правильный массив
        String[][] arrayFourWithWrongString = ArrayMaker.getArrayFourWithWrongString(); // Массив с неправильным типом данных
//        String[][] arrayFive = ArrayMaker.getArrayFive(); // Массив с неправильным размером

        int sum = 0;
        try {
            // Проверка правильного массива
//            sum = handler.process(arrayFour);
//            System.out.println("Сумма элементов массива: " + sum);

            // Проверка массива с неправильным типом данных
            sum = handler.process(arrayFourWithWrongString);
            System.out.println(sum);

            // Проверка массива с неправильным размером
//            sum = handler.process(arrayFive);
//            System.out.println(sum);
        } catch (MySizeArrayException ex){
            System.out.println(ex.getMessage());
        } catch (MyArrayDataException e) {
            e.printStackTrace();
//            System.out.println(e.getMessage() + " " + e.getI() + " " + e.getJ());
        } finally {
            System.out.println("Программа завершила свою работу");
        }


    }
}
