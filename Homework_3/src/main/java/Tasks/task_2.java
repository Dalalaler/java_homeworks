package Tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task_2 {


    public static void get() {
        String simpleString = task_1.getString();
        Pattern pattern = Pattern.compile(" [0-9][0-9] ");
        Matcher matcher = pattern.matcher(simpleString);
        String changedString;
        changedString = matcher.replaceAll(" -1 ");
        matcher = pattern.matcher(changedString);
        changedString = matcher.replaceAll(" -1 ");//program willn't replace numbers that goes more than two
        //times in the row without this code
        System.out.println("Changed simple string: \n" + changedString);

    }

}
