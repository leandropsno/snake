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
            //System.out.println("Waiting to start");
        }

        gui.initializeGrid();
        gui.initializeSnake();

        boolean success = true;

        while (success) {
            if (snakeSize == 1225) {
                break;
            }
            success = gui.updateSnakeCell(gui.getHeadI(), gui.getHeadJ());
            Thread.sleep(100);
        }

        System.out.println("Done");
        gui.dispose();
    }
}
