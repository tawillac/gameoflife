package de.twi.gameOfLife.rest;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;
import de.twi.gameOfLife.game.game.Game;
import de.twi.gameOfLife.game.grid.Grid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = {"http://localhost:3000"})
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    Game game = null;

    private Grid getGrid() {
        Grid initalGrid = new Grid(7, 8);
        initalGrid.getCellAt(1, 2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(2, 3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3, 1).setCellState(CellState.ALIVE);
        return initalGrid;
    }

    @GetMapping("/nextStep")
    public Cell[][] getNextStepGrid() {
        game.nextStep();
        return game.getGrid().getCellGrid();
    }

    @GetMapping("/startGame")
    public Cell[][] getNewGameGrid() {
        this.game = new Game(getGrid());
        return game.getGrid().getCellGrid();
    }

    @GetMapping("/isGameRunning")
    public boolean isGameRunning() {
        return this.game != null;
    }
}
