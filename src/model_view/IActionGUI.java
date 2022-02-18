package model_view;

public interface IActionGUI {

    boolean startPanelActive();

    void initializeGrid();

    void initializeSnake();

    void dispose();

    boolean updateSnakeCell(int i, int j);

    int getHeadI();

    int getHeadJ();

     void generateFood();

}
