package com.davidrodriguezcabrera.proyectotema5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 400, Color.BLACK);
        stage.setTitle("GEOMETRY DASH");
        stage.setScene(scene);
        stage.show();
        
        Rectangle cubo = new Rectangle(50,300,50,50);
        cubo.setFill(Color.YELLOW);
        root.getChildren().add(cubo);
        
        Rectangle ojoIzquierdo = new Rectangle(60,310,10,10);
        ojoIzquierdo.setFill(Color.BLUE);
        root.getChildren().add(ojoIzquierdo);
        
        Rectangle ojoDerecho = new Rectangle(80,310,10,10);
        ojoDerecho.setFill(Color.BLUE);
        root.getChildren().add(ojoDerecho);
        
        Rectangle boca = new Rectangle(60,330,30,10);
        boca.setFill(Color.BLUE);
        root.getChildren().add(boca);
        
    }

    public static void main(String[] args) {
        launch();
    }

}