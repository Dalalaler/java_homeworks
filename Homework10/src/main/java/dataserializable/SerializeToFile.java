package dataserializable;

import datamanagment.DataReadUtil;
import datapattern.Task;
import exceptions.DataReadException;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializeToFile implements Serializable {
    private ArrayList<Task> Tasks;


    public void serializeFromJson() throws DataReadException {
        String fileName = ".\\src\\main\\resources\\data.json";
        this.Tasks = DataReadUtil.readFromFile(fileName);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".\\src\\main\\resources\\dataserialized")))
        {
            oos.writeObject(Tasks);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
