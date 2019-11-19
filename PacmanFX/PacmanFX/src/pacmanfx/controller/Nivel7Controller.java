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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import pacmanfx.model.Arista;
import pacmanfx.model.CyanGhost;
import pacmanfx.model.Dijkstra;
import pacmanfx.model.Floyd;
import pacmanfx.model.Grafo;
import pacmanfx.model.Nodo;
import pacmanfx.model.OrangeGhost;
import pacmanfx.model.PinkGhost;
import pacmanfx.model.RedGhost;
import pacmanfx.model.pacMan2D;
import pacmanfx.util.FlowController;
import pacmanfx.util.hiloTiempo;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class Nivel7Controller extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    double x = 447, y = 407, velx = 0, vely = 0;
    int code = 39/*por default a la derecha*/, cont = 0, gameStatus = 0, MouseX = 0, MouseY = 0,
            xAux = 434, yAux = 392, jAux = 14, iAux = 14, aux = 39, aux2 = 0, cont1 = 0, cont2 = 0, cont4 = 0, vidas = 6, cont3 = 0, contPuntos = 0,
            cont5 = 0, cont6 = 0, cont7 = 0, cont8 = 0, cont9 = 0, cont10 = 0;
    static boolean up = false, down = false, left = false, right = false, value = false, mapa2 = false, Nivel1 = true, Nivel2 = false, Nivel3 = false, Nivel4 = false,
            Nivel5 = false, Nivel6 = false, Nivel7 = false, Nivel8 = false, Nivel9 = false, Nivel10 = false;
    String nivel = "Nivel 7";
    int EncierroValor = 0;
    private ArrayList<Nodo> nodos = new ArrayList();
    private ArrayList<Arista> aristas = new ArrayList();
    private ArrayList<Circle> puntos = new ArrayList();
    private pacMan2D pacman;
    RedGhost redGhost = new RedGhost();
    CyanGhost cyanGhost = new CyanGhost();
    OrangeGhost orangeGhost = new OrangeGhost();
    PinkGhost pinkGhost = new PinkGhost();
    private hiloTiempo Hilo;
    int contVidas = 0, contVidas2 = 0;
    private boolean Pelotas = false;
    char Mapa[][]
            = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
            {'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
            {'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '/', 'X', 'X', 'X', 'X', 'X'}};

    @FXML
    private AnchorPane root;
    private BorderPane border;
    @FXML
    private ImageView img;
    @FXML
    private Label lblEncierro;
    @FXML
    private Label lblSuperVelocidad;

    @Override
    public void initialize() {
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/FondoNivel7.jpg");
            img.setImage(imgLogo);
        } catch (Exception e) {
        }
    }

    private void pasar(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("Menu");
    }

    @FXML
    private void Movimiento(KeyEvent event) {
    }

    private Nodo nodoDestino = null;
    private static boolean encontrado = false;
    private String movimiento = "";
    private Double posY;
    private Double posX;
    ArrayList<Nodo> nodosAux;
    Boolean adyacente = false;
    String movimientoPrevio;
    String movimientoOriginal;
    Nodo auxNodo;
    Boolean bandera = false;
    Stack<String> pila = new Stack<>();
    private boolean EncierroBandera = false;
    private int contadorEncierro = 0;

    private EventHandler<KeyEvent> moverPacman = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            /*
            Se activa el encierro en el caso que la habilidad este activa
            La condición es: que se presiona le tecla E y que se cumplan las condiciones de Encierro
             */
            if ((event.getCode() == event.getCode().E) && EncierroBandera && contadorEncierro == 0) {
                lblEncierro.setVisible(false);
                UsarEncierroContador();//contador para saber si se usa la habilidad al menos 5 veces y entregar premio respectivo
                EncierroBandera = false;
                /*
                
                Método a realizar
                
                 */
                contadorEncierro++;
            } else if (event.getCode() == event.getCode().DOWN) {
                if (nodoDestino == null) {
                    movimiento = "DOWN";
                    movimientoOriginal = "DOWN";
                    pila.push("DOWN");
                    down(false);
                } else {
                    pila.push("DOWN");
                    movimiento = "DOWN";
                }
            } else if (event.getCode() == event.getCode().LEFT) {
                if (nodoDestino == null) {
                    movimiento = "LEFT";
                    movimientoOriginal = "LEFT";
                    pila.push("LEFT");
                    left(false);
                } else {
                    movimiento = "LEFT";
                    pila.push("LEFT");
                }
            } else if (event.getCode() == event.getCode().UP) {
                if (nodoDestino == null) {
                    movimiento = "UP";
                    movimientoOriginal = "UP";
                    pila.push("UP");
                    up(false);
                } else {
                    movimiento = "UP";
                    pila.push("UP");
                }
            } else if (event.getCode() == event.getCode().RIGHT) {
                if (nodoDestino == null) {
                    movimiento = "RIGHT";
                    movimientoOriginal = "RIGHT";
                    pila.push("RIGHT");
                    right(false);
                } else {
                    movimiento = "RIGHT";
                    pila.push("RIGHT");
                }
            } else if (event.getCode() == event.getCode().ESCAPE) {
                //aquí se mide guarda el dato con el tiempo que tarda en finalizar un nivel
                hiloTiempo.finalizado = true;
                int tiempo = Hilo.getTic();
                MenuController.TiempoTotalJuego += tiempo;
                int tiempoActual = 0;
                try {
                    File f = new File(".");
                    String dir = f.getAbsolutePath();
                    String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo7.txt";
                    File file = new File(fileName);
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        tiempoActual = Integer.parseInt(line);
                    }
                    if (tiempo > tiempoActual) {
                        try {
                            String content = String.valueOf(tiempo);
                            File f1 = new File(".");
                            String dir1 = f1.getAbsolutePath();
                            String path = dir1 + "\\src\\pacmanfx\\resources\\Mejor_Tiempo7.txt";
                            Files.write(Paths.get(path), content.getBytes());
                        } catch (IOException ex) {
                            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                MenuController.PuntosTotales += contPuntos * 10;
                int PuntosPorNivel = 0;
                try {
                    File f = new File(".");
                    String dir = f.getAbsolutePath();
                    String fileName = dir + "\\src\\pacmanfx\\resources\\MayorCantidadDePuntosPartida.txt";
                    File file = new File(fileName);
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        PuntosPorNivel = Integer.parseInt(line);
                    }
                    System.out.println(contPuntos + " > " + PuntosPorNivel);
                    if (contPuntos > PuntosPorNivel) {
                        try {
                            String content = String.valueOf(contPuntos);
                            File f1 = new File(".");
                            String dir1 = f1.getAbsolutePath();
                            String path = dir1 + "\\src\\pacmanfx\\resources\\MayorCantidadDePuntosPartida.txt";
                            Files.write(Paths.get(path), content.getBytes());
                        } catch (IOException ex) {
                            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        System.out.println("no es mayor");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                /*
                 *  Guardamos el puntaje en el arrayList, lo acomodamos de mayor a menos y cojemos los primeros 10
                 */
                TopList.add(contPuntos * 10);
                Collections.sort(TopList);
                Collections.reverse(TopList);
                OrganizarTop();
                
                FlowController.getInstance().initialize();
                FlowController.getInstance().goViewInStage("SeleccionNivel", Nivel7Controller.this.getStage());
            }
        }
    };

    private void movimiento() {
        if (!pila.isEmpty()) {
            String movAux = pila.pop();
            if (movimientoCorrecto(movAux, nodoOrigen)) {
                movimiento = movAux;
                movimientoOriginal = movimiento;
            } else if (!movimiento.equals(movimientoOriginal) && !movimientoCorrecto(movimiento, nodoOrigen)) {
                movimiento = movimientoOriginal;
            }
            pila.push(movAux);
        }
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

    Integer xAux2;
    Integer yAux2;

    private boolean movimientoCorrecto(String movimiento, Nodo destino) {
        bandera = false;
        copiaNodos();
        auxNodo = null;
        if (movimiento.equals("UP") && destino != null) {
            xAux2 = (int) destino.getPoint2D().getX() - 14;
            yAux2 = (int) destino.getPoint2D().getY() - 13;
            while (xAux2 < (int) destino.getPoint2D().getX() + 14 && !bandera) {
                while (yAux2 >= 0) {
                    if (nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux2 && (int) nodo.getPoint2D().getY() == yAux2).findAny().isPresent() && !bandera) {
                        auxNodo = nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux2 && (int) nodo.getPoint2D().getY() == yAux2).findAny().get();
                        nodosAux.remove(auxNodo);
                        destino.getAristas_Adyacentes().stream().forEach((arista) -> {
                            if (arista.getDestino().equals(auxNodo)) {
                                bandera = true;
                            } else if (arista.getOrigen().equals(auxNodo)) {
                                bandera = true;
                            }
                        });
                        if (!bandera) {
                            auxNodo = null;
                        }
                    }
                    if (auxNodo != null) {
                        yAux2 = -1;
                        break;
                    }
                    yAux2--;
                }

                if (auxNodo != null) {
                    xAux2 = (int) destino.getPoint2D().getX() + 14;
                    break;
                }

                yAux2 = (int) destino.getPoint2D().getY() - 13;
                xAux2++;
            }
        } else if (movimiento.equals("DOWN") && destino != null) {
            xAux2 = (int) destino.getPoint2D().getX() - 14;
            yAux2 = (int) destino.getPoint2D().getY() + 13;
            while (xAux2 < (int) destino.getPoint2D().getX() + 14 && !bandera) {
                while (yAux2 < 645) {
                    if (nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux2 && (int) nodo.getPoint2D().getY() == yAux2).findAny().isPresent() && !bandera) {
                        auxNodo = nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux2 && (int) nodo.getPoint2D().getY() == yAux2).findAny().get();
                        nodosAux.remove(auxNodo);
                        destino.getAristas_Adyacentes().stream().forEach((arista) -> {
                            if (arista.getDestino().equals(auxNodo)) {
                                bandera = true;
                            } else if (arista.getOrigen().equals(auxNodo)) {
                                bandera = true;
                            }
                        });
                        if (!bandera) {
                            auxNodo = null;
                        }
                    }
                    if (auxNodo != null) {
                        yAux2 = 646;
                        break;
                    }
                    yAux2++;
                }

                if (auxNodo != null) {
                    xAux2 = (int) destino.getPoint2D().getX() + 14;
                    break;
                }
                yAux2 = (int) destino.getPoint2D().getY() + 13;
                xAux2++;
            }
        } else if (movimiento.equals("LEFT") && destino != null) {
            xAux2 = (int) destino.getPoint2D().getX() - 13;
            yAux2 = (int) destino.getPoint2D().getY() - 14;
            while (yAux2 < (int) destino.getPoint2D().getY() + 14 && !bandera) {
                while (xAux2 >= 0) {
                    if (nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux2 && (int) nodo.getPoint2D().getY() == yAux2).findAny().isPresent() && !bandera) {
                        auxNodo = nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux2 && (int) nodo.getPoint2D().getY() == yAux2).findAny().get();
                        nodosAux.remove(auxNodo);
                        destino.getAristas_Adyacentes().stream().forEach((arista) -> {
                            if (arista.getDestino().equals(auxNodo)) {
                                bandera = true;
                            } else if (arista.getOrigen().equals(auxNodo)) {
                                bandera = true;
                            }
                        });
                        if (!bandera) {
                            auxNodo = null;
                        }
                    }
                    if (auxNodo != null) {
                        xAux2 = -1;
                        break;
                    }
                    xAux2--;
                }
                if (auxNodo != null) {
                    yAux2 = (int) destino.getPoint2D().getY() - 13;
                    break;
                }

                yAux2++;
                xAux2 = (int) destino.getPoint2D().getX() - 13;
            }
        } else if (movimiento.equals("RIGHT") && destino != null) {
            xAux2 = (int) destino.getPoint2D().getX() + 13;
            yAux2 = (int) destino.getPoint2D().getY() - 13;
            while (yAux2 < (int) destino.getPoint2D().getY() + 13 && !bandera) {
                while (xAux2 < 900) {
                    if (nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux2 && (int) nodo.getPoint2D().getY() == yAux2).findAny().isPresent() && !bandera) {
                        auxNodo = nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux2 && (int) nodo.getPoint2D().getY() == yAux2).findAny().get();
                        nodosAux.remove(auxNodo);
                        destino.getAristas_Adyacentes().stream().forEach((arista) -> {
                            if (arista.getDestino().equals(auxNodo)) {
                                bandera = true;
                            } else if (arista.getOrigen().equals(auxNodo)) {
                                bandera = true;
                            }
                        });
                        if (!bandera) {
                            auxNodo = null;
                        }
                    }

                    if (auxNodo != null) {
                        xAux2 = -1;
                        break;
                    }
                    xAux2++;
                }
                if (auxNodo != null) {
                    yAux2 = (int) destino.getPoint2D().getY() + 13;
                    break;
                }

                yAux2++;
                xAux2 = (int) destino.getPoint2D().getX() + 13;
            }
        }
        return bandera;
    }

    public void up(Boolean devolver) {
        adyacente = false;
        copiaNodos();
        if (!devolver) {
            xAux = (int) pacman.getpMan().getCenterX() - 14;
            yAux = (int) pacman.getpMan().getCenterY() - 13;
            while (xAux < (int) pacman.getpMan().getCenterX() + 14) {
                while (yAux >= 0) {
                    if (nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().isPresent() && !adyacente) {
                        nodoDestino = nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().get();
                        nodosAux.remove(nodoDestino);
                        nodoOrigen.getAristas_Adyacentes().stream().forEach((arista) -> {
                            if (arista.getDestino().equals(nodoDestino)) {
                                adyacente = true;
                            } else if (arista.getOrigen().equals(nodoDestino)) {
                                adyacente = true;
                            }
                        });
                        if (!adyacente) {
                            nodoDestino = null;
                        }
                    }
                    if (nodoDestino != null) {
                        yAux = -1;
                        break;
                    }
                    yAux--;
                }

                if (nodoDestino != null) {
                    xAux = (int) pacman.getpMan().getCenterX() + 14;
                    break;
                }

                yAux = (int) pacman.getpMan().getCenterY() - 13;
                xAux++;
            }
            if (nodoDestino != null) {
                pacman.getpMan().setRotate(-90);
                Timeline timeline = new Timeline();
                KeyValue kvy = new KeyValue(pacman.getpMan().centerYProperty(), nodoDestino.getPoint2D().getY());
                Double distance = nodoDestino.getPoint2D().distance(pacman.getNodo().getPoint2D());
                //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
                KeyFrame kfy = new KeyFrame(Duration.millis((distance / 13) * 100), kvy);
                timeline.getKeyFrames().add(kfy);
                //La posicion del PacMan antes de la animacion
                posY = pacman.getpMan().getCenterY();
                posX = pacman.getpMan().getCenterX();
                timeline.play();
                movimientoPrevio = "UP";
                timeline.currentTimeProperty().addListener((observable) -> {
                    if (!movimientoPrevio.equals(movimiento) && movimiento.equals("DOWN")) {
                        Platform.runLater(() -> {
                            movimientoOriginal = movimiento;
                            pila.clear();
                            timeline.stop();
                            down(true);
                        });
                    } else {
                        //Aqui verifico si el movimiento del PacMan se haga bien y no pare
                        //movimiento = "UP";
                    }
                });

                timeline.setOnFinished((value) -> {
                    nodoOrigen = nodoDestino;
                    nodoDestino = null;
                    movimiento();
                });
            } else {
                //Abro la boca del pacMan cuando no encuentro ningun nodo
                pacman.getpMan().setLength(300);
                movimiento = "";
                movimientoOriginal = "";
                movimientoPrevio = "";
                pila.clear();
                /*if (nodoOrigen.getAristas_Adyacentes().stream().anyMatch(x -> x.getDestino().getPoint2D().getY() < nodoOrigen.getPoint2D().getY() || x.getOrigen().getPoint2D().getY() < nodoOrigen.getPoint2D().getY())) {
                    movimiento = movientoOriginal;
                    movimiento();
                }*/
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

            movimientoPrevio = "UP";

            timeline.currentTimeProperty().addListener((observable) -> {
                if (!movimientoPrevio.equals(movimiento) && movimiento.equals("DOWN")) {
                    Platform.runLater(() -> {
                        movimientoOriginal = movimiento;
                        pila.clear();
                        timeline.stop();
                        down(true);
                    });
                } else {
                    //movimiento = "UP";
                }
            });

            timeline.setOnFinished((value) -> {
                //nodoOrigen = nodoAux;
                nodoDestino = null;
                movimiento();
            });
        }
    }

    public void down(Boolean devolver) {
        adyacente = false;
        copiaNodos();
        if (!devolver) {
            xAux = (int) pacman.getpMan().getCenterX() - 14;
            yAux = (int) pacman.getpMan().getCenterY() + 13;
            while (xAux < (int) pacman.getpMan().getCenterX() + 14) {
                while (yAux < 645) {
                    if (nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().isPresent() && !adyacente) {
                        nodoDestino = nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().get();
                        nodosAux.remove(nodoDestino);
                        nodoOrigen.getAristas_Adyacentes().stream().forEach((arista) -> {
                            if (arista.getDestino().equals(nodoDestino)) {
                                adyacente = true;
                            } else if (arista.getOrigen().equals(nodoDestino)) {
                                adyacente = true;
                            }
                        });
                        if (!adyacente) {
                            nodoDestino = null;
                        }
                    }
                    if (nodoDestino != null) {
                        yAux = 646;
                        break;
                    }
                    yAux++;
                }

                if (nodoDestino != null) {
                    xAux = (int) pacman.getpMan().getCenterX() + 14;
                    break;
                }
                yAux = (int) pacman.getpMan().getCenterY() + 13;
                xAux++;

            }
            if (nodoDestino != null) {
                pacman.getpMan().setRotate(90);
                Timeline timeline = new Timeline();
                KeyValue kvy = new KeyValue(pacman.getpMan().centerYProperty(), nodoDestino.getPoint2D().getY());
                Double distance = nodoDestino.getPoint2D().distance(pacman.getNodo().getPoint2D());
                //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
                KeyFrame kfy = new KeyFrame(Duration.millis((distance / 13) * 100), kvy);
                timeline.getKeyFrames().add(kfy);
                //La posicion del PacMan antes de la animacion
                posY = pacman.getpMan().getCenterY();
                posX = pacman.getpMan().getCenterX();
                timeline.play();
                movimientoPrevio = "DOWN";

                timeline.currentTimeProperty().addListener((observable) -> {
                    if (!movimientoPrevio.equals(movimiento) && movimiento.equals("UP")) {
                        Platform.runLater(() -> {
                            movimientoOriginal = movimiento;
                            pila.clear();
                            timeline.stop();
                            up(true);
                        });
                    } else {
                        //  movimiento = "DOWN";
                    }
                });

                timeline.setOnFinished((valor) -> {
                    nodoOrigen = nodoDestino;
                    nodoDestino = null;
                    movimiento();
                });
            } else {
                //Abro la boca del pacMan cuando no encuentro ningun nodo
                pacman.getpMan().setLength(300);
                movimiento = "";
                movimientoOriginal = "";
                movimientoPrevio = "";
                pila.clear();
                /*if (nodoOrigen.getAristas_Adyacentes().stream().anyMatch(x -> x.getDestino().getPoint2D().getY() > nodoOrigen.getPoint2D().getY() || x.getOrigen().getPoint2D().getY() > nodoOrigen.getPoint2D().getY())) {
                    movimiento = movientoOriginal;
                    movimiento();
                }*/
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
            movimientoPrevio = "DOWN";
            timeline.currentTimeProperty().addListener((observable) -> {
                if (!movimientoPrevio.equals(movimiento) && movimiento.equals("UP")) {
                    Platform.runLater(() -> {
                        movimientoOriginal = movimiento;
                        pila.clear();
                        timeline.stop();
                        up(true);
                    });
                } else {
                    //movimiento = "DOWN";
                }
            });

            timeline.setOnFinished((valor) -> {
                //nodoOrigen = nodoAux;
                nodoDestino = null;
                movimiento();
            });
        }
    }

    public void left(Boolean devolver) {
        adyacente = false;
        copiaNodos();
        if (!devolver) {
            xAux = (int) pacman.getpMan().getCenterX() - 13;
            yAux = (int) pacman.getpMan().getCenterY() - 14;
            while (yAux < (int) pacman.getpMan().getCenterY() + 14) {
                while (xAux >= 0) {
                    if (nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().isPresent() && !adyacente) {
                        nodoDestino = nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().get();
                        nodosAux.remove(nodoDestino);
                        nodoOrigen.getAristas_Adyacentes().stream().forEach((arista) -> {
                            if (arista.getDestino().equals(nodoDestino)) {
                                adyacente = true;
                            } else if (arista.getOrigen().equals(nodoDestino)) {
                                adyacente = true;
                            }
                        });
                        if (!adyacente) {
                            nodoDestino = null;
                        }
                    }
                    if (nodoDestino != null) {
                        xAux = -1;
                        break;
                    }
                    xAux--;
                }
                if (nodoDestino != null) {
                    yAux = (int) pacman.getpMan().getCenterY() - 13;
                    break;
                }

                yAux++;
                xAux = (int) pacman.getpMan().getCenterX() - 13;

            }
            if (nodoDestino != null) {
                pacman.getpMan().setRotate(-180);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(pacman.getpMan().centerXProperty(), nodoDestino.getPoint2D().getX());
                Double distance = nodoDestino.getPoint2D().distance(pacman.getNodo().getPoint2D());
                //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
                KeyFrame kf = new KeyFrame(Duration.millis((distance / 13) * 100), kv);
                timeline.getKeyFrames().add(kf);
                //La posicion del PacMan antes de la animacion
                posY = pacman.getpMan().getCenterY();
                posX = pacman.getpMan().getCenterX();
                //Inicio de la animacion
                timeline.play();
                movimientoPrevio = "LEFT";
                //Durante el transcurso de la animacion
                timeline.currentTimeProperty().addListener((observable) -> {
                    if (!movimientoPrevio.equals(movimiento) && movimiento.equals("RIGHT")) {
                        Platform.runLater(() -> {
                            movimientoOriginal = movimiento;
                            pila.clear();
                            timeline.stop();
                            right(true);
                        });
                    } else {
                        //  movimiento = "LEFT";
                    }
                });
                //Cuando se termina la animacion
                timeline.setOnFinished((valor) -> {
                    nodoOrigen = nodoDestino;
                    nodoDestino = null;
                    movimiento();
                });
            } else {
                //Cuando el pacMan no encuentra un nodo para moverse
                pacman.getpMan().setLength(300);
                movimiento = "";
                movimientoOriginal = "";
                movimientoPrevio = "";
                pila.clear();
                /*if (nodoOrigen.getAristas_Adyacentes().stream().anyMatch(x -> x.getDestino().getPoint2D().getX() < nodoOrigen.getPoint2D().getX() || x.getOrigen().getPoint2D().getX() < nodoOrigen.getPoint2D().getX())) {
                    movimiento = movientoOriginal;
                    movimiento();
                }*/
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
            movimientoPrevio = "LEFT";
            //Inicio de la animacion
            timeline.play();
            //Durante el transcurso de la animacion
            timeline.currentTimeProperty().addListener((observable) -> {
                if (!movimientoPrevio.equals(movimiento) && movimiento.equals("RIGHT")) {
                    Platform.runLater(() -> {
                        movimientoOriginal = movimiento;
                        pila.clear();
                        timeline.stop();
                        right(true);
                    });
                } else {
                    //movimiento = "LEFT";
                }
            });
            //Cuando se termina la animacion
            timeline.setOnFinished((valor) -> {
                // nodoOrigen = nodoAux;
                nodoDestino = null;
                movimiento();

            });
        }
    }

    public void right(Boolean devolver) {
        adyacente = false;
        copiaNodos();
        //cargarNodoArista();
        if (!devolver) {
            xAux = (int) pacman.getpMan().getCenterX() + 13;
            yAux = (int) pacman.getpMan().getCenterY() - 13;
            while (yAux < (int) pacman.getpMan().getCenterY() + 13) {
                while (xAux < 900) {
                    if (nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().isPresent() && !adyacente) {
                        nodoDestino = nodosAux.stream().filter(nodo -> (int) nodo.getPoint2D().getX() == xAux && (int) nodo.getPoint2D().getY() == yAux).findAny().get();
                        nodosAux.remove(nodoDestino);
                        nodoOrigen.getAristas_Adyacentes().stream().forEach((arista) -> {
                            if (arista.getDestino().equals(nodoDestino)) {
                                adyacente = true;
                            } else if (arista.getOrigen().equals(nodoDestino)) {
                                adyacente = true;
                            }
                        });
                        if (!adyacente) {
                            nodoDestino = null;
                        }
                    }

                    if (nodoDestino != null) {
                        xAux = -1;
                        break;
                    }
                    xAux++;
                }
                if (nodoDestino != null) {
                    yAux = (int) pacman.getpMan().getCenterY() + 13;
                    break;
                }

                yAux++;
                xAux = (int) pacman.getpMan().getCenterX() + 13;
            }

            if (nodoDestino != null) {
                pacman.getpMan().setRotate(0);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(pacman.getpMan().centerXProperty(), nodoDestino.getPoint2D().getX());
                Double distance = nodoDestino.getPoint2D().distance(pacman.getNodo().getPoint2D());
                //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
                KeyFrame kf = new KeyFrame(Duration.millis((distance / 13) * 100), kv);
                timeline.getKeyFrames().add(kf);
                //La posicion del PacMan antes de la animacion
                posY = pacman.getpMan().getCenterY();
                posX = pacman.getpMan().getCenterX();
                timeline.play();
                movimientoPrevio = "RIGHT";
                //Durante el transcurso de la animacion
                timeline.currentTimeProperty().addListener((observable) -> {
                    if (!movimientoPrevio.equals(movimiento) && movimiento.equals("LEFT")) {
                        Platform.runLater(() -> {
                            movimientoOriginal = movimiento;
                            pila.clear();
                            timeline.stop();
                            left(true);
                        });
                    } else {
                        //movimiento = "RIGHT";
                    }
                });

                timeline.setOnFinished((valor) -> {
                    nodoOrigen = nodoDestino;
                    nodoDestino = null;
                    movimiento();
                });
            } else {
                //Cuando el pacMan no encuentra un nodo para moverse
                pacman.getpMan().setLength(300);
                movimiento = "";
                movimientoOriginal = "";
                movimientoPrevio = "";
                pila.clear();
                /*if (nodoOrigen.getAristas_Adyacentes().stream().anyMatch(x -> x.getDestino().getPoint2D().getX() > nodoOrigen.getPoint2D().getX() || x.getOrigen().getPoint2D().getX() > nodoOrigen.getPoint2D().getX())) {
                    movimiento = movientoOriginal;
                    movimiento();
                }*/
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
            movimientoPrevio = "RIGHT";
            //Durante el transcurso de la animacion
            timeline.currentTimeProperty().addListener((observable) -> {
                if (!movimientoPrevio.equals(movimiento) && movimiento.equals("LEFT")) {
                    Platform.runLater(() -> {
                        movimientoOriginal = movimiento;
                        pila.clear();
                        timeline.stop();
                        left(true);
                    });
                } else {
                    //movimiento = "RIGHT";
                }
            });

            timeline.setOnFinished((valor) -> {
                //nodoOrigen = nodoAux;
                nodoDestino = null;
                movimiento();
            });
        }
    }

    private Label puntosJugador;
    private static Circle circle;
    private static Double xOrigen;
    private static Double xDestino;
    private static Double yOrigen;
    private static Double yDestino;

    public void nodos() {
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            //para que esto funcione en visualCode es necesario seleccionarlo desde src y usar este código
            /*File f = new File(".");
            String dir = f.getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(dir + "\\pacmanfx\\resources\\Arista.txt"));*/
            BufferedReader reader = new BufferedReader(new FileReader(dir + "\\src\\pacmanfx\\resources\\Nodos7.txt"));
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
    }

    public void aristas() {
        try {
            //para que esto funcione en visualCode es necesario seleccionarlo desde src y usar este código
            /*File f = new File(".");
            String dir = f.getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(dir + "\\pacmanfx\\resources\\Arista.txt"));*/
            File f = new File(".");
            String dir = f.getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(dir + "\\src\\pacmanfx\\resources\\Arista7.txt"));
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
                //this.root.getChildren().add(linea);
                arista.agregarNodos(nodos);
                aristas.add(arista);
            }
        } catch (IOException | NumberFormatException e) {
        }
    }

    public void cargarNodoArista() {
        nodos();
        aristas();
    }

    public void copiaNodos() {
        this.nodosAux = new ArrayList();
        nodos.stream().forEach((nodo) -> {
            nodosAux.add(nodo);
        });
    }

    public void CrearMapa() {
        cargarNodoArista();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 29; j++) {
                if (Mapa[i][j] == 'X') {//pared
                    Rectangle rec = new Rectangle(j * 31, i * 28, 31, 28);
                    rec.setStrokeType(StrokeType.OUTSIDE);
                    rec.setStroke(Paint.valueOf("BLACK"));
                    rec.setStrokeWidth(0.1);
                    rec.setFill(Paint.valueOf("#192936"));
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
                        //puntaje obtenido
                        puntos.stream().forEach((punto) -> {
                            Integer puntoX = (int) pacman.getpMan().getCenterX();
                            //System.out.println(puntoX);
                            while (puntoX < (int) pacman.getpMan().getCenterX() + 12) {
                                if (puntoX == (int) punto.getCenterX() && (int) punto.getCenterY() == (int) pacman.getpMan().getCenterY()) {
                                    root.getChildren().remove(punto);
                                    contPuntos++;
                                    Integer puntaje = contPuntos * 10;
                                    puntosJugador.setText(puntaje.toString());
                                    circle = punto;
                                    /*
                                        El pacman se comio un power pellet
                                     */
                                    if ((punto.getCenterX() == 45 && punto.getCenterY() == 517) || (punto.getCenterX() == 851 && punto.getCenterY() == 45)
                                            || (punto.getCenterX() == 45 && punto.getCenterY() == 45) || (punto.getCenterX() == 851 && punto.getCenterY() == 517)) {
                                        Pelotas = true;
                                    }
                                    break;
                                }
                                puntoX++;
                            }

                        });

                        /*
                            envíamos por parametros los fantasmas y en el hilo le cambiamos el color a azul
                         */
                        if (Pelotas) {
                            new hiloTiempo().correrHilo(redGhost, cyanGhost, orangeGhost, pinkGhost);
                            Pelotas = false;
                        }

                        if (Encierro()) {
                            lblEncierro.setVisible(true);
                            EncierroBandera = true;
                        }

                        puntos.remove(circle);
                        //Cuando logra comerse todos los puntos en la pantalla
                        //quedan 16 porque aún no se han limpiado bien más adelante hay que cambiiarlo
                        //todavía es necesario cambiar un poco la forma en la que está hecho el mapa por lo tanto debería de bajar a 8 y cuando ya se 
                        //arreglen todos los problemas que hay debería de bajar a 0 que es lo más lógico
                        int veces = 0;
                        if (puntos.size() == 8) {
                            if (vidas == 6) {
                                if (contVidas == 0) {
                                    System.out.println("Si cumple");
                                    /*
                                    Lo que hace esta parte es aumentar un contador en el texto para saber cual es la cantidad de juegos terminados sin perder vidas
                                    la variable contVidas es porque el método se hace varias veces entonces es para que solo se haga una vez la suma del contador
                                     */
                                    try {
                                        File f = new File(".");
                                        String dir = f.getAbsolutePath();
                                        String fileName = dir + "\\src\\pacmanfx\\resources\\NoPerderVidasCont.txt";
                                        File file = new File(fileName);
                                        FileReader fr = new FileReader(file);
                                        BufferedReader br = new BufferedReader(fr);
                                        String line;
                                        while ((line = br.readLine()) != null) {
                                            veces = Integer.parseInt(line);
                                        }
                                        try {
                                            String content = String.valueOf(veces + 1);
                                            File f1 = new File(".");
                                            String dir1 = f1.getAbsolutePath();
                                            String path = dir1 + "\\src\\pacmanfx\\resources\\NoPerderVidasCont.txt";
                                            Files.write(Paths.get(path), content.getBytes());

                                        } catch (IOException ex) {
                                            Logger.getLogger(MenuController.class
                                                    .getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(JugadorController.class
                                                .getName()).log(Level.SEVERE, null, ex);

                                    } catch (IOException ex) {
                                        Logger.getLogger(JugadorController.class
                                                .getName()).log(Level.SEVERE, null, ex);
                                    }
                                    contVidas++;
                                }
                            } else {
                                if (contVidas2 == 0) {
                                    System.out.println("no cumple");
                                    try {
                                        String content = "0";
                                        File f1 = new File(".");
                                        String dir1 = f1.getAbsolutePath();
                                        String path = dir1 + "\\src\\pacmanfx\\resources\\NoPerderVidasCont.txt";
                                        Files.write(Paths.get(path), content.getBytes());

                                    } catch (IOException ex) {
                                        Logger.getLogger(MenuController.class
                                                .getName()).log(Level.SEVERE, null, ex);
                                    }
                                    contVidas2++;
                                }
                            }
                            try {
                                String content = "1";
                                File f1 = new File(".");
                                String dir1 = f1.getAbsolutePath();
                                String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel7Completado.txt";
                                Files.write(Paths.get(path), content.getBytes());

                            } catch (IOException ex) {
                                Logger.getLogger(MenuController.class
                                        .getName()).log(Level.SEVERE, null, ex);

                            }
                            FlowController.getInstance().initialize();
                            FlowController.getInstance().goViewInStage("SeleccionNivel", this.getStage());
                        }

                        circle = null;
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
                        //puntaje obtenido
                        puntos.stream().forEach((punto) -> {
                            Double puntoY = pacman.getpMan().getCenterY();
                            while (puntoY.intValue() < (int) pacman.getpMan().getCenterY() + 12) {
                                if (puntoY.intValue() == (int) punto.getCenterY() && (int) punto.getCenterX() == (int) pacman.getpMan().getCenterX()) {
                                    root.getChildren().remove(punto);
                                    contPuntos++;
                                    Integer puntaje = contPuntos * 10;
                                    puntosJugador.setText(puntaje.toString());
                                    circle = punto;
                                    /*
                                        Cuando el pacman se come una power pellet
                                     */
                                    if ((punto.getCenterX() == 45 && punto.getCenterY() == 517) || (punto.getCenterX() == 851 && punto.getCenterY() == 45)
                                            || (punto.getCenterX() == 45 && punto.getCenterY() == 45) || (punto.getCenterX() == 851 && punto.getCenterY() == 517)) {
                                        Pelotas = true;
                                    }
                                    break;
                                }
                                puntoY++;
                            }

                        });

                        if (Pelotas) {
                            /*
                                envíamos por parametros los fantasmas y en el hilo le cambiamos el color a azul
                             */
                            new hiloTiempo().correrHilo(redGhost, cyanGhost, orangeGhost, pinkGhost);
                            Pelotas = false;
                        }
                        puntos.remove(circle);
                        //Cuando se quita los puntos de la pantalla

                        circle = null;
                        pacman.getNodo().setPoint2D(new Point2D(pacman.getpMan().getCenterX(), pacman.getpMan().getCenterY()));
                    });

                    pacman.getpMan().setFill(Paint.valueOf("#F22836"));
                    pacman.getpMan().setStrokeType(StrokeType.INSIDE);
                    pacman.getpMan().setStroke(Paint.valueOf("#2D4758"));
                    pacman.getpMan().setStrokeWidth(2);
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
        puntosJugador = puntaje;
        root.getChildren().add(puntaje);
        Label label1 = new Label(nivel);
        label1.setLayoutX(390);
        label1.setLayoutY(585);
        label1.setId("puntos");
        root.getChildren().add(label1);

        for (int i = 0; i < vidas; i++) {
            Arc arc = new Arc(725 + cont3, 605, 13.0, 15.0, 30, 300);
            arc.setFill(Paint.valueOf("#F22836"));
            arc.setStrokeType(StrokeType.INSIDE);
            arc.setStroke(Paint.valueOf("#2D4758"));
            arc.setStrokeWidth(2);
            arc.setType(ArcType.ROUND);
            root.getChildren().add(arc);
            cont3 += 30;
        }

        aristas.stream().forEach((arista) -> {

            xOrigen = arista.getOrigen().getPoint2D().getX();
            xDestino = arista.getDestino().getPoint2D().getX();
            yOrigen = arista.getOrigen().getPoint2D().getY();
            yDestino = arista.getDestino().getPoint2D().getY();
            /*if (((xOrigen != 512.0 && yOrigen != 240.0) || (xDestino != 512.0 && yDestino != 240.0))
                    && ((xOrigen != 260.0 && yOrigen != 240.0) || (xDestino != 260.0 && yDestino != 240.0))
                    && ((xOrigen != 260.0 && yOrigen != 240.0) || (xDestino != 260.0 && yDestino != 240.0))
                    && ((xOrigen != 633.0 && yOrigen != 240.0) || (xDestino != 633.0 && yDestino != 240.0))
                    && ((xOrigen != 601.0 && yOrigen != 405.0) || (xDestino != 601.0 && yDestino != 405.0))
                    && ((xOrigen != 323.0 && yOrigen != 405.0) || (xDestino != 323.0 && yDestino != 405.0))
                    && ((xOrigen != 387.0 && yOrigen != 240.0) || (xDestino != 387.0 && yDestino != 240.0))) {*/
            Circle origen = new Circle(xDestino, yDestino, 3, Paint.valueOf("#d4d4d4"));
            puntos.add(origen);
            root.getChildren().add(origen);//
            Circle destino = new Circle(xOrigen, yOrigen, 3, Paint.valueOf("#d4d4d4"));
            puntos.add(destino);
            root.getChildren().add(destino);//
            //}

            if (Objects.equals(xOrigen, xDestino) && yOrigen > yDestino) {
                //if (((xOrigen != 512.0 && yOrigen != 240.0) || (xDestino != 512.0 && yDestino != 240.0))) {
                yDestino += 29;
                while (yDestino < yOrigen) {
                    if (yDestino <= yOrigen - 13) {
                        circle = new Circle(xDestino, yDestino, 3, Paint.valueOf("#d4d4d4"));
                        puntos.add(circle);
                        root.getChildren().add(circle);//tamaño y posición de la comida del pacman
                    }
                    yDestino += 29;
                }
                //}
            } else if (Objects.equals(xOrigen, xDestino) && yOrigen < yDestino) {
                /*if (((xOrigen != 260.0 && yOrigen != 240.0) || (xDestino != 260.0 && yDestino != 240.0))
                        && ((xOrigen != 633.0 && yOrigen != 240.0) || (xDestino != 633.0 && yDestino != 240.0))
                        && ((xOrigen != 601.0 && yOrigen != 405.0) || (xDestino != 601.0 && yDestino != 405.0))
                        && ((xOrigen != 323.0 && yOrigen != 405.0) || (xDestino != 323.0 && yDestino != 405.0))
                        && ((xOrigen != 387.0 && yOrigen != 240.0) || (xDestino != 387.0 && yDestino != 240.0))) {*/
                yOrigen += 29;
                while (yOrigen < yDestino) {
                    if (yOrigen <= yDestino - 13) {
                        circle = new Circle(xDestino, yOrigen, 3, Paint.valueOf("#d4d4d4"));
                        puntos.add(circle);
                        root.getChildren().add(circle);//tamaño y posición de la comida del pacman
                    }
                    yOrigen += 29;
                }
                //}
            } else if (Objects.equals(yOrigen, yDestino) && xOrigen > xDestino) {
                /*if (((xOrigen != 387.0 && yOrigen != 240.0) || (xDestino != 387.0 && yDestino != 240.0))
                        && ((xOrigen != 260.0 && yOrigen != 405.0) || (xDestino != 260.0 && yDestino != 405.0))) {*/
                xDestino += 31;
                while (xDestino < xOrigen) {
                    if (xDestino <= xOrigen - 16) {
                        circle = new Circle(xDestino, yDestino, 3, Paint.valueOf("#d4d4d4"));
                        puntos.add(circle);
                        root.getChildren().add(circle);//tamaño y posición de la comida del pacman
                    }
                    xDestino += 31;
                }
                //}
            } else if (Objects.equals(yOrigen, yDestino) && xOrigen < xDestino) {
                /*if (((xOrigen != 387.0 && yOrigen != 240.0) || (xDestino != 387.0 && yDestino != 240.0))
                        && ((xOrigen != 260.0 && yOrigen != 405.0) || (xDestino != 260.0 && yDestino != 405.0))) {*/
                xOrigen += 31;
                while (xOrigen <= xDestino) {
                    if (xOrigen <= xDestino - 16) {
                        circle = new Circle(xOrigen, yDestino, 3, Paint.valueOf("#d4d4d4"));
                        puntos.add(circle);
                        root.getChildren().add(circle);//tamaño y posición de la comida del pacman
                    }
                    xOrigen += 31;
                }
                //}
            }
        });

        //Elimina las puntos repetidos en el mapa 
        ArrayList<Circle> pAux = new ArrayList();
        puntos.stream().forEach((t) -> {
            puntos.stream().forEach((c) -> {
                if (c != t || (t.getCenterX() == 294.0 && t.getCenterY() == 407.0) || (t.getCenterX() == 294.0 && t.getCenterY() == 380.0)
                        || (t.getCenterX() == 294.0 && t.getCenterY() == 354.0) || (t.getCenterX() == 294.0 && t.getCenterY() == 325.0)
                        || (t.getCenterX() == 294.0 && t.getCenterY() == 296.0) || (t.getCenterX() == 294.0 && t.getCenterY() == 267.0)
                        || (t.getCenterX() == 294.0 && t.getCenterY() == 238.0) || (t.getCenterX() == 325.0 && t.getCenterY() == 238.0)
                        || (t.getCenterX() == 356.0 && t.getCenterY() == 238.0) || (t.getCenterX() == 386.0 && t.getCenterY() == 238.0)
                        || (t.getCenterX() == 417.0 && t.getCenterY() == 238.0) || (t.getCenterX() == 448.0 && t.getCenterY() == 238.0)
                        || (t.getCenterX() == 450.0 && t.getCenterY() == 269.0) || (t.getCenterX() == 429.0 && t.getCenterY() == 305.0)
                        || (t.getCenterX() == 398.0 && t.getCenterY() == 305.0) || (t.getCenterX() == 481.0 && t.getCenterY() == 305.0)
                        || (t.getCenterX() == 479.0 && t.getCenterY() == 238.0) || (t.getCenterX() == 510.0 && t.getCenterY() == 238.0)
                        || (t.getCenterX() == 541.0 && t.getCenterY() == 238.0) || (t.getCenterX() == 572.0 && t.getCenterY() == 238.0)
                        || (t.getCenterX() == 606.0 && t.getCenterY() == 238.0) || (t.getCenterX() == 606.0 && t.getCenterY() == 267.0)
                        || (t.getCenterX() == 606.0 && t.getCenterY() == 296.0) || (t.getCenterX() == 606.0 && t.getCenterY() == 322.0)
                        || (t.getCenterX() == 450.0 && t.getCenterY() == 240.0) || (t.getCenterX() == 367.0 && t.getCenterY() == 305.0)
                        || (t.getCenterX() == 450.0 && t.getCenterY() == 305.0) || (t.getCenterX() == 527.0 && t.getCenterY() == 305.0)
                        || (t.getCenterX() == 606.0 && t.getCenterY() == 352.0) || (t.getCenterX() == 606.0 && t.getCenterY() == 381.0)
                        || (t.getCenterX() == 325.0 && t.getCenterY() == 407.0) || (t.getCenterX() == 356.0 && t.getCenterY() == 407.0)
                        || (t.getCenterX() == 387.0 && t.getCenterY() == 407.0) || (t.getCenterX() == 418.0 && t.getCenterY() == 407.0)
                        || (t.getCenterX() == 447.0 && t.getCenterY() == 407.0) || (t.getCenterX() == 478.0 && t.getCenterY() == 407.0)
                        || (t.getCenterX() == 509.0 && t.getCenterY() == 407.0) || (t.getCenterX() == 541.0 && t.getCenterY() == 407.0)
                        || (t.getCenterX() == 571.0 && t.getCenterY() == 407.0) || (t.getCenterX() == 606.0 && t.getCenterY() == 407.0)
                        || (t.getCenterX() == 294.0 && t.getCenterY() == 323.0) || (t.getCenterX() == 294.0 && t.getCenterY() == 352.0)
                        || (t.getCenterX() == 294.0 && t.getCenterY() == 383.0) || (t.getCenterX() == 606.0 && t.getCenterY() == 325.0)
                        || (t.getCenterX() == 606.0 && t.getCenterY() == 354.0) || (t.getCenterX() == 606.0 && t.getCenterY() == 383.0)
                        || (t.getCenterX() == 540.0 && t.getCenterY() == 407.0)) {
                    if (c.getCenterX() == t.getCenterX() && c.getCenterY() == t.getCenterY()) {
                        if (!pAux.contains(c)) {
                            pAux.add(t);
                        }
                    }
                }
            });
        });

        puntos.removeAll(pAux);
        root.getChildren().removeAll(pAux);

        //aquí se crean los fantasmas
        root.getChildren().add(redGhost);
        root.getChildren().add(cyanGhost);
        root.getChildren().add(orangeGhost);
        root.getChildren().add(pinkGhost);
        Circle origen1 = new Circle(45.0, 517.0, 5, Paint.valueOf("#d4d4d4"));
        puntos.add(origen1);
        root.getChildren().add(origen1);
        Circle origen2 = new Circle(45.0, 45.0, 5, Paint.valueOf("#d4d4d4"));
        puntos.add(origen2);
        root.getChildren().add(origen2);
        Circle origen3 = new Circle(851.0, 45.0, 5, Paint.valueOf("#d4d4d4"));
        puntos.add(origen3);
        root.getChildren().add(origen3);
        Circle origen4 = new Circle(851.0, 517.0, 5, Paint.valueOf("#d4d4d4"));
        puntos.add(origen4);
        root.getChildren().add(origen4);
        nodos.stream().forEach((nodo) -> {
            if (nodo.getPoint2D().getX() == 447.0 && nodo.getPoint2D().getY() == 407.0) {
                nodoOrigen = nodo;
            }
        });
    }

    /*
     *  Algortitmo de dijstra 
     */
    Nodo inicial;
    Nodo auxInicial;
    Nodo auxNodo5;
    Stack<Nodo> pilaSuprema = new Stack<>();

    void moveRedGhost() {
        Platform.runLater(() -> {
            if (inicial == null) {
                nodos.stream().forEach((t) -> {
                    //System.out.println(t.getAristas_Adyacentes().size());
                    if (t.getPoint2D().getX() == 450.0 && t.getPoint2D().getY() == 240.0) {
                        inicial = t;
                    }
                });
            }

            Dijkstra dijkstra;
            nodos.stream().forEach((t) -> {
                t.setLongitud(0);
                t.setMarca(false);
                t.setNodoAntecesorDisjktra(null);
            });

            inicial.setMarca(false);
            dijkstra = new Dijkstra(new Grafo(nodos, aristas));
            dijkstra.ejecutar(inicial);

            List<Arista> aristasAux;

            if (nodoDestino != null) {
                aristasAux = dijkstra.marcarRutaCorta(nodoDestino);
            } else {
                aristasAux = dijkstra.marcarRutaCorta(nodoOrigen);
            }

            //Doy vuelta a la lista 
            Collections.reverse(aristasAux);
            /*
             *  Bloqueamos a la primera arista del fantasma
             */
            if (aristasAux != null && !aristasAux.isEmpty()) {
                aristasAux.get(0).setBloqueado(true);
            }
            LinkedList<Nodo> listEnlazada = new LinkedList();
            aristasAux.stream().forEach((t) -> {
                /*
                 *   Si contiene origen guardamos destino, de lo contrario guardamos destino
                 */
                if (listEnlazada.size() > 1) {
                    if (listEnlazada.contains(t.getDestino())) {
                        listEnlazada.add(t.getOrigen());
                    } else /*if (listEnlazada.contains(t.getOrigen()))*/ {
                        listEnlazada.add(t.getDestino());
                    }
                } else {
                    if (t.getDestino().getPoint2D().getX() == inicial.getPoint2D().getX() && t.getDestino().getPoint2D().getY() == inicial.getPoint2D().getY()) {
                        listEnlazada.add(t.getOrigen());
                    } else {
                        listEnlazada.add(t.getDestino());
                    }
                }
            });

            Queue<Nodo> cola = new LinkedList(listEnlazada);

            auxNodo5 = cola.poll();

            Timeline timeline = new Timeline();
            if (auxNodo5 == null) {
                auxNodo5 = nodoOrigen;
            }

            Double distance = inicial.getPoint2D().distance(auxNodo5.getPoint2D());
            KeyValue kv2 = new KeyValue(redGhost.layoutYProperty(), auxNodo5.getPoint2D().getY() - 14);
            KeyValue kv = new KeyValue(redGhost.layoutXProperty(), auxNodo5.getPoint2D().getX() - 14);
            KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 10) * 100), kv2);
            KeyFrame kf = new KeyFrame(Duration.millis((distance / 10) * 100), kv);
            timeline.getKeyFrames().addAll(kf2, kf);

            timeline.play();
            //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
            timeline.setOnFinished((event) -> {
                Platform.runLater(() -> {
                    inicial = auxNodo5;
                    if (aristasAux != null && !aristasAux.isEmpty()) {
                        aristasAux.get(0).setBloqueado(false);
                    }
                    moveRedGhost();
                });

            });

        });
    }

    /*
     *  Algortitmo de dijstra 
     */
    Nodo inicial2;
    Nodo auxInicial2;
    Nodo auxNodo6;

    void movePinkGhost() {
        Platform.runLater(() -> {
            if (inicial2 == null) {
                nodos.stream().forEach((t) -> {
                    //System.out.println(t.getAristas_Adyacentes().size());
                    if (t.getPoint2D().getX() == 527.0 && t.getPoint2D().getY() == 305.0) {
                        inicial2 = t;
                    }
                });
            }

            Dijkstra dijkstra;
            nodos.stream().forEach((t) -> {
                t.setLongitud(0);
                t.setMarca(false);
                t.setNodoAntecesorDisjktra(null);
            });

            inicial2.setMarca(false);
            dijkstra = new Dijkstra(new Grafo(nodos, aristas));
            dijkstra.ejecutar(inicial2);

            List<Arista> aristasAux;

            if (nodoDestino != null) {
                aristasAux = dijkstra.marcarRutaCorta(nodoDestino);
            } else {
                aristasAux = dijkstra.marcarRutaCorta(nodoOrigen);
            }

            //Doy vuelta a la lista 
            Collections.reverse(aristasAux);
            /*
             *  Bloqueamos a la primera arista del fantasma
             */
            if (aristasAux != null && !aristasAux.isEmpty()) {
                aristasAux.get(0).setBloqueado(true);
            }
            LinkedList<Nodo> listEnlazada = new LinkedList();
            aristasAux.stream().forEach((t) -> {
                /*
                 *   Si contiene origen guardamos destino, de lo contrario guardamos destino
                 */
                if (listEnlazada.size() > 1) {
                    if (listEnlazada.contains(t.getDestino())) {
                        listEnlazada.add(t.getOrigen());
                    } else /*if (listEnlazada.contains(t.getOrigen()))*/ {
                        listEnlazada.add(t.getDestino());
                    }
                } else {
                    if (t.getDestino().getPoint2D().getX() == inicial2.getPoint2D().getX() && t.getDestino().getPoint2D().getY() == inicial2.getPoint2D().getY()) {
                        listEnlazada.add(t.getOrigen());
                    } else {
                        listEnlazada.add(t.getDestino());
                    }
                }
            });

            Queue<Nodo> cola = new LinkedList(listEnlazada);

            auxNodo6 = cola.poll();
            if (auxNodo6 == null) {
                auxNodo6 = nodoOrigen;
            }

            Timeline timeline = new Timeline();
            Double distance = inicial2.getPoint2D().distance(auxNodo6.getPoint2D());
            KeyValue kv2 = new KeyValue(pinkGhost.layoutYProperty(), auxNodo6.getPoint2D().getY() - 14);
            KeyValue kv = new KeyValue(pinkGhost.layoutXProperty(), auxNodo6.getPoint2D().getX() - 14);
            KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 8) * 100), kv2);
            KeyFrame kf = new KeyFrame(Duration.millis((distance / 8) * 100), kv);
            timeline.getKeyFrames().addAll(kf2, kf);

            timeline.play();
            //Formula para sacar el tiempo necesario para que se vea fluido distancia/velocidad  multiplicado por 100 ya que es en milisegundos
            timeline.setOnFinished((event) -> {
                Platform.runLater(() -> {
                    inicial2 = auxNodo6;
                    if (aristasAux != null && !aristasAux.isEmpty()) {
                        aristasAux.get(0).setBloqueado(false);
                    }
                    movePinkGhost();
                });
            });
        });
    }

    Nodo nodoOrigen;
    Nodo nFinal;

    Floyd floyd;
    int index1 = 10000, index2;

    private void moveOrangeGhost() {
        Platform.runLater(() -> {
            if (!floyd.getCaminos().isEmpty()) {
                index2 = floyd.getCaminos().poll();

                Timeline timeline = new Timeline();
                Double distance = nodos.get(index1).getPoint2D().distance(nodos.get(index2).getPoint2D());
                KeyValue kv2 = new KeyValue(orangeGhost.layoutYProperty(), nodos.get(index2).getPoint2D().getY() - 14);
                KeyValue kv = new KeyValue(orangeGhost.layoutXProperty(), nodos.get(index2).getPoint2D().getX() - 14);
                KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 8) * 100), kv2);
                KeyFrame kf = new KeyFrame(Duration.millis((distance / 8) * 100), kv);
                timeline.getKeyFrames().addAll(kf2, kf);

                timeline.play();

                timeline.setOnFinished((event) -> {
                    //floyd.getCaminos().clear();
                    index1 = index2;
                    moveOrangeGhost();
                });
            } else {
                if (index1 == 10000) {
                    nodos.stream().forEach(x -> {
                        if (x.getPoint2D().getX() == 450.0 && x.getPoint2D().getY() == 305.0) {
                            index1 = nodos.indexOf(x);
                        }
                    });
                }

                index2 = random();
                floyd.recuperaCamino(index1, index2);
                if (floyd.getCaminos().isEmpty()) {
                    moveOrangeGhost();
                } else {
                    index2 = floyd.getCaminos().poll();

                    Timeline timeline = new Timeline();
                    Double distance = nodos.get(index1).getPoint2D().distance(nodos.get(index2).getPoint2D());
                    KeyValue kv2 = new KeyValue(orangeGhost.layoutYProperty(), nodos.get(index2).getPoint2D().getY() - 14);
                    KeyValue kv = new KeyValue(orangeGhost.layoutXProperty(), nodos.get(index2).getPoint2D().getX() - 14);
                    KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 8) * 100), kv2);
                    KeyFrame kf = new KeyFrame(Duration.millis((distance / 8) * 100), kv);
                    timeline.getKeyFrames().addAll(kf2, kf);

                    timeline.play();

                    timeline.setOnFinished((event) -> {
                        //floyd.getCaminos().clear();
                        index1 = index2;
                        moveOrangeGhost();
                    });
                }
            }
        });
    }

    private int random() {
        int valorEntero = (int) Math.floor(Math.random() * (nodos.size()));
        if (index1 != valorEntero) {
            return valorEntero;
        } else {
            return random();
        }
    }
    /*
    *Algortimo de Floyd Warshall
     */
    private Integer matPeso[][];

    private void llenarMatPeso() {
        StringBuilder sb = new StringBuilder();
        //Se crea una matriz cuadrada del tamanno de los nodos totales

        matPeso = new Integer[nodos.size()][nodos.size()];
        for (int i = 0; i < nodos.size(); i++) {
            Nodo aux = nodos.get(i);//Ubicamos el nodo con el que vamos a comparar
            for (int j = 0; j < nodos.size(); j++) {
                matPeso[i][j] = 10000;
                if (i != j) {// Si no se esta ubicado en la diagonal
                    Nodo aux2 = nodos.get(j);

                    for (Arista arista : aristas) {
                        //Intentamos ubicar la arista que coincida con los nodos auxiliares para agregar el peso en la matriz
                        if ((arista.getDestino().equals(aux) && arista.getOrigen().equals(aux2)) || (arista.getDestino().equals(aux2) && arista.getOrigen().equals(aux))) {
                            matPeso[i][j] = arista.getPeso();
                        }
                    }
                } //Si es la diagonal se llena la matriz con peso 0
                else {
                    matPeso[i][j] = 0;
                }
                sb.append(matPeso[i][j]);
                sb.append("\t");
            }
            sb.append("\n");
        }

        floyd = new Floyd(nodos.size());
        floyd.iniciarMatriz(matPeso);
        floyd2 = new Floyd(nodos.size());
        floyd2.iniciarMatriz(matPeso);
        // System.out.println(sb);
    }
    Floyd floyd2;

    private void moveCyanGhost() {
        int caso = RandomCian();
        switch (caso) {
            case 1: // Caso en el que buscamos nodos aleatorios
                caso1();
                break;
            case 2: // caso en el que se persigue al pacman
                caso2();
                break;
            case 3: // caso en el que se persigue a un fantasma
                caso3();
                break;
        }
    }

    int ind1 = 10000, ind2;

    private void caso1() {
        Platform.runLater(() -> {
            if (!floyd2.getCaminos().isEmpty()) {
                ind2 = floyd2.getCaminos().poll();

                Timeline timeline = new Timeline();
                Double distance = nodos.get(ind1).getPoint2D().distance(nodos.get(ind2).getPoint2D());
                KeyValue kv2 = new KeyValue(cyanGhost.layoutYProperty(), nodos.get(ind2).getPoint2D().getY() - 14);
                KeyValue kv = new KeyValue(cyanGhost.layoutXProperty(), nodos.get(ind2).getPoint2D().getX() - 14);
                KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 8) * 100), kv2);
                KeyFrame kf = new KeyFrame(Duration.millis((distance / 8) * 100), kv);
                timeline.getKeyFrames().addAll(kf2, kf);

                timeline.play();
                timeline.setOnFinished((event) -> {
                    //floyd.getCaminos().clear();

                    ind1 = ind2;
                    if (floyd2.getCaminos().isEmpty()) {
                        moveCyanGhost();
                    } else {
                        caso1();
                    }

                });
            } else {
                if (ind1 == 10000) {
                    nodos.stream().forEach(x -> {
                        if (x.getPoint2D().getX() == 367.0 && x.getPoint2D().getY() == 305.0) {
                            ind1 = nodos.indexOf(x);
                        }
                    });
                }

                ind2 = random();
                floyd2.recuperaCamino(ind1, ind2);
                if (floyd2.getCaminos().isEmpty()) {
                    caso1();
                } else {
                    ind2 = floyd2.getCaminos().poll();

                    Timeline timeline = new Timeline();
                    Double distance = nodos.get(ind1).getPoint2D().distance(nodos.get(ind2).getPoint2D());
                    KeyValue kv2 = new KeyValue(cyanGhost.layoutYProperty(), nodos.get(ind2).getPoint2D().getY() - 14);
                    KeyValue kv = new KeyValue(cyanGhost.layoutXProperty(), nodos.get(ind2).getPoint2D().getX() - 14);
                    KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 8) * 100), kv2);
                    KeyFrame kf = new KeyFrame(Duration.millis((distance / 8) * 100), kv);
                    timeline.getKeyFrames().addAll(kf2, kf);

                    timeline.play();

                    timeline.setOnFinished((event) -> {
                        //floyd.getCaminos().clear();
                        ind1 = ind2;
                        if (floyd2.getCaminos().isEmpty()) {
                            moveCyanGhost();
                        } else {
                            caso1();
                        }
                    });
                }
            }
        });
    }

    private void caso2() {
        Platform.runLater(() -> {
            if (!floyd2.getCaminos().isEmpty()) {
                ind2 = floyd2.getCaminos().poll();

                Timeline timeline = new Timeline();
                Double distance = nodos.get(ind1).getPoint2D().distance(nodos.get(ind2).getPoint2D());
                KeyValue kv2 = new KeyValue(cyanGhost.layoutYProperty(), nodos.get(ind2).getPoint2D().getY() - 14);
                KeyValue kv = new KeyValue(cyanGhost.layoutXProperty(), nodos.get(ind2).getPoint2D().getX() - 14);
                KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 8) * 100), kv2);
                KeyFrame kf = new KeyFrame(Duration.millis((distance / 8) * 100), kv);
                timeline.getKeyFrames().addAll(kf2, kf);

                timeline.play();
                timeline.setOnFinished((event) -> {
                    //floyd.getCaminos().clear();

                    ind1 = ind2;
                    if (floyd2.getCaminos().isEmpty()) {
                        moveCyanGhost();
                    } else {
                        caso2();
                    }

                });
            } else {
                if (ind1 == 10000) {
                    nodos.stream().forEach(x -> {
                        if (x.getPoint2D().getX() == 367.0 && x.getPoint2D().getY() == 305.0) {
                            ind1 = nodos.indexOf(x);
                        }
                    });
                }

                ind2 = nodos.indexOf(nodoOrigen);
                floyd2.recuperaCamino(ind1, ind2);
                if (floyd2.getCaminos().isEmpty()) {
                    caso2();
                } else {
                    floyd2.getCaminos().add(ind2);
                    ind2 = floyd2.getCaminos().poll();

                    Timeline timeline = new Timeline();
                    Double distance = nodos.get(ind1).getPoint2D().distance(nodos.get(ind2).getPoint2D());
                    KeyValue kv2 = new KeyValue(cyanGhost.layoutYProperty(), nodos.get(ind2).getPoint2D().getY() - 14);
                    KeyValue kv = new KeyValue(cyanGhost.layoutXProperty(), nodos.get(ind2).getPoint2D().getX() - 14);
                    KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 8) * 100), kv2);
                    KeyFrame kf = new KeyFrame(Duration.millis((distance / 8) * 100), kv);
                    timeline.getKeyFrames().addAll(kf2, kf);

                    timeline.play();

                    timeline.setOnFinished((event) -> {
                        //floyd.getCaminos().clear();
                        ind1 = ind2;
                        if (floyd2.getCaminos().isEmpty()) {
                            moveCyanGhost();
                        } else {
                            caso2();
                        }
                    });
                }
            }
        });
    }

    private void caso3() {
        Platform.runLater(() -> {
            if (!floyd2.getCaminos().isEmpty()) {
                ind2 = floyd2.getCaminos().poll();

                Timeline timeline = new Timeline();
                Double distance = nodos.get(ind1).getPoint2D().distance(nodos.get(ind2).getPoint2D());
                KeyValue kv2 = new KeyValue(cyanGhost.layoutYProperty(), nodos.get(ind2).getPoint2D().getY() - 14);
                KeyValue kv = new KeyValue(cyanGhost.layoutXProperty(), nodos.get(ind2).getPoint2D().getX() - 14);
                KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 8) * 100), kv2);
                KeyFrame kf = new KeyFrame(Duration.millis((distance / 8) * 100), kv);
                timeline.getKeyFrames().addAll(kf2, kf);

                timeline.play();
                timeline.setOnFinished((event) -> {
                    //floyd.getCaminos().clear();

                    ind1 = ind2;
                    if (floyd2.getCaminos().isEmpty()) {
                        moveCyanGhost();
                    } else {
                        caso3();
                    }

                });
            } else {
                if (ind1 == 10000) {
                    nodos.stream().forEach(x -> {
                        if (x.getPoint2D().getX() == 367.0 && x.getPoint2D().getY() == 305.0) {
                            ind1 = nodos.indexOf(x);
                        }
                    });
                }

                ind2 = GhostsRandom();

                floyd2.recuperaCamino(ind1, ind2);
                if (floyd2.getCaminos().isEmpty()) {
                    caso3();
                } else {
                    floyd2.getCaminos().add(ind2);
                    ind2 = floyd2.getCaminos().poll();

                    Timeline timeline = new Timeline();
                    Double distance = nodos.get(ind1).getPoint2D().distance(nodos.get(ind2).getPoint2D());
                    KeyValue kv2 = new KeyValue(cyanGhost.layoutYProperty(), nodos.get(ind2).getPoint2D().getY() - 14);
                    KeyValue kv = new KeyValue(cyanGhost.layoutXProperty(), nodos.get(ind2).getPoint2D().getX() - 14);
                    KeyFrame kf2 = new KeyFrame(Duration.millis((distance / 8) * 100), kv2);
                    KeyFrame kf = new KeyFrame(Duration.millis((distance / 8) * 100), kv);
                    timeline.getKeyFrames().addAll(kf2, kf);

                    timeline.play();

                    timeline.setOnFinished((event) -> {
                        //floyd.getCaminos().clear();
                        ind1 = ind2;
                        if (floyd2.getCaminos().isEmpty()) {
                            moveCyanGhost();
                        } else {
                            caso3();
                        }

                    });
                }
            }
        });
    }

    private int GhostsRandom() {
        int fantasma = 0;
        int valorEntero = (int) Math.floor(Math.random() * (3) + 1);
        switch (valorEntero) {
            case 1:            // RED GHOST
                fantasma = nodos.indexOf(auxNodo5);
                break;
            case 2:            // ORANGE GHOST
                fantasma = index2;
                break;
            case 3:            // PINK GHOST
                fantasma = nodos.indexOf(auxNodo6);
                break;
        }
        return fantasma;
    }

    private int RandomCian() {
        int valorEntero = (int) Math.floor(Math.random() * (3) + 1);
        return valorEntero;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contadorEncierro = 0;
        Top10();
        CrearMapa();
        llenarMatPeso();
        //Inicio el movimiento del PacMan hacia la derecha
        movimiento = "RIGHT";
        movimientoOriginal = "RIGHT";
        pila.push("RIGHT");
        right(false);
        moveRedGhost();
        movePinkGhost();
        moveOrangeGhost();
        moveCyanGhost();
        EncierroValor = (puntos.size() - 8) / 2;
        Hilo = new hiloTiempo();
        hiloTiempo.finalizado = false;
        Hilo.correrHilo();

        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/FondoNivel7.jpg");
            img.setImage(imgLogo);
        } catch (Exception e) {
        }
        int veces = 0;
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas7.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                veces = Integer.parseInt(line);
            }
            try {
                String content = String.valueOf(veces + 1);
                File f1 = new File(".");
                String dir1 = f1.getAbsolutePath();
                String path = dir1 + "\\src\\pacmanfx\\resources\\Partidas7.txt";
                Files.write(Paths.get(path), content.getBytes());

            } catch (IOException ex) {
                Logger.getLogger(MenuController.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        lblEncierro.setVisible(false);
        lblSuperVelocidad.setVisible(false);
    }

    @FXML
    private void mouse(MouseEvent event) {
        root.getChildren().get(root.getChildren().size() - 1).setOpacity(0);
        System.out.println(event.getX());
        System.out.println(event.getY());
        Circle circle = new Circle(event.getX(), event.getY(), 3, Paint.valueOf("RED"));
        root.getChildren().add(circle);
    }

    /*
        este método lo que hace es aumentar la cantidad de fantasmas que se ha comido el usuario. Es para usarlo cuando ya funcione comer fantasmas
     */
    void ComerFantasmaGuardarArchivo() {
        int veces = 0;
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\FantasmasComidos.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                veces = Integer.parseInt(line);
            }
            try {
                String content = String.valueOf(veces + 1);
                File f1 = new File(".");
                String dir1 = f1.getAbsolutePath();
                String path = dir1 + "\\src\\pacmanfx\\resources\\FantasmasComidos.txt";
                Files.write(Paths.get(path), content.getBytes());

            } catch (IOException ex) {
                Logger.getLogger(MenuController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UsarEncierroContador() {
        int veces = 0;
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Encierro5VecesCont.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                veces = Integer.parseInt(line);
            }
            try {
                String content = String.valueOf(veces + 1);
                File f1 = new File(".");
                String dir1 = f1.getAbsolutePath();
                String path = dir1 + "\\src\\pacmanfx\\resources\\Encierro5VecesCont.txt";
                Files.write(Paths.get(path), content.getBytes());

            } catch (IOException ex) {
                Logger.getLogger(MenuController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean Encierro() {
        /*
            condición para el encierro
            Que el pacman se haya comido la mitad de los puntos del mapa y que no haya perdido ninguna vida
         */
        return ((((puntos.size() - 8) > EncierroValor - 4) && ((puntos.size() - 8) < EncierroValor + 4)) && (vidas == 6));
    }
    private ArrayList<Integer> TopList = new ArrayList();

    public void Top10() {
        /*
         * Basicamente lleno el ArrayList con los datos Top que tengo en los txt
         */
        try {
            File f13 = new File(".");
            String dir13 = f13.getAbsolutePath();
            String fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top1.txt";
            File file13 = new File(fileName13);
            FileReader fr13 = new FileReader(file13);
            BufferedReader br13 = new BufferedReader(fr13);
            String line13;
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top2.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top3.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top4.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top5.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top6.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top7.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top8.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top9.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
            fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Top10.txt";
            file13 = new File(fileName13);
            fr13 = new FileReader(file13);
            br13 = new BufferedReader(fr13);
            while ((line13 = br13.readLine()) != null) {
                TopList.add(Integer.parseInt(line13));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        TopList.stream().forEach(c -> {
            System.out.println(c);
        });
    }

    private void OrganizarTop() {
        try {
            String content = String.valueOf(TopList.get(0));
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Top1.txt";
            Files.write(Paths.get(path), content.getBytes());
            content = String.valueOf(TopList.get(1));
            path = dir1 + "\\src\\pacmanfx\\resources\\Top2.txt";
            Files.write(Paths.get(path), content.getBytes());
            content = String.valueOf(TopList.get(2));
            path = dir1 + "\\src\\pacmanfx\\resources\\Top3.txt";
            Files.write(Paths.get(path), content.getBytes());
            content = String.valueOf(TopList.get(3));
            path = dir1 + "\\src\\pacmanfx\\resources\\Top4.txt";
            Files.write(Paths.get(path), content.getBytes());
            content = String.valueOf(TopList.get(4));
            path = dir1 + "\\src\\pacmanfx\\resources\\Top5.txt";
            Files.write(Paths.get(path), content.getBytes());
            content = String.valueOf(TopList.get(5));
            path = dir1 + "\\src\\pacmanfx\\resources\\Top6.txt";
            Files.write(Paths.get(path), content.getBytes());
            content = String.valueOf(TopList.get(6));
            path = dir1 + "\\src\\pacmanfx\\resources\\Top7.txt";
            Files.write(Paths.get(path), content.getBytes());
            content = String.valueOf(TopList.get(7));
            path = dir1 + "\\src\\pacmanfx\\resources\\Top8.txt";
            Files.write(Paths.get(path), content.getBytes());
            content = String.valueOf(TopList.get(8));
            path = dir1 + "\\src\\pacmanfx\\resources\\Top9.txt";
            Files.write(Paths.get(path), content.getBytes());
            content = String.valueOf(TopList.get(9));
            path = dir1 + "\\src\\pacmanfx\\resources\\Top10.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Editar Puntos Totales");
            alert.setContentText("Error al editar Puntos totales");
            alert.showAndWait();
        }
    }
}
