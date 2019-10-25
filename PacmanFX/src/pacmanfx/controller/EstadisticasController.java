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
public class EstadisticasController extends Controller implements Initializable {

    @FXML
    private ImageView omg;
    @FXML
    private Label lblVolver;
    @FXML
    private Label lblTotalPuntos;
    @FXML
    private Label lblPuntosPartida;
    @FXML
    private Label lblPuntosPartidaVida;
    @FXML
    private Label lblVidasPerdidas;
    @FXML
    private Label lblNivel1;
    @FXML
    private Label lblNivel2;
    @FXML
    private Label lblNivel3;
    @FXML
    private Label lblNivel4;
    @FXML
    private Label lblNivel5;
    @FXML
    private Label lblNivel6;
    @FXML
    private Label lblNivel7;
    @FXML
    private Label lblNivel8;
    @FXML
    private Label lblNivel9;
    @FXML
    private Label lblNivel10;
    @FXML
    private Label lblTiempo1;
    @FXML
    private Label lblTiempo2;
    @FXML
    private Label lblTiempo3;
    @FXML
    private Label lblTiempo4;
    @FXML
    private Label lblTiempo5;
    @FXML
    private Label lblTiempo6;
    @FXML
    private Label lblTiempo7;
    @FXML
    private Label lblTiempo8;
    @FXML
    private Label lblTiempo9;
    @FXML
    private Label lblTiempo10;
    @FXML
    private Label lblFantasmasComidos;
    @FXML
    private Label lblTiempoTotalJuego;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        omg.setImage(new Image("/pacmanfx/resources/fondo8.jpg"));
    }    

    @Override
    public void initialize() {
        omg.setImage(new Image("/pacmanfx/resources/fondo8.jpg"));
    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Jugador", this.getStage());
    }
    
}
