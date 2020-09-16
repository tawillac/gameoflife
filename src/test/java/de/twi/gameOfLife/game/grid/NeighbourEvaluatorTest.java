package de.twi.gameOfLife.game.grid;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NeighbourEvaluatorTest {

    Grid testGrid3x3;

    @BeforeEach
    void setUp() {
        testGrid3x3 = new Grid(3,3);
        testGrid3x3.getCellAt(1,1).setCellState(CellState.ALIVE);
    }

    @Test
    void getNumberOfCellsWithCertainState_inTestGrid_thereIs1CellAlive() {
        Integer numberOfAliveCells = NeighbourEvaluator.getNumberOfCellsWithCertainState(testGrid3x3.getAllCells(), CellState.ALIVE);
        assertEquals(1, numberOfAliveCells);
    }

    @Test
    void getNumberOfCellsWithCertainState_inTestGrid_thereAre8CellsDead() {
        Integer numberOfDeadCells = NeighbourEvaluator.getNumberOfCellsWithCertainState(testGrid3x3.getAllCells(), CellState.DEAD);
        assertEquals(8, numberOfDeadCells);
    }

    @Test
    void getAllNeighboursForCell_forCentralCell_thereAre8Neighbours() {
        Cell centerCell = testGrid3x3.getCellAt(1,1);
        List<Cell> neighbours = NeighbourEvaluator.getAllNeighboursForCell(testGrid3x3, centerCell);
        assertEquals(8, neighbours.size());
    }

    @Test
    void getAllNeighboursForCell_forCentralCell_neighboursAreCorrectlyDetermined() {
        Cell centerCell = testGrid3x3.getCellAt(1,1);
        List<Cell> neighbours = NeighbourEvaluator.getAllNeighboursForCell(testGrid3x3, centerCell);

        assertTrue(neighbours.contains(testGrid3x3.getCellAt(0,0)));
        assertTrue(neighbours.contains(testGrid3x3.getCellAt(0,1)));
        assertTrue(neighbours.contains(testGrid3x3.getCellAt(0,2)));
        assertTrue(neighbours.contains(testGrid3x3.getCellAt(1,0)));
        assertTrue(neighbours.contains(testGrid3x3.getCellAt(1,2)));
        assertTrue(neighbours.contains(testGrid3x3.getCellAt(2,0)));
        assertTrue(neighbours.contains(testGrid3x3.getCellAt(2,1)));
        assertTrue(neighbours.contains(testGrid3x3.getCellAt(2,2)));
    }

    @Test
    void getAllNeighboursForCell_forCentralCell_neighboursDoesNotContainCentralCell() {
        Cell centerCell = testGrid3x3.getCellAt(1,1);
        List<Cell> neighbours = NeighbourEvaluator.getAllNeighboursForCell(testGrid3x3, centerCell);

        assertFalse(neighbours.contains(testGrid3x3.getCellAt(1,1)));
    }

    @Test
    void getPossibleYValues_forCentralCell_thereAre3PossibleYValues() {
        Cell centerCell = testGrid3x3.getCellAt(1,1);
        List<Integer> possibleYValues = NeighbourEvaluator.getPossibleYValues(testGrid3x3,centerCell);
        assertEquals(3, possibleYValues.size());
    }

    @Test
    void getPossibleYValues_forCellAt0x0_thereAre2PossibleYValues() {
        Cell centerCell = testGrid3x3.getCellAt(0,0);
        List<Integer> possibleYValues = NeighbourEvaluator.getPossibleYValues(testGrid3x3,centerCell);
        assertEquals(2, possibleYValues.size());
    }

    @Test
    void getPossibleYValues_forCellThatIsNotInGrid_thereAre0PossibleYValues() {
        Cell centerCell = new Cell(5,5);
        List<Integer> possibleYValues = NeighbourEvaluator.getPossibleYValues(testGrid3x3,centerCell);
        assertEquals(0, possibleYValues.size());
    }

    @Test
    void getPossibleXValues_forCentralCell_thereAre3PossibleYValues() {
        Cell centerCell = testGrid3x3.getCellAt(1,1);
        List<Integer> possibleXValues = NeighbourEvaluator.getPossibleXValues(testGrid3x3,centerCell);
        assertEquals(3, possibleXValues.size());
    }

    @Test
    void getPossibleXValues_forCellAt0x0_thereAre2PossibleYValues() {
        Cell centerCell = testGrid3x3.getCellAt(0,0);
        List<Integer> possibleXValues = NeighbourEvaluator.getPossibleXValues(testGrid3x3,centerCell);
        assertEquals(2, possibleXValues.size());
    }

    @Test
    void getPossibleXValues_forCellThatIsNotInGrid_thereAre0PossibleXValues() {
        Cell centerCell = new Cell(5,5);
        List<Integer> possibleXValues = NeighbourEvaluator.getPossibleXValues(testGrid3x3,centerCell);
        assertEquals(0, possibleXValues.size());
    }
}