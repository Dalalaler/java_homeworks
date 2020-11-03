package ready_classes;
import abstract_classes.abstract_basic_class;

public class superClassWithoutDescription extends abstract_basic_class {



    superClassWithoutDescription(String ... args){
        super(args);
    }




    @Override
    public void setTaskName(String setName) {
        super.setTaskName(setName);
    }

    @Override
    public void setTaskCategory(String setCategory) {
        super.setTaskCategory(setCategory);
    }

    @Override
    public void setTaskPriority(String setPriority) {
        super.setTaskPriority(setPriority);
    }

    @Override
    public void setTaskDateToComplete(String setDateToComplete) {
        super.setTaskDateToComplete(setDateToComplete);
    }

    @Override
    public String getTaskName() {
        return super.getTaskName();
    }

    @Override
    public String getTaskCategory() {
        return super.getTaskCategory();
    }

    @Override
    public String getTaskPriority() {
        return super.getTaskPriority();
    }

    @Override
    public String getTaskDateToComplete() {
        return super.getTaskDateToComplete();
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
