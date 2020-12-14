package datapattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import enums.Category;
import enums.Priority;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;


@JsonAutoDetect
public class Task<T> implements Comparable<Task> {
    private T id;
    private String taskName;
    private String taskDescription[];
    private Calendar dateToComplete;
    private double hoursToComplete;
    private Priority taskPriority;
    private Category taskCategory;





    public double getHoursToComplete() {
        return hoursToComplete;
    }

    public Category getTaskCategory() {
        return taskCategory;
    }

    public String getTaskName() {
        return taskName;
    }

    public String[] getTaskDescription() {
        return taskDescription;
    }

    public Priority getTaskPriority() {
        return taskPriority;
    }

    public T getId() {
        return id;
    }

    public Calendar getDateToComplete() {
        return dateToComplete;
    }

    public static class Builder<T> {
        private Task newTask;

        public Builder() {
            newTask = new Task();
        }

        public Builder withTaskName(String taskName) {
            newTask.taskName = taskName;
            return this;
        }

        public Builder withHoursToComplete(double hoursToComplete) {
            newTask.hoursToComplete = hoursToComplete;
            return this;
        }

        public Builder withTaskDescription(String[] taskDescription) {
            newTask.taskDescription = taskDescription;
            return this;
        }

        public Builder withTaskPriority(Priority taskPriority) {
            newTask.taskPriority = taskPriority;
            return this;
        }

        public Builder withId(T id) {
            newTask.id = id;
            return this;
        }

        public Builder withDateToComplete(Calendar dateToComplete) {
            newTask.dateToComplete = dateToComplete;
            return this;
        }
        public Builder withTaskCategory(Category taskCategory){
            newTask.taskCategory = taskCategory;
            return this;
        }

        public Task build() {
            return newTask;
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(taskName, hoursToComplete, taskPriority, id, dateToComplete);
        result = 31 * result + Arrays.hashCode(taskDescription);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        Task<?> test = (Task<?>) o;



        return this.taskName.equals(test.getTaskName());

//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Task<?> test = (Task<?>) o;
//        return Double.compare(test.hoursToComplete, hoursToComplete) == 0 &&
//                Objects.equals(taskName, test.taskName) &&
//                Arrays.equals(taskDescription, test.taskDescription) &&
//                taskPriority == test.taskPriority &&
//                Objects.equals(dateToComplete, test.dateToComplete);
    }


    @Override
    public int compareTo(Task o) {
        return dateToComplete.compareTo(o.dateToComplete);
    }

    @Override
    public String toString() {
        return "task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription=" + Arrays.toString(taskDescription) +
                ", taskCategory=" + taskCategory +
                ", taskPriority=" + taskPriority +
                ", hoursToComplete=" + hoursToComplete +
                ", dateToComplete=" + dateToComplete.getTime() +
                '}';
    }
}
