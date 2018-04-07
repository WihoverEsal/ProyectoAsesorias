/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoasesorias;

/**
 *
 * @author Victor EstupiÃ±an
 */
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Usuario;
//import login.Login;
//import modelo.Alumno;

public class Registrate extends Application {

    @Override
    public void start(Stage escenario) throws Exception {

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 10, 10, 10));
        HBox hbtit = new HBox();
        hbtit.setPadding(new Insets(5, 5, 5, 5));
        hbtit.setSpacing(50);
        // Image image = new Image("signup.png");
        //ImageView iv1 = new ImageView();
        //iv1.setImage(image);
        //HBOX TOP
        HBox hb = new HBox();
        hb.setPadding(new Insets(2, 2, 2, 2));
        hb.setSpacing(20);
        hb.getChildren().addAll(hbtit);
        hb.setStyle("-fx-background-color: #3FF4CB;");
        bp.setTop(hb);

        //HBOX BOTTOM
        HBox hdb = new HBox();
        hdb.setPadding(new Insets(10, 10, 10, 10));
        hdb.setSpacing(20);
        hdb.setStyle("-fx-background-color: #3FF4CB;");
        bp.setBottom(hdb);

        //VBOX LEFT
        VBox vdl = new VBox();
        vdl.setPadding(new Insets(10, 10, 10, 10));
        vdl.setSpacing(20);
        vdl.setStyle("-fx-background-color: #3FF4CB;");
        bp.setLeft(vdl);

        //VBOX RIGHT
        VBox vdr = new VBox();
        vdr.setPadding(new Insets(10, 10, 10, 10));
        vdr.setSpacing(20);
        vdr.setStyle("-fx-background-color: #3FF4CB;");
        bp.setRight(vdr);

        //CENTER GRID
        //  GridPane gd=new GridPane();
        //gd.add(child, columnIndex, rowIndex);
        GridPane gdtop = new GridPane();
        gdtop.setPadding(new Insets(10, 10, 10, 10));
        gdtop.setVgap(30);
        gdtop.setHgap(20);

        //  GridPane.setHalignment(iv1, HPos.CENTER);
        // gdtop.add(iv1, 0, 0);
        Label title = new Label("Registrate");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        GridPane.setHalignment(title, HPos.CENTER);
        gdtop.add(title, 1, 0);

        //NAME LABEL
        Label name = new Label("Nombre: ");
        name.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gdtop.add(name, 0, 1);

        //NAME TEXT BOX
        TextField namet = new TextField();
        namet.setPromptText("Escribe tu Nombre");
        gdtop.add(namet, 1, 1);
        name.setFocusTraversable(false);

        //label matricula
        Label mobnol = new Label("Ingresa matricula o no. economico");
        mobnol.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gdtop.add(mobnol, 0, 2);

        //matricula
        TextField mobnot = new TextField();
        mobnot.setPromptText("Matricula o no. economico");
        gdtop.add(mobnot, 1, 2);

        //label del password
        Label pwd = new Label("ContraseÃ±a");
        pwd.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gdtop.add(pwd, 0, 3);

        //PASSWORD TEXTFIELD
        PasswordField pwdt = new PasswordField();
        pwdt.setPromptText("ContraseÃ±a");
        gdtop.add(pwdt, 1, 3);

        //SUBMIT BUTTON HBOX
        HBox subh = new HBox();
        // subh.setPadding(new Insets(50,50,50,50));
        // subh.setSpacing(20);
        subh.setAlignment(Pos.CENTER_RIGHT);

        //SUBMIT BUTTON
        HBox canch = new HBox();

        // canch.setPadding(new Insets(10,10,10,10));
        //canch.setSpacing(20);
        canch.setAlignment(Pos.CENTER_LEFT);
        Button submit = new Button("Enviar");
        submit.setCursor(Cursor.HAND);
        submit.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        submit.setStyle("-fx-background-color: #3FF4CB;");

        submit.setOnAction((ActionEvent event) -> {

            String matricula = mobnot.getText();
            String contraseña = pwdt.getText();

            Login log = new Login();
            
            
            if ((mobnot.getText().length() == 10 || mobnot.getText().length() == 5) && pwdt.getText().length() > 7) {                
                Usuario usuario = new Usuario( namet.getText(), mobnot.getText(), pwdt.getText() );
                if( log.addUser(usuario) == 1){
                //if (log.addPassUser(matricula, contraseña) == 1)  {                                        
                    System.out.println("Usuario agregado: " + usuario.getIdentificador() + " " + usuario.getClavePass() + 
                            " " + usuario.getNombre());
                    try {
                        log.start(escenario);
                        //Stage stage = (Stage) submit.getScene().getWindow();
                        // do what you have to do
                        //stage.close();
                        //Poner aqui el escenario de la pantalla registrarse
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Alert hola = new Alert(AlertType.ERROR);
                    hola.setTitle("error");
                    hola.setHeaderText("usuario existente");
                    hola.setContentText(null);
                    hola.showAndWait();
                    mobnot.clear();
                }
            } else {
                Alert hola = new Alert(AlertType.WARNING);
                hola.setTitle("error");
                hola.setHeaderText("verificar usuario y/o contraseña");
                hola.setContentText(null);
                hola.showAndWait();
                mobnot.clear();                                
            }

        });

        // GridPane.setHalignment(submit, HPos.CENTER);
        subh.getChildren().addAll(submit);
        gdtop.add(subh, 0, 4);

        //CANCEL BUTTON
        Button cancel = new Button("Cancelar");
        cancel.setCursor(Cursor.HAND);
        cancel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        cancel.setStyle("-fx-background-color: #3FF4CB;");

        //si se da cancelar en el boton te regresa a la pantalla de iniciar sesion
        cancel.setOnAction((ActionEvent event) -> {
            Login log = new Login();
            try {
                log.start(escenario);
                Stage stage = (Stage) cancel.getScene().getWindow();
                // do what you have to do
                stage.close();
                //Poner aqui el escenario de la pantalla registrarse
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        canch.getChildren().addAll(cancel);

        // GridPane.setHalignment(cancel, HPos.CENTER);
        gdtop.add(canch, 1, 4);
        bp.setCenter(gdtop);
        Scene scene = new Scene(bp);
        escenario.setTitle("Registrarte");
        escenario.setScene(scene);
        escenario.show();
    }

    /*public static void main(String[] args) {
        launch(args);

    }*/

}
