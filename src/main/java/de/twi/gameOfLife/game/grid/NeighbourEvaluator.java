package de.twi.gameOfLife.game.grid;


import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;

import java.util.List;

public class NeighbourEvaluator {

    public static int getNumberOfCellsWithCertainState(List<Cell> neighbours, CellState cellState) {
        int numberOfCells = 0;
        for (Cell cell : neighbours) {
            if (cell.getCellState().equals(cellState)) {
                numberOfCells++;
            }
        }
        return numberOfCells;
    }
}
