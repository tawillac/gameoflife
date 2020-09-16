package de.twi.gameOfLife.game.grid;


import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.cell.CellState;

import java.util.ArrayList;
import java.util.List;

public class NeighbourEvaluator {

    public static int getNumberOfCellsWithCertainState(List<Cell> neighbours, CellState cellState) {
        int numberOfCells = 0;
        for (Cell cell : neighbours) {
            if (cell.getCellState().equals(cellState)) {
                numberOfCells++;
            }
        }
        return numberOfCells;
    }

    public static List<Cell> getAllNeighboursForCell(Grid grid, Cell centerCell) {
        List<Cell> neighbours = new ArrayList<>();
        List<Integer> xValues = getPossibleXValues(grid, centerCell);
        List<Integer> yValues = getPossibleYValues(grid, centerCell);
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

    public static List<Integer> getPossibleXValues(Grid grid, Cell centerCell) {
        List<Integer> xValues = new ArrayList<>();
        if (centerCell.getX()-1 >= 0 && centerCell.getX()-1 < grid.getXLength()) {
            xValues.add(centerCell.getX()-1);
        }
        if (centerCell.getX()+1 < grid.getXLength() && centerCell.getX()+1 >= 0) {
            xValues.add(centerCell.getX()+1);
        }
        if (centerCell.getX() >= 0 && centerCell.getX() < grid.getXLength()) {
            xValues.add(centerCell.getX());
        }
        return xValues;
    }

    public static List<Integer> getPossibleYValues(Grid grid, Cell centerCell) {
        List<Integer> yValues = new ArrayList<>();
        if (centerCell.getY()-1 >= 0 && centerCell.getY()-1 < grid.getYLength()) {
            yValues.add(centerCell.getY()-1);
        }
        if (centerCell.getY()+1 < grid.getYLength() && centerCell.getY()+1 >= 0) {
            yValues.add(centerCell.getY()+1);
        }
        if (centerCell.getY() >= 0 && centerCell.getY() < grid.getYLength()) {
            yValues.add(centerCell.getY());
        }
        return yValues;
    }
}
