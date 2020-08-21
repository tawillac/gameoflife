package de.twi.gameOfLife.game.grid;

import de.twi.gameOfLife.game.cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class NeighbourGetter {

    private Grid grid;
    private Cell centerCell;

    public NeighbourGetter(Grid grid, Cell centerCell) {
        this.grid = grid;
        this.centerCell = centerCell;
    }

    public List<Cell> getAllNeighboursForCell(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        List<Integer> xValues = getPossibleXValues();
        List<Integer> yValues = getPossibleYValues();
        for (Integer xValue : xValues) {
            for (Integer yValue : yValues) {
                Cell neighbour = grid.getCellAt(xValue, yValue);
                if (neighbour != centerCell) {
                    neighbours.add(neighbour);
                }
            }
        }
        return neighbours;
    }

    private List<Integer> getPossibleXValues() {
        List<Integer> xValues = new ArrayList<>();
        if (centerCell.getX()-1 >= 0) {
            xValues.add(centerCell.getX()-1);
        }
        if (centerCell.getX()+1 < grid.getXLength()) {
            xValues.add(centerCell.getX()+1);
        }
        xValues.add(centerCell.getX());
        return xValues;
    }

    private List<Integer> getPossibleYValues() {
        List<Integer> yValues = new ArrayList<>();
        if (centerCell.getY()-1 >= 0) {
            yValues.add(centerCell.getY()-1);
        }
        if (centerCell.getY()+1 < grid.getYLength()) {
            yValues.add(centerCell.getY()+1);
        }
        yValues.add(centerCell.getY());
        return yValues;
    }
}
