package com.GameOfLife.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    public Board getBoardForTick(List<Cell> input) {
        Board board = new Board(input);
        board.getLiveAmongDead();
        board.getLiveAmongLive();
        return board;
    }
}
