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
import javafx.scene.shape.Circle;
/**
 * JavaFX App
 */
public class App extends Application {
    int velocidad = 3;
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
    int posicionplataformaX2= 650;
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
    int SueloY= 585;
    boolean Sueloboolean = true;
    AudioClip musicaFondo;
    AudioClip Muerte;
    AudioClip Victoria;
    int BanderaX = 1300;
    int MonedaX = 800;
    int MonedaY = 300;
    double zonaMonedaX = 412.5;
    int zonaMonedaY = 325;
    int Salto = 0;
    Timeline animationCubo;
    Pane root;
    Text textTitleWin;
    Circle CirculoMoneda;
    Image Moneda;
    ImageView MonedaView;
    ImageView BanderaView;
    @Override
    public void start(Stage stage) {
        //PANEL ROOT
        root = new Pane();
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
        Image fondo = new Image(getClass().getResourceAsStream("/images/fondo.png"));
        ImageView fondoView = new ImageView(fondo);
        fondoView.setLayoutX(fondox);
        
        //SEGUNDA IMAGEN FONDO
        Image fondo2 = new Image(getClass().getResourceAsStream("/images/fondo.png"));
        ImageView fondo2View = new ImageView(fondo2);
        fondo2View.setLayoutX(fondo2x);
        
        //Bandera España
        Image Bandera = new Image(getClass().getResourceAsStream("/images/Bandera.png"));
        BanderaView = new ImageView(Bandera);
        BanderaView.setLayoutX(BanderaX);
        BanderaView.setLayoutY(-50);
        
        //Moneda
        Moneda = new Image(getClass().getResourceAsStream("/images/Coin.png"));
        MonedaView = new ImageView(Moneda);
        MonedaView.setLayoutX(MonedaX);
        MonedaView.setLayoutY(MonedaY);
        MonedaView.setFitWidth(50);
        MonedaView.setFitHeight(50);
        
        //Zona moneda
        CirculoMoneda = new Circle(zonaMonedaX,zonaMonedaY,25);
        CirculoMoneda.setFill(Color.BLACK);
        CirculoMoneda.setVisible(false);
        
        
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
        
        //LINEA SUELO
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
        
        //SONIDO MUERTE
        URL urlMuerte = getClass().getResource("/audio/Muerte.mp3");
        if(urlMuerte != null) {
            try {
                Muerte = new AudioClip(urlMuerte.toURI().toString());
                
            } catch (URISyntaxException ex) {
            }            
        } else {
        System.out.println("No se ha encontrado el archivo de audio");
        }
        
        //SONIDO Victoria
        URL urlVictoria = getClass().getResource("/audio/Victoria.mp3");
        if(urlVictoria != null) {
            try {
                Victoria = new AudioClip(urlVictoria.toURI().toString());
                
            } catch (URISyntaxException ex) {
            }            
        } else {
        System.out.println("No se ha encontrado el archivo de audio");
        }
        
        //FONDO Y IMAGENES
        root.getChildren().add(fondoView);
        root.getChildren().add(fondo2View);
        root.getChildren().add(BanderaView);
        root.getChildren().add(MonedaView);
        root.getChildren().add(CirculoMoneda);
        
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
        
        //AÑADIR SUELO
        root.getChildren().add(Suelo);
        
        //TIMELINE
        animationCubo = new Timeline(
        new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) ->{
            //TRANSLATE PERSONAJE
        groupPersonaje.setTranslateX(posicionCuboX);
        groupPersonaje.setLayoutY(posicionCuboY);
            
            //TRANSLATE Y VELOCIDAD PLATAFORMAS
            plataforma.setTranslateX(posicionplataformaX);
            posicionplataformaX -= velocidad;
            plataforma2.setTranslateX(posicionplataformaX2);
            posicionplataformaX2 -= velocidad;
            
            
            //LAYOUTS Y VELOCIDAD PLATAFORMAS
            trianguloArriba -= velocidad;
            trianguloDerecha -= velocidad;
            trianguloIzquierda -= velocidad;
            triangulo.setLayoutX(trianguloArriba);
            triangulo.setLayoutX(trianguloDerecha);
            triangulo.setLayoutX(trianguloIzquierda);
            
            trianguloArriba2 -= velocidad;
            trianguloDerecha2 -= velocidad;
            trianguloIzquierda2 -= velocidad;
            triangulo2.setLayoutX(trianguloArriba2);
            triangulo2.setLayoutX(trianguloDerecha2);
            triangulo2.setLayoutX(trianguloIzquierda2);
            
            //Bandera Victoria
            BanderaView.setLayoutX(BanderaX);
            BanderaX+= velocidadFondo;
            if (posicionCuboX >= BanderaX+120){
               Victoria();
            }
            
            //Moneda
            MonedaView.setLayoutX(MonedaX);
            CirculoMoneda.setLayoutX(zonaMonedaX);
            
            MonedaX+= velocidadFondo;
            zonaMonedaX+= velocidadFondo;
            
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
        
         //DISTANCIA
            Distancia += 1;
            textScore.setText(String.valueOf(Distancia));
            
         //DISTANCIA MAXIMA
        if (Distancia > DistanciaMaxima){
                    DistanciaMaxima = Distancia;
                    textHighScore.setText(String.valueOf(DistanciaMaxima));
                }
        
        // SALTO
        if (Salto >= -190 && movimientoCuboY == -10){
            posicionCuboYMovimiento =-4;
            Salto -= 4;
            posicionCuboY += posicionCuboYMovimiento;
            System.out.println(posicionCuboYMovimiento);
        }
        //CAIDA
        else{
            movimientoCuboY = 0;
            Salto = 0;
            posicionCuboYMovimiento = 4;
            posicionCuboY += posicionCuboYMovimiento;
            Sueloboolean = true;
        }

        //Colison SUELO
        Shape shapeSuelo = Shape.intersect(Suelo, lineaYAbajo);
        boolean colisionSuelo = shapeSuelo.getBoundsInLocal().isEmpty();
        if (colisionSuelo == false && (Sueloboolean == true)){
            posicionCuboY = SueloY-50;
            posicionCuboYMovimiento= 0;
            Salto = 0;
        }

        //Colison Moneda
        Shape shapeMoneda = Shape.intersect(CirculoMoneda, lineaYAbajo);
                boolean colisionMoneda = shapeMoneda.getBoundsInLocal().isEmpty();
                if (colisionMoneda == false){
                    //MonedaCogida
                    CogerMoneda();
                }
        //COLISON PLATAFORMA ARRIBA
        Shape shapeColisonPlataformaY = Shape.intersect(plataforma, lineaYAbajo);
            boolean colisionVaciaPlataformaY = shapeColisonPlataformaY.getBoundsInLocal().isEmpty();
            if(colisionVaciaPlataformaY == false && (posicionlineaYAbajo+posicionplataformaY -50) == posicionplataformaY && (Sueloboolean == true)){
                posicionCuboY = posicionplataformaY-50;
                posicionCuboYMovimiento= 0;
                
            }
            
            
            //COLISON PLATAFORMA LADOS
            Shape shapeColisonPlataformaX = Shape.intersect(plataforma2, lineaXDerecha);
            boolean colisionVaciaPlataformaX = shapeColisonPlataformaX.getBoundsInLocal().isEmpty();
            if(colisionVaciaPlataformaX == false && (posicionlineaXDerecha+posicionplataformaX -50) == posicionplataformaX){
                Muerte();
            }
            
            //COLISON PLATAFORMA2 ARRIBA
        Shape shapeColisonPlataformaY2 = Shape.intersect(plataforma2, lineaYAbajo);
            boolean colisionVaciaPlataformaY2 = shapeColisonPlataformaY2.getBoundsInLocal().isEmpty();
            if(colisionVaciaPlataformaY2 == false && (posicionlineaYAbajo+posicionplataformaY2 -50) == posicionplataformaY2 && (Sueloboolean == true)){
                posicionCuboY = posicionplataformaY2-50;
                posicionCuboYMovimiento= 0;
                
            }
            
            
            //COLISON PLATAFORMA2 LADOS
            Shape shapeColisonPlataformaX2 = Shape.intersect(plataforma, lineaXDerecha);
            boolean colisionVaciaPlataformaX2 = shapeColisonPlataformaX2.getBoundsInLocal().isEmpty();
            if(colisionVaciaPlataformaX2 == false && (posicionlineaXDerecha+posicionplataformaX2 -50) == posicionplataformaX2){
                Muerte();
            }
            
            
        //COLISION TRIANGULO MUERTE
        Shape shapeColisonMuerte = Shape.intersect(triangulo, cubo);
        boolean colisionMuerte = shapeColisonMuerte.getBoundsInLocal().isEmpty();
        if(colisionMuerte == false){
            
        Muerte();
            }
        
        //COLISION TRIANGULO2 MUERTE
        Shape shapeColisonMuerte2 = Shape.intersect(triangulo2, cubo);
        boolean colisionMuerte2 = shapeColisonMuerte2.getBoundsInLocal().isEmpty();
        if(colisionMuerte2 == false){
        Muerte();
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
                case ENTER:
                   if (posicionCuboX >= BanderaX+120){
               Reinicio();
            } 
                   else {
                       Muerte();
                   }
            
                break;
            }
        });

        scene.setOnKeyReleased((KeyEvent event) -> {
            
        });
        
    }
    
// VOID DE COGER MONEDA
    private void CogerMoneda(){
        Image MonedaCogida = new Image(getClass().getResourceAsStream("/images/Coin.png"));
        ImageView MonedaCogidaView = new ImageView(MonedaCogida);
        MonedaCogidaView.setLayoutX(20);
        MonedaCogidaView.setLayoutY(30);
        MonedaCogidaView.setFitWidth(30);
        MonedaCogidaView.setFitHeight(30);
        root.getChildren().add(MonedaCogidaView);
        MonedaView.setVisible(false);
    }
    
// VOID DE REINICIO
    private void Reinicio() {
        animationCubo.play();
        musicaFondo.play();
    velocidad = 3;
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
    posicionplataformaX2= 650;
    posicionplataformaY2= 525;
    trianguloArriba = 450.0;
    trianguloDerecha = 480.0;
    trianguloIzquierda = 420.0;
    trianguloArriba2 = 650.0;
    trianguloDerecha2 = 680.0;
    trianguloIzquierda2 = 620.0;
    Distancia = 0;
    SueloY= 585;
    Sueloboolean = true;
    BanderaX = 1300;
    MonedaX = 800;
    MonedaY = 300;
    zonaMonedaX = 412.5;
    zonaMonedaY = 325;
    Salto = 0;
    
    textTitleWin.setVisible(false);
    MonedaView.setVisible(true);
    }
    
    // VOID DE MUERTE Y REINICIO EN CUALQUIER LADO
    private void Muerte() {
        animationCubo.play();
        Muerte.play();
    velocidad = 3;
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
    posicionplataformaX2= 650;
    posicionplataformaY2= 525;
    trianguloArriba = 450.0;
    trianguloDerecha = 480.0;
    trianguloIzquierda = 420.0;
    trianguloArriba2 = 650.0;
    trianguloDerecha2 = 680.0;
    trianguloIzquierda2 = 620.0;
    Distancia = 0;
    SueloY= 585;
    Sueloboolean = true;
    BanderaX = 1300;
    MonedaX = 800;
    MonedaY = 300;
    zonaMonedaX = 412.5;
    zonaMonedaY = 325;
    Salto = 0; 
    
    musicaFondo.stop();
    musicaFondo.play();
    MonedaView.setVisible(true);
    }
    
    //VOID DE VICTORIA
    private void Victoria() {
        animationCubo.stop();
        musicaFondo.stop();
        Victoria.play();
        
    //TEXTO WIN
        HBox paneWin = new HBox();
        paneWin.setTranslateY(80);
        paneWin.setMinWidth(ancho_Pantalla);
        paneWin.setAlignment(Pos.BASELINE_CENTER);
        paneWin.setSpacing(100);
        // LAYOUT PARA DISTANCIA ACTUAL
        HBox paneCurrentWin = new HBox();
        paneCurrentWin.setSpacing(10);
        
        // TEXTO DE ETIQUETA PARA WIN
        textTitleWin = new Text("YOU WIN");
        textTitleWin.setFont(Font.font(180));
        textTitleWin.setFill(Color.BLUE);
        textTitleWin.setVisible(true);
        
        // AÑADIR LOS TEXTOS A LOS LAYOUTS RESERVADOS PARA ELLOS
        root.getChildren().add(paneWin);
        paneWin.getChildren().add(paneCurrentWin);
        paneCurrentWin.getChildren().add(textTitleWin);
        
    }
    
    
    public static void main(String[] args) {
        launch();
    }

}