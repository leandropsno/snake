package model_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GUI extends JFrame implements IGUI {

    private static final long serialVersionUID = 1L;
    private StartPanel panel = new StartPanel();
    private CellPanel[][] grid = new CellPanel[35][35];
    private final Random random = new Random();

    public GUI() {
        super();
        this.setSize(700, 750);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.setTitle("Snake!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(panel);
        this.setLayout(null);
    }

    public boolean startPanelActive() {
        return panel.isVisible();
    }

    public void initializeGrid() {
        int y = 0;
        for (int i = 0; i < 35; i++) {
            int x = 0;
            for (int j = 0; j < 35; j++) {
                grid[i][j] = new CellPanel(x, y);
                this.add(grid[i][j]);
                x += 20;
            }
            y += 20;
        }
    }

    public void initializeSnake() throws InterruptedException {
        setCellContent(1, 1, 't');
        setCellDirection(1, 1, 'r');
        setCellContent(1, 2, 'b');
        setCellDirection(1, 2, 'r');
        setCellContent(1, 3, 'h');
        setCellDirection(1, 3, 'r');
        this.remove(panel);
        while (true) {
            generateFood();
        }
    }

    public void setCellContent(int i, int j, char content) {
        grid[i][j].setContent(content);
    }

    public void setCellDirection(int i, int j, char direction) {
        grid[i][j].setDirection(direction);
    }

    public char getCellContent(int i, int j) {
        return grid[i][j].getContent();
    }

    public char getCellDirection(int i, int j) {
        return grid[i][j].getDirection();
    }

    public void dispose() {
        super.dispose();
    }

    public boolean updateSnake() {
        return true;
    }

    public void generateFood() throws InterruptedException {
        int i = 0, j = 0;
        boolean occupiedCell = true;
        while (occupiedCell) {
            i = random.nextInt(35);
            j = random.nextInt(35);
            if (getCellContent(i, j) == 'e') {
                occupiedCell = false;
            }
        }
        setCellContent(i, j, 'f');
        Thread.sleep(1000);
        setCellContent(i, j, 'e');
    }
}
