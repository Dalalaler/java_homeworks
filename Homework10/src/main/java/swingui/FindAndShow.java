package swingui;

import data.StringInputUtil;
import datapattern.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindAndShow extends JFrame {
    JPanel contents = new JPanel(new VerticalLayout());
    JPanel searchResults = new JPanel(new VerticalLayout());

    public FindAndShow(ArrayList<Task> Tasks) {
        super("Поиск задачи");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel taskNameLabel = new JLabel("Введите название задачи:");
        final JTextField taskName = new JTextField(50);

        JButton button = new JButton("Найти задачи по названию");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchResults.removeAll();
                String nameFilter = taskName.getText();
                int i = (int) Tasks.stream().filter(task -> (task.getTaskName()).contains(nameFilter)).count();

                if(i == 0){
                    searchResults.add(new JLabel("Поиск не дал результатов"));
                } else searchResults.add(new JLabel("РЕЗУЛЬТАТЫ ПОИСКА:"));

                Tasks.stream().filter(task -> (task.getTaskName()).contains(nameFilter)).
                        forEach(task -> searchResults.add(new JLabel(task.getTaskName())));



                setContentPane(new JScrollPane(searchResults, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
                contents.add(searchResults);
                setContentPane(new JScrollPane(contents, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
                setVisible(true);
            }
        });


        contents.add(taskNameLabel);
        contents.add(taskName);
        contents.add(button);
        add(contents);
        getContentPane().add(contents);
        setContentPane(new JScrollPane(contents, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));


        setSize(550, 500);
        setVisible(true);
    }
}
