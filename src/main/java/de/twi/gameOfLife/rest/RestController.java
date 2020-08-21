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

    @GetMapping("/testget")
    public Cell[][] getGrid() {
        Grid initalGrid = new Grid(7,7);
        initalGrid.getCellAt(1,3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(2,3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3,3).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(3,2).setCellState(CellState.ALIVE);
        initalGrid.getCellAt(2,1).setCellState(CellState.ALIVE);

        //initalGrid.visualize();
        //Game game = new Game(initalGrid);
        return initalGrid.getGrid();
    }
}
