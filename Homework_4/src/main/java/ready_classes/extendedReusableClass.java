package ready_classes;

import java.util.Arrays;

public class extendedReusableClass extends superClassWithoutDescription {

    private String datesArray[] = new String[]{"Not setted"};

    extendedReusableClass(String... args) {
        super(args[0], args[1], args[2]);

        if (args.length > 3) {
            datesArray = new String[args.length - 3];
            for (int i = 0; i < (args.length - 3); i++) {
                datesArray[i] = args[3 + i];
            }
        }
    }


    @Override
    public String getTaskDateToComplete() {
        return Arrays.toString(datesArray);
    }


    public void setDatesArray(String... args) {
        datesArray = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            datesArray[i] = args[i];
        }
    }

    @Override
    public String toString() {
        return "\nTask name: " + getTaskName() +
                "\nTask category: " + getTaskCategory() +
                "\nTask priority: " + getTaskPriority() +
                "\nTask array of completion dates: " + getTaskDateToComplete();
    }
}
