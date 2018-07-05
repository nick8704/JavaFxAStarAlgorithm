package com.company;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class Board {

    public static GraphicsContext gc;
    public static List<Square> squareList = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;
        makeSquareList();
    }

    public void draw() {
        for (int i = 0; i < squareList.size(); i++) {
            Square.SquareColor squareColor = squareList.get(i).getColor();
            switch (squareColor) {
                case BLACK:
                    squareList.get(i).drawBlackSquare();
                    break;
                case RED:
                    squareList.get(i).drawRedSquare();
                    break;
                case GREEN:
                    squareList.get(i).drawGreenSquare();
                    break;
                default:
                    squareList.get(i).drawWhiteSquare();
                    break;
            }
        }
    }

    private static void makeSquareList() {
        int[] pointsArray = {0, 50, 100, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600, 650, 700, 750};
        final int size = 50;
        for (int i = 0; i < pointsArray.length; i++) {
            for (int j = 0; j < pointsArray.length; j++) {
                squareList.add(new Square(pointsArray[i], pointsArray[j], size, size, gc));
            }
        }
    }

    public void chooseColorOnBlack(int sceneX, int sceneY) {
        for (int i = 0; i < squareList.size(); i++) {
            if (squareList.get(i).consistPoint(sceneX, sceneY)) {
                if (squareList.get(i).getColor() == Square.SquareColor.WHITE) {
                    squareList.get(i).setColor(Square.SquareColor.BLACK);
                    break;
                }
            }
        }
    }

    public void chooseColorOnWhite(int sceneX, int sceneY) {
        for (int i = 0; i < squareList.size(); i++) {
            if (squareList.get(i).consistPoint(sceneX, sceneY)) {
                if (squareList.get(i).getColor() == Square.SquareColor.BLACK || squareList.get(i).getColor() == Square.SquareColor.RED) {
                    squareList.get(i).setColor(Square.SquareColor.WHITE);
                    break;
                }
            }
        }
    }

}