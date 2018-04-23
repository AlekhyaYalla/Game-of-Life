package com.GameOfLife.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void shouldGetLiveAmongDead(){
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(1, 1));
        cellsList.add(new Cell(1, 2));
        cellsList.add(new Cell(2, 2));
        cellsList.add(new Cell(2, 4));

        Board board = new Board(cellsList);

        board.getLiveAmongDead();

        assertTrue(board.outputCellsList.contains(new Cell(2,1)));
    }

    @Test
    public void shouldGetLiveAmongLive(){
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(1, 1));
        cellsList.add(new Cell(1, 2));
        cellsList.add(new Cell(2, 2));
        cellsList.add(new Cell(3, 2));
        cellsList.add(new Cell(4, 3));

        Board board = new Board(cellsList);

        board.getLiveAmongLive();

        assertFalse(board.outputCellsList.contains(new Cell(4,3)));
    }

}