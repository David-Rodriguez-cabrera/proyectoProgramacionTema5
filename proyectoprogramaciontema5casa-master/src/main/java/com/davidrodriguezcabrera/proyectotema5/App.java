package com.davidrodriguezcabrera.proyectotema5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {
    int velocidadCubo = 3;
    int posicionCuboX = 100;
    int posicionCuboY = 535;
    int movimientoCuboX = 0;
    int movimientoCuboY = 0;
    int fondox = 0;
    int fondo2x = 800;
    @Override
    public void start(Stage stage) {
        
        
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("GEOMETRY DASH");
        stage.setScene(scene);
        stage.show();
        
        Rectangle cubo = new Rectangle(50,50);
        cubo.setFill(Color.YELLOW);
        
        
        Rectangle ojoIzquierdo = new Rectangle(10,10,10,10);
        ojoIzquierdo.setFill(Color.BLUE);
        
        
        Rectangle ojoDerecho = new Rectangle(30,10,10,10);
        ojoDerecho.setFill(Color.BLUE);
        
        
        Rectangle boca = new Rectangle(10,30,30,10);
        boca.setFill(Color.BLUE);
        
        
        Image fondo = new Image(getClass().getResourceAsStream("/images/grid_bg.png"));
        ImageView fondoView = new ImageView(fondo);
        fondoView.setLayoutX(fondox);
        
        Image fondo2 = new Image(getClass().getResourceAsStream("/images/grid_bg.png"));
        ImageView fondo2View = new ImageView(fondo2);
        fondo2View.setLayoutX(fondo2x);
        
        root.getChildren().add(fondoView);
        root.getChildren().add(fondo2View);
        
        Group groupPersonaje = new Group();
        groupPersonaje.getChildren().add(cubo);
        groupPersonaje.getChildren().add(ojoIzquierdo);
        groupPersonaje.getChildren().add(ojoDerecho);
        groupPersonaje.getChildren().add(boca);
        
        groupPersonaje.setLayoutX(posicionCuboX);
        groupPersonaje.setLayoutY(posicionCuboY);
        
        root.getChildren().add(groupPersonaje);
        
        Timeline animationCubo = new Timeline(
        new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) ->{
        groupPersonaje.setTranslateX(posicionCuboX);
        groupPersonaje.setLayoutY(posicionCuboY);
        //groupPersonaje.setTranslateY(posicionCuboY);
            posicionCuboX += velocidadCubo;
            //System.out.println(posicionCuboX);
            System.out.println(posicionCuboX);
        if (posicionCuboY == 535){
            //groupPersonaje.setTranslateY(posicionCuboY);
            posicionCuboY += movimientoCuboY;
            //System.out.println(posicionCuboY);
        }
        if (posicionCuboY < 535){
            //groupPersonaje.setTranslateY(posicionCuboY);
            posicionCuboY += 2;
            //System.out.println(posicionCuboY);
        }
        if (posicionCuboX > 700){
            fondoView.setLayoutX(800);
            fondo2View.setLayoutX(0);
            posicionCuboX = 0-100;
            System.out.println(fondo2x);
            }
            
        })
        );
        animationCubo.setCycleCount(Timeline.INDEFINITE);
        animationCubo.play();
                
        
            
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case SPACE:
                    if (posicionCuboY == 535){
                    movimientoCuboY -=100;
                    }
                    //posicionCuboY += movimientoCuboY;
                    //System.out.println(posicionCuboY);
                    break;
                
            }
        });

        scene.setOnKeyReleased((KeyEvent event) -> {
            movimientoCuboY = 0;
        });
        
    }

    public static void main(String[] args) {
        launch();
    }

}