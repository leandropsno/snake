package model_view;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel {

    private char content, direction;

    public CellPanel(int x, int y) {
        super();
        this.setBounds(x, y,20, 20);
        this.content = 'e';
        this.direction = 'n';
        this.setBackground(Color.black);
        this.setVisible(true);
    }

    public void setContent(char content) {
        this.content = content;
        updateColor();
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public char getContent() {
        return this.content;
    }

    public char getDirection() {
        return this.direction;
    }

    public void updateColor() {
        if (this.content == 'e') {
            this.setBackground(Color.cyan);
        }
        else {
            this.setBackground(Color.black);
        }
    }
}
