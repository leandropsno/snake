package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }

    public void showStartPanel() {
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
