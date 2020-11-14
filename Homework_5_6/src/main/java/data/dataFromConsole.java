package data;

import data_managment.write;
import data_pattern.task;
import enums.category;
import enums.priority;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class dataFromConsole {


    public static void getData() throws ParseException, IOException {


        System.out.println("\nEnter the name of task: ");
        String taskName = stringinput.get();

        System.out.println("\nEnter a few strings of description of task. Enter via enter, write STOP to stop. ");
        String bufferString = "";
        ArrayList<String> arrayOfDescription = new ArrayList<String>();

        do {
            bufferString = stringinput.get();
            arrayOfDescription.add(bufferString);
            System.out.println("BufferString: " + bufferString);
        } while (bufferString.compareTo("STOP") != 0);
        String[] taskDescription = new String[arrayOfDescription.size()];
        taskDescription = arrayOfDescription.toArray(taskDescription);

        System.out.println("\nEnter the category of task(NECESSARY, OPTIONAL, UNWANTED, DESIRABLE) ");
        category taskCategory = category.valueOf(stringinput.get());

        System.out.println("\nEnter the priority of task(LOW, MIDDLE, HIGH): ");
        priority taskPriority = priority.valueOf(stringinput.get());


        System.out.println("\nEnter the date of delivery  of task in format dd.MM.yyyy: ");
        bufferString = stringinput.get();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar taskDateToComplete  = Calendar.getInstance();
        taskDateToComplete.setTime(df.parse(bufferString));

        System.out.println("\nEnter how much time the task would last: ");
        Integer taskHoursToComplete = intinput.get();



        task<Integer> task3 = new task.Builder()
                .withId((int) (Math.random() * 10000000))
                .withTaskName(taskName)
                .withTaskDescription(taskDescription)
                .withTaskCategory(taskCategory)
                .withTaskPriority(taskPriority)
                .withDateToComplete(taskDateToComplete)
                .withHoursToComplete(taskHoursToComplete)
                .build();

        write.writeInFile(".\\src\\main\\resources\\data.json", task3);


    }


}
