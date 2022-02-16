package model_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements IGUI {

    private StartPanel panel = new StartPanel();
    private CellPanel[][] grid = new CellPanel[35][35];

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

    public void initializeSnake() {
        grid[1][1].setContent('t');
        grid[1][1].setDirection('r');
        grid[1][2].setContent('b');
        grid[1][2].setDirection('r');
        grid[1][3].setContent('h');
        grid[1][3].setDirection('r');
    }

    public void setCellContent(int i, int j, char content) {
        grid[i][j].setContent(content);
    }

    public void setCellDirection(int i, int j, char direction) {
        grid[i][j].setDirection(direction);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
