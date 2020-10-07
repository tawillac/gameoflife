package de.twi.gameOfLife.game.game;


import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.grid.Grid;
import de.twi.gameOfLife.game.ruleApplication.RuleApplicator;
import de.twi.gameOfLife.game.rules.*;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private Grid grid;
    private RuleApplicator ruleApplicator;

    public Game(Grid grid) {
        this.grid = grid;
        this.ruleApplicator = new RuleApplicator(new Overpopulation(), new Underpopulation(), new Survive(), new Reproduction());
    }

    public Game(Grid grid, RuleApplicator ruleApplicator) {
        this.grid = grid;
        this.ruleApplicator = ruleApplicator;
    }

    public Grid getGrid() {
        return grid;
    }

    public void nextStep() {
        Grid nextGenerationGrid = new Grid(grid);
        for (Cell cell : grid.getAllCells()) {
            CellState newCellState = ruleApplicator.getCellStateForNextGeneration(cell, grid.getAllNeighboursForCell(cell));
            nextGenerationGrid.getCellAt(cell.getX(), cell.getY()).setCellState(newCellState);
        }

        grid = nextGenerationGrid;
    }
}
