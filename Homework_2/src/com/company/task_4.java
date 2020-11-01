package com.company;

public class task_4 {
    public static void get() {
        int number = -1;
        int randomNumber;
        int stupidAttempts = 0;
        int cleverAttempts = 0;
        int memoryArray[] = new int[101];
        memoryArray[0] = 1;

        do {
            System.out.println("Enter the number (0 - 100)");
            number = intinput.get();
        } while (number < 0 || number > 100);

        System.out.println("_____________Stupid Guessing _____________");

        do {
            randomNumber = (int) ((Math.random() * 100) + 0.5);
            stupidAttempts++;
            System.out.println("Attempt № " + stupidAttempts + ". Computer generated:  " + randomNumber);
        } while (randomNumber != number);

        System.out.println("_____________Clever Guessing _____________");

        do {
            randomNumber = (int) ((Math.random() * 100) + 0.5);

            if (memoryArray[randomNumber] != randomNumber) {
                memoryArray[randomNumber] = randomNumber;
                cleverAttempts++;
                System.out.println("Attempt № " + cleverAttempts + ". Computer generated:  " + randomNumber);
            }
        } while (randomNumber != number);


    }
}
