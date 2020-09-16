package de.twi.gameOfLife.game.game;


import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.grid.Grid;
import de.twi.gameOfLife.game.ruleApplication.RuleApplicator;
import de.twi.gameOfLife.game.rules.Overpopulation;
import de.twi.gameOfLife.game.rules.Reproduction;
import de.twi.gameOfLife.game.rules.Survive;
import de.twi.gameOfLife.game.rules.Underpopulation;

import java.util.Timer;
import java.util.TimerTask;

public class Game_OLD {

    private Grid grid;
    private Timer timer;
    private RuleApplicator ruleApplicator;

    public Game_OLD(Grid grid) {
        this.grid = grid;
        this.timer = new Timer();
        this.ruleApplicator = new RuleApplicator(new Overpopulation(), new Underpopulation(), new Survive(), new Reproduction());
    }

    public void startGameTask() {
        GameTask gameTask = new GameTask();
        timer.schedule(gameTask, 1000, 1000);
    }

    public void stopGameTask() {
        timer.cancel();
    }

    public Grid getGrid() {
        return grid;
    }

    class GameTask extends TimerTask {

        @Override
        public void run() {
            //System.out.println("GameTask executed");
            nextStep();
            visualize();

        }

    }

    private void visualize() {
        System.out.println("------------------------");
        grid.visualize();
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
