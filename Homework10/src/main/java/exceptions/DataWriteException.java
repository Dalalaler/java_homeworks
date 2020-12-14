package exceptions;

public class DataWriteException extends Exception {
    public String toString() {
        return "Error while writing, check for source file";
    }
}
