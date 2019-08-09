package com.codegym.games.snake;
import com.codegym.engine.cell.*;
//import com.codegym.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class Snake extends GameObject
{
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private  List<GameObject> snakeParts = new ArrayList<>();
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

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


        if (!isAlive) {
            game.setCellValueEx(x, y, Color.NONE, HEAD_SIGN, Color.RED, 75);
            game.setCellValueEx(x + 1, y, Color.NONE, BODY_SIGN, Color.RED, 75);
            game.setCellValueEx(x + 2, y, Color.NONE, BODY_SIGN, Color.RED, 75);
        }
        else {
            game.setCellValueEx(x, y, Color.NONE, HEAD_SIGN, Color.BLUE, 75);
            game.setCellValueEx(x + 1, y, Color.NONE, BODY_SIGN, Color.ALICEBLUE, 75);
            game.setCellValueEx(x + 2, y, Color.NONE, BODY_SIGN, Color.ALICEBLUE, 75);
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(){

    }

}