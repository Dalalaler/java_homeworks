package exceptions;

public class DataReadException extends Exception {
    public String toString() {
    return "Error while reading, check for source file";
    }
}
