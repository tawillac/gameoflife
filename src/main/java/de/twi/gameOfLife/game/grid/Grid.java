package de.twi.gameOfLife.game.grid;

import de.twi.gameOfLife.game.cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private Cell[][] grid; // Rows, Columns

    public Grid(Grid originalGrid) {
        this.grid = copy(originalGrid.getGrid());
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
        this.grid = new Cell[x][y];
        init();
    }

    private void init() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = new Cell(x, y);
            }
        }
    }

    public void visualize() {
        // TODO implement as stream!
        for (int y = 0; y < getYLength(); y++) {
            for (int x = 0; x < getXLength(); x++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }

    public Cell getCellAt(int x, int y) {
        return grid[x][y];
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public List<Cell> getAllNeighboursForCell(Cell cell) {
        return new NeighbourGetter(this, cell).getAllNeighboursForCell(cell);
    }

    public int getXLength() {
        return grid.length;
    }

    public int getYLength() {
        return grid[0].length;
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
}
