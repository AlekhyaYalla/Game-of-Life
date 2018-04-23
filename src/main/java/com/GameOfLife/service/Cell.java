package com.GameOfLife.service;

import java.util.List;
import java.util.Objects;

public class Cell {
    public int x_coordinate;
    public int y_coordinate;
    public State state;

    public enum State {
        LIVE,
        DEAD
    }

    public Cell(int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;

    }

    public Cell() {
        this.y_coordinate = -1;
        this.x_coordinate = -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x_coordinate == cell.x_coordinate &&
                y_coordinate == cell.y_coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x_coordinate, y_coordinate);
    }

    public void canThisCellBeAlive(List<Cell> input) {
        int count = 0;
        Cell tempCell = new Cell();
        for (Neighbours neighbour : Neighbours.values()) {
            tempCell.x_coordinate = this.x_coordinate + neighbour.x_addon;
            tempCell.y_coordinate = this.y_coordinate + neighbour.y_addon;
            if (input.contains(tempCell))
                count++;
        }
        if (count == 2 && input.contains(this)) {
            this.state = State.LIVE;
            return;
        }
        if (count == 3) {
            this.state = State.LIVE;
            return;
        }
        this.state = State.DEAD;
    }


}
