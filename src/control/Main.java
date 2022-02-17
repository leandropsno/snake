package control;

import model_view.GUI;
import model_view.IGUI;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        IControl control = new Control();
        IGUI gui = new GUI();
        control.connect(gui);
        control.executeGame();
    }
}
