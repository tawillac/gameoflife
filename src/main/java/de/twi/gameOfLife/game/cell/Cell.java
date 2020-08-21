package de.twi.gameOfLife.game.cell;

public class Cell {

    private CellState cellState;
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.cellState = CellState.DEAD;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        if (cellState == CellState.DEAD) {
            return "X";
        } else {
            return "O";
        }
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String visualize() {
        return "(" + x + "|" + y +")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell otherCell = (Cell) obj;
            if (otherCell.getX() == this.getX() && otherCell.getY() == this.getY()) {
                return true;
            }
        }
        return false;
    }
}
