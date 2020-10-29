package de.twi.gameOfLife.game.grid;
import de.twi.gameOfLife.game.setup.GridCreator;

public enum StartPattern {

    GLIDER(new GridCreator().getGridWithGlider()),
    BLINKER(new GridCreator().getGridWithBlinker());

    private Grid grid;
    private StartPattern (Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }
}
