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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
    int posicionplataformaX= 480;
    int posicionplataformaY= 450;
    int posicionCuboYMovimiento = 2;
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
        
        Rectangle plataforma = new Rectangle(posicionplataformaX,posicionplataformaY,60,60);
        plataforma.setFill(Color.BLACK);
        
        Polygon triangulo = new Polygon();
        triangulo.getPoints().addAll(new Double[]{
        450.0, 510.0,
        480.0, 584.0,
        420.0, 584.0 });
        triangulo.setFill(Color.GOLD);
        
        root.getChildren().add(fondoView);
        root.getChildren().add(fondo2View);
        
        root.getChildren().add(triangulo);
        
        root.getChildren().add(plataforma);
        
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
            
        if (posicionCuboY == 535){
            //groupPersonaje.setTranslateY(posicionCuboY);
            posicionCuboY += posicionCuboYMovimiento;
            //System.out.println(posicionCuboY);
        }
        
        if (posicionCuboY > 350 && movimientoCuboY == -10){
            posicionCuboYMovimiento -=2;
            posicionCuboY += posicionCuboYMovimiento;
            //System.out.println(posicionCuboYMovimiento);
        }
        else{
            movimientoCuboY = 0;
            posicionCuboYMovimiento = 2;
            posicionCuboY += posicionCuboYMovimiento;
            
        }
        if (posicionCuboY >= 535){
            //groupPersonaje.setTranslateY(posicionCuboY);
            posicionCuboY = 535;
            //posicionCuboYMovimiento = 2;
            //posicionCuboY += posicionCuboYMovimiento;
            //posicionCuboY += 2;
            
        }
        //if (posicionCuboX > 100){
            //fondo2x -=10;
            //System.out.println(fondo2x);
            //}
        //if (fondo2x == -800) {
            //fondo2x = 0;
        //}
        //System.out.println(movimientoCuboY);
        //System.out.println(posicionplataformaX);
        Shape shapeColison = Shape.intersect(plataforma, cubo);
            boolean colisionVacia = shapeColison.getBoundsInLocal().isEmpty();
            if(colisionVacia == false && posicionCuboY > ((posicionplataformaY/2) * 1.73) && posicionCuboY < ((posicionplataformaY/2) * 1.8)){
                //posicionCuboYMovimiento = 0;
                //posicionCuboY = posicionCuboYMovimiento;
                posicionCuboY = 402;
            }
            if(colisionVacia == false && posicionCuboX > ((posicionplataformaX/2) * 1.38) && posicionCuboX < (posicionplataformaX/2) * 1.4){
                
                velocidadCubo = 0;
            }
            
        Shape shapeColisonMuerte = Shape.intersect(triangulo, cubo);
        boolean colisionMuerte = shapeColisonMuerte.getBoundsInLocal().isEmpty();
        if(colisionMuerte == false){
                posicionCuboX = 100;
                posicionCuboY = 535;
                velocidadCubo = 3;
            }
            
        })
        );
        animationCubo.setCycleCount(Timeline.INDEFINITE);
        animationCubo.play();
                
        
            
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case SPACE:
                    if (posicionCuboY == 535){
                    movimientoCuboY -=10;
                    }
                    //if (posicionCuboY == 445){
                        
                    //}
                    //posicionCuboY += movimientoCuboY;
                    //System.out.println(posicionCuboY);
                    break;
                
            }
        });

        scene.setOnKeyReleased((KeyEvent event) -> {
            
        });
        
    }

    public static void main(String[] args) {
        launch();
    }

}