import datapattern.Task;
import datamanagment.*;
import data.*;
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
        int menuNumber;

        do {
            System.out.println("\nChoose one of the menu paragraphs:\n" +
                    "1. Create new task and write it to data.json\n" +
                    "2. Write ready unsorted data to data.json\n" +
                    "3. Read unsorted data from data.json\n" +
                    "4. Read sorted data from sorted_data.json\n" +
                    "5. Sort data from data.json and write it to sorted_data.json\n" +
                    "6. Exit\n");

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
                    Tasks = DataReadUtil.readFromFile(fileName);
                    DataWriteUtil.writeSortedInFile(sortedFileName, Tasks);
                    break;
                default:
                    System.out.println("Wrong paragraph, choose again.");
            }
        } while (menuNumber != 6);

    }
}
