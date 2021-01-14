package swingui;



import datapattern.Task;
import enums.Category;
import enums.Priority;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CreateTask extends JFrame {



    public CreateTask(final JPanel leftPanel, final JPanel rightPanel, final JFrame fatherFrame,
                       ArrayList<Task> Tasks) {
        super("Создание задачи");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel taskNameLabel = new JLabel("Введите имя задачи:");
        JTextField taskName = new JTextField(50);

        JLabel taskDescriptionLabel = new JLabel("Введите описание задачи:");
        JTextArea taskDescription = new JTextArea(5, 50);

        JLabel taskCategoriesLabel = new JLabel("Выберите категорию задачи:");
        final String[] categories = {"NECESSARY", "OPTIONAL", "UNWANTED", "DESIRABLE"};
        JList categoryList = new JList(categories);

        JLabel taskPrioritiesLabel = new JLabel("Выберите приоритет задачи:");
        final String[] priorities = {"LOW", "MIDDLE", "HIGH"};
        JList prioritiesList = new JList(priorities);

        JLabel taskDateToCompleteLabel = new JLabel("Введите дату выполнения задачи(dd.MM.yyyy):");
        JTextField taskDateToComplete = new JTextField(50);

        JLabel taskHoursToCompleteLabel = new JLabel("Введите количество часов на выполнение задачи:");
        JTextField taskHoursToComplete = new JTextField(50);

        JButton button = new JButton("Создать и сохранить задачу");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Task newTask = new Task();

                newTask.setTaskName(taskName.getText());
                String[] lines = taskDescription.getText().split("\n");
                newTask.setTaskDescription(lines);

                switch (categoryList.getSelectedIndex()) {
                    case 0:
                        newTask.setTaskCategory(Category.NECESSARY);
                        break;
                    case 1:
                        newTask.setTaskCategory(Category.OPTIONAL);
                        break;
                    case 2:
                        newTask.setTaskCategory(Category.UNWANTED);
                        break;
                    case 3:
                        newTask.setTaskCategory(Category.DESIRABLE);
                        break;
                }

                switch (prioritiesList.getSelectedIndex()) {
                    case 0:
                        newTask.setTaskPriority(Priority.LOW);
                        break;
                    case 1:
                        newTask.setTaskPriority(Priority.MIDDLE);
                        break;
                    case 2:
                        newTask.setTaskPriority(Priority.HIGH);
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
                newTask.setDateToComplete(taskDateToComplete);

                newTask.setHoursToComplete(Double.parseDouble(taskHoursToComplete.getText()));

                Tasks.add(newTask);


                leftPanel.removeAll();
                leftPanel.setVisible(false);
                ShowTaskList.addTaskLists(leftPanel, rightPanel, fatherFrame, Tasks);
                leftPanel.setVisible(true);

                JOptionPane.showMessageDialog(CreateTask.this,
                        "Задача успешно создана и сохранена!");

            }
        });


        JPanel contents = new JPanel(new VerticalLayout());
        contents.add(taskNameLabel);
        contents.add(taskName);
        contents.add(taskDescriptionLabel);
        contents.add(taskDescription);
        contents.add(taskCategoriesLabel);
        contents.add(taskCategoriesLabel);
        contents.add(categoryList);
        contents.add(taskPrioritiesLabel);
        contents.add(prioritiesList);
        contents.add(taskDateToCompleteLabel);
        contents.add(taskDateToComplete);
        contents.add(taskHoursToCompleteLabel);
        contents.add(taskHoursToComplete);
        contents.add(button);

        setContentPane(new JScrollPane(contents, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));

        setSize(550, 500);
        setVisible(true);
    }

    public static void main(String[] args) {

    }
}
