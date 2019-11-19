/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Top10Controller extends Controller implements Initializable {

    @FXML
    private ImageView omg;
    @FXML
    private Label lblVolver;
    @FXML
    private Label top1;
    @FXML
    private Label top2;
    @FXML
    private Label top3;
    @FXML
    private Label top4;
    @FXML
    private Label top5;
    @FXML
    private Label top6;
    @FXML
    private Label top7;
    @FXML
    private Label top8;
    @FXML
    private Label top9;
    @FXML
    private Label top10;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image imgLogo;
        omg.setImage(new Image("/pacmanfx/resources/fondo8.jpg"));
        /*
         *  Cargo los mejores puntajes de todos los tiempos
        */
        try{
            File f13 = new File(".");
            String dir13 = f13.getAbsolutePath();
            String fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top1.txt";
            File file13 = new File(fileName13);
            FileReader fr13 = new FileReader(file13);
            BufferedReader br13 = new BufferedReader(fr13);
            String line13;
            while ((line13 = br13.readLine()) != null) {
                top1.setText(top1.getText() + "   " +line13);
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top2.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                top2.setText(top2.getText() + "   " +line13);
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top3.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                top3.setText(top3.getText() + "   " +line13);
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top4.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                top4.setText(top4.getText() + "   " +line13);
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top5.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                top5.setText(top5.getText() + "   " +line13);
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top6.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                top6.setText(top6.getText() + "   " +line13);
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top7.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                top7.setText(top7.getText() + "   " +line13);
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top8.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                top8.setText(top8.getText() + "   " +line13);
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top9.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                top9.setText(top9.getText() + "   " +line13);
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top10.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                top10.setText(top10.getText() + " " +line13);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @Override
    public void initialize() {
        
    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Menu", this.getStage());
    }
    
}
