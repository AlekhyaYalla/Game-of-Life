package com.GameOfLife.service;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameServiceTest {

    GameService gameService;

    @Before
    public void setUp() {
        gameService = new GameService();
    }

    @Test
    public void shouldCallTick() {
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(2, 2));
        cellsList.add(new Cell(3, 2));
        cellsList.add(new Cell(3, 3));
        cellsList.add(new Cell(2, 4));
        cellsList.add(new Cell(3, 6));
        cellsList.add(new Cell(4, 3));
        cellsList.add(new Cell(4, 5));

        List<Cell> output = gameService.getBoardForTick(cellsList).outputCellsList;

        assertEquals(6, output.size());
        assertTrue(output.contains(new Cell(2, 2)));
        assertTrue(output.contains(new Cell(3, 2)));
        assertTrue(output.contains(new Cell(4, 3)));
        assertTrue(output.contains(new Cell(4, 2)));
        assertTrue(output.contains(new Cell(3, 5)));
        assertTrue(output.contains(new Cell(4, 4)));

    }

    @Test
    public void shouldReturnBoardForBlockPattern() {
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(1, 1));
        cellsList.add(new Cell(1, 2));
        cellsList.add(new Cell(2, 1));
        cellsList.add(new Cell(2, 2));

        List<Cell> output = gameService.getBoardForTick(cellsList).outputCellsList;

        assertEquals(4, output.size());
        assertTrue(output.contains(new Cell(1, 1)));
        assertTrue(output.contains(new Cell(1, 2)));
        assertTrue(output.contains(new Cell(2, 1)));
        assertTrue(output.contains(new Cell(2, 2)));

    }

    @Test
    public void shouldReturnBoardForBoatPattern() {
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(0, 1));
        cellsList.add(new Cell(1, 0));
        cellsList.add(new Cell(2, 1));
        cellsList.add(new Cell(0, 2));
        cellsList.add(new Cell(1, 2));

        List<Cell> output = gameService.getBoardForTick(cellsList).outputCellsList;

        assertEquals(5, output.size());
        assertTrue(output.contains(new Cell(0, 1)));
        assertTrue(output.contains(new Cell(1, 0)));
        assertTrue(output.contains(new Cell(2, 1)));
        assertTrue(output.contains(new Cell(0, 2)));
        assertTrue(output.contains(new Cell(1, 2)));

    }

    @Test
    public void shouldReturnBoardForBlinkerPattern() {
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(1, 1));
        cellsList.add(new Cell(1, 0));
        cellsList.add(new Cell(1, 2));

        List<Cell> output = gameService.getBoardForTick(cellsList).outputCellsList;

        assertEquals(3, output.size());
        assertTrue(output.contains(new Cell(1, 1)));
        assertTrue(output.contains(new Cell(0, 1)));
        assertTrue(output.contains(new Cell(2, 1)));

    }

    @Test
    public void shouldReturnBoardForToadPattern() {
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(1, 1));
        cellsList.add(new Cell(1, 2));
        cellsList.add(new Cell(1, 3));
        cellsList.add(new Cell(2, 2));
        cellsList.add(new Cell(2, 3));
        cellsList.add(new Cell(2, 4));

        List<Cell> output = gameService.getBoardForTick(cellsList).outputCellsList;

        assertEquals(6, output.size());
        assertTrue(output.contains(new Cell(0, 2)));
        assertTrue(output.contains(new Cell(1, 1)));
        assertTrue(output.contains(new Cell(1, 4)));
        assertTrue(output.contains(new Cell(2, 1)));
        assertTrue(output.contains(new Cell(2, 4)));
        assertTrue(output.contains(new Cell(3, 3)));

    }


}