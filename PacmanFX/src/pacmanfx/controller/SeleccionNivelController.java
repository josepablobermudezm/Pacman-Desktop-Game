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
public class SeleccionNivelController extends Controller implements Initializable {

    @FXML
    private ImageView omg;
    @FXML
    private Label lblVolver;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ImageView img8;
    @FXML
    private ImageView img9;
    @FXML
    private ImageView img10;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize() {
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/fondo8.jpg");
            omg.setImage(imgLogo);
        } catch (Exception e) {
        }
        Image img11;
        try {
            img11 = new Image("/pacmanfx/resources/FondoNivel1.jpg");
            img1.setImage(img11);
        } catch (Exception e) {
        }
        Image img22;
        try {
            img22 = new Image("/pacmanfx/resources/FondoNivel22.jpg");
            img2.setImage(img22);
        } catch (Exception e) {
        }
        Image img33;
        try {
            img33 = new Image("/pacmanfx/resources/FondoNivel3.jpg");
            img3.setImage(img33);
        } catch (Exception e) {
        }
        Image img44;
        try {
            img44 = new Image("/pacmanfx/resources/FondoNivel4.jpg");
            img4.setImage(img44);
        } catch (Exception e) {
        }
        Image img55;
        try {
            img55 = new Image("/pacmanfx/resources/FondoNivel5.jpg");
            img5.setImage(img55);
        } catch (Exception e) {
        }
        Image img66;
        try {
            img66 = new Image("/pacmanfx/resources/FondoNivel6.jpg");
            img6.setImage(img66);
        } catch (Exception e) {
        }
        Image img77;
        try {
            img77 = new Image("/pacmanfx/resources/FondoNivel7.jpg");
            img7.setImage(img77);
        } catch (Exception e) {
        }
        Image img88;
        try {
            img88 = new Image("/pacmanfx/resources/FondoNivel8.jpg");
            img8.setImage(img88);
        } catch (Exception e) {
        }
        Image img99;
        try {
            img99 = new Image("/pacmanfx/resources/FondoNivel9.jpg");
            img9.setImage(img99);
        } catch (Exception e) {
        }
        Image img100;
        try {
            img100 = new Image("/pacmanfx/resources/FondoNivel10.jpg");
            img10.setImage(img100);
        } catch (Exception e) {
        }
    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Menu", this.getStage());
    }

    @FXML
    private void Nivel1(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Nivel1", this.getStage());
    }

    @FXML
    private void Nivel2(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Nivel2", this.getStage());
    }

    @FXML
    private void Nivel3(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Nivel3", this.getStage());
    }

    @FXML
    private void Nivel4(MouseEvent event) {
        FlowController.getInstance().goViewInWindowTransparent("Nivel4");
        this.getStage().close();
    }

    @FXML
    private void Nivel5(MouseEvent event) {
        FlowController.getInstance().goViewInWindowTransparent("Nivel5");
        this.getStage().close();
    }

    @FXML
    private void Nivel6(MouseEvent event) {
        FlowController.getInstance().goViewInWindowTransparent("Nivel6");
        this.getStage().close();
    }

    @FXML
    private void Nivel7(MouseEvent event) {
        FlowController.getInstance().goViewInWindowTransparent("Nivel7");
        this.getStage().close();
    }

    @FXML
    private void Nivel8(MouseEvent event) {
        FlowController.getInstance().goViewInWindowTransparent("Nivel8");
        this.getStage().close();
    }

    @FXML
    private void Nivel9(MouseEvent event) {
        FlowController.getInstance().goViewInWindowTransparent("Nivel9");
        this.getStage().close();
    }

    @FXML
    private void Nivel10(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Nivel10", this.getStage());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/fondo8.jpg");
            omg.setImage(imgLogo);
        } catch (Exception e) {
        }
        Image img11;
        try {
            img11 = new Image("/pacmanfx/resources/FondoNivel1.jpg");
            img1.setImage(img11);
        } catch (Exception e) {
        }
        Image img22;
        try {
            img22 = new Image("/pacmanfx/resources/FondoNivel22.jpg");
            img2.setImage(img22);
        } catch (Exception e) {
        }
        Image img33;
        try {
            img33 = new Image("/pacmanfx/resources/FondoNivel3.jpg");
            img3.setImage(img33);
        } catch (Exception e) {
        }
        Image img44;
        try {
            img44 = new Image("/pacmanfx/resources/FondoNivel4.jpg");
            img4.setImage(img44);
        } catch (Exception e) {
        }
        Image img55;
        try {
            img55 = new Image("/pacmanfx/resources/FondoNivel5.jpg");
            img5.setImage(img55);
        } catch (Exception e) {
        }
        Image img66;
        try {
            img66 = new Image("/pacmanfx/resources/FondoNivel6.jpg");
            img6.setImage(img66);
        } catch (Exception e) {
        }
        Image img77;
        try {
            img77 = new Image("/pacmanfx/resources/FondoNivel7.jpg");
            img7.setImage(img77);
        } catch (Exception e) {
        }
        Image img88;
        try {
            img88 = new Image("/pacmanfx/resources/FondoNivel8.jpg");
            img8.setImage(img88);
        } catch (Exception e) {
        }
        Image img99;
        try {
            img99 = new Image("/pacmanfx/resources/FondoNivel9.jpg");
            img9.setImage(img99);
        } catch (Exception e) {
        }
        Image img100;
        try {
            img100 = new Image("/pacmanfx/resources/FondoNivel10.jpg");
            img10.setImage(img100);
        } catch (Exception e) {
        }
    }
}
