/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rolprofesor;

import fachadabd.FachadaBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Confirmacion;
import modelo.Usuario;
import proyectoasesorias.Alumno;
import proyectoasesorias.Login;

/**
 *
 * @author Victor Estupiñan
 */
public class RProfesor extends Application {
    
    String eco;
    ArrayList<Usuario> alUsuario;
    public RProfesor(){
        
    }
    public RProfesor(String eco){
        this.eco = eco;
    }
    public RProfesor(String eco, ArrayList<Usuario> alUsuario){
        this.eco = eco;
        this.alUsuario = alUsuario;
    }
    
    @Override
    public void start(Stage escenario) throws Exception {
        escenario.setTitle("Profesor");

        FlowPane raiz = new FlowPane(10, 10);
        raiz.setAlignment(Pos.CENTER);
        raiz.setStyle("-fx-background-color: #FFC107;");
        Scene escena = new Scene(raiz, 350, 350);
        

        escenario.setScene(escena);

        String cubo = "224";
        Label lblNombre = new Label();
        Label lblEco = new Label();
        Label lblCubo = new Label();

        Login log = new Login();        
        FachadaBD f = new FachadaBD();
        f.connectToAndQueryDatabase("DBProyecto.db");
        try{
            ResultSet rs = f.ejecutaSQLreturnRS("select id, nombre, pass from Tusuarios");            
            while(rs.next()){
                if(rs.getString(1).equalsIgnoreCase(eco) ){
                    lblNombre.setText("Nombre: " + rs.getString(2));
                    lblEco.setText("No. Eco: " + rs.getString(1));
                    switch(rs.getString(2)){
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
                    lblCubo.setText("Cubiculo: " + cubo);                
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Button agenda = new Button("Confirmar Asesorias");
        Button cerrsesion = new Button("Cerrar sesion");
        
        agenda.setOnAction((ActionEvent event) -> {
                Alert altConfirma = new Alert(Alert.AlertType.CONFIRMATION);
                altConfirma.setTitle("Confirmado");
                altConfirma.setHeaderText("Status: Disponible para asesoria");
                altConfirma.setContentText(null);
                altConfirma.showAndWait();
        });
        
        cerrsesion.setOnAction((ActionEvent event)->{
                try {
                    log.start(escenario);
                } catch (Exception ex) {
                    Logger.getLogger(Confirmacion.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
        
        agenda.setStyle("-fx-font: 22 arial; -fx-base: #E91E63;");
        DropShadow shadow = new DropShadow();
        shadow.setColor(javafx.scene.paint.Color.web("#E91E63"));
        //Adding the shadow when the mouse cursor is on
        agenda.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                agenda.setEffect(shadow);
                }
        });
        //Removing the shadow when the mouse cursor is off
        agenda.addEventHandler(MouseEvent.MOUSE_EXITED, 
        new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                agenda.setEffect(null);
            }
        });
        
        cerrsesion.setStyle("-fx-font: 22 arial; -fx-base: #E91E63;");
        DropShadow shadow2 = new DropShadow();
        shadow2.setColor(javafx.scene.paint.Color.web("#E91E63"));
        //Adding the shadow when the mouse cursor is on
        cerrsesion.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                cerrsesion.setEffect(shadow2);
                }
        });
        //Removing the shadow when the mouse cursor is off
        cerrsesion.addEventHandler(MouseEvent.MOUSE_EXITED, 
        new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                cerrsesion.setEffect(null);
            }
        });
        
        agenda.setScaleX(.7);
        agenda.setScaleY(.7);
        cerrsesion.setScaleX(.7);
        cerrsesion.setScaleY(.7);
        
        HBox hbBtns = new HBox(7);
        hbBtns.getChildren().addAll(agenda, cerrsesion);       
        hbBtns.setAlignment(Pos.CENTER);
        
        VBox vbDatos = new VBox(10);
        vbDatos.getChildren().addAll(lblNombre, lblEco, lblCubo);
        
        raiz.getChildren().addAll(vbDatos, hbBtns);
        escenario.show();
    }

}
