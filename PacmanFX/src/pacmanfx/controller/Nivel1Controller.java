/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import com.sun.prism.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class Nivel1Controller extends Controller {

    @FXML
    private ImageView pacman;
    double x = 0, y = 0, velx = 9, vely = 9;
    boolean der, izq, arr, aba = false;
    char Mapa[][] = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
    {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
    {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

    @FXML
    private AnchorPane root;

    @Override
    public void initialize() {

        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/pacman.png");
            pacman.setImage(imgLogo);
        } catch (Exception e) {
        }
        pacman.setFocusTraversable(true);

        CrearMapa();
        Mov();
    }

    private void pasar(ActionEvent event) {

        FlowController.getInstance().goViewInWindow("Menu");

    }

    @FXML
    private void Movimiento(KeyEvent event) {

    }

    @FXML
    private void MoverPacman(KeyEvent event) {
        if (event.getCode() == event.getCode().DOWN) {
            down();
            pacman.setRotate(90);

        }
        if (event.getCode() == event.getCode().LEFT) {
            left();
            pacman.setRotate(-180);

        }
        if (event.getCode() == event.getCode().UP) {
            up();
            pacman.setRotate(-90);

        }
        if (event.getCode() == event.getCode().RIGHT) {
            right();
            pacman.setRotate(0);
        }

        pacman.setLayoutY(pacman.getLayoutY() + vely);
        pacman.setLayoutX(pacman.getLayoutX() + velx);
        Timeline timeline = new Timeline();
        
        KeyValue kv = new KeyValue(pacman.layoutXProperty(),pacman.getLayoutX()+200);
        KeyValue kvy = new KeyValue(pacman.layoutYProperty(),pacman.getLayoutY());
        KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
        KeyFrame kfy = new KeyFrame(Duration.millis(1000), kvy);
        timeline.getKeyFrames().addAll(kf, kfy);
        timeline.play();
        
    }

    public void up() {
        vely = -1.5;
        velx = 0;
    }

    public void down() {
        vely = 1.5;
        velx = 0;
    }

    public void left() {
        velx = -1.5;

        vely = 0;
    }

    public void right() {
        velx = 1.5;
        vely = 0;
    }

     public void CrearMapa() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 29; j++) {
                if (Mapa[i][j] == 'X') {
                    Rectangle rec = new Rectangle(j * 30, i * 30, 30, 30);
                    rec.setFill(Paint.valueOf("BLUE"));
                    root.getChildren().add(rec);
                }
            }
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 29; j++) {
                if (Mapa[i][j] == 'X') {//pared
                    Rectangle rec = new Rectangle(j * 30, i * 30, 30, 30);
                    rec.setFill(Paint.valueOf("BLUE"));
                    root.getChildren().add(rec);//tamaño y posición del cada uno de los rectangulos
                } else if (Mapa[i][j] == '@') {//pacman
                    
                    //System.out.print("@");
                   /* pacMan2D pacMan = new pacMan2D(x, y, 23, 23, (aux == 39) ? 30 : (aux == 37) ? 210 : (aux == 38) ? 120 : 300, 300, Arc2D.PIE);
                    pacMan.getpMan();
                    root.getChildren().add(pacMan.getpMan());//*/
                    //x, y son las posiciones del pacman, van a ir cambiando dependiendo de que tecla se use
                } else if (Mapa[i][j] == ' ') {//espacio en blanco
                    Circle circle = new Circle(j * 31 + 10, i * 29 + 5, 4, Paint.valueOf("YELLOW"));
                    root.getChildren().add(circle);//tamaño y posición del cada uno de los rectangulos
                   
                    //Aquí están los puntos para comerse, hay que ver como acomodarlos,
                    //System.out.print(" ");
                }
                if (Mapa[i][j] == 'X' && i == 9 && j == 14) {//pared
                    //System.out.print("X");
                  /*  g2.setColor(Color.black);
                    g2.fillRect(j * 31, i * 28, 31, 28);//tamaño y posición del cada uno de los rectangulos
                    g2.setColor(new Color(209, 209, 209));
                    g2.fillRect(j * 31, i * 28 + 10, 31, 4);*/
                }
                if (Mapa[i][j] == ' ') {
                 //   contPuntos++;
                }
            }
            //System.out.print("\n");
        }

    }

    public void Mov() {
        pacman.layoutXProperty().addListener(listener -> {
            if (der) {
                pacman.setLayoutX(pacman.getLayoutX() + velx);
            }

        });
        pacman.layoutYProperty().addListener(listener -> {

        });
    }
}
