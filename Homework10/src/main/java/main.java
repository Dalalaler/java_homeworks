import datapattern.Task;
import datamanagment.*;
import data.*;
import dataserializable.SerializeToFile;
import datasteams.DataStreamUtil;
import exceptions.DataReadException;
import exceptions.DataWriteException;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException, ParseException, DataWriteException, DataReadException {
        ArrayList<Task> Tasks = new ArrayList<>();
        String fileName = ".\\src\\main\\resources\\data.json";
        String sortedFileName = ".\\src\\main\\resources\\sorted_data.json";
        Tasks = DataReadUtil.readFromFile(fileName);
        DataStreamUtil tasksStream = new DataStreamUtil(Tasks);
        int menuNumber;

        do {
            System.out.println("\nChoose one of the menu paragraphs:\n" +
                    "1. Create new task and write it to data.json\n" +
                    "2. Write ready unsorted data to data.json\n" +
                    "3. Read unsorted data from data.json\n" +
                    "4. Read sorted data from sorted_data.json\n" +
                    "5. Sort data from data.json and write it to sorted_data.json\n" +
                    "6. Sort tasks with stream API\n" +
                    "7. Filter tasks by name with stream api\n" +
                    "8. Leave tasks with only unique names\n" +
                    "9. Print tasks names with stream API\n" +
                    "10. Check tasks names length with stream API\n" +
                    "11. Serialize data from json to file\n" +
                    "12. Exit\n");

            menuNumber = IntInputUtil.get();

            switch (menuNumber) {
                case 1:
                    DataFromConsole.getData();
                    break;
                case 2:
                    DataToGenerate.writeReadyData();
                    break;
                case 3:
                    DataReadUtil.readFromFile(fileName);
                    break;
                case 4:
                    DataReadUtil.readFromFile(sortedFileName);
                    break;
                case 5:
                    DataWriteUtil.writeSortedInFile(sortedFileName, Tasks);
                    break;
                case 6:
                    DataStreamUtil.dataSort();
                    break;
                case 7:
                    DataStreamUtil.dataFilter();
                    break;
                case 8:
                    DataStreamUtil.dataWithoutRepeats();
                    break;
                case 9:
                    DataStreamUtil.dataNames();
                    break;
                case 10:
                    DataStreamUtil.dataCheckTaskLength();
                    break;
                case 11:
                    SerializeToFile jsonToSerialize = new SerializeToFile();
                    jsonToSerialize.serializeFromJson();
                    break;
                default:
                    System.out.println("Wrong paragraph, choose again.");
            }
        } while (menuNumber != 12);

    }
}
