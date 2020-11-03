package interfaces;

public interface interface_basic {
    String  taskName = "";
    String  taskCategory = "";
    String  taskPriority = "";
    String taskDateToComplete = "";


    void setTaskName(String Name);
    void setTaskCategory(String Category);
    void setTaskPriority(String Priority);
    void setTaskDateToComplete(String Date);


    String getTaskName();
    String getTaskCategory();
    String  getTaskPriority();
    String getTaskDateToComplete();

}
