package com.codegym.games.snake;

public class GameObject { //this class stores cell coordinates;
                          // this will always be checked against the HEIGHT and WIDTH constraints variables

    public int x;
    public int y;

    GameObject (int a, int b) {
        this.x = a;
        this.y = b;
    }
    //GameObject(){}
}
