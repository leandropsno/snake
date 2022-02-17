package model_view;

public interface IActionGUI {

    boolean startPanelActive();

    void initializeGrid();

    void initializeSnake() throws InterruptedException;

    void dispose();

    boolean updateSnake();

}
