package ru.geekbrains.classes.lesson5;

public class MultyThreading {
    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static void main(String[] args) {
        processArray();
    }

    static void processArray() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long b = System.currentTimeMillis();

        System.out.println(b - a);
    }


}
