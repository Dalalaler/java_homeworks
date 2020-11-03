package abstract_classes;

import interfaces.interface_basic;


public abstract class abstract_basic_class implements interface_basic {

    private String taskName = "Not setted";
    private String taskCategory = "Not setted";
    private String taskPriority = "Not setted";
    private String taskDateToComplete = "Not setted";




    public abstract_basic_class(String ... args){
        if (args.length > 0){
            setTaskName( args[0]);
        }
        if (args.length > 1){
            setTaskCategory(args[1]);
        }
        if (args.length > 2){
            setTaskPriority(args[2]);
        }
        if (args.length > 3){
            setTaskDateToComplete(args[3]);
        }
    }


    public void setTaskName(String setName){
        taskName = setName;
    }
    public void setTaskCategory(String setCategory){
        taskCategory = setCategory;
    }
    public void setTaskPriority(String setPriority){
        taskPriority = setPriority;
    }
    public void setTaskDateToComplete(String setDateToComplete){
        taskDateToComplete = setDateToComplete;
    }


    public String getTaskName(){
        return taskName;
    }
    public String getTaskCategory(){
        return taskCategory;
    }
    public String  getTaskPriority(){
        return taskPriority;
    }
    public String getTaskDateToComplete(){
        return taskDateToComplete;
    }


    public String toString(){
        return "\nTask name: " + getTaskName() +
                "\nTask category: " + getTaskCategory() +
                "\nTask priority: " + getTaskPriority()+
                "\nTask completion date: " + getTaskDateToComplete();
    }


}
