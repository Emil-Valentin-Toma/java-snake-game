package com.codegym.games.snake;

import com.codegym.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;


    @Override
    public void initialize() {
        // Set the field size to 15 cells x 15 cells
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        //super.onTurn(step);
        snake.move(apple);
        if (apple.isAlive == false) {
            createNewApple();
        }
        drawScene();
    }
    
    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT)
            this.snake.setDirection(Direction.LEFT);
        else if (key == Key.DOWN)
            this.snake.setDirection(Direction.DOWN);
        else if (key == Key.RIGHT)
            this.snake.setDirection(Direction.RIGHT);
        else if (key == Key.UP)
            this.snake.setDirection(Direction.UP);


        /*switch (key) {
            case LEFT: {}

            case UP: {}

            case DOWN: {}

            case RIGHT: {}
        }*/

    }


    private void createGame() {
        turnDelay = 300;
        setTurnTimer(turnDelay);
        Snake snake = new Snake(WIDTH/2, HEIGHT/2);
        this.snake = snake;
                                    //        Apple apple = new Apple(5, 5);
                                    //        this.apple = apple;
        createNewApple();
        drawScene();
    

       // Apple apple = new Apple(7,7);
       // apple.draw(this);

    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                //setCellColor(x, y, Color.DARKORCHID );
                setCellValueEx(x, y, Color.DARKSEAGREEN,"");
            }
        }
        //apple.draw(this);
        snake.draw(this);
        apple.draw(this);
    }

    private void createNewApple() {
        int xRand = getRandomNumber(WIDTH);
        int yRand = getRandomNumber(HEIGHT);
        Apple apple = new Apple(xRand, yRand);
        this.apple = apple;
        //apple.x = xRand;
        //apple.y = yRand;


    }


}
