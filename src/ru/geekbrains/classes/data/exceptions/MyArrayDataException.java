package ru.geekbrains.classes.data.exceptions;

public class MyArrayDataException extends Exception{
    private int i;
    private int j;

    public MyArrayDataException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + " " + i + " " + j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
