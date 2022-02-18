package model_view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GUI extends JFrame implements IGUI {

    private static final long serialVersionUID = 1L;
    private final StartPanel panel = new StartPanel();
    private final CellPanel[][] grid = new CellPanel[35][35];
    private final Random random = new Random();
    private int headJ, headI;

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
        this.remove(panel);
        setCellContent(1, 1, 't');
        setCellDirection(1, 1, 'r');
        setCellPreviousDirection(1, 1, 'r');
        setCellContent(1, 2, 'b');
        setCellDirection(1, 2, 'r');
        setCellPreviousDirection(1, 2, 'r');
        setCellContent(1, 3, 'h');
        setCellDirection(1, 3, 'r');
        setCellPreviousDirection(1, 3, 'r');
        this.headJ = 3;
        this.headI = 1;
    }

    public void setCellContent(int i, int j, char content) {grid[i][j].setContent(content); }

    public void setCellDirection(int i, int j, char direction) {
        grid[i][j].setDirection(direction);
    }

    public void setCellPreviousDirection(int i, int j, char direction) {
        grid[i][j].setPreviousDirection(direction);
    }

    public char getCellContent(int i, int j) {
        return grid[i][j].getContent();
    }

    public char getCellDirection(int i, int j) {
        return grid[i][j].getDirection();
    }

    public char getCellPreviousDirection(int i, int j) { return grid[i][j].getPreviousDirection(); }

    public int getHeadJ() { return this.headJ; }

    public int getHeadI() { return this.headI; }

    public void dispose() {
        super.dispose();
    }

    public boolean updateSnakeCell(int i, int j) {

        // Calculates new cell coordinates based on its direction.
        int incrementI = 0;
        int incrementJ = 0;
        char content = getCellContent(i, j);
        char currentDirection = getCellDirection(i, j);
        switch (currentDirection) {
            case 'r':
                incrementJ = 1;
                break;
            case 'l':
                incrementJ = -1;
                break;
            case 'u':
                incrementI = -1;
                break;
            case 'd':
                incrementI = 1;
                break;
        }
        int newI = i + incrementI;
        int newJ = j + incrementJ;

        // Verifies if new cell coordinates are valid (if not, player loses).
        if (newJ > 34 || newJ < 0 ||newI < 0 || newI > 34 || occupiedCell(newI, newJ)) {
            return false;
        }

        // Moves cell to its new coordinates.
        setCellContent(i, j, 'e');
        setCellContent(newI, newJ, content);
        setCellDirection(newI, newJ, currentDirection);
        setCellPreviousDirection(newI, newJ, currentDirection);

        // If cell is head, updates variables. If cell is tail, then snake update is complete (recursion base case).
        if (content == 'h') {
            headJ = newJ;
            headI = newI;
        }
        else if (content == 't') {
            return true;
        }

        // Gets coordinates of previous cell based on current and previous direction.
        char previousDirection = grid[i][j].getPreviousDirection();
        int[] previousCellCoords = getPreviousCellCoords(currentDirection, previousDirection, i, j);

        // Passes direction to previous cell.
        setCellDirection(previousCellCoords[0], previousCellCoords[1], currentDirection);

        // Calls update for previous cell (recursive general case).
        return updateSnakeCell(previousCellCoords[0], previousCellCoords[1]);
    }

    public int[] getPreviousCellCoords(char current, char previous, int i, int j) {
        int[] coords = new int[2];
        if (current == previous) {
            switch(current) {
                case 'r': coords[0] = i; coords[1] = j-1;
                    break;
                case 'l': coords[0] = i; coords[1] = j+1;
                    break;
                case 'u': coords[0] = i+1; coords[1] = j;
                    break;
                case 'd': coords[0] = i-1; coords[1] = j;
                    break;
            }
        }
        else {
            switch(previous) {
                case 'r': coords[0] = i; coords[1] = j-1;
                    break;
                case 'l': coords[0] = i; coords[1] = j+1;
                    break;
                case 'u': coords[0] = i+1; coords[1] = j;
                    break;
                case 'd': coords[0] = i-1; coords[1] = j;
                    break;
            }
        }
        return coords;
    }

    public boolean occupiedCell(int i, int j) {
        return getCellContent(i, j) != 'e' && getCellContent(i, j) != 'f';
    }

    public void generateFood() {
        int i = 0, j = 0;
        do {
            i = random.nextInt(35);
            j = random.nextInt(35);
        } while (occupiedCell(i, j));
        setCellContent(i, j, 'f');
    }
}
