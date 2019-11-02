/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import static java.awt.SystemColor.text;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static pacmanfx.controller.SeleccionNivelController.dificultad;
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class JugadorController extends Controller {

    @FXML
    private ImageView omg;
    @FXML
    private Label lblVolver;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Label lbl;
    @FXML
    private ImageView logro1;
    @FXML
    private ImageView logro2;
    @FXML
    private ImageView logro3;
    @FXML
    private ImageView logro4;
    @FXML
    private ImageView logro5;
    @FXML
    private ImageView logro6;

    int Nivel1 = 0, Nivel2 = 0, Nivel3 = 0, Nivel4 = 0, Nivel5 = 0, Nivel6 = 0, Nivel7 = 0, Nivel8 = 0, Nivel9 = 0, Nivel10 = 0,
            Nivel11 = 0, Nivel22 = 0, Nivel33 = 0, Nivel44 = 0, Nivel55 = 0, Nivel66 = 0, Nivel77 = 0, Nivel88 = 0, Nivel99 = 0, Nivel100 = 0,
            Nivel111 = 0, Nivel222 = 0, Nivel333 = 0, Nivel444 = 0, Nivel555 = 0, Nivel666 = 0, Nivel777 = 0, Nivel888 = 0, Nivel999 = 0, Nivel1000 = 0,
            cantFantasmas = 0, vidasConsecutivas = 0, vidasConsecutivasAux = 0, EncierroCont = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize() {
        Image imgLogo;
        omg.setImage(new Image("/pacmanfx/resources/fondo8.jpg"));
        /*logro1.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro2.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro3.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro4.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro5.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro6.setImage(new Image("/pacmanfx/resources/premio.png"));
         */
        try {
            try {
                File f = new File(".");
                String dir = f.getAbsolutePath();
                String fileName = dir + "\\src\\pacmanfx\\resources\\Dificultad.txt";
                File file = new File(fileName);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    dificultad = Integer.parseInt(line);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = (dir + "\\src\\pacmanfx\\resources\\Nivel1Completado.txt");
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                Nivel1 = Integer.parseInt(line);
            }
            File f2 = new File(".");
            String dir2 = f2.getAbsolutePath();
            String fileName2 = (dir2 + "\\src\\pacmanfx\\resources\\Nivel2Completado.txt");
            File file2 = new File(fileName2);
            FileReader fr2 = new FileReader(file2);
            BufferedReader br2 = new BufferedReader(fr2);
            String line2;
            while ((line2 = br2.readLine()) != null) {
                Nivel2 = Integer.parseInt(line2);
            }
            File f3 = new File(".");
            String dir3 = f3.getAbsolutePath();
            String fileName3 = (dir3 + "\\src\\pacmanfx\\resources\\Nivel3Completado.txt");
            File file3 = new File(fileName3);
            FileReader fr3 = new FileReader(file3);
            BufferedReader br3 = new BufferedReader(fr3);
            String line3;
            while ((line3 = br3.readLine()) != null) {
                Nivel3 = Integer.parseInt(line3);
            }
            File f4 = new File(".");
            String dir4 = f4.getAbsolutePath();
            String fileName4 = (dir4 + "\\src\\pacmanfx\\resources\\Nivel4Completado.txt");
            File file4 = new File(fileName4);
            FileReader fr4 = new FileReader(file4);
            BufferedReader br4 = new BufferedReader(fr4);
            String line4;
            while ((line4 = br4.readLine()) != null) {
                Nivel4 = Integer.parseInt(line4);
            }
            File f5 = new File(".");
            String dir5 = f5.getAbsolutePath();
            String fileName5 = (dir5 + "\\src\\pacmanfx\\resources\\Nivel5Completado.txt");
            File file5 = new File(fileName5);
            FileReader fr5 = new FileReader(file5);
            BufferedReader br5 = new BufferedReader(fr5);
            String line5;
            while ((line5 = br5.readLine()) != null) {
                Nivel5 = Integer.parseInt(line5);
            }
            File f6 = new File(".");
            String dir6 = f6.getAbsolutePath();
            String fileName6 = (dir6 + "\\src\\pacmanfx\\resources\\Nivel6Completado.txt");
            File file6 = new File(fileName6);
            FileReader fr6 = new FileReader(file6);
            BufferedReader br6 = new BufferedReader(fr6);
            String line6;
            while ((line6 = br6.readLine()) != null) {
                Nivel6 = Integer.parseInt(line6);
            }
            File f7 = new File(".");
            String dir7 = f7.getAbsolutePath();
            String fileName7 = (dir7 + "\\src\\pacmanfx\\resources\\Nivel7Completado.txt");
            File file7 = new File(fileName7);
            FileReader fr7 = new FileReader(file7);
            BufferedReader br7 = new BufferedReader(fr7);
            String line7;
            while ((line7 = br7.readLine()) != null) {
                Nivel7 = Integer.parseInt(line7);
            }
            File f8 = new File(".");
            String dir8 = f8.getAbsolutePath();
            String fileName8 = (dir8 + "\\src\\pacmanfx\\resources\\Nivel8Completado.txt");
            File file8 = new File(fileName8);
            FileReader fr8 = new FileReader(file8);
            BufferedReader br8 = new BufferedReader(fr8);
            String line8;
            while ((line8 = br8.readLine()) != null) {
                Nivel8 = Integer.parseInt(line8);
            }
            File f9 = new File(".");
            String dir9 = f9.getAbsolutePath();
            String fileName9 = (dir9 + "\\src\\pacmanfx\\resources\\Nivel9Completado.txt");
            File file9 = new File(fileName9);
            FileReader fr9 = new FileReader(file9);
            BufferedReader br9 = new BufferedReader(fr9);
            String line9;
            while ((line9 = br9.readLine()) != null) {
                Nivel9 = Integer.parseInt(line9);
            }
            File f10 = new File(".");
            String dir10 = f10.getAbsolutePath();
            String fileName10 = (dir10 + "\\src\\pacmanfx\\resources\\Nivel10Completado.txt");
            File file10 = new File(fileName10);
            FileReader fr10 = new FileReader(file10);
            BufferedReader br10 = new BufferedReader(fr10);
            String line10;
            while ((line10 = br10.readLine()) != null) {
                Nivel10 = Integer.parseInt(line10);
            }
            
            String fileName20 = (dir + "\\src\\pacmanfx\\resources\\IntNivel1Completado.txt");
            File file20 = new File(fileName20);
            FileReader fr20 = new FileReader(file20);
            BufferedReader br20 = new BufferedReader(fr20);
            String line20;
            while ((line20 = br20.readLine()) != null) {
                Nivel11 = Integer.parseInt(line20);
            }
            
            String fileName21 = (dir2 + "\\src\\pacmanfx\\resources\\IntNivel2Completado.txt");
            File file21 = new File(fileName21);
            FileReader fr21 = new FileReader(file21);
            BufferedReader br21 = new BufferedReader(fr21);
            String line21;
            while ((line21 = br21.readLine()) != null) {
                Nivel22 = Integer.parseInt(line21);
            }
            String fileName22 = (dir3 + "\\src\\pacmanfx\\resources\\IntNivel3Completado.txt");
            File file22 = new File(fileName22);
            FileReader fr22 = new FileReader(file22);
            BufferedReader br22 = new BufferedReader(fr22);
            String line22;
            while ((line22 = br22.readLine()) != null) {
                Nivel33 = Integer.parseInt(line22);
            }
            String fileName23 = (dir2 + "\\src\\pacmanfx\\resources\\IntNivel4Completado.txt");
            File file23 = new File(fileName23);
            FileReader fr23 = new FileReader(file23);
            BufferedReader br23 = new BufferedReader(fr23);
            String line23;
            while ((line23 = br23.readLine()) != null) {
                Nivel44 = Integer.parseInt(line23);
            }
            String fileName24 = (dir5 + "\\src\\pacmanfx\\resources\\IntNivel5Completado.txt");
            File file24 = new File(fileName24);
            FileReader fr24 = new FileReader(file24);
            BufferedReader br24 = new BufferedReader(fr24);
            String line24;
            while ((line24 = br24.readLine()) != null) {
                Nivel55 = Integer.parseInt(line24);
            }
            String fileName25 = (dir6 + "\\src\\pacmanfx\\resources\\IntNivel6Completado.txt");
            File file25 = new File(fileName25);
            FileReader fr25 = new FileReader(file25);
            BufferedReader br25 = new BufferedReader(fr25);
            String line25;
            while ((line25 = br6.readLine()) != null) {
                Nivel66 = Integer.parseInt(line25);
            }
            String fileName26= (dir7 + "\\src\\pacmanfx\\resources\\IntNivel7Completado.txt");
            File file26 = new File(fileName26);
            FileReader fr26 = new FileReader(file26);
            BufferedReader br26 = new BufferedReader(fr26);
            String line26;
            while ((line26 = br26.readLine()) != null) {
                Nivel77 = Integer.parseInt(line26);
            }
            String fileName27 = (dir2 + "\\src\\pacmanfx\\resources\\IntNivel8Completado.txt");
            File file27 = new File(fileName27);
            FileReader fr27 = new FileReader(file27);
            BufferedReader br27 = new BufferedReader(fr27);
            String line27;
            while ((line27 = br27.readLine()) != null) {
                Nivel88 = Integer.parseInt(line27);
            }
            String fileName28 = (dir9 + "\\src\\pacmanfx\\resources\\IntNivel9Completado.txt");
            File file28 = new File(fileName28);
            FileReader fr28 = new FileReader(file28);
            BufferedReader br28 = new BufferedReader(fr28);
            String line28;
            while ((line28 = br28.readLine()) != null) {
                Nivel99 = Integer.parseInt(line28);
            }
            String fileName100 = (dir10 + "\\src\\pacmanfx\\resources\\IntNivel10Completado.txt");
            File file100 = new File(fileName100);
            FileReader fr100 = new FileReader(file100);
            BufferedReader br100 = new BufferedReader(fr100);
            String line100;
            while ((line100 = br100.readLine()) != null) {
                Nivel100 = Integer.parseInt(line100);
            }
            
            String fileName31 = (dir2 + "\\src\\pacmanfx\\resources\\DifNivel1Completado.txt");
            File file31 = new File(fileName31);
            FileReader fr31 = new FileReader(file31);
            BufferedReader br31 = new BufferedReader(fr31);
            String line31;
            while ((line31 = br31.readLine()) != null) {
                Nivel111 = Integer.parseInt(line31);
            }
            String fileName32 = (dir2 + "\\src\\pacmanfx\\resources\\DifNivel2Completado.txt");
            File file32 = new File(fileName32);
            FileReader fr32 = new FileReader(file32);
            BufferedReader br32 = new BufferedReader(fr32);
            String line32;
            while ((line32 = br32.readLine()) != null) {
                Nivel222 = Integer.parseInt(line32);
            }
            String fileName33 = (dir3 + "\\src\\pacmanfx\\resources\\DifNivel3Completado.txt");
            File file33 = new File(fileName33);
            FileReader fr33 = new FileReader(file33);
            BufferedReader br33 = new BufferedReader(fr33);
            String line33;
            while ((line33 = br33.readLine()) != null) {
                Nivel333 = Integer.parseInt(line33);
            }
            String fileName34 = (dir4 + "\\src\\pacmanfx\\resources\\DifNivel4Completado.txt");
            File file34 = new File(fileName34);
            FileReader fr34 = new FileReader(file34);
            BufferedReader br34 = new BufferedReader(fr34);
            String line34;
            while ((line34 = br34.readLine()) != null) {
                Nivel444 = Integer.parseInt(line34);
            }
            String fileName35 = (dir3 + "\\src\\pacmanfx\\resources\\DifNivel5Completado.txt");
            File file35 = new File(fileName35);
            FileReader fr35 = new FileReader(file35);
            BufferedReader br35 = new BufferedReader(fr35);
            String line35;
            while ((line35 = br35.readLine()) != null) {
                Nivel555 = Integer.parseInt(line35);
            }
            String fileName36 = (dir6 + "\\src\\pacmanfx\\resources\\DifNivel6Completado.txt");
            File file36 = new File(fileName36);
            FileReader fr36 = new FileReader(file36);
            BufferedReader br36 = new BufferedReader(fr36);
            String line36;
            while ((line36 = br36.readLine()) != null) {
                Nivel666 = Integer.parseInt(line36);
            }
            String fileName37 = (dir7 + "\\src\\pacmanfx\\resources\\DifNivel7Completado.txt");
            File file37 = new File(fileName37);
            FileReader fr37 = new FileReader(file37);
            BufferedReader br37 = new BufferedReader(fr37);
            String line37;
            while ((line37 = br37.readLine()) != null) {
                Nivel777 = Integer.parseInt(line37);
            }
            String fileName38 = (dir8 + "\\src\\pacmanfx\\resources\\DifNivel8Completado.txt");
            File file38 = new File(fileName38);
            FileReader fr38 = new FileReader(file38);
            BufferedReader br38 = new BufferedReader(fr38);
            String line38;
            while ((line38 = br38.readLine()) != null) {
                Nivel888 = Integer.parseInt(line38);
            }
            String fileName39 = (dir9 + "\\src\\pacmanfx\\resources\\DifNivel9Completado.txt");
            File file39 = new File(fileName39);
            FileReader fr39 = new FileReader(file39);
            BufferedReader br39 = new BufferedReader(fr39);
            String line39;
            while ((line39 = br39.readLine()) != null) {
                Nivel999 = Integer.parseInt(line39);
            }
            String fileName40 = (dir10 + "\\src\\pacmanfx\\resources\\DifNivel10Completado.txt");
            File file40 = new File(fileName40);
            FileReader fr40 = new FileReader(file40);
            BufferedReader br40 = new BufferedReader(fr40);
            String line40;
            while ((line40 = br40.readLine()) != null) {
                Nivel1000 = Integer.parseInt(line40);
            }
            
            
            File f11 = new File(".");
            String dir11 = f11.getAbsolutePath();
            String fileName11 = dir11 + "\\src\\pacmanfx\\resources\\FantasmasComidos.txt";
            File file11 = new File(fileName11);
            FileReader fr11 = new FileReader(file11);
            BufferedReader br11 = new BufferedReader(fr11);
            String line11;
            while ((line11 = br11.readLine()) != null) {
                cantFantasmas = Integer.parseInt(line11);
            }
            File f13 = new File(".");
            String dir13 = f13.getAbsolutePath();
            String fileName13 = dir13 + "\\src\\pacmanfx\\resources\\NoPerderVidasCont.txt";
            File file13 = new File(fileName13);
            FileReader fr13 = new FileReader(file13);
            BufferedReader br13 = new BufferedReader(fr13);
            String line13;
            while ((line13 = br13.readLine()) != null) {
                vidasConsecutivasAux = Integer.parseInt(line13);
            }
            if (vidasConsecutivasAux >= 3) {
                try {
                    String content = "1";
                    File f1 = new File(".");
                    String dir1 = f1.getAbsolutePath();
                    String path = dir1 + "\\src\\pacmanfx\\resources\\NoPerderVidas.txt";
                    Files.write(Paths.get(path), content.getBytes());
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class
                            .getName()).log(Level.SEVERE, null, ex);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Edición de Nivel");
                    alert.setContentText("Error al editar el nivel");
                    alert.showAndWait();
                }
            }
            File f14 = new File(".");
            String dir14 = f14.getAbsolutePath();
            String fileName14 = dir14 + "\\src\\pacmanfx\\resources\\Encierro5VecesCont.txt";
            File file14 = new File(fileName14);
            FileReader fr14 = new FileReader(file14);
            BufferedReader br14 = new BufferedReader(fr14);
            String line14;
            while ((line14 = br14.readLine()) != null) {
                EncierroCont = Integer.parseInt(line14);
            }
            if (EncierroCont >= 5) {
                try {
                    String content = "1";
                    File f1 = new File(".");
                    String dir1 = f1.getAbsolutePath();
                    String path = dir1 + "\\src\\pacmanfx\\resources\\Encierro5Veces.txt";
                    Files.write(Paths.get(path), content.getBytes());
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class
                            .getName()).log(Level.SEVERE, null, ex);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Edición de Nivel");
                    alert.setContentText("Error al editar el nivel");
                    alert.showAndWait();
                }
            }
            File f12 = new File(".");
            String dir12 = f12.getAbsolutePath();
            String fileName12 = dir12 + "\\src\\pacmanfx\\resources\\NoPerderVidas.txt";
            File file12 = new File(fileName12);
            FileReader fr12 = new FileReader(file12);
            BufferedReader br12 = new BufferedReader(fr12);
            String line12;
            while ((line12 = br12.readLine()) != null) {
                vidasConsecutivas = Integer.parseInt(line12);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ((Nivel1 == 1 && Nivel2 == 1 && Nivel3 == 1 && Nivel4 == 1 && Nivel5 == 1 && Nivel6 == 1 && Nivel7 == 1 && Nivel8 == 1 && Nivel9 == 1 && Nivel10 == 1)
            || (Nivel11 == 1 && Nivel22 == 1 && Nivel33 == 1 && Nivel44 == 1 && Nivel55 == 1 && Nivel66 == 1 && Nivel77 == 1 && Nivel88 == 1 && Nivel99 == 1 && Nivel100 == 1) 
            || (Nivel111 == 1 && Nivel222 == 1 && Nivel333 == 1 && Nivel444 == 1 && Nivel555 == 1 && Nivel666 == 1 && Nivel777 == 1 && Nivel888 == 1 && Nivel999 == 1 && Nivel1000 == 1) ) {
           logro1.setImage(new Image("/pacmanfx/resources/premio.png"));
        } else {
            logro1.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        }
        if (cantFantasmas >= 5) {
            logro2.setImage(new Image("/pacmanfx/resources/premio.png"));
        } else {
            logro2.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        }
        if (vidasConsecutivas == 1) {
            logro3.setImage(new Image("/pacmanfx/resources/premio.png"));
        } else {
            logro3.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        }
        if (EncierroCont >= 5) {
            logro4.setImage(new Image("/pacmanfx/resources/premio.png"));
        } else {
            logro4.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        }
        logro5.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        
        if (Nivel111 == 1 && Nivel222 == 1 && Nivel333 == 1 && Nivel444 == 1
                && Nivel555 == 1 && Nivel666 == 1 && Nivel777 == 1 && Nivel888 == 1 && Nivel999 == 1 && Nivel1000 == 1) {
            logro6.setImage(new Image("/pacmanfx/resources/premio.png"));
        } else {
            logro6.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        }

        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Datos.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                txtUsuario.setText(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Menu", this.getStage());
    }

    @FXML
    private void agregar(ActionEvent event) {
        try {
            if (!txtUsuario.getText().isEmpty()) {
                String content = txtUsuario.getText();
                File f = new File(".");
                String dir = f.getAbsolutePath();
                String path = dir + "\\src\\pacmanfx\\resources\\Datos.txt";
                Files.write(Paths.get(path), content.getBytes());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMACIÓN");
                alert.setContentText("Nombre guardado exitosamente!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("INFORMACIÓN");
                alert.setContentText("Debes de escribir algo!");
                alert.showAndWait();

            }
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class
                    .getName()).log(Level.SEVERE, null, ex);
            lbl.setText("   Algo salió mal...");
        }
    }

    @FXML
    private void Estadisticas(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Estadisticas", this.getStage());
    }

}
