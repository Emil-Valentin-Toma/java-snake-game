package com.codegym.games.snake;

import com.codegym.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;

    @Override
    public void initialize() {
        // Set the field size to 15 cells x 15 cells
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (apple.isAlive == false) {
            createNewApple();
        }
        if (snake.isAlive == false) {
            gameOver();
        }
        if (snake.getLength() > GOAL) {
            win();
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
    }


    private void createGame() {
        isGameStopped = false;
        turnDelay = 300;
        setTurnTimer(turnDelay);
        Snake snake = new Snake(WIDTH/2, HEIGHT/2);
        this.snake = snake;
        createNewApple();
        drawScene();
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                //setCellColor(x, y, Color.DARKORCHID );
                setCellValueEx(x, y, Color.DARKSEAGREEN,"");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void createNewApple() {
        int xRand = getRandomNumber(WIDTH);
        int yRand = getRandomNumber(HEIGHT);
        Apple apple = new Apple(xRand, yRand);
        this.apple = apple;
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.LIGHTSKYBLUE, "GAME OVER", Color.RED, 24);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.ORANGE, "YOU WIN", Color.LAWNGREEN, 24);
    }


}
