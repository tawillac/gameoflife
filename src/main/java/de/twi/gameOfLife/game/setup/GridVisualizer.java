package de.twi.gameOfLife.game.setup;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.grid.Grid;

public class GridVisualizer {

    public static void visualize(Grid grid) {
        for (int x = 0; x < grid.getXLength(); x++) {
            System.out.println();
            for (int y = 0; y < grid.getYLength(); y++) {
                Cell cell = grid.getCellAt(x, y);
                System.out.print(cell.getCellState()== CellState.ALIVE ? "O" : "X");
                System.out.print(" ");
            }

        }
    }
}
