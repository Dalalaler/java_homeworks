package com.company;

public class task_1 {

    public static void get() {
        int daynumber;

        do {
            System.out.println("Enter the day number (1-7): ");
            daynumber = intinput.get();
            if (daynumber < 1 || daynumber > 7) {
                System.out.println("Incorrect day number .");
            }

        } while (daynumber < 1 || daynumber > 7);

        System.out.println("Your day is: ");

        switch (daynumber) {
            case 1:
                System.out.print("Monday");
                break;
            case 2:
                System.out.print("Tuesday");
                break;
            case 3:
                System.out.print("Wednesday");
                break;
            case 4:
                System.out.print("Thursday");
                break;
            case 5:
                System.out.print("Friday");
                break;
            case 6:
                System.out.print("Saturday");
                break;
            case 7:
                System.out.print("Sunday");
                break;

        }

        return;

    }

}



