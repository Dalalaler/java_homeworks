package data_pattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import enums.category;
import enums.priority;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;


@JsonAutoDetect
public class task<T> implements Comparable<task> {
    private T id;
    private String taskName;
    private String taskDescription[];
    private Calendar dateToComplete;
    private double hoursToComplete;
    private priority taskPriority;
    private category taskCategory;





    public double getHoursToComplete() {
        return hoursToComplete;
    }

    public category getTaskCategory() {
        return taskCategory;
    }

    public String getTaskName() {
        return taskName;
    }

    public String[] getTaskDescription() {
        return taskDescription;
    }

    public priority getTaskPriority() {
        return taskPriority;
    }

    public T getId() {
        return id;
    }

    public Calendar getDateToComplete() {
        return dateToComplete;
    }

    public static class Builder<T> {
        private task newTask;

        public Builder() {
            newTask = new task();
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

        public Builder withTaskPriority(priority taskPriority) {
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
        public Builder withTaskCategory(category taskCategory){
            newTask.taskCategory = taskCategory;
            return this;
        }

        public task build() {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        task<?> test = (task<?>) o;
        return Double.compare(test.hoursToComplete, hoursToComplete) == 0 &&
                Objects.equals(taskName, test.taskName) &&
                Arrays.equals(taskDescription, test.taskDescription) &&
                taskPriority == test.taskPriority &&
                Objects.equals(id, test.id) &&
                Objects.equals(dateToComplete, test.dateToComplete);
    }


    @Override
    public int compareTo(task o) {
        return dateToComplete.compareTo(o.getDateToComplete());
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
