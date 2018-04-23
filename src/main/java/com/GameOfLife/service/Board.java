package com.GameOfLife.service;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public List<Cell> outputCellsList;
    public List<Cell> inputCellsList;

    public Board(List<Cell> inputCellsList) {
        this.inputCellsList = inputCellsList;
        this.outputCellsList = new ArrayList<Cell>();
    }


    public void getLiveAmongDead() {
        List<Cell> output = new ArrayList<>();
        for (Cell liveCell : this.inputCellsList) {
            for (Cell deadCell : this.getNeighbourDeadCells(liveCell)) {
                deadCell.canThisCellBeAlive(this.inputCellsList);
                if (deadCell.state == Cell.State.LIVE && !output.contains(deadCell))
                    output.add(deadCell);
            }
        }
        this.outputCellsList.addAll(output);
    }

    private List<Cell> getNeighbourDeadCells(Cell liveCell) {
        List<Cell> deadNeighbours = new ArrayList<>();
        for(Neighbours neighbour: Neighbours.values()) {
            Cell cell = new Cell(liveCell.x_coordinate+neighbour.x_addon,liveCell.y_coordinate+neighbour.y_addon);
            if (this.inputCellsList.contains(cell))
                continue;
            deadNeighbours.add(cell);
        }
        return  deadNeighbours;
    }

    public void getLiveAmongLive() {
        List<Cell> output = new ArrayList<>();
        for (Cell liveCell : this.inputCellsList) {
            liveCell.canThisCellBeAlive(this.inputCellsList);
            if (liveCell.state == Cell.State.LIVE)
                output.add(liveCell);
        }
        this.outputCellsList.addAll(output);
    }
}
