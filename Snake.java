package com.codegym.games.snake;
import com.codegym.engine.cell.*;
//import com.codegym.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class Snake extends GameObject{
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private  List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        super(x,y);
        GameObject first = new GameObject(x,y);
        GameObject second = new GameObject(x + 1, y);
        GameObject third = new GameObject(x + 2,y);
        snakeParts.add(first);
        snakeParts.add(second);
        snakeParts.add(third);
    }

    public void draw(Game game)
    {
        game.setCellValue(x, y, HEAD_SIGN);
        game.setCellValue(x + 1, y, BODY_SIGN);
        game.setCellValue(x + 2, y, BODY_SIGN);

    }



}