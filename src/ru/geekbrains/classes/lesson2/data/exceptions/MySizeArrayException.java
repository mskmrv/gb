package ru.geekbrains.classes.lesson2.data.exceptions;

public class MySizeArrayException extends Exception {
    public MySizeArrayException() {
        super("Переданный массив имеет неправильный размер");
    }
}
