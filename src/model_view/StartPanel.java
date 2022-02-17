package model_view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {

    private JButton button = new JButton("Start Game");
    private Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

    public StartPanel() {
        super();
        this.setBackground(Color.cyan);
        this.setLayout(null);
        this.setBounds(200, 250, 300, 100 );
        this.setBorder(border);
        initializeButton();
    }

    public void initializeButton() {
        button.setBounds(25, 25, 250, 50);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setFont(new Font("Atari Classic", Font.PLAIN, 20));
        button.setBorder(border);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button) {
            button.setEnabled(false);
            this.setVisible(false);
            System.out.println("The start panel is no longer visible.");
        }
    }
}
