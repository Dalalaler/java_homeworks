package data_managment;

import com.fasterxml.jackson.databind.ObjectMapper;
import data_pattern.task;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

public class write {


    public static void writeInFile(String fileName, task taskToWrite) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, taskToWrite);
        String jsonString = writer.toString();
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(jsonString + '\n');
        } catch (IOException exc) {
            System.out.println("Input-output error: " + exc);
        }
    }

    public static void writeSortedInFile(String fileName, ArrayList<task> tasksToWrite) throws IOException {
        File file = new File(fileName);
        file.delete();
        Collections.sort(tasksToWrite);
        System.out.println("\n_______________________\n" + "Sorted by a date Tasks\n" + "Writed in sorted_data.json\n"
                + "_______________________\n");
        for (task currentTask : tasksToWrite) {
            System.out.println(currentTask);
            writeInFile(fileName, currentTask);
        }
    }

}
