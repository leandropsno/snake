package control;

import model.ISpace;
import view.IGUI;

public class Control implements IControl {

    private IGUI gui;
    private ISpace space;

    public void connect(IGUI gui) {
        this.gui = gui;
    }

    public void connect(ISpace space) {
        this.space = space;
    }

    public void executeGame() {

    }
}
