package de.twi.gameOfLife.game.rules;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.grid.NeighbourEvaluator;

import java.util.List;

public class Underpopulation implements Rule {
    @Override
    public boolean applies(Cell centerCell, List<Cell> neighbours) {
        if (centerCell.getCellState() == CellState.ALIVE) {
            if (NeighbourEvaluator.getNumberOfCellsWithCertainState(neighbours, CellState.ALIVE) < 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CellState getNewCellState() {
        return CellState.DEAD;
    }
}
