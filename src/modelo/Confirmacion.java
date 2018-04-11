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
import javafx.scene.layout.*;
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
    
    public Confirmacion(String hora, String dia, String profe){
        this.hora = hora;
        this.dia = dia;
        this.profe = profe;
    }

    @Override
    public void start(Stage escenario) throws Exception {
        escenario.setTitle("Confirmacion");
        
        FlowPane raiz = new FlowPane(10, 10);
        raiz.setAlignment(Pos.CENTER);
        
        Scene escena = new Scene(raiz, 490, 100);        
        escenario.setScene(escena);
        
        VBox vbControles = new VBox(10);
        HBox hbBtns = new HBox(20);
        
        Label lblConfirm = new Label();
        lblConfirm .setText("¿Estas seguro de enviar la notificacion para asesoria el dia "
                + dia + " a las " + hora +"\n con el docente " + profe + "?");
        
        Button btnConfirm = new Button("Confirmar");
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
