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
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class InicioController extends Controller {

    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Button btn;
  

    @Override
    public void initialize() {
        
        //lbl1.setText("Hola ");


    }

    @FXML
    private void pasar(ActionEvent event) {
        
        FlowController.getInstance().goViewInWindow("Menu");
        
    }
    
}
