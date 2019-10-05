/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

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
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class Nivel1Controller extends Controller {

    @FXML
    private ImageView pacman;

  

    @Override
    public void initialize() {
        
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/pacman.png");
            pacman.setImage(imgLogo);
        } catch (Exception e) {
        }

    }

    private void pasar(ActionEvent event) {
        
        FlowController.getInstance().goViewInWindow("Menu");
        
    }

    @FXML
    private void Movimiento(KeyEvent event) {
        
        
        
    }
    
}
