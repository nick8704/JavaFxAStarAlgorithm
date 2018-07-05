package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square {

    public enum SquareColor {
        WHITE,
        BLACK,
        RED,
        GREEN;
    }
    private GraphicsContext gc;

    private int x;
    private int y;
    private int width;
    private int height;
    private SquareColor color;

    public Square(int x, int y, int width, int height, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gc = gc;
        this.color = SquareColor.WHITE;
    }

    public void drawWhiteSquare() {
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.fillRect(x, y, width, height);
        gc.strokeRect(x, y, width, height);
    }

    public void drawBlackSquare() {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.fillRect(x, y, width, height);
        gc.strokeRect(x, y, width, height);
    }

    public void drawRedSquare() {
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.fillRect(x, y, width, height);
        gc.strokeRect(x, y, width, height);
    }

    public void drawGreenSquare() {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.fillRect(x, y, width, height);
        gc.strokeRect(x, y, width, height);
    }

    public SquareColor getColor() {
        return color;
    }

    public void setColor(SquareColor color) {
        this.color = color;
    }
}