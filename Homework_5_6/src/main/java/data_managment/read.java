package data_managment;

import com.fasterxml.jackson.databind.ObjectMapper;
import data_pattern.task;
import enums.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class read {



    public static ArrayList readFromFile(String fileName) {
        String jsonString;
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((jsonString = br.readLine()) != null) {
                StringReader reader = new StringReader(jsonString);
                task taskToRead = mapper.readValue(reader, task.class);
                tasks.add(taskToRead);
            }
        } catch (IOException exc) {
            System.out.println("Input-output error: " + exc);
        }

        System.out.println("\n_______________________\n" + "Data that read from data.json\n" + "_______________________\n");
        for (task currentTask : tasks) {
            System.out.println(currentTask);
        }
        return tasks;

    }
}
