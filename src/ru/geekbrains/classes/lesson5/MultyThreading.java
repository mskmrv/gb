package ru.geekbrains.classes.lesson5;

import java.util.Arrays;

public class MultyThreading {
    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static void main(String[] args) {
        processArray();
        treadsProcessArray();
    }

    static void processArray() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }

    static void treadsProcessArray() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();
        float ar1[] = new float[h];
        System.arraycopy(arr, 0, ar1, 0, h);
        float ar2[] = new float[h];
        System.arraycopy(arr, h, ar2, 0, h);

        ArrayHandler arrayHandler1 = new ArrayHandler(ar1);
        ArrayHandler arrayHandler2 = new ArrayHandler(ar2);

        Thread thread1 = new Thread(arrayHandler1);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(arrayHandler2);
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ar1 = arrayHandler1.getArr();
        ar2 = arrayHandler1.getArr();

        System.arraycopy(ar1, 0, arr, 0, h);
        System.arraycopy(ar2, 0, arr, h, h);

        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }
}
