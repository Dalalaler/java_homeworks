package swingui;

import datamanagment.DataReadUtil;
import datamanagment.DataWriteUtil;
import datapattern.Task;
import datasteams.DataStreamUtil;
import exceptions.DataReadException;
import exceptions.DataWriteException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MainWindow extends JFrame {
    private static ArrayList<Task> Tasks = new ArrayList<>();
    private int dividerMain = 450;
    private  JFileChooser fileChooser   = null;
    static String fileName;
    private final String[][] FILTERS = {{"json", "Файлы json (*.json)"},
            {"txt" , "Файлы txt (*.txt)"}};
    JPanel leftPanel;
    JPanel rightPanel;

    public static void setFilePath(String filePath){
        fileName = filePath;
    }


    private JMenu createFileMenu()
    {
        // Создание выпадающего меню
        JMenu file = new JMenu("Файл");
        // Пункт меню "Открыть" с изображением
        JMenuItem open = new JMenuItem("Открыть");
        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem close = new JMenuItem("Закрыть");

        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(close);


        open.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new JFileChooserTest();


            }
        });


        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file = new File(fileName);
                file.delete();
                for (Task currentTask: Tasks) {
                    try {
                        DataWriteUtil.writeInFile(fileName,currentTask);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (DataWriteException dataWriteException) {
                        dataWriteException.printStackTrace();
                    }
                }


                JOptionPane.showMessageDialog(MainWindow.this,
                        "Задачи успешно сохранены!");
            }
        });

        close.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                System. exit(0);
            }
        });

        return file;
    }


    private JMenu createTaskMenu()
    {
        // Создание выпадающего меню
        JMenu file = new JMenu("Задача");
        // Пункт меню "Открыть" с изображением
        JMenuItem create = new JMenuItem("Создать");
        JMenuItem sort = new JMenuItem("Сортировать");
        JMenuItem find = new JMenuItem("Поиск");

        file.add(create);
        // Добавление разделителя
        file.addSeparator();

        file.add(sort);
        // Добавление разделителя
        file.addSeparator();

        file.add(find);
        // Добавление разделителя
        file.addSeparator();

        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreateTask(leftPanel, rightPanel, MainWindow.this, Tasks);
            }
        });

        sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(Tasks);
                ShowTaskList.addTaskLists(leftPanel, rightPanel, MainWindow.this, Tasks);
                JOptionPane.showMessageDialog(MainWindow.this,
                        "Задачи успешно остортированы и сохранены!");
            }
        });

        find.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FindAndShow(Tasks);
            }
        });

        return file;
    }



    public MainWindow(String newFile) throws DataReadException {
        super("Планировщик задач");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fileName = newFile;
        Tasks = DataReadUtil.readFromFile(fileName);

       if(fileName != "default") {  //Меню
            JMenuBar menuBar = new JMenuBar();
            // Добавление в главное меню выпадающих пунктов меню
            menuBar.add(createFileMenu());
            menuBar.add(createTaskMenu());

            // Подключаем меню к интерфейсу приложения
            setJMenuBar(menuBar);

            // Левая панель
            leftPanel = new JPanel(new VerticalLayout());
            leftPanel.add(new JLabel("СПИСОК ЗАДАЧ"));


            leftPanel.setBackground(Color.lightGray);

            // Правая панель
            rightPanel = new JPanel(new VerticalLayout());


            rightPanel.setBackground(Color.lightGray);
            rightPanel.setVisible(true);

            ShowTaskList.addTaskLists(leftPanel, rightPanel, this, Tasks);


            // Создание разделяемой панели
            final JSplitPane splitHorizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
            splitHorizontal.setOneTouchExpandable(true);
            // Размер разделяемой панели
            splitHorizontal.setDividerSize(14);
            // Положение разделяемой панели
            splitHorizontal.setDividerLocation(dividerMain);
            // Текстовая метка для главной панели
            splitHorizontal.setLeftComponent(new JScrollPane(leftPanel));
            splitHorizontal.setRightComponent(new JScrollPane(rightPanel));
            // Размещение панели в интерфейсе и вывод окна на экран
            getContentPane().add(splitHorizontal);
            setSize(1366, 768);
            setVisible(true);
        }


    }

    public static void main(String[] args) throws DataReadException {
        new JFileChooserTest();
    }
}