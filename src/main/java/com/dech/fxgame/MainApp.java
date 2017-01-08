package com.dech.fxgame;

import com.dech.fxgame.view.GameController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by user on 04.01.2017.
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private GameController gameController;

    public static void main(String... args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initRootLayout();
        initGameLayout();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //user input
                //update
                //render
                //sync
                update();
            }
        };
        timer.start();

    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            rootLayout = (BorderPane) loader.load(getClass().getResourceAsStream("view/RootLayout.fxml"));
            primaryStage.setScene(new Scene(rootLayout));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initGameLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane gameLayout = (AnchorPane) loader.load(getClass().getResourceAsStream("view/GameLayout.fxml"));
            rootLayout.setCenter(gameLayout);

            gameController = loader.getController();
            System.out.println(gameController.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(){
        double newCenterX = (gameController.getCenterXofCircle() + 10) % 600;
        gameController.relocateCircle(newCenterX, gameController.getCenterYofCircle());
    }
}
