package datasteams;

import data.StringInputUtil;
import datapattern.Task;

import java.util.ArrayList;


public class DataStreamUtil {
    static ArrayList<Task> tasks = new ArrayList<>();

    public DataStreamUtil(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public static void dataSort(){
        tasks.stream().sorted().forEach(s->System.out.println(s));
    }

    public static void dataFilter(){
        System.out.println("Enter the name of tasks.");

        String nameFilter;
        nameFilter = StringInputUtil.get();

        System.out.println("Found matches: ");
        tasks.stream().filter(task -> (task.getTaskName()).contains(nameFilter)).forEach(task -> System.out.println(task.getTaskName()));
    }

    public static void dataWithoutRepeats(){
        tasks.stream().distinct().forEach(task -> System.out.println(task.getTaskName()));

    }

    public static void dataNames(){
        tasks.stream().map(task -> task.getTaskName()).forEach(tasks -> System.out.println(tasks));

    }


    public static void dataCheckTaskLength(){
        boolean any = tasks.stream().anyMatch(task -> (task.getTaskName()).length() <= 1);

        if (any){
            System.out.println("The Tasks list contains names with length less than one character");
        } else System.out.println("All of the task names are longer than one character");

    }

}
