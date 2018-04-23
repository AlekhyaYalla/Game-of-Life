package com.GameOfLife.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void shouldReturnTrueForKeepingDeadCellAlive() {
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(1, 1));
        cellsList.add(new Cell(1, 2));
        cellsList.add(new Cell(1, 3));

        Cell deadCell = new Cell(0, 2);
        deadCell.canThisCellBeAlive(cellsList);
        assertEquals(Cell.State.LIVE, deadCell.state);

    }

    @Test
    public void shouldReturnFalseForKeepingDeadCellAlive() {
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(1, 1));
        cellsList.add(new Cell(1, 2));
        cellsList.add(new Cell(1, 3));
        Cell deadCell = new Cell(0, 3);
        deadCell.canThisCellBeAlive(cellsList);
        assertEquals(Cell.State.DEAD, deadCell.state);

    }


}