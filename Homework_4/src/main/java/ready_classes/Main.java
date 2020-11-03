package ready_classes;

public class Main {
    public static void main(String[] args) {



        superClassWithoutDescription firstTask = new superClassWithoutDescription("First task",
                "Necessary", "High", "05.11.2020");

        extendedClassWithDescription fourthTask = new extendedClassWithDescription(
                "Description of fourth task", "Fourth task",
                "Necessary", "High", "05.11.2020");

        extendedReusableClass fifthTask = new extendedReusableClass(
                "Fifth task", "Optional", "Low", "05.11.2020", "06.11.2020", "07.11.2020"
        );

        extendedReusableClass sixthTask = new extendedReusableClass(
                "Sixth task", "Optional", "Low", "05.11.2020"
        );

         extendedReusableClass seventhTask = new extendedReusableClass(
                "seventh task", "Optional", "Low"
        );


        System.out.println(firstTask);
        System.out.println(fourthTask);
        System.out.println(fifthTask);
        System.out.println(sixthTask);
        System.out.println(seventhTask);





    }
}
