package control;

import model_view.IGUI;

public class Control implements IControl {

    private IGUI gui;
    private int snakeSize = 3;

    public void connect(IGUI gui) {
        this.gui = gui;
    }

    public void executeGame() {
        while (gui.startPanelActive()) {}
        gui.initializeGrid();
        gui.initializeSnake();
    }
}
