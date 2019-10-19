/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class MenuController extends Controller{

    @FXML
    private ImageView omg;

    @Override
    public void initialize() {
        
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/fondo4.jpg");
            omg.setImage(imgLogo);
        } catch (Exception e) {
        }
        
    }

    @FXML
    private void Start(MouseEvent event) {
        FlowController.getInstance().goViewInWindowTransparent("SeleccionNivel");
        this.getStage().close();
    }

    @FXML
    private void Configuracion(MouseEvent event) {
        FlowController.getInstance().goViewInStage("Configuracion", this.getStage());
        //this.getStage().close();
    }

    @FXML
    private void Salir(MouseEvent event) {
        //FlowController.getMainStage().close();
        FlowController.getInstance().cerrar(stage);
    }

    @FXML
    private void jugador(MouseEvent event) {
        FlowController.getInstance().goViewInStage("Jugador", this.getStage());
    }
    
}
