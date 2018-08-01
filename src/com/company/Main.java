package com.company;

import javafx.animation.PauseTransitionBuilder;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private GraphicsContext gc;
    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(Config.WIDTH, Config.HEIGHT);

        BorderPane group = new BorderPane();
        group.setCenter(canvas);

        Scene scene = new Scene(group);
        registerOnMousePressListener(scene);

        primaryStage.setScene(scene);
        primaryStage.setTitle("A* algorithm by @anikonets v.1.0");
        primaryStage.show();

        gc = canvas.getGraphicsContext2D();
        board = new Board(gc);
        board.draw();
    }

    private void clean() {
        gc.clearRect(0, 0, Config.WIDTH, Config.HEIGHT);
    }

    public void registerOnMousePressListener(Scene scene) {
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clean();
                if(event.getButton() == MouseButton.PRIMARY){
                    board.chooseColorWhiteAndBlack((int) event.getSceneX(), (int) event.getSceneY());
                }
                if(event.getButton() == MouseButton.SECONDARY){
                    board.chooseColorOnRed((int) event.getSceneX(), (int) event.getSceneY());
                }
                if(event.isControlDown()) {
                    board.resetRedSquare((int) event.getSceneX(), (int) event.getSceneY());
                }
                board.draw();
            }
        });
    }

}