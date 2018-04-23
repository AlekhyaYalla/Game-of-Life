package com.GameOfLife.controller;

import com.GameOfLife.service.Cell;
import com.GameOfLife.service.CellsInput;
import com.GameOfLife.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/tick",method = RequestMethod.POST)
    public List<Cell> getBoardForTick(@RequestBody CellsInput cells){
        System.out.println(cells.getCells());
        return gameService.getBoardForTick(cells.getCells()).outputCellsList;
    }




}
