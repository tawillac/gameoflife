package de.twi.gameOfLife.game.rules;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;

import java.util.List;

public interface Rule {

    public boolean applies(Cell centerCell, List<Cell> neighbours);
    public CellState getNewCellState();
}
