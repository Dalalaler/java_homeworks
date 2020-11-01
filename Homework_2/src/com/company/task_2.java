package com.company;

public class task_2 {
    public static void get() {

        int month;
        int day;
        int year;
        boolean isConsist = false;

        System.out.println("Enter the year: ");
        year = intinput.get();

        System.out.println("Enter the day: ");
        day = intinput.get();


        System.out.println("Enter the month: ");
        month = intinput.get();


        if (isLeapYear(year)) {
            System.out.println("Is leap year.");
        } else {
            System.out.println("Is not leap year.");
        }


        if (month >= 1 & month <= 12) {                                 //only really existing months
            if (day >= 1 & day <= 31) {                                 //only really existing days
                if (month != 2) {                                       //not the february
                    if ((month % 2 == 0) & (day <= 30)) {
                        isConsist = true;
                    } else if ((month % 2 != 0) & (day <= 31)) {
                        isConsist = true;
                    }
                } else if (month == 2 & isLeapYear(year) & day <= 29) {
                    isConsist = true;
                } else if (month == 2 & !(isLeapYear(year)) & day <= 28) {
                    isConsist = true;
                }
            } else {
                System.out.println("Wrong day (only 1 - 31).");
            }
        } else {
            System.out.println("Wrong month (only 1 - 12).");
        }

        if (isConsist) {
            System.out.println("This day is consist in this month and year");
        } else {
            System.out.println("This day is NOT consist in this month and year");
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
