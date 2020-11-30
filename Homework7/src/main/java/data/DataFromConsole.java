package data;

import datamanagment.DataWriteUtil;
import datapattern.Task;
import enums.Category;
import enums.Priority;
import exceptions.DataWriteException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DataFromConsole {


    public static void getData() throws ParseException, IOException, DataWriteException {


        System.out.println("\nEnter the name of task: ");
        String taskName = StringInputUtil.get();

        System.out.println("\nEnter a few strings of description of task. Enter via enter, write STOP to stop. ");
        String bufferString = "";
        ArrayList<String> arrayOfDescription = new ArrayList<String>();

        do {
            bufferString = StringInputUtil.get();
            arrayOfDescription.add(bufferString);
            System.out.println("BufferString: " + bufferString);
        } while (bufferString.compareTo("STOP") != 0);
        String[] taskDescription = new String[arrayOfDescription.size()];
        taskDescription = arrayOfDescription.toArray(taskDescription);

        System.out.println("\nEnter the category of task(NECESSARY, OPTIONAL, UNWANTED, DESIRABLE) ");
        Category taskCategory = Category.valueOf(StringInputUtil.get());

        System.out.println("\nEnter the priority of task(LOW, MIDDLE, HIGH): ");
        Priority taskPriority = Priority.valueOf(StringInputUtil.get());


        System.out.println("\nEnter the date of delivery  of task in format dd.MM.yyyy: ");
        bufferString = StringInputUtil.get();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar taskDateToComplete  = Calendar.getInstance();
        taskDateToComplete.setTime(df.parse(bufferString));

        System.out.println("\nEnter how much time the task would last: ");
        Integer taskHoursToComplete = IntInputUtil.get();



        Task<Integer> task3 = new Task.Builder()
                .withId((int) (Math.random() * 10000000))
                .withTaskName(taskName)
                .withTaskDescription(taskDescription)
                .withTaskCategory(taskCategory)
                .withTaskPriority(taskPriority)
                .withDateToComplete(taskDateToComplete)
                .withHoursToComplete(taskHoursToComplete)
                .build();

        DataWriteUtil.writeInFile(".\\src\\main\\resources\\data.json", task3);


    }


}
