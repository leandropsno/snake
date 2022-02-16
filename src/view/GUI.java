package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements IGUI {

    private StartPanel panel = new StartPanel();

    public GUI() {
        super();
        this.setSize(700, 700);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.setTitle("Snake!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(panel);
        this.setLayout(null);
    }

    public boolean startPanelActive() {
        if (panel.isVisible()) {
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
