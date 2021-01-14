package swingui;

import datapattern.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class ShowTaskList{




    public static void addTaskLists(JPanel leftPanel, JPanel rightPanel, JFrame fatherFrame, ArrayList<Task> Tasks) {
        leftPanel.removeAll();
        leftPanel.setVisible(false);
        for (Task currentTask : Tasks) {
            JButton edit = new JButton("Просмтор и редактирование");
            JButton delete = new JButton("Удаление задачи");
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rightPanel.setVisible(false);
                    TaskDescAndChange.showTaskDesc(leftPanel, rightPanel, fatherFrame, currentTask, Tasks);
                    rightPanel.setVisible(true);
                    fatherFrame.setVisible(true);
                }
            });

            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Tasks.remove(currentTask);
                    leftPanel.removeAll();
                    leftPanel.setVisible(false);
                    ShowTaskList.addTaskLists(leftPanel, rightPanel, fatherFrame, Tasks);
                    leftPanel.setVisible(true);
                    rightPanel.setVisible(false);
                    rightPanel.removeAll();
                    rightPanel.setVisible(true);
                }
            });

            GridLayout layout = new GridLayout(2, 2, 5, 5);
            JPanel taskDescriptionPanel = new JPanel(layout);
            taskDescriptionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            taskDescriptionPanel.add(new JLabel(currentTask.getTaskName()));
            Calendar dateToComplete = currentTask.getDateToComplete();
            String dateString = "" + dateToComplete.get(Calendar.DAY_OF_MONTH) + "." +
                    (dateToComplete.get(Calendar.MONTH) + 1) +
                    "." + dateToComplete.get(Calendar.YEAR);
            taskDescriptionPanel.add(new JLabel(dateString));
            taskDescriptionPanel.add(edit);
            taskDescriptionPanel.add(delete);
            leftPanel.add(taskDescriptionPanel);
            leftPanel.setVisible(true);
        }

    }
}
