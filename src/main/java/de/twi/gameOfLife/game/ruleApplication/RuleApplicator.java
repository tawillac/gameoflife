package de.twi.gameOfLife.game.ruleApplication;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.rules.Rule;

import java.util.Arrays;
import java.util.List;

public class RuleApplicator {

    private List<Rule> rules;

    public RuleApplicator(Rule... rules) {
        this.rules = Arrays.asList(rules);
    }

    public CellState getCellStateForNextGeneration(Cell cell, List<Cell> neighbours) {
        CellState newCellstate = cell.getCellState();
        boolean alreadyApplied = false;
        for (Rule rule : rules) {

            if (rule.applies(cell, neighbours)) {
                if (alreadyApplied) {
                    throw new IllegalStateException("More than one rule applied!");
                }

                System.out.println(cell.visualize() + " " + rule.getClass());
                newCellstate = rule.getNewCellState();
                alreadyApplied = true;
            }
        }
        return newCellstate;
    }
}
