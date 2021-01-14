package datamanagment;

import com.fasterxml.jackson.databind.ObjectMapper;
import datapattern.Task;
import exceptions.DataWriteException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

public class DataWriteUtil {


    public static void writeInFile(String fileName, Task taskToWrite) throws IOException, DataWriteException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, taskToWrite);
        String jsonString = writer.toString();
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(jsonString + '\n');
        } catch (IOException exc) {
            throw new DataWriteException();
        }
    }

    public static void writeAllTasksInFile(String fileName, ArrayList<Task> tasksToWrite) throws IOException, DataWriteException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();

        for (Task currentTask : tasksToWrite) {
            mapper.writeValue(writer, currentTask);
            String jsonString = writer.toString();
            try (FileWriter fw = new FileWriter(fileName, true)) {
                fw.write(jsonString + '\n');
            } catch (IOException exc) {
                throw new DataWriteException();
            }
        }


    }


    public static void writeSortedInFile(String fileName, ArrayList<Task> tasksToWrite) throws IOException, DataWriteException {
        File file = new File(fileName);
        file.delete();
        Collections.sort(tasksToWrite);
        for (Task currentTask : tasksToWrite) {
            System.out.println(currentTask);
            writeInFile(fileName, currentTask);
        }
    }

}
