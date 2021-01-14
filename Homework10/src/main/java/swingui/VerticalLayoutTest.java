package swingui;

import javax.swing.*;

public class VerticalLayoutTest {
    public static void main(String[] args) {
        // Создаем окно
        JFrame frame = new JFrame("VerticalLayoutTest");
        // Определяем размеры
        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Создаем панель с менеджером вертикального расположения компонентов
        JPanel contents = new JPanel(new VerticalLayout());

        final JScrollPane scrollPanel = new JScrollPane(contents,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPanel);
        frame.setVisible(true);
        frame.setContentPane(contents);


        // Добавим кнопки и текстовое поле в панель
//        AddButtons.add(frame, contents, 40);



    }
}