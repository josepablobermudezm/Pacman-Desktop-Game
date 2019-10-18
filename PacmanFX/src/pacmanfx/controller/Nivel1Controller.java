/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import com.sun.prism.paint.Color;
import java.awt.BasicStroke;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import pacmanfx.model.Nodo;
import pacmanfx.model.Arista;
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class Nivel1Controller extends Controller {

    @FXML
    private ImageView pacman;
    double x = 434, y = 392, velx = 0, vely = 0;
    int code = 39/*por default a la derecha*/, cont = 0, gameStatus = 0, MouseX = 0, MouseY = 0,
            xAux = 434, yAux = 392, jAux = 14, iAux = 14, aux = 0, aux2 = 0, cont1 = 0, cont2 = 0, cont4 = 0, vidas = 6, cont3 = 0, contPuntos = 0,
            cont5 = 0, cont6 = 0, cont7 = 0, cont8 = 0, cont9 = 0, cont10 = 0;
    static boolean up = false, down = false, left = false, right = false, value = false, mapa2 = false, Nivel1 = true, Nivel2 = false, Nivel3 = false, Nivel4 = false,
            Nivel5 = false, Nivel6 = false, Nivel7 = false, Nivel8 = false, Nivel9 = false, Nivel10 = false;
    String nivel = "Nivel 1";

    private ArrayList<Nodo> nodos = new ArrayList();
    private ArrayList<Arista> aristas = new ArrayList();

    char Mapa[][]
            = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'/', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', '/'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
    //vector de char, para cambiar un nivel lo que se hace es cargar este vector sobre la matriz ya existente
    char Mapa2[][]
            = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X'},
            {'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X'},
            {'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X'},
            {'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', 'X'},
            {'X', 'X', ' ', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', 'X'},
            {'X', 'X', ' ', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', ' ', 'X', 'X'},
            {'X', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', 'X', 'X'},
            {'X', 'X', ' ', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', ' ', 'X', 'X'},
            {'/', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', '/'},
            {'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X'},
            {'X', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
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
//        Mov();
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

        KeyValue kv = new KeyValue(pacman.layoutXProperty(), pacman.getLayoutX() + 200);
        KeyValue kvy = new KeyValue(pacman.layoutYProperty(), pacman.getLayoutY());
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

        /*   for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 29; j++) {
                if (Mapa[i][j] == 'X') {
                    Rectangle rec = new Rectangle(j * 45, i * 30, 45, 30);
                    rec.setFill(Paint.valueOf("BLUE"));
                    root.getChildren().add(rec);
                }
            }
        }*/
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/pacmanfx/resources/Nodos.txt"));
            String line = null;
            Integer i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts;
                parts = line.split("\\$");
                Double posx = Double.valueOf(parts[0]);
                Double posy = Double.valueOf(parts[1]);

                Nodo nodo = new Nodo(posx,posy);
                Circle circle = new Circle(posx,posy, 3, Paint.valueOf("RED"));
                this.root.getChildren().add(circle);
                /*g2.setColor(java.awt.Color.RED);
                        g2.fillOval((int) nod.getPoint2D().getX(), (int) nod.getPoint2D().getY(), 4, 4);*/
                //nod.setPuntoMapa(new Point2D(posx, posy));
                i++;
                nodos.add(nodo);
            }
        } catch (IOException ex) {

        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/pacmanfx/resources/Arista.txt"));
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] parts;
                parts = line.split("\\$");
                Double posx = Double.valueOf(parts[0]);
                Double posy = Double.valueOf(parts[1]);
                Double posx2 = Double.valueOf(parts[2]);
                Double posy2 = Double.valueOf(parts[3]);

                Arista arista = new Arista(posx, posy, posx2, posy2);
                Line linea = new Line(posx, posy, posx2, posy2);
                linea.setStroke(Paint.valueOf("RED"));
                linea.setStrokeWidth(3.00);
                this.root.getChildren().add(linea);
                // System.out.println(posx+" "+posy+" "+posx2+" "+posy2);
                /*g2.setColor(java.awt.Color.red);
                g2.setStroke(new BasicStroke(3.0f));
                g2.drawLine(posx2.intValue(), posy2.intValue(), posx.intValue(), posy.intValue());*/

                arista.agregarNodos(nodos);
                aristas.add(arista);
            };
        } catch (Exception e) {
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 29; j++) {
                if (Mapa[i][j] == 'X') {//pared
                    Rectangle rec = new Rectangle(j * 31, i * 28, 31, 28);
                    rec.setFill(Paint.valueOf("BLUE"));
                    root.getChildren().add(rec);//tamaño y posición del cada uno de los rectangulos
                } else if (Mapa[i][j] == '@') {//pacman

                    //System.out.print("@");
                    /* pacMan2D pacMan = new pacMan2D(x, y, 23, 23, (aux == 39) ? 30 : (aux == 37) ? 210 : (aux == 38) ? 120 : 300, 300, Arc2D.PIE);
                    pacMan.getpMan();
                    root.getChildren().add(pacMan.getpMan());//*/
                    //x, y son las posiciones del pacman, van a ir cambiando dependiendo de que tecla se use
                } else if (Mapa[i][j] == ' ') {//espacio en blanco
                    Circle circle = new Circle(j * 31 + 12, i * 29 + 5, 3, Paint.valueOf("YELLOW"));
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

    /* public void Mov() {
        pacman.layoutXProperty().addListener(listener -> {
            if (der) {
                pacman.setLayoutX(pacman.getLayoutX() + velx);
            }

        });
        pacman.layoutYProperty().addListener(listener -> {

        });
    }*/
}
