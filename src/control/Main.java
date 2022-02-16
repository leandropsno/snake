package control;

import model.ISpace;
import model.Space;
import view.GUI;
import view.IGUI;

public class Main {

    public static void main(String[] args) {
        IControl control = new Control();
        ISpace space = new Space();
        IGUI gui = new GUI();
        control.connect(space);
        control.connect(gui);
        control.executeGame();
    }
}
