package de.twi.gameOfLife.game.rules;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.grid.Grid;
import de.twi.gameOfLife.game.grid.NeighbourEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReproductionTest {

    Grid testGrid3x3;
    Cell centerCell;

    Rule reproduction;

    @BeforeEach
    void setUp() {
        testGrid3x3 = new Grid(3,3);
        centerCell = testGrid3x3.getCellAt(1,1);

        reproduction = new Reproduction();
    }

    @Test
    void applies_3AliveNeighboursForDeadCenterCell_true() {
        centerCell.setCellState(CellState.DEAD);

        testGrid3x3.getCellAt(0,0).setCellState(CellState.ALIVE);
        testGrid3x3.getCellAt(1,0).setCellState(CellState.ALIVE);
        testGrid3x3.getCellAt(2,0).setCellState(CellState.ALIVE);

        boolean applies = reproduction.applies(centerCell, NeighbourEvaluator.getAllNeighboursForCell(testGrid3x3, centerCell));
        assertTrue(applies);
    }

    @Test
    void applies_3AliveNeighboursForAliveCenterCell_false() {
        centerCell.setCellState(CellState.ALIVE);

        testGrid3x3.getCellAt(0,0).setCellState(CellState.ALIVE);
        testGrid3x3.getCellAt(1,0).setCellState(CellState.ALIVE);
        testGrid3x3.getCellAt(2,0).setCellState(CellState.ALIVE);

        boolean applies = reproduction.applies(centerCell, NeighbourEvaluator.getAllNeighboursForCell(testGrid3x3, centerCell));
        assertFalse(applies);
    }

    @Test
    void applies_2AliveNeighboursForDeadCenterCell_false() {
        centerCell.setCellState(CellState.DEAD);

        testGrid3x3.getCellAt(0,0).setCellState(CellState.ALIVE);
        testGrid3x3.getCellAt(1,0).setCellState(CellState.ALIVE);

        boolean applies = reproduction.applies(centerCell, NeighbourEvaluator.getAllNeighboursForCell(testGrid3x3, centerCell));
        assertFalse(applies);
    }
}