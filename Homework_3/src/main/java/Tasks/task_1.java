package Tasks;

public class task_1 {
    private static int randomNumber;
    private static String simpleString;
    private static StringBuilder builderString = new StringBuilder();

    public static void get() {
        simpleString = "";
        builderString = new StringBuilder();


        for (int i = 0; i < 100; i++) {
            randomNumber = (int) ((Math.random() * 1000));
            simpleString = simpleString.concat(String.valueOf(randomNumber) + " ");
        }

        for (int i = 0; i < 100; i++) {
            randomNumber = (int) ((Math.random() * 1000));
            builderString.append((String.valueOf(randomNumber) + " "));
        }


        System.out.println("Simple string: \n" + simpleString);
        System.out.println("StringBuilder string: \n" + builderString);


    }

    public static String getString() {
        get();
        return (simpleString);
    }


}
