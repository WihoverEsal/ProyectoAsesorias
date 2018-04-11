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
        Scene escena = new Scene(raiz, 350, 350);
        raiz.setAlignment(Pos.CENTER);

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
        
        HBox hbBtns = new HBox(20);
        hbBtns.getChildren().addAll(agenda, cerrsesion);       
        hbBtns.setAlignment(Pos.CENTER);
        
        VBox vbDatos = new VBox(10);
        vbDatos.getChildren().addAll(lblNombre, lblEco, lblCubo, hbBtns);
        
        raiz.getChildren().add(vbDatos);
        escenario.show();
    }

}
