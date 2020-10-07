package de.twi.gameOfLife.game.ruleApplication;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.grid.Grid;
import de.twi.gameOfLife.game.rules.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RuleApplicatorTest {

    Grid testGrid3x3;
    Cell centerCell;

    Rule appliesNever1;
    Rule appliesNever2;

    Rule appliesAlways1;
    Rule appliesAlways2;


    @BeforeEach
    void setUp() {
        testGrid3x3 = new Grid(3,3);
        centerCell = testGrid3x3.getCellAt(1,1);
        appliesAlways1 = new Rule() {
            @Override
            public boolean applies(Cell centerCell, List<Cell> neighbours) {
                return true;
            }

            @Override
            public CellState getNewCellState() {
                return CellState.ALIVE;
            }
        };

        appliesAlways2 = new Rule() {
            @Override
            public boolean applies(Cell centerCell, List<Cell> neighbours) {
                return true;
            }

            @Override
            public CellState getNewCellState() {
                return CellState.DEAD;
            }
        };

        appliesNever1 = new Rule() {
            @Override
            public boolean applies(Cell centerCell, List<Cell> neighbours) {
                return false;
            }

            @Override
            public CellState getNewCellState() {
                return CellState.ALIVE;
            }
        };

        appliesNever2 = new Rule() {
            @Override
            public boolean applies(Cell centerCell, List<Cell> neighbours) {
                return false;
            }

            @Override
            public CellState getNewCellState() {
                return CellState.DEAD;
            }
        };
    }

    @Test
    void getCellStateForNextGeneration_twoRulesApply_illegalStateExIsThrown() {
        RuleApplicator ruleApplicator = new RuleApplicator(appliesAlways1, appliesAlways2);
        assertThrows(IllegalStateException.class, () -> ruleApplicator.getCellStateForNextGeneration(centerCell, testGrid3x3.getAllCells()));
    }

    @Test
    void getCellStateForNextGeneration_testWithThe4Rules_noExceptionThrown() {
        RuleApplicator ruleApplicator = new RuleApplicator(new Survive(), new Reproduction(), new Overpopulation(), new Underpopulation());
        ruleApplicator.getCellStateForNextGeneration(centerCell, testGrid3x3.getAllCells());
        // No exception is thrown
    }

    @Test
    void getCellStateForNextGeneration_oneRuleApplies_noExceptionThrown() {
        RuleApplicator ruleApplicator = new RuleApplicator(appliesAlways1, appliesNever1);
        ruleApplicator.getCellStateForNextGeneration(centerCell, testGrid3x3.getAllCells());
        // No exception is thrown
    }

    @Test
    void getCellStateForNextGeneration_noRuleApplies_noExceptionThrown() {
        RuleApplicator ruleApplicator = new RuleApplicator(appliesNever1, appliesNever2);
        ruleApplicator.getCellStateForNextGeneration(centerCell, testGrid3x3.getAllCells());
        // No exception is thrown
    }
}