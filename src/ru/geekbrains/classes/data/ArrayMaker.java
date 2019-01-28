package ru.geekbrains.classes.data;

public class ArrayMaker {
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    public static String[][] getArrayFour() {
        String[][] array = new String[FOUR][FOUR];

        array[0][0] = "1";
        array[0][1] = "2";
        array[0][2] = "3";
        array[0][3] = "4";

        array[1][0] = "5";
        array[1][1] = "6";
        array[1][2] = "7";
        array[1][3] = "8";

        array[2][0] = "9";
        array[2][1] = "10";
        array[2][2] = "11";
        array[2][3] = "12";

        array[3][0] = "13";
        array[3][1] = "14";
        array[3][2] = "15";
        array[3][3] = "16";

        return array;
    }

    public static String[][] getArrayFourWithWrongString() {
        String[][] array = new String[FOUR][FOUR];

        array[0][0] = "1";
        array[0][1] = "2";
        array[0][2] = "3";
        array[0][3] = "4";

        array[1][0] = "пять";
        array[1][1] = "6";
        array[1][2] = "7";
        array[1][3] = "8";

        array[2][0] = "9";
        array[2][1] = "10";
        array[2][2] = "11";
        array[2][3] = "12";

        array[3][0] = "13";
        array[3][1] = "14";
        array[3][2] = "15";
        array[3][3] = "16";

        return array;
    }

    public static String[][] getArrayFive(){
        String[][] array = new String[FIVE][FIVE];

        array[0][0] = "1";
        array[0][1] = "2";
        array[0][2] = "3";
        array[0][3] = "4";

        array[1][0] = "5";
        array[1][1] = "6";
        array[1][2] = "7";
        array[1][3] = "8";

        array[2][0] = "9";
        array[2][1] = "10";
        array[2][2] = "11";
        array[2][3] = "12";

        array[3][0] = "13";
        array[3][1] = "14";
        array[3][2] = "15";
        array[3][3] = "16";

        array[4][0] = "17";
        array[4][1] = "18";
        array[4][2] = "19";
        array[4][3] = "20";

        return array;
    }

}
