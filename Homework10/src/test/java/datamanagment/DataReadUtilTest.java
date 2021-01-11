package datamanagment;

import exceptions.DataReadException;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataReadUtilTest {

    @Test(expected = DataReadException.class)
    public void readFromFile() throws DataReadException {
        String fileName = ".\\src\\main\\resources\\data.json";
        DataReadUtil.readFromFile(fileName);
    }
}