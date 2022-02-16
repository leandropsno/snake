package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {

    private JButton button = new JButton("Start Game");

    public StartPanel() {
        super();
        this.setBackground(Color.cyan);
        this.setBounds(250, 250, 200, 200 );
        button.setBounds(50, 50, 100, 100);
        this.add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button) {
            this.setVisible(false);
        }
    }
}
