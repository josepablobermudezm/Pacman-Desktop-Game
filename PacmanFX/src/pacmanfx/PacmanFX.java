/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pacmanfx.util.FlowController;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class PacmanFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        FlowController.getInstance().InitializeFlow(primaryStage, null);
        FlowController.getInstance().goMain();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
