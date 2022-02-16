package model_view;

public interface IActionGUI {

    public boolean startPanelActive();

    public void initializeGrid();

    public void initializeSnake() ;

    public void setCellContent(int i, int j, char content);

    public void setCellDirection(int i, int j, char direction);

}
