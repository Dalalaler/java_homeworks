package Tasks;

public class task_3 {
    private static String userName;
    private static int userAge;

    public static void get() {
        System.out.println("Enter your name: ");
        userName = stringinput.get();
        System.out.println("Enter your age: ");
        userAge = intinput.get();
        System.out.printf("Hello, %s years old %s", userAge, userName);

    }
}
