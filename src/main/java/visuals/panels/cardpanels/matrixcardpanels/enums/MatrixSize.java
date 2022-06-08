package visuals.panels.cardpanels.matrixcardpanels.enums;

public enum MatrixSize {
    M2x2(2,2),
    M2x3(2,3),
    M3x2(3,2),
    M3x3(3,3);

    private final int rows;
    private final int columns;

    MatrixSize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
