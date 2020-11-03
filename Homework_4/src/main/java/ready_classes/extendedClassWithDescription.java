package ready_classes;

public class extendedClassWithDescription extends superClassWithoutDescription {

    private String taskDescription = "Not setted";

    extendedClassWithDescription(String taskDescription, String ... args){
            super(args);
            this.taskDescription = taskDescription;

    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public String toString() {
        return  super.toString() + "\nTask description: " + getTaskDescription();
    }
}
