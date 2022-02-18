package model_view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CellPanel extends JPanel implements KeyListener {

    private char content, direction, previousDirection;
    private Border border = BorderFactory.createLineBorder(Color.black);

    public CellPanel(int x, int y) {
        super();
        this.setBounds(x, y,20, 20);
        this.content = 'e';
        this.direction = 'n';
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setBorder(border);
    }

    public void setContent(char content) {
        this.content = content;
        updateColor();
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void setPreviousDirection(char direction) {
        this.previousDirection = direction;
    }

    public char getContent() {
        return this.content;
    }

    public char getDirection() {
        return this.direction;
    }

    public char getPreviousDirection() {return this.previousDirection; }

    public void updateColor() {
        if (this.content == 'e') {
            this.setBackground(Color.black);
        }
        else {
            this.setBackground(Color.cyan);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 37: setDirection('l');
                break;
            case 38: setDirection('u');
                break;
            case 39: setDirection('r');
                break;
            case 40: setDirection('d');
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

}
