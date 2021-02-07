package com.davidrodriguezcabrera.proyectotema5;

import java.net.URISyntaxException;
import java.net.URL;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;
/**
 * JavaFX App
 */
public class App extends Application {
    int velocidadCubo = 3;
    int posicionCuboX = 100;
    int posicionCuboY = 535;
    int movimientoCuboX = 0;
    int movimientoCuboY = 0;
    float fondox = 0;
    float fondo2x = 800;
    int posicionCuboYMovimiento = 0;
    int posicionlineaYAbajo = 50;
    int posicionlineaYArriba = 50;
    int posicionlineaXIzquierda = 50;
    int posicionlineaXDerecha = 50;
    int ancho_Pantalla= 800;
    int velocidadFondo = -2;
    int posicionplataformaX= 450;
    int posicionplataformaY= 450;
    int posicionplataformaX2= 550;
    int posicionplataformaY2= 525;
    double trianguloArriba = 450.0;
    double trianguloDerecha = 480.0;
    double trianguloIzquierda = 420.0;
    double trianguloArriba2 = 650.0;
    double trianguloDerecha2 = 680.0;
    double trianguloIzquierda2 = 620.0;
    final int TEXT_SIZE = 24;
    int Distancia = 0;
    int DistanciaMaxima = 0;
    boolean encimaDEPlataforma;
    int SueloY= 585;
    boolean Sueloboolean = true;
    AudioClip musicaFondo;
    @Override
    public void start(Stage stage) {
        
        //PANEL ROOT
        Pane root = new Pane();
        Scene scene = new Scene(root, ancho_Pantalla, 600);
        stage.setTitle("GEOMETRY DASH");
        stage.setScene(scene);
        stage.show();
        
        //CUBO PERSONAJE
        Rectangle cubo = new Rectangle(50,50);
        cubo.setFill(Color.YELLOW);
        
        //OJO IZQUIERDO
        Rectangle ojoIzquierdo = new Rectangle(10,10,10,10);
        ojoIzquierdo.setFill(Color.BLUE);
        
        //OJODERECHO
        Rectangle ojoDerecho = new Rectangle(30,10,10,10);
        ojoDerecho.setFill(Color.BLUE);
        
        //BOCA
        Rectangle boca = new Rectangle(10,30,30,10);
        boca.setFill(Color.BLUE);
        
        //PRIMERA IMAGEN FONDO
        Image fondo = new Image(getClass().getResourceAsStream("/images/grid_bg.png"));
        ImageView fondoView = new ImageView(fondo);
        fondoView.setLayoutX(fondox);
        
        //SEGUNDA IMAGEN FONDO
        Image fondo2 = new Image(getClass().getResourceAsStream("/images/grid_bg.png"));
        ImageView fondo2View = new ImageView(fondo2);
        fondo2View.setLayoutX(fondo2x);
        
        //PRIMERA PLATAFORMA
        Rectangle plataforma = new Rectangle(posicionplataformaX,posicionplataformaY,60,60);
        plataforma.setFill(Color.BLACK);
        //SEGUNDA PLATAFORMA
        Rectangle plataforma2 = new Rectangle(posicionplataformaX2,posicionplataformaY2,60,60);
        plataforma2.setFill(Color.BLACK);
        
        //PRIMER TRIANGULO
        Polygon triangulo = new Polygon();
        triangulo.getPoints().addAll(new Double[]{
        trianguloArriba, 510.0,
        trianguloDerecha, 584.0,
        trianguloIzquierda, 584.0 });
        triangulo.setFill(Color.GOLD);
        //SEGUNDO TRIANGULO
        Polygon triangulo2 = new Polygon();
        triangulo2.getPoints().addAll(new Double[]{
        trianguloArriba2, 510.0,
        trianguloDerecha2, 584.0,
        trianguloIzquierda2, 584.0 });
        triangulo2.setFill(Color.GOLD);
        
        //LINEA ABAJO PERSONAJE
        Line lineaYAbajo = new Line(10,posicionlineaYAbajo,45,posicionlineaYAbajo);
        lineaYAbajo.setStroke(Color.BLACK);
        lineaYAbajo.setStrokeWidth(1);
        //LINEA ARRIBA PERSONAJE
        Line lineaYArriba = new Line(10,0,45,0);
        lineaYArriba.setStroke(Color.BLACK);
        lineaYArriba.setStrokeWidth(1);
        //LINEA IZQUIERDA PERSONAJE
        Line lineaXIzquierda = new Line(0,10,0,45);
        lineaXIzquierda.setStroke(Color.BLACK);
        lineaXIzquierda.setStrokeWidth(1);
        //LINEA DERECHA PERSONAJE
        Line lineaXDerecha = new Line(posicionlineaXDerecha,45,posicionlineaXDerecha,10);
        lineaXDerecha.setStroke(Color.BLACK);
        lineaXDerecha.setStrokeWidth(1);
        
        Line Suelo = new Line(ancho_Pantalla,SueloY,0,SueloY);
        Suelo.setStroke(Color.LAWNGREEN);
        Suelo.setStrokeWidth(5);
        
        //TEXTOS DISTANCIA Y DISTANCIA MAXIMA
        HBox paneScores = new HBox();
        paneScores.setTranslateY(20);
        paneScores.setMinWidth(ancho_Pantalla);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(100);
        // LAYOUT PARA DISTANCIA ACTUAL
        HBox paneCurrentScore = new HBox();
        paneCurrentScore.setSpacing(10);
        
        // LAYOUT PARA DISTANCIA MAXIMA
        HBox paneHighScore = new HBox();
        paneHighScore.setSpacing(10);
        
        // TEXTO DE ETIQUETA PARA DISTANCIA
        Text textTitleScore = new Text("Distancia");
        textTitleScore.setFont(Font.font(TEXT_SIZE));
        textTitleScore.setFill(Color.WHITE);
        // TEXTO PARA LA DISTANCIA
        Text textScore = new Text("0");
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.WHITE);
        // TEXTO DE ETIQUETA PARA LA DISTANCIA MAXIMA
        Text textTitleHighScore = new Text("Distancia.Maxima");
        textTitleHighScore.setFont(Font.font(TEXT_SIZE));
        textTitleHighScore.setFill(Color.WHITE);
        //TEXTO PARA LA DISTANCIA MAXIMA
        Text textHighScore = new Text("0");
        textHighScore.setFont(Font.font(TEXT_SIZE));
        textHighScore.setFill(Color.WHITE);
        
        //SONIDO FONDO JUEGO
        URL urlmusicaFondo = getClass().getResource("/audio/GEOMETRY-DASH.mp3");
        if(urlmusicaFondo != null) {
            try {
                musicaFondo = new AudioClip(urlmusicaFondo.toURI().toString());
                musicaFondo.play();
            } catch (URISyntaxException ex) {
            }            
        } else {
        System.out.println("No se ha encontrado el archivo de audio");
        }
        
        //FONDO
        root.getChildren().add(fondoView);
        root.getChildren().add(fondo2View);
        
        // AÑADIR LOS TEXTOS A LOS LAYOUTS RESERVADOS PARA ELLOS
        root.getChildren().add(paneScores);
        paneScores.getChildren().add(paneCurrentScore);
        paneScores.getChildren().add(paneHighScore);
        paneCurrentScore.getChildren().add(textTitleScore);
        paneCurrentScore.getChildren().add(textScore);
        paneHighScore.getChildren().add(textTitleHighScore);
        paneHighScore.getChildren().add(textHighScore);
        
        //AÑADIR PLATAFORMAS Y TRIANGULOS
        root.getChildren().add(plataforma);
        root.getChildren().add(plataforma2);
        root.getChildren().add(triangulo);
        root.getChildren().add(triangulo2);
        
        //AÑADIR GRUPO PERSONAJE
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
        
        root.getChildren().add(Suelo);
        //TIMELINE
        Timeline animationCubo = new Timeline(
        new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) ->{
            //TRANSLATE PERSONAJE
        groupPersonaje.setTranslateX(posicionCuboX);
        groupPersonaje.setLayoutY(posicionCuboY);
        //groupPersonaje.setTranslateY(posicionCuboY);
            //posicionCuboX += velocidadCubo;
            //System.out.println(posicionCuboX);
            //TRANSLATE Y VELOCIDAD PLATAFORMAS
            plataforma.setTranslateX(posicionplataformaX);
            posicionplataformaX -= velocidadCubo;
            
            plataforma2.setTranslateX(posicionplataformaX2);
            posicionplataformaX2 -= velocidadCubo;
            
            //LAYOUTS Y VELOCIDAD PLATAFORMAS
            trianguloArriba -= velocidadCubo;
            trianguloDerecha -= velocidadCubo;
            trianguloIzquierda -= velocidadCubo;
            triangulo.setLayoutX(trianguloArriba);
            triangulo.setLayoutX(trianguloDerecha);
            triangulo.setLayoutX(trianguloIzquierda);
            
            trianguloArriba2 -= velocidadCubo;
            trianguloDerecha2 -= velocidadCubo;
            trianguloIzquierda2 -= velocidadCubo;
            triangulo2.setLayoutX(trianguloArriba2);
            triangulo2.setLayoutX(trianguloDerecha2);
            triangulo2.setLayoutX(trianguloIzquierda2);
            
            //MOVIMIENTO INFINITO PANTALLA
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
         //DISTANCIA MAXIMA
        if (Distancia > DistanciaMaxima){
                    DistanciaMaxima = Distancia;
                    textHighScore.setText(String.valueOf(DistanciaMaxima));
                }
        //DISTANCIA
        if (fondox> -900){
            Distancia += 1;
            textScore.setText(String.valueOf(Distancia));
        }
        //System.out.println(Distancia);
       
        
        // SALTO
        if (posicionCuboY > 360 && movimientoCuboY == -10){
            posicionCuboYMovimiento =-4;
            posicionCuboY += posicionCuboYMovimiento;
        }
        //CAIDA
        else{
            movimientoCuboY = 0;
            posicionCuboYMovimiento = 4;
            posicionCuboY += posicionCuboYMovimiento;
            Sueloboolean = true;
        }
        //SUELO
        //if (posicionCuboY >= 535){
            //posicionCuboY = 535;
            //posicionCuboYMovimiento= 0;
        //}
        
        //Colison SUELO
        Shape shapeSuelo = Shape.intersect(Suelo, cubo);
        boolean colisionSuelo = shapeSuelo.getBoundsInLocal().isEmpty();
        if (colisionSuelo == false && (Sueloboolean == true)){
            posicionCuboY = SueloY-50;
            posicionCuboYMovimiento= 0;
        }

        //COLISON PLATAFORMA ARRIBA
        Shape shapeColisonPlataformaY = Shape.intersect(plataforma, lineaYAbajo);
            boolean colisionVaciaPlataformaY = shapeColisonPlataformaY.getBoundsInLocal().isEmpty();
            if(colisionVaciaPlataformaY == false && (posicionlineaYAbajo+posicionplataformaY -50) == posicionplataformaY){
                //posicionCuboYMovimiento = 0;
                //posicionCuboY = posicionCuboYMovimiento;
                posicionCuboY = posicionplataformaY-50;
                posicionCuboYMovimiento= 0;
                movimientoCuboY = 0;
                encimaDEPlataforma = false;
                 System.out.println(movimientoCuboY);
                
            }
            
            
            //COLISON PLATAFORMA LADOS
            Shape shapeColisonPlataformaX = Shape.intersect(plataforma, lineaXDerecha);
            boolean colisionVaciaPlataformaX = shapeColisonPlataformaX.getBoundsInLocal().isEmpty();
            if(colisionVaciaPlataformaX == false && (posicionlineaXDerecha+posicionplataformaX -50) == posicionplataformaX){
                Reinicio();
            }
            
        //COLISION TRIANGULO MUERTE
        Shape shapeColisonMuerte = Shape.intersect(triangulo, cubo);
        boolean colisionMuerte = shapeColisonMuerte.getBoundsInLocal().isEmpty();
        if(colisionMuerte == false){
        Reinicio();
            }
        
        
        })
        );
        animationCubo.setCycleCount(Timeline.INDEFINITE);
        animationCubo.play();
                
        
            //DEFINIR CONTROLES
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case SPACE:
                    //System.out.println(posicionCuboYMovimiento);
                    if (posicionCuboYMovimiento== 0){
                    movimientoCuboY -=10;
                    Sueloboolean = false;
                    }
                    break;
                
            }
        });

        scene.setOnKeyReleased((KeyEvent event) -> {
            
        });
        
    }
// VOID DE REINICIO
    private void Reinicio() {
    velocidadCubo = 3;
    posicionCuboX = 100;
    posicionCuboY = 535;
    movimientoCuboX = 0;
    movimientoCuboY = 0;
    fondox = 0;
    fondo2x = 800;
    posicionCuboYMovimiento = 0;
    posicionlineaYAbajo = 50;
    posicionlineaYArriba = 50;
    posicionlineaXIzquierda = 50;
    posicionlineaXDerecha = 50;
    ancho_Pantalla= 800;
    velocidadFondo = -2;
    posicionplataformaX= 450;
    posicionplataformaY= 450;
    posicionplataformaX2= 550;
    posicionplataformaY2= 550;
    trianguloArriba = 450.0;
    trianguloDerecha = 480.0;
    trianguloIzquierda = 420.0;
    trianguloArriba2 = 550.0;
    trianguloDerecha2 = 580.0;
    trianguloIzquierda2 = 520.0;
    Distancia = 0;   
    musicaFondo.stop();
    musicaFondo.play(); 
    }
    
    
    public static void main(String[] args) {
        launch();
    }

}