package de.twi.gameOfLife.game.setup;

import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.grid.Grid;

public class GridCreator {

    public Grid getGridWithBlinker() {
        Grid initalGrid = new Grid(7, 9);
        initalGrid.getCellAt(3, 2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 4).setCellState(CellState.ALIVE);
        return initalGrid;
    }

    public Grid getGridWithGlider() {
        Grid initalGrid = new Grid(7, 8);
        initalGrid.getCellAt(1, 2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(2, 3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 1).setCellState(CellState.ALIVE);
        return initalGrid;
    }
}
