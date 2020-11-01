package com.company;

public class task_1 {
    public static void get() {

        System.out.println("Enter the size of the array: ");


        int arrSize = intinput.get();
        int array[][] = new int[arrSize][arrSize];

        int number = 1;
        for (int j = 0; j <= (arrSize - 1); j++) {
            for (int k = j; k < (arrSize - j); k++) {
                array[j][k] = number;
                array[k][j] = number;
                array[arrSize - j - 1][arrSize - k - 1] = number;
                array[arrSize - k - 1][arrSize - j - 1] = number;
                arrPrint(array, arrSize);                           //it shows how's algorithm working
                System.out.println();
            }
            number++;
        }
    }

    public static void arrPrint(int array[][], int arrSize) {

        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();

        }
    }

}
