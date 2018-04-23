package com.GameOfLife.controller;

import com.GameOfLife.service.Board;
import com.GameOfLife.service.Cell;
import com.GameOfLife.service.CellsInput;
import com.GameOfLife.service.GameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    @Mock
    private GameService gameService;
    private GameController gameController;

    @Before
    public void setUp() {
        gameController = new GameController(gameService);
    }

    @Test
    public void shouldReturnOutputList() {
        List<Cell> cellsList = new ArrayList<>();
        cellsList.add(new Cell(2, 2));
        cellsList.add(new Cell(3, 2));
        cellsList.add(new Cell(3, 3));
        cellsList.add(new Cell(2, 4));
        cellsList.add(new Cell(3, 6));
        cellsList.add(new Cell(4, 3));
        cellsList.add(new Cell(4, 5));


        List<Cell> output = new ArrayList<>();
        output.add(new Cell(2, 2));
        output.add(new Cell(3, 2));
        output.add(new Cell(4, 3));
        output.add(new Cell(4, 2));
        output.add(new Cell(3, 5));

        Board board = new Board(cellsList);
        board.outputCellsList = output;

        when(gameService.getBoardForTick(cellsList)).thenReturn(board);
        CellsInput input = new CellsInput();
        input.setCells(cellsList);
        assertEquals(gameController.getBoardForTick(input ), output);
    }

}