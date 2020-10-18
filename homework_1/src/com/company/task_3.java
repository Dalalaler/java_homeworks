package com.company;

public class task_3 {
    public static void get() {

        double var1, var2, var3, average;

        System.out.println("Enter the first variable: "); // Далее будет приведение типов
        var1 = intinput.get();
        System.out.println("Enter the second variable: ");
        var2 = intinput.get();
        System.out.println("Enter the third variable: ");
        var3 = intinput.get();

        if (var1 > var2 & var1 > var3) {
            System.out.println("The biggest variable is " + var1);
        }
        else if (var2 > var1 & var2 > var3) {
            System.out.println("The biggest variable is " + var2);
        }
        else {
            System.out.println("The biggest variable is " + var3);
        }


        if (var1 < var2 & var1 < var3) {
            System.out.println("The smallest variable is " + var1);
        }
        else if (var2 < var1 & var2 < var3) {
            System.out.println("The smallest variable is " + var2);
        }
        else {
            System.out.println("The smallest variable is " + var3);
        }

        average = (var1 + var2 + var3) / 3;
        System.out.println("Average is " + average);


    }
}
