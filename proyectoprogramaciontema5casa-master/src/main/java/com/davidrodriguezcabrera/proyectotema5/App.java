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
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {
    int velocidadCubo = 2;
    int posicionCuboX = 100;
    int posicionCuboY = 535;
    int movimientoCuboX = 0;
    int movimientoCuboY = 0;
    float fondox = 0;
    float fondo2x = 800;
    int posicionplataformaX= 450;
    int posicionplataformaY= 450;
    int posicionCuboYMovimiento = 0;
    int posicionlineaYAbajo = 50;
    int posicionlineaYArriba = 50;
    int posicionlineaXIzquierda = 50;
    int posicionlineaXDerecha = 50;
    int ancho_Pantalla= 800;
    int velocidadFondo = -2;
    double trianguloArriba = 450.0;
    double trianguloDerecha = 480.0;
    double trianguloIzquierda = 420.0;
    
    @Override
    public void start(Stage stage) {
        
        
        Pane root = new Pane();
        Scene scene = new Scene(root, ancho_Pantalla, 600);
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
        trianguloArriba, 510.0,
        trianguloDerecha, 584.0,
        trianguloIzquierda, 584.0 });
        triangulo.setFill(Color.GOLD);
        
        Line lineaYAbajo = new Line(10,posicionlineaYAbajo,45,posicionlineaYAbajo);
        lineaYAbajo.setStroke(Color.BLACK);
        lineaYAbajo.setStrokeWidth(1);
        
        Line lineaYArriba = new Line(10,0,45,0);
        lineaYArriba.setStroke(Color.BLACK);
        lineaYArriba.setStrokeWidth(1);
        
        Line lineaXIzquierda = new Line(0,10,0,45);
        lineaXIzquierda.setStroke(Color.BLACK);
        lineaXIzquierda.setStrokeWidth(1);
        
        Line lineaXDerecha = new Line(posicionlineaXDerecha,45,posicionlineaXDerecha,10);
        lineaXDerecha.setStroke(Color.BLACK);
        lineaXDerecha.setStrokeWidth(1);
        
        root.getChildren().add(fondoView);
        root.getChildren().add(fondo2View);
        
        
        root.getChildren().add(triangulo);
        
        root.getChildren().add(plataforma);
        
        
        Group groupPersonaje = new Group();
        
        groupPersonaje.getChildren().add(cubo);
        groupPersonaje.getChildren().add(ojoIzquierdo);
        groupPersonaje.getChildren().add(ojoDerecho);
        groupPersonaje.getChildren().add(boca);
        groupPersonaje.getChildren().add(lineaYAbajo);
        groupPersonaje.getChildren().add(lineaYArriba);
        groupPersonaje.getChildren().add(lineaXIzquierda);
        groupPersonaje.getChildren().add(lineaXDerecha);
        groupPersonaje.setLayoutX(posicionCuboX);
        groupPersonaje.setLayoutY(posicionCuboY);
        
        root.getChildren().add(groupPersonaje);
        
        Timeline animationCubo = new Timeline(
        new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) ->{
        groupPersonaje.setTranslateX(posicionCuboX);
        groupPersonaje.setLayoutY(posicionCuboY);
        //groupPersonaje.setTranslateY(posicionCuboY);
            //posicionCuboX += velocidadCubo;
            //System.out.println(posicionCuboX);
            plataforma.setTranslateX(posicionplataformaX);
            
            posicionplataformaX -= velocidadCubo;
            trianguloArriba -= velocidadCubo;
            trianguloDerecha -= velocidadCubo;
            trianguloIzquierda -= velocidadCubo;
            triangulo.setLayoutX(trianguloArriba);
            triangulo.setLayoutX(trianguloDerecha);
            triangulo.setLayoutX(trianguloIzquierda);
            
                fondoView.setLayoutX(fondox);
                fondox+= velocidadFondo;
                fondo2View.setLayoutX(fondo2x);
                fondo2x+= velocidadFondo;
                
                if (fondox <= -800) {
                    fondox = 800;
                }
                if (fondo2x <= -800) {
                    fondo2x = 800;
                }
            
                
            
        
        if (posicionCuboY > 350 && movimientoCuboY == -10){
            posicionCuboYMovimiento -=1;
            posicionCuboY += posicionCuboYMovimiento;
        }
        else{
            movimientoCuboY = 0;
            posicionCuboYMovimiento = 2;
            posicionCuboY += posicionCuboYMovimiento;
            
        }
        if (posicionCuboY >= 535){
            posicionCuboY = 535;
        }
        //if (posicionCuboX > 150){
            //fondox +=10;
            //System.out.println(fondox);
            //}
        //if (fondox >= 800) {
            //fondo2x -= 10;
        //}
        //System.out.println(posicionplataformaX);
        
        Shape shapeColison = Shape.intersect(plataforma, lineaYAbajo);
            boolean colisionVacia = shapeColison.getBoundsInLocal().isEmpty();
            if(colisionVacia == false && (posicionlineaYAbajo+posicionplataformaY -50) == posicionplataformaY){
                //posicionCuboYMovimiento = 0;
                //posicionCuboY = posicionCuboYMovimiento;
                posicionCuboY = 402;
            }
            
            Shape shapeColison2 = Shape.intersect(plataforma, lineaXDerecha);
            boolean colisionVacia2 = shapeColison2.getBoundsInLocal().isEmpty();
            
            if(colisionVacia2 == false && (posicionlineaXDerecha+posicionplataformaX -50) == posicionplataformaX){
                velocidadCubo = 2;
    posicionCuboX = 100;
    posicionCuboY = 535;
    movimientoCuboX = 0;
    movimientoCuboY = 0;
    fondox = 0;
    fondo2x = 800;
    posicionplataformaX= 450;
    posicionplataformaY= 450;
    posicionCuboYMovimiento = 0;
    posicionlineaYAbajo = 50;
    posicionlineaYArriba = 50;
    posicionlineaXIzquierda = 50;
    posicionlineaXDerecha = 50;
    ancho_Pantalla= 800;
    velocidadFondo = -2;
    trianguloArriba = 450.0;
    trianguloDerecha = 480.0;
    trianguloIzquierda = 420.0;
            }
            
            
            
        Shape shapeColisonMuerte = Shape.intersect(triangulo, cubo);
        boolean colisionMuerte = shapeColisonMuerte.getBoundsInLocal().isEmpty();
        if(colisionMuerte == false){
    velocidadCubo = 2;
    posicionCuboX = 100;
    posicionCuboY = 535;
    movimientoCuboX = 0;
    movimientoCuboY = 0;
    fondox = 0;
    fondo2x = 800;
    posicionplataformaX= 450;
    posicionplataformaY= 450;
    posicionCuboYMovimiento = 0;
    posicionlineaYAbajo = 50;
    posicionlineaYArriba = 50;
    posicionlineaXIzquierda = 50;
    posicionlineaXDerecha = 50;
    ancho_Pantalla= 800;
    velocidadFondo = -2;
    trianguloArriba = 450.0;
    trianguloDerecha = 480.0;
    trianguloIzquierda = 420.0;
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