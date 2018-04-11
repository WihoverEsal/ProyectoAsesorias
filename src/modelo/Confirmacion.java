/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import proyectoasesorias.Alumno;

/**
 *
 * @author VictorEstupiñan
 */
public class Confirmacion extends Application{
    
    String hora;
    String dia;
    String profe;
    String cubo;
    
    public Confirmacion(String hora, String dia, String profe){
        this.hora = hora;
        this.dia = dia;
        this.profe = profe;
        this.cubo = "H-224";
    }

    @Override
    public void start(Stage escenario) throws Exception {
        escenario.setTitle("Confirmacion");
        
        FlowPane raiz = new FlowPane(10, 10);
        raiz.setAlignment(Pos.CENTER);
        raiz.setStyle("-fx-background-color: #FFC107;");
        
        Scene escena = new Scene(raiz, 670, 100);        
        escenario.setScene(escena);
        
        VBox vbControles = new VBox(10);
        HBox hbBtns = new HBox(20);
        
        switch(profe){
            case "Martha Mora Torres":
                cubo = "H-263";
                break;
            case "Francisco Javier Zaragoza Martinez":
                cubo = "H-264";
                break;
            case "Lourdes Sanchez Guerrero":
                cubo = "H-262";
                break;
            case "Josue Figueroa Gonzalez":
                cubo = "H-293";
                break;
            case "Alejandro Cruz Sandoval":
                cubo = "H-295";
                break;
            case "Hugo Pablo Leyva":
                cubo = "HP-7";
                break;
            case "Marco A. Gutiérrez Villegas":
                cubo = "H-295";
                break;
            case "Rodrigo Alexander Castro Campos":
                cubo = "HP-11";
                break;
            case "Irma Fernanda Ardon Pulido":
                cubo = "HP-6";
                break;
            case "Oscar Alvarado Nava":
                cubo = "G-301";
                break;                       
            case "Eduardo Rodriguez Martinez":
                cubo = "G-312";
                break;
            case "Oscar Herrera Alcántara":
                cubo = "H-255";
                break;
            case "Lizbeth Gallardo López":
                cubo = "H-244";
                break;                    
        }
        
        Label lblConfirm = new Label();
        lblConfirm.setFont(Font.font("Arial", 16));
        lblConfirm .setText("¿Estas seguro de enviar la notificacion para asesoria el dia "
                + dia + " a las " + hora +"\n con el docente " + profe + " en el cubiculo " + cubo + "?");
        
        Button btnConfirm = new Button("Confirmar");
        btnConfirm.setStyle("-fx-font: 17 arial; -fx-base: #E91E63;");
        DropShadow shadow = new DropShadow();
        shadow.setColor(javafx.scene.paint.Color.web("#E91E63"));
        //Adding the shadow when the mouse cursor is on
        btnConfirm.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                btnConfirm.setEffect(shadow);
                }
        });
        //Removing the shadow when the mouse cursor is off
        btnConfirm.addEventHandler(MouseEvent.MOUSE_EXITED, 
        new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                btnConfirm.setEffect(null);
            }
        });
        btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert altConfirma = new Alert(Alert.AlertType.CONFIRMATION);
                altConfirma.setTitle("Confirmado");
                altConfirma.setHeaderText("Se ha enviado correctamente la notificacion ");
                altConfirma.setContentText(null);
                altConfirma.showAndWait();
                Alumno alumno = new Alumno();
                try {
                    alumno.start(escenario);
                } catch (Exception ex) {
                    Logger.getLogger(Confirmacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setStyle("-fx-font: 17 arial; -fx-base: #E91E63;");
        //DropShadow shadow = new DropShadow();
        shadow.setColor(javafx.scene.paint.Color.web("#E91E63"));
        //Adding the shadow when the mouse cursor is on
        btnCancelar.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                btnCancelar.setEffect(shadow);
                }
        });
        //Removing the shadow when the mouse cursor is off
        btnCancelar.addEventHandler(MouseEvent.MOUSE_EXITED, 
        new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                btnCancelar.setEffect(null);
            }
        });
        btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AgendaProfesor agendaP = new AgendaProfesor(profe);
                try {
                    agendaP.start(escenario);
                } catch (Exception ex) {
                    Logger.getLogger(Confirmacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        hbBtns.getChildren().addAll(btnConfirm, btnCancelar);       
        hbBtns.setAlignment(Pos.CENTER);
        vbControles.getChildren().addAll(lblConfirm,hbBtns);
        
        
        raiz.getChildren().addAll(vbControles);
        escenario.show();
    }
    
}
