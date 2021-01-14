package swingui;

import javax.swing.*;

public class AddButtons {
    public static void add(JPanel jPanel, int count) {
        for (int i = 0; i < count; i++) {
            jPanel.add(new JButton("Button #" + i));
        }

    }
}
