package de.twi.gameOfLife.game.grid;

import de.twi.gameOfLife.game.cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private Cell[][] cellGrid; // Rows, Columns

    public Grid(Grid originalGrid) {
        this.cellGrid = copy(originalGrid.getCellGrid());
    }

    private Cell[][] copy(Cell[][] originalGrid) {
        Cell[][] copiedGrid = new Cell[originalGrid.length][originalGrid[0].length];
        for (int i = 0; i < originalGrid.length; i++) {
            for (int j = 0; j < originalGrid[i].length; j++) {
                Cell originalCell = originalGrid[i][j];
                Cell copiedCell = new Cell(originalCell.getX(), originalCell.getY());
                copiedCell.setCellState(originalCell.getCellState());
                copiedGrid[i][j] = copiedCell;
            }
        }
        return copiedGrid;
    }

    public Grid(int x, int y) {
        this.cellGrid = new Cell[x][y];
        init();
    }

    private void init() {
        for (int x = 0; x < cellGrid.length; x++) {
            for (int y = 0; y < cellGrid[x].length; y++) {
                cellGrid[x][y] = new Cell(x, y);
            }
        }
    }

    public void visualize() {
        // TODO implement as stream!
        for (int y = 0; y < getYLength(); y++) {
            for (int x = 0; x < getXLength(); x++) {
                System.out.print(cellGrid[x][y] + " ");
            }
            System.out.println();
        }
    }

    public Cell getCellAt(int x, int y) {
        return cellGrid[x][y];
    }

    public Cell[][] getCellGrid() {
        return cellGrid;
    }

    public List<Cell> getAllNeighboursForCell(Cell cell) {
        return NeighbourEvaluator.getAllNeighboursForCell(this, cell);
    }

    public int getXLength() {
        return cellGrid.length;
    }

    public int getYLength() {
        return cellGrid[0].length;
    }

    public List<Cell> getAllCells() {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < getXLength(); i++) {
            for (int j = 0; j < getYLength(); j++) {
                cells.add(getCellAt(i, j));
            }
        }
        return cells;
    }

    public boolean equalsGrid(Grid otherGrid) {
        if (this.getYLength() != otherGrid.getYLength()) {
            return false;
        }
        if (this.getXLength() != otherGrid.getXLength()) {
            return false;
        }
        for (int x = 0; x < this.getXLength(); x++) {
            for (int y = 0; y < this.getYLength(); y++) {
                Cell cellInThisGrid = getCellAt(x,y);
                Cell cellInOtherGrid = otherGrid.getCellAt(x,y);
                if (cellInThisGrid.getCellState() != cellInOtherGrid.getCellState()) {
                    System.err.println("Grid.equalsGrid() - Mismatch at (x=" + x + "|y=" + y+")");
                    return false;
                }
            }
        }
        return true;
    }
}
