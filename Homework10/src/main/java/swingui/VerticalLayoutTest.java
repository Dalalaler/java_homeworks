package swingui;

import javax.swing.*;

public class VerticalLayoutTest {
    public static void main(String[] args) {

        JFrame frame = new JFrame("VerticalLayoutTest");

        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contents = new JPanel(new VerticalLayout());

        final JScrollPane scrollPanel = new JScrollPane(contents, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPanel);
        frame.setVisible(true);
        frame.setContentPane(contents);


    }
}