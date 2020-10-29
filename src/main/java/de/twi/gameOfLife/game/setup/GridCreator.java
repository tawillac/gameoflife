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

    public Grid getGridWithSmile() {
        Grid initalGrid = new Grid(7, 9);
        initalGrid.getCellAt(1, 2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(1, 6).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(4, 3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(4, 4).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(4, 5).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 6).setCellState(CellState.ALIVE);


        return initalGrid;
    }

    public Grid getGridWithGlider() {
        Grid initalGrid = new Grid(7, 9);
        initalGrid.getCellAt(1, 2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(2, 3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 1).setCellState(CellState.ALIVE);
        return initalGrid;
    }
}
