package swingui;

import data.StringInputUtil;
import datapattern.Task;
import enums.Category;
import enums.Priority;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TaskDescAndChange {

    public static void showTaskDesc(final JPanel leftPanel, final JPanel rightPanel, final JFrame fatherFrame,
                                    Task currentTask, ArrayList<Task> Tasks) {

        JLabel taskNameLabel = new JLabel("Введите имя задачи:");
        JTextField taskName = new JTextField(85);
        taskName.setText(currentTask.getTaskName());

        JLabel taskDescriptionLabel = new JLabel("Введите описание задачи:");
        JTextArea taskDescription = new JTextArea(10, 85);
        for (String currentString : currentTask.getTaskDescription()) {
            taskDescription.append(currentString + "\n");
        }


        JLabel taskCategoriesLabel = new JLabel("Выберите категорию задачи:");
        final String[] categories = {"NECESSARY", "OPTIONAL", "UNWANTED", "DESIRABLE"};
        JList categoryList = new JList(categories);
        switch (currentTask.getTaskCategory()) {
            case NECESSARY:
                categoryList.setSelectedIndex(0);
                break;
            case OPTIONAL:
                categoryList.setSelectedIndex(1);
                break;
            case UNWANTED:
                categoryList.setSelectedIndex(2);
                break;
            case DESIRABLE:
                categoryList.setSelectedIndex(3);
                break;
        }


        JLabel taskPrioritiesLabel = new JLabel("Выберите приоритет задачи:");
        final String[] priorities = {"LOW", "MIDDLE", "HIGH"};
        JList prioritiesList = new JList(priorities);
        switch (currentTask.getTaskPriority()) {
            case LOW:
                prioritiesList.setSelectedIndex(0);
                break;
            case MIDDLE:
                prioritiesList.setSelectedIndex(1);
                break;
            case HIGH:
                prioritiesList.setSelectedIndex(2);
                break;
        }


        JLabel taskDateToCompleteLabel = new JLabel("Введите дату выполнения задачи(dd.MM.yyyy):");
        JTextField taskDateToComplete = new JTextField(85);
        Calendar dateToComplete = currentTask.getDateToComplete();
        String dateString = "" + dateToComplete.get(Calendar.DAY_OF_MONTH) + "." +
                (dateToComplete.get(Calendar.MONTH) + 1) +
                "." + dateToComplete.get(Calendar.YEAR);

        taskDateToComplete.setText(dateString);

        JLabel taskHoursToCompleteLabel = new JLabel("Введите количество часов на выполнение задачи:");
        JTextField taskHoursToComplete = new JTextField(85);
        taskHoursToComplete.setText("" + currentTask.getHoursToComplete());

        JButton button = new JButton("Изменить и сохранить задачу");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentTask.setTaskName(taskName.getText());
                String[] lines = taskDescription.getText().split("\n");
                currentTask.setTaskDescription(lines);

                switch (categoryList.getSelectedIndex()) {
                    case 0:
                        currentTask.setTaskCategory(Category.NECESSARY);
                        break;
                    case 1:
                        currentTask.setTaskCategory(Category.OPTIONAL);
                        break;
                    case 2:
                        currentTask.setTaskCategory(Category.UNWANTED);
                        break;
                    case 3:
                        currentTask.setTaskCategory(Category.DESIRABLE);
                        break;
                }

                switch (prioritiesList.getSelectedIndex()) {
                    case 0:
                        currentTask.setTaskPriority(Priority.LOW);
                        break;
                    case 1:
                        currentTask.setTaskPriority(Priority.MIDDLE);
                        break;
                    case 2:
                        currentTask.setTaskPriority(Priority.HIGH);
                        break;
                }

                String bufferString = taskDateToComplete.getText();
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                Calendar taskDateToComplete  = Calendar.getInstance();
                try {
                    taskDateToComplete.setTime(df.parse(bufferString));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                currentTask.setDateToComplete(taskDateToComplete);

                currentTask.setHoursToComplete(Double.parseDouble(taskHoursToComplete.getText()));
                leftPanel.removeAll();
                leftPanel.setVisible(false);
                ShowTaskList.addTaskLists(leftPanel, rightPanel, fatherFrame, Tasks);
                leftPanel.setVisible(true);
                JOptionPane.showMessageDialog(fatherFrame,
                        "Задача успешно изменена и сохранена!");
            }
        });


        rightPanel.removeAll();
        rightPanel.add(taskNameLabel);
        rightPanel.add(taskName);
        rightPanel.add(taskDescriptionLabel);
        rightPanel.add(taskDescription);
        JScrollPane jp = new JScrollPane(taskDescription);
        rightPanel.add(jp, BorderLayout.CENTER);
        rightPanel.add(taskCategoriesLabel);
        rightPanel.add(taskCategoriesLabel);
        rightPanel.add(categoryList);
        rightPanel.add(taskPrioritiesLabel);
        rightPanel.add(prioritiesList);
        rightPanel.add(taskDateToCompleteLabel);
        rightPanel.add(taskDateToComplete);
        rightPanel.add(taskHoursToCompleteLabel);
        rightPanel.add(taskHoursToComplete);
        rightPanel.add(button);
        rightPanel.setVisible(true);
    }


}
