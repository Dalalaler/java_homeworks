package com.company;

public class task_3 {
    public static void get() {
        int answer = 0;
        int attempts = 5;
        int surrender = 1;
        do {
            System.out.println("How many players are on an Olympic curling team?");
            answer = intinput.get();
            if (answer != 4) {
                System.out.println("Wrong answer. " +
                        attempts + " attempts left. Press 0 if you wanna surrender or another number to continue.");
                surrender = intinput.get();
                if (surrender == 0) {
                    attempts = 0;
                    System.out.println("You gave up.");
                } else {
                    attempts--;
                }
            } else {
                attempts = 0;
            }
        } while (attempts > 0);

        if (answer == 4) {
            System.out.println("You guessed.");
        } else {
            System.out.println("You didn't guess.");
        }

    }
}
