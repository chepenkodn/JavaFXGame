package com.dech.fxgame.view;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

/**
 * Created by user on 07.01.2017.
 */
public class GameController {
    @FXML
    private Circle circle;

    public GameController() {
    }

    @FXML
    private void initialize(){
        circle.setCenterX(160);
        circle.setCenterY(100);
    }

    public void relocateCircle(double x, double y){
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    public double getCenterXofCircle(){
        return circle.getCenterX();
    }

    public double getCenterYofCircle(){
        return circle.getCenterY();
    }
}
