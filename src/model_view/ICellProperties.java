package model_view;

public interface ICellProperties {

    char getCellContent(int i, int j);

    char getCellDirection(int i, int j);

    void setCellContent(int i, int j, char content);

    void setCellDirection(int i, int j, char direction);

}
