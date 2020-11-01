package com.company;

public class Main {

    public static void main(String[] args) {

        int menunumber;

        do {
            System.out.println("\nChoose one of the menu numbers:\n" +
                    "1. Check first task\n" +
                    "2. Check second task\n" +
                    "3. Check third task\n" +
                    "4. Check fourth task\n" +
                    "5. Exit\n");

            menunumber = intinput.get();

            switch (menunumber) {
                case 1:
                    task_1.get();
                    break;
                case 2:
                    task_2.get();
                    break;
                case 3:
                    task_3.get();
                    break;
                case 4:
                    task_4.get();
                    break;
                case 5:
                    System.out.println("You chose the exit.");
                    break;
                default:
                    System.out.println("Wrong number, choose again.");
            }
        } while (menunumber != 5);

    }
}




