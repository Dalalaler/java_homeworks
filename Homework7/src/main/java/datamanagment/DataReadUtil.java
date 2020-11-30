package datamanagment;

import com.fasterxml.jackson.databind.ObjectMapper;
import datapattern.Task;
import exceptions.DataReadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class DataReadUtil {



    public static ArrayList readFromFile(String fileName) throws DataReadException {
        String jsonString;
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Task> Tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((jsonString = br.readLine()) != null) {
                StringReader reader = new StringReader(jsonString);
                Task taskToRead = mapper.readValue(reader, Task.class);
                Tasks.add(taskToRead);
            }
        } catch (IOException exc) {
            throw new DataReadException();
        }

        System.out.println("\n_______________________\n" + "Data that read from data.json\n" + "_______________________\n");
        for (Task currentTask : Tasks) {
            System.out.println(currentTask);
        }
        return Tasks;

    }
}
