package control;

import model_view.IGUI;

public class Control implements IControl {

    private IGUI gui;
    private int snakeSize = 3;

    public void connect(IGUI gui) {
        this.gui = gui;
    }

    public void executeGame() throws InterruptedException {
        while (gui.startPanelActive()) {
            continue;
        }
        gui.initializeGrid();
        gui.initializeSnake();

        boolean loss = false;

        while (!loss) {
            if (snakeSize == 1225) {
                break;
            }
            loss = gui.updateSnake();
        }

        System.out.println("Done");
        gui.dispose();
    }
}
