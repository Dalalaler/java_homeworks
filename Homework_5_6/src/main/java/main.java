import data_pattern.task;
import data_managment.*;
import data.*;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<task> tasks = new ArrayList<>();
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

            menuNumber = intinput.get();

            switch (menuNumber) {
                case 1:
                    dataFromConsole.getData();
                    break;
                case 2:
                    dataToGenerate.writeReadyData();
                    break;
                case 3:
                    read.readFromFile(fileName);
                    break;
                case 4:
                    read.readFromFile(sortedFileName);
                    break;
                case 5:
                    tasks = read.readFromFile(fileName);
                    write.writeSortedInFile(sortedFileName, tasks);
                    break;
                default:
                    System.out.println("Wrong paragraph, choose again.");
            }
        } while (menuNumber != 6);

    }
}
