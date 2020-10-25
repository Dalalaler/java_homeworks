package com.company;

public class task_4 {
    public static void get() {

        double var1, var2;

        System.out.println("Enter the first variable: "); // Далее будет приведение типов
        var1 = intinput.get();
        do {
            System.out.println("Enter the second variable: ");
            var2 = intinput.get();
        } while (var2 != 0);

        if ((var2 / var1) >= 0.9 & (var2 / var1) <= 1.1) {
            System.out.println("The second variable " + var2 + " is close enough to the first " + var1);
        } else System.out.println("The second variable " + var2 + " is NOT close enough to the first " + var1);

    }
}
