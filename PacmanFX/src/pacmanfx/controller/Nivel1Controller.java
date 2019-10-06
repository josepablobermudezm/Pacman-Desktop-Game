/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import com.sun.prism.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.shape.Rectangle;
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
            pacman.setRotate(90);
            //pacman.setLayoutY(pacman.getLayoutY() + vely);
            
        }
        if (event.getCode() == event.getCode().LEFT) {
            pacman.setRotate(-180);
            
        }
        if (event.getCode() == event.getCode().UP) {
            pacman.setRotate(-90);
            
        }
        if (event.getCode() == event.getCode().RIGHT) {
            der=true;
            pacman.setLayoutX(pacman.getLayoutX());
            
            pacman.setRotate(0);
            
        }
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
    }
    public void Mov(){
         pacman.layoutXProperty().addListener(listener->{
             if(der){
                  pacman.setLayoutX(pacman.getLayoutX()+velx);
             }
           
        });
        pacman.layoutYProperty().addListener(listener->{
           
        });
    }
}
