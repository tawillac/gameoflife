package de.twi.gameOfLife.game.game;


import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.grid.Grid;
import de.twi.gameOfLife.game.rules.*;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private Grid grid;
    private Timer timer;

    public Game(Grid grid) {
        this.grid = grid;
        this.timer = new Timer();
    }

    public void startGame() {
        GameTask gameTask = new GameTask();
        timer.schedule(gameTask, 1000, 1000);
    }

    public void stopGame() {
        timer.cancel();
    }

    public Grid getGrid() {
        return grid;
    }

    class GameTask extends TimerTask {

        RuleApplicator ruleApplicator = new RuleApplicator(new Overpopulation(), new Underpopulation(), new Survive(), new Reproduction());

        @Override
        public void run() {
            //System.out.println("GameTask executed");
            Grid nextGenerationGrid = new Grid(grid);
            for (Cell cell : grid.getAllCells()) {
                CellState newCellState = ruleApplicator.getCellStateForNextGeneration(cell, grid.getAllNeighboursForCell(cell));
                nextGenerationGrid.getCellAt(cell.getX(), cell.getY()).setCellState(newCellState);
            }

            grid = nextGenerationGrid;
            System.out.println("------------------------");
            grid.visualize();

        }
    }
}
