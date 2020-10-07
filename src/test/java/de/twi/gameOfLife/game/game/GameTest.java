package de.twi.gameOfLife.game.game;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.grid.Grid;
import de.twi.gameOfLife.game.ruleApplication.RuleApplicator;
import de.twi.gameOfLife.game.rules.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Grid testGrid3x3;
    Cell centerCell;
    Rule ruleAppliesAlways;

    @BeforeEach
    void setUp() {
        testGrid3x3 = new Grid(3,3);
        testGrid3x3.getCellAt(1,2).setCellState(CellState.ALIVE);
        testGrid3x3.getCellAt(2,2).setCellState(CellState.ALIVE);

        centerCell = testGrid3x3.getCellAt(1,1);
        ruleAppliesAlways = new Rule() {
            @Override
            public boolean applies(Cell centerCell, List<Cell> neighbours) {
                return true;
            }

            @Override
            public CellState getNewCellState() {
                return CellState.ALIVE;
            }
        };
    }

    @Test
    public void nextStep_twoRulesApply_exceptionIsThrown() {
        RuleApplicator ruleApplicator = new RuleApplicator(new Survive(), new Overpopulation(), new Underpopulation(), new Reproduction(), ruleAppliesAlways);
        Game game = new Game(testGrid3x3, ruleApplicator);
        assertThrows(IllegalStateException.class, () -> game.nextStep());
    }

    @Test
    public void nextStep_onlyOneRuleAppliesAtATime_noExceptionIsThrown() {
        RuleApplicator ruleApplicator = new RuleApplicator(new Survive(), new Overpopulation(), new Underpopulation(), new Reproduction());
        Game game = new Game(testGrid3x3, ruleApplicator);
        game.nextStep();
        game.nextStep();
        game.nextStep();
    }

}