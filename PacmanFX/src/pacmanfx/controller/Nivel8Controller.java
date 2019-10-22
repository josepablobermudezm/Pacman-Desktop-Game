/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import pacmanfx.model.Arista;
import pacmanfx.model.Nodo;
import pacmanfx.model.pacMan2D;
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class Nivel8Controller extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    double x = 447, y = 406, velx = 0, vely = 0;
    int code = 39/*por default a la derecha*/, cont = 0, gameStatus = 0, MouseX = 0, MouseY = 0,
            xAux = 434, yAux = 392, jAux = 14, iAux = 14, aux = 39, aux2 = 0, cont1 = 0, cont2 = 0, cont4 = 0, vidas = 6, cont3 = 0, contPuntos = 0,
            cont5 = 0, cont6 = 0, cont7 = 0, cont8 = 0, cont9 = 0, cont10 = 0;
    static boolean up = false, down = false, left = false, right = false, value = false, mapa2 = false, Nivel1 = true, Nivel2 = false, Nivel3 = false, Nivel4 = false,
            Nivel5 = false, Nivel6 = false, Nivel7 = false, Nivel8 = false, Nivel9 = false, Nivel10 = false;
    String nivel = "Nivel 8";
    private ArrayList<Nodo> nodos = new ArrayList();
    private ArrayList<Arista> aristas = new ArrayList();
    private ArrayList<Circle> puntos = new ArrayList();
    private pacMan2D pacman;
    char Mapa[][]
            = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', 'X', ' ', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', ' ', 'X', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

    @FXML
    private AnchorPane root;
    private BorderPane border;

    @Override
    public void initialize() {

    }

    private void pasar(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("Menu");
    }

    @FXML
    private void Movimiento(KeyEvent event) {

    }

    private Nodo nodoAux = null;
    private static boolean encontrado = false;
    private String movimiento = "";

    private EventHandler<KeyEvent> moverPacman = event -> {
        if (event.getCode() == event.getCode().DOWN) {
            if (nodoAux == null) {

                movimiento = "DOWN";
                down(false);
            } else {
                movimiento = "DOWN";
            }
        } else if (event.getCode() == event.getCode().LEFT) {
            if (nodoAux == null) {
                movimiento = "LEFT";
                left(false);
            } else {
                movimiento = "LEFT";
            }

        } else if (event.getCode() == event.getCode().UP) {
            if (nodoAux == null) {
                movimiento = "UP";
                up(false);
            } else {
                movimiento = "UP";
            }
        } else if (event.getCode() == event.getCode().RIGHT) {
            if (nodoAux == null) {
                movimiento = "RIGHT";
                right(false);
            } else {
                movimiento = "RIGHT";
            }

        } else if (event.getCode() == event.getCode().ESCAPE) {
            FlowController.getInstance().initialize();
            FlowController.getInstance().goViewInStage("SeleccionNivel", this.getStage());
        }
    };

    private void movimiento() {
        switch (movimiento) {
            case "UP":
                up(false);
                break;
            case "DOWN":
                down(false);
                break;
            case "LEFT":
                left(false);
                break;
            case "RIGHT":
                right(false);
                break;
        }
    }

    private Double posY;
    private Double posX;

    public void up(Boolean devolver) {
        if (!devolver) {
            xAux = (int) pacman.getpMan().getCenterX() - 14;
            yAux = (int) pacman.getpMan().getCenterY() - 13;
            while (xAux < (int) pacman.getpMan().getCenterX() + 14) {
                while (yAux >= 0) {
                    if (nodos.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().isPresent()) {
                        nodoAux = nodos.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().get();
                    }
                    if (nodoAux != null) {
                        yAux = -1;
                        break;
                    }
                    yAux--;
                }

                if (nodoAux != null) {
                    xAux = (int) pacman.getpMan().getCenterX() + 14;
                    break;
                }

                yAux = (int) pacman.getpMan().getCenterY() - 13;
                xAux++;
            }
            if (nodoAux != null) {
                pacman.getpMan().setRotate(-90);
                Timeline timeline = new Timeline();
                KeyValue kvy = new KeyValue(pacman.getpMan().centerYProperty(), nodoAux.getPoint2D().getY());
                Double distance = nodoAux.getPoint2D().distance(pacman.getNodo().getPoint2D());
                //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
                KeyFrame kfy = new KeyFrame(Duration.millis((distance / 13) * 100), kvy);
                timeline.getKeyFrames().add(kfy);
                //La posicion del PacMan antes de la animacion
                posY = pacman.getpMan().getCenterY();
                posX = pacman.getpMan().getCenterX();
                timeline.play();

                String movimientoOr = "UP";

                timeline.currentTimeProperty().addListener((observable) -> {

                    //contPuntos++;
                    if (!movimientoOr.equals(movimiento) && movimiento.equals("DOWN")) {
                        Platform.runLater(() -> {
                            timeline.stop();
                            down(true);
                        });
                    }
                });

                timeline.setOnFinished((value) -> {
                    nodoAux = null;
                    movimiento();
                });
            } else {
                //Abro la boca del pacMan cuando no encuentro ningun nodo
                pacman.getpMan().setLength(300);
            }
        } else {
            pacman.getpMan().setRotate(-90);
            Timeline timeline = new Timeline();
            KeyValue kvy = new KeyValue(pacman.getpMan().centerYProperty(), posY);
            Double distance = new Point2D(posX, posY).distance(pacman.getNodo().getPoint2D());
            //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
            KeyFrame kfy = new KeyFrame(Duration.millis((distance / 13) * 100), kvy);
            timeline.getKeyFrames().add(kfy);
            //La posicion del PacMan antes de la animacion
            posY = pacman.getpMan().getCenterY();
            posX = pacman.getpMan().getCenterX();
            timeline.play();

            String movimientoOr = "UP";

            timeline.currentTimeProperty().addListener((observable) -> {
                if (!movimientoOr.equals(movimiento) && movimiento.equals("DOWN")) {
                    Platform.runLater(() -> {
                        timeline.stop();
                        down(true);
                    });
                }
            });

            timeline.setOnFinished((value) -> {
                nodoAux = null;
                movimiento();
            });
        }
    }

    public void down(Boolean devolver) {
        if (!devolver) {
            xAux = (int) pacman.getpMan().getCenterX() - 14;
            yAux = (int) pacman.getpMan().getCenterY() + 13;
            while (xAux < (int) pacman.getpMan().getCenterX() + 14) {
                while (yAux < 645) {
                    if (nodos.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().isPresent()) {
                        nodoAux = nodos.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().get();
                    }
                    if (nodoAux != null) {
                        yAux = 646;
                        break;
                    }
                    yAux++;
                }

                if (nodoAux != null) {
                    xAux = (int) pacman.getpMan().getCenterX() + 14;
                    break;
                }
                yAux = (int) pacman.getpMan().getCenterY() + 13;
                xAux++;

            }
            if (nodoAux != null) {
                pacman.getpMan().setRotate(90);
                Timeline timeline = new Timeline();
                KeyValue kvy = new KeyValue(pacman.getpMan().centerYProperty(), nodoAux.getPoint2D().getY());
                Double distance = nodoAux.getPoint2D().distance(pacman.getNodo().getPoint2D());
                //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
                KeyFrame kfy = new KeyFrame(Duration.millis((distance / 13) * 100), kvy);
                timeline.getKeyFrames().add(kfy);
                //La posicion del PacMan antes de la animacion
                posY = pacman.getpMan().getCenterY();
                posX = pacman.getpMan().getCenterX();
                timeline.play();
                String movimientoOr = "DOWN";
                timeline.currentTimeProperty().addListener((observable) -> {
                    if (!movimientoOr.equals(movimiento) && movimiento.equals("UP")) {
                        Platform.runLater(() -> {
                            timeline.stop();
                            up(true);
                        });
                    }
                });

                timeline.setOnFinished((valor) -> {
                    nodoAux = null;
                    movimiento();
                });
            } else {
                //Abro la boca del pacMan cuando no encuentro ningun nodo
                pacman.getpMan().setLength(300);
            }
        } else {
            pacman.getpMan().setRotate(90);
            Timeline timeline = new Timeline();
            KeyValue kvy = new KeyValue(pacman.getpMan().centerYProperty(), posY);
            Double distance = new Point2D(posX, posY).distance(pacman.getNodo().getPoint2D());
            //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
            KeyFrame kfy = new KeyFrame(Duration.millis((distance / 13) * 100), kvy);
            timeline.getKeyFrames().add(kfy);
            //La posicion del PacMan antes de la animacion
            posY = pacman.getpMan().getCenterY();
            posX = pacman.getpMan().getCenterX();
            timeline.play();
            String movimientoOr = "DOWN";
            timeline.currentTimeProperty().addListener((observable) -> {
                if (!movimientoOr.equals(movimiento) && movimiento.equals("UP")) {
                    Platform.runLater(() -> {
                        timeline.stop();
                        up(true);
                    });
                }
            });

            timeline.setOnFinished((valor) -> {
                nodoAux = null;
                movimiento();
            });
        }
    }

    public void left(Boolean devolver) {
        if (!devolver) {
            xAux = (int) pacman.getpMan().getCenterX() - 13;
            yAux = (int) pacman.getpMan().getCenterY() - 14;

            while (yAux < (int) pacman.getpMan().getCenterY() + 14) {
                while (xAux >= 0) {
                    if (nodos.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().isPresent()) {
                        nodoAux = nodos.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().get();
                    }

                    if (nodoAux != null) {
                        xAux = -1;
                        break;
                    }
                    xAux--;
                }
                if (nodoAux != null) {
                    yAux = (int) pacman.getpMan().getCenterY() - 13;
                    break;
                }

                yAux++;
                xAux = (int) pacman.getpMan().getCenterX() - 13;

            }

            if (nodoAux != null) {
                pacman.getpMan().setRotate(-180);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(pacman.getpMan().centerXProperty(), nodoAux.getPoint2D().getX());
                Double distance = nodoAux.getPoint2D().distance(pacman.getNodo().getPoint2D());
                //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
                KeyFrame kf = new KeyFrame(Duration.millis((distance / 13) * 100), kv);
                timeline.getKeyFrames().add(kf);
                //La posicion del PacMan antes de la animacion
                posY = pacman.getpMan().getCenterY();
                posX = pacman.getpMan().getCenterX();
                //Inicio de la animacion
                timeline.play();
                String movimientoOr = "LEFT";
                //Durante el transcurso de la animacion
                timeline.currentTimeProperty().addListener((observable) -> {
                    if (!movimientoOr.equals(movimiento) && movimiento.equals("RIGHT")) {
                        Platform.runLater(() -> {
                            timeline.stop();
                            right(true);
                        });
                    }
                });
                //Cuando se termina la animacion
                timeline.setOnFinished((valor) -> {
                    nodoAux = null;
                    movimiento();
                });
            } else {
                //Cuando el pacMan no encuentra un nodo para moverse
                pacman.getpMan().setLength(300);
            }
        } else {
            pacman.getpMan().setRotate(-180);
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(pacman.getpMan().centerXProperty(), posX);
            Double distance = new Point2D(posX, posY).distance(pacman.getNodo().getPoint2D());
            //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
            KeyFrame kf = new KeyFrame(Duration.millis((distance / 13) * 100), kv);
            timeline.getKeyFrames().add(kf);
            //La posicion del PacMan antes de la animacion
            posY = pacman.getpMan().getCenterY();
            posX = pacman.getpMan().getCenterX();
            String movimientoOr = "LEFT";
            //Inicio de la animacion
            timeline.play();
            //Durante el transcurso de la animacion
            timeline.currentTimeProperty().addListener((observable) -> {
                if (!movimientoOr.equals(movimiento) && movimiento.equals("RIGHT")) {
                    Platform.runLater(() -> {
                        timeline.stop();
                        right(true);
                    });
                }
            });
            //Cuando se termina la animacion
            timeline.setOnFinished((valor) -> {
                nodoAux = null;
                movimiento();
            });
        }
    }

    public void right(Boolean devolver) {
        if (!devolver) {
            xAux = (int) pacman.getpMan().getCenterX() + 13;
            yAux = (int) pacman.getpMan().getCenterY() - 13;

            while (yAux < (int) pacman.getpMan().getCenterY() + 13) {
                while (xAux < 900) {
                    if (nodos.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().isPresent()) {
                        nodoAux = nodos.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().get();
                    }

                    if (nodoAux != null) {
                        xAux = -1;
                        break;
                    }
                    xAux++;
                }
                if (nodoAux != null) {
                    yAux = (int) pacman.getpMan().getCenterY() + 13;
                    break;
                }

                yAux++;
                xAux = (int) pacman.getpMan().getCenterX() + 13;

            }

            if (nodoAux != null) {
                pacman.getpMan().setRotate(0);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(pacman.getpMan().centerXProperty(), nodoAux.getPoint2D().getX());
                Double distance = nodoAux.getPoint2D().distance(pacman.getNodo().getPoint2D());
                //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
                KeyFrame kf = new KeyFrame(Duration.millis((distance / 13) * 100), kv);
                timeline.getKeyFrames().add(kf);
                //La posicion del PacMan antes de la animacion
                posY = pacman.getpMan().getCenterY();
                posX = pacman.getpMan().getCenterX();
                timeline.play();
                String movimientoOr = "RIGHT";
                //Durante el transcurso de la animacion
                timeline.currentTimeProperty().addListener((observable) -> {
                    if (!movimientoOr.equals(movimiento) && movimiento.equals("LEFT")) {
                        Platform.runLater(() -> {
                            timeline.stop();
                            left(true);
                        });
                    }
                });

                timeline.setOnFinished((valor) -> {
                    nodoAux = null;
                    movimiento();
                });
            } else {
                //Cuando el pacMan no encuentra un nodo para moverse
                pacman.getpMan().setLength(300);
            }
        } else {
            pacman.getpMan().setRotate(0);
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(pacman.getpMan().centerXProperty(), posX);
            Double distance = new Point2D(posX, posY).distance(pacman.getNodo().getPoint2D());
            //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
            KeyFrame kf = new KeyFrame(Duration.millis((distance / 13) * 100), kv);
            timeline.getKeyFrames().add(kf);
            //La posicion del PacMan antes de la animacion
            posY = pacman.getpMan().getCenterY();
            posX = pacman.getpMan().getCenterX();
            timeline.play();
            String movimientoOr = "RIGHT";
            //Durante el transcurso de la animacion
            timeline.currentTimeProperty().addListener((observable) -> {
                if (!movimientoOr.equals(movimiento) && movimiento.equals("LEFT")) {
                    Platform.runLater(() -> {
                        timeline.stop();
                        left(true);
                    });
                }
            });

            timeline.setOnFinished((valor) -> {
                nodoAux = null;
                movimiento();
            });
        }
    }

    public void CrearMapa() {

        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            //para que esto funcione en visualCode es necesario seleccionarlo desde src y usar este código
            /*File f = new File(".");
            String dir = f.getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(dir + "\\pacmanfx\\resources\\Arista.txt"));*/
            BufferedReader reader = new BufferedReader(new FileReader(dir + "\\src\\pacmanfx\\resources\\Nodos8.txt"));
            String line = null;
            Integer i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts;
                parts = line.split("\\$");
                Double posx = Double.valueOf(parts[0]);
                Double posy = Double.valueOf(parts[1]);

                Nodo nodo = new Nodo(posx, posy);
                Circle circle = new Circle(posx, posy, 5, Paint.valueOf("GREEN"));
                //this.root.getChildren().add(circle);

                i++;
                nodos.add(nodo);
            }
        } catch (IOException ex) {

        }
        try {
            //para que esto funcione en visualCode es necesario seleccionarlo desde src y usar este código
            /*File f = new File(".");
            String dir = f.getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(dir + "\\pacmanfx\\resources\\Arista.txt"));*/
            File f = new File(".");
            String dir = f.getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(dir + "\\src\\pacmanfx\\resources\\Arista8.txt"));
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
                arista.agregarNodos(nodos);
                aristas.add(arista);
            }
        } catch (IOException | NumberFormatException e) {
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 29; j++) {
                if (Mapa[i][j] == 'X') {//pared
                    Rectangle rec = new Rectangle(j * 31, i * 28, 31, 28);
                    rec.setFill(Paint.valueOf("#2E3782"));
                    root.getChildren().add(rec);//tamaño y posición del cada uno de los rectangulos
                } else if (Mapa[i][j] == '@') {//pacman
                    pacman = new pacMan2D((Double) x, (Double) y, 11.0, 11.0, 30.0, 300.0);
                    pacman.getpMan().setFocusTraversable(true);
                    pacman.getpMan().setOnKeyReleased(moverPacman);
                    pacman.setNodo(new Nodo(x, y));
                    //Actualiza el nodo, y el point2D conforme se esta moviendo
                    pacman.getpMan().centerXProperty().addListener((observable) -> {
                        cont++;
                        //Cierro y abro el PacMan
                        if (pacman.getpMan().getLength() == 300.0 && cont == 10) {
                            pacman.getpMan().setLength(360);
                            cont = 0;
                        } else if (pacman.getpMan().getLength() == 360.0 && cont == 10) {
                            pacman.getpMan().setLength(300);
                            cont = 0;
                        }
                        pacman.getNodo().setPoint2D(new Point2D(pacman.getpMan().getCenterX(), pacman.getpMan().getCenterY()));
                    });
                    //Actualiza el nodo, y el point2D conforme se esta moviendo
                    pacman.getpMan().centerYProperty().addListener((observable) -> {
                        cont++;
                        //Cierro y abro el PacMan
                        if (pacman.getpMan().getLength() == 300.0 && cont == 10) {
                            pacman.getpMan().setLength(360);
                            cont = 0;
                        } else if (pacman.getpMan().getLength() == 360.0 && cont == 10) {
                            pacman.getpMan().setLength(300);
                            cont = 0;
                        }
                        pacman.getNodo().setPoint2D(new Point2D(pacman.getpMan().getCenterX(), pacman.getpMan().getCenterY()));
                    });

                    root.getChildren().add(pacman.getpMan());
                    //x, y son las posiciones del pacman, van a ir cambiando dependiendo de que tecla se use
                }
                if (Mapa[i][j] == 'X' && i == 9 && j == 14) {//pared
                    Rectangle rec1 = new Rectangle(j * 31, i * 28, 31, 28);
                    rec1.setFill(Paint.valueOf("BLACK"));
                    Rectangle rec = new Rectangle(j * 31, i * 28 + 10, 31, 4);
                    rec.setFill(Paint.valueOf("WHITE"));
                    root.getChildren().add(rec1);
                    root.getChildren().add(rec);
                }
                if (Mapa[i][j] == ' ') {
                    //   contPuntos++;
                }
            }
        }

        Label label = new Label("Puntos:");
        label.setLayoutX(10);
        label.setLayoutY(585);
        label.setId("puntos");
        root.getChildren().add(label);
        Label puntaje = new Label(String.valueOf(contPuntos));
        puntaje.setLayoutX(165);
        puntaje.setLayoutY(585);
        puntaje.setId("puntos");
        //Agregaar lo de puntaje
        root.getChildren().add(puntaje);

        for (int i = 0; i < vidas; i++) {
            Arc arc = new Arc(725 + cont3, 605, 13.0, 15.0, 30, 300);
            arc.setFill(Paint.valueOf("YELLOW"));
            arc.setType(ArcType.ROUND);
            root.getChildren().add(arc);
            cont3 += 30;
        }

        aristas.stream().forEach((arista) -> {

            Double xOrigen = arista.getOrigen().getPoint2D().getX();
            Double xDestino = arista.getDestino().getPoint2D().getX();
            Double yOrigen = arista.getOrigen().getPoint2D().getY();
            Double yDestino = arista.getDestino().getPoint2D().getY();
            Circle origen = new Circle(xDestino, yDestino, 3, Paint.valueOf("YELLOW"));
            puntos.add(origen);
            root.getChildren().add(origen);//
            Circle destino = new Circle(xOrigen, yOrigen, 3, Paint.valueOf("YELLOW"));
            puntos.add(destino);
            root.getChildren().add(destino);//

            if (Objects.equals(xOrigen, xDestino) && yOrigen > yDestino) {
                yDestino += 29;
                while (yDestino < yOrigen) {
                    if (yDestino <= yOrigen - 13) {
                        Circle circle = new Circle(xDestino, yDestino, 3, Paint.valueOf("YELLOW"));
                        puntos.add(circle);
                        root.getChildren().add(circle);//tamaño y posición de la comida del pacman
                    }
                    yDestino += 29;
                }
            } else if (Objects.equals(xOrigen, xDestino) && yOrigen < yDestino) {
                yOrigen += 29;
                while (yOrigen < yDestino) {
                    if (yOrigen <= yDestino - 13) {
                        Circle circle = new Circle(xDestino, yOrigen, 3, Paint.valueOf("YELLOW"));
                        puntos.add(circle);
                        root.getChildren().add(circle);//tamaño y posición de la comida del pacman
                    }
                    yOrigen += 29;
                }
            } else if (Objects.equals(yOrigen, yDestino) && xOrigen > xDestino) {
                xDestino += 31;
                while (xDestino < xOrigen) {
                    if (xDestino <= xOrigen - 16) {
                        Circle circle = new Circle(xDestino, yDestino, 3, Paint.valueOf("YELLOW"));
                        puntos.add(circle);
                        root.getChildren().add(circle);//tamaño y posición de la comida del pacman
                    }
                    xDestino += 31;
                }
            } else if (Objects.equals(yOrigen, yDestino) && xOrigen < xDestino) {
                while (xOrigen <= xDestino) {
                    if (xOrigen <= xDestino - 16) {
                        Circle circle = new Circle(xOrigen, yDestino, 3, Paint.valueOf("YELLOW"));
                        puntos.add(circle);
                        root.getChildren().add(circle);//tamaño y posición de la comida del pacman
                    }
                    xOrigen += 31;
                }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CrearMapa();
    }

    @FXML
    private void mouse(MouseEvent event) {

        root.getChildren().get(root.getChildren().size() - 1).setOpacity(0);
        System.out.println(event.getX());
        System.out.println(event.getY());
        Circle circle = new Circle(event.getX(), event.getY(), 3, Paint.valueOf("RED"));
        root.getChildren().add(circle);
    }
}
