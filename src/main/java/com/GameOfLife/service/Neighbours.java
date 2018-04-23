package com.GameOfLife.service;

public enum Neighbours {
    UP_RIGHT(1,1),
    DOWN_RIGHT(1,-1),
    RIGHT(1,0),
    UP_LEFT(-1,1),
    DOWN_LEFT(-1,-1),
    LEFT(-1,0),
    UP(0,1),
    DOWN(0,-1);
    int y_addon, x_addon;
    Neighbours(int x_addon, int y_addon) {
        this.x_addon = x_addon;
        this.y_addon = y_addon;
    }
}
