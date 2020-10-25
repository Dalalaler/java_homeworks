package com.company;

class task_2 {

    public static void get() {

        int point1, point2, variable, buffer;

        System.out.println("Enter the variable: ");
        variable = intinput.get();

        do {
            System.out.println("Enter the first point: ");
            point1 = intinput.get();
            System.out.println("Enter the second point: ");
            point2 = intinput.get();
            if (point1 == point2) {
                System.out.println("Points must be different.");
            }

        } while (point1 == point2); //Проверка, чтобы промежуток не оказался точкой


        if (point1 > point2) { //Чтобы точки шли по порядку
            buffer = point1;
            point1 = point2;
            point2 = buffer;
        }


        if (variable < point1) {
            System.out.println("Your variable is between -∞ and " + point1);
        } else if (variable >= point1 & variable <= point2) {
            System.out.println("Your variable is between " + point1 + " and " + point2);
        } else {
            System.out.println("Your variable is between " + point2 + " and +∞");
        }


    }

}
