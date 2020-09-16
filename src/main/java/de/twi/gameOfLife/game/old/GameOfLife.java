package de.twi.gameOfLife.game.old;


import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.game.Game;
import de.twi.gameOfLife.game.grid.Grid;

public class GameOfLife {

    public static void main(String[] args) {
        Grid initalGrid = new Grid(15,10);
        initalGrid.getCellAt(1,3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(2,3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3,3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3,2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(2,1).setCellState(CellState.ALIVE);

        //initalGrid.visualize();
        Game_OLD game = new Game_OLD(initalGrid);
        game.startGameTask();


    }
}
