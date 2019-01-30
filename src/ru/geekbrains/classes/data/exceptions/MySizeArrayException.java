package ru.geekbrains.classes.data.exceptions;

public class MySizeArrayException extends Exception {
    public MySizeArrayException() {
        super("Переданный массив имеет неправильный размер");
    }
}
