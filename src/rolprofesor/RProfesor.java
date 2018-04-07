/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rolprofesor;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Usuario;
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
        //ArrayList<Usuario> alUser = log.getUsers();
        ArrayList<Usuario> alProfUser = new ArrayList();

        for (int i = 0; i < alUsuario.size(); i++) {
            if (alUsuario.get(i).getIdentificador().length() == 5) {
                alProfUser.add(alUsuario.get(i));//Lleno el arraylist solo de profesores
            }
        }
                   
        System.out.println("Tamaño del AL de profes: " + alProfUser.size() + "\nTamaño del AL Ususarios: " + alUsuario.size());
        if (eco.length() == 5) {
            for (int i = 0; i < alProfUser.size(); i++) {
                if(alProfUser.get(i).getIdentificador().equals(eco)){
                    lblNombre.setText("Nombre: " + alProfUser.get(i).getNombre());
                    lblEco.setText("No. Eco: " + alProfUser.get(i).getIdentificador());                    
                    //elemento = i;
                    switch(alProfUser.get(i).getNombre()) {
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
        }

        //lblNombre.setText("Nombre: " + alProfUser.get(elemento).getNombre());
        //lblEco.setText("No. Economico: " + alProfUser.get(elemento).getIdentificador());
        //lblCubo.setText("Cubiculo: " + cubo);

        VBox vbDatos = new VBox(10);
        vbDatos.getChildren().addAll(lblNombre, lblEco, lblCubo);
        
        raiz.getChildren().add(vbDatos);
        escenario.show();
    }

}
