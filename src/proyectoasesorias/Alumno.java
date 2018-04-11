/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoasesorias;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.*;

public class Alumno extends Application {

    ChoiceBox cbMaterias;
    ChoiceBox cbProfesores;
    
    Label materias;
    Label profesores;
    
    ObservableList<String> profEstructDatos;
    ObservableList<String> profProgEstr;
    ObservableList<String> profMetodos;
    ObservableList<String> profEstructArchivos;
    ObservableList<String> profDiseño;
    ObservableList<String> profPOO;
    
    //AGENDAS
    ArrayList<String> array3;
    ArrayList<String> array4;
    ArrayList<String> array5;
    
    ArrayList<HoraAsesoria> horasAs1;    
    ListView<String> lvProfesor;
    
//    Button btBuscar;
    Button btCerrar;
    
    Stage escenario;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        array3 = new ArrayList<>();
        array3.add("Lunes"); array3.add("Miercoles");
        
        array4 = new ArrayList<>();
        array4.add("Lunes"); array4.add("Martes"); array4.add("Miercoles"); array4.add("Jueves"); array4.add("Viernes");
        
        array5 = new ArrayList<>();
        array5.add("Miercoles"); array5.add("Viernes");
        
        horasAs1 = new ArrayList<>();
        horasAs1.add(new HoraAsesoria(true,4));
       
        escenario = stage;
        escenario.setTitle("Alumno");
        
        
        
       // btBuscar = new Button("Buscar");
        btCerrar = new Button("Cerrar"+ "\nSesión");
      
        materias = new Label("Materias:");
        profesores = new Label("Profesores:");
        
        materias.setFont(new Font("Calabria",14));
        profesores.setFont(new Font("Calabria",14));
        
        cbProfesores = new ChoiceBox();
        cbMaterias = new ChoiceBox(FXCollections.observableArrayList("Algoritmos y Estructura de Datos",
                "Programación Estructurada","Métodos Numéricos", "Almacenamiento y Estructura de Archivos",
                "Diseño Lógico","Programación Orientada a Objetos"));
        
        
        profEstructDatos = FXCollections.observableArrayList("Martha Mora Torres", "Francisco Javier Zaragoza Martinez");
        profProgEstr = FXCollections.observableArrayList("Lourdes Sanchez Guerrero", "Josue Figueroa Gonzalez","Alejandro Cruz Sandoval");
        profMetodos = FXCollections.observableArrayList("Lourdes Sanchez Guerrero", "Hugo Pablo Leyva","Marco A. Gutiérrez Villegas");
        profEstructArchivos = FXCollections.observableArrayList("Rodrigo Alexander Castro Campos","Irma Fernanda Ardon Pulido");
        profDiseño = FXCollections.observableArrayList("Oscar Alvarado Nava","Eduardo Rodriguez Martinez");
        profPOO = FXCollections.observableArrayList("Oscar Herrera Alcántara", "Lizbeth Gallardo López");
        
        cbMaterias.setValue("Algoritmos y Estructura de Datos");
        cbProfesores.setItems(profEstructDatos);
        cbMaterias.setPrefWidth(200);
        cbProfesores.setPrefWidth(200);
        
        //Se crea el listView con la lista de profesores de ED por default
        lvProfesor = new ListView<String>(profEstructDatos);
        lvProfesor.setPrefSize(200,90);
        
        MultipleSelectionModel<String> lvSelModel = lvProfesor.getSelectionModel(); 
        lvSelModel.setSelectionMode(SelectionMode.SINGLE);
       
        SingleSelectionModel<String> cbSelModel = 
                cbMaterias.getSelectionModel();
                
        cbSelModel.selectedItemProperty().addListener(
                                           new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> cambio,
                    String antVal, String nuevoVal){
                
                switch(nuevoVal){
                    case "Algoritmos y Estructura de Datos":
                        //cbProfesores.setItems(profEstructDatos);                        
                        lvProfesor.setItems(profEstructDatos);
                        break;
                        
                    case "Programación Estructurada":
                        //cbProfesores.setItems(profProgEstr);
                        lvProfesor.setItems(profProgEstr);
                        break;
                        
                    case "Métodos Numéricos":
                        //cbProfesores.setItems(profMetodos);
                        lvProfesor.setItems(profMetodos);
                        break;
                        
                    case "Almacenamiento y Estructura de Archivos":
                        //cbProfesores.setItems(profEstructArchivos);
                        lvProfesor.setItems(profEstructArchivos);
                        break;
                        
                    case "Diseño Lógico":
                        //cbProfesores.setItems(profDiseño);
                        lvProfesor.setItems(profDiseño);
                        break;
                        
                    case "Programación Orientada a Objetos":
                        //cbProfesores.setItems(profPOO);
                        lvProfesor.setItems(profPOO);
                        break;
                }    
            }
        });
        
        lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> cambio, String viejoValor, String nuevoValor) {
                
                AgendaProfesor prof = new AgendaProfesor(nuevoValor);
                try {
                    prof.start(escenario);
                } catch (Exception ex) {
                    Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //esta parte es para el boton de cerrar sesion
        btCerrar.setOnAction(e -> {
            try {
                ButtonClicked(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        btCerrar.setStyle("-fx-font: 22 arial; -fx-base: #E91E63;");
        DropShadow shadow = new DropShadow();
        shadow.setColor(javafx.scene.paint.Color.web("#E91E63"));
        //Adding the shadow when the mouse cursor is on
        btCerrar.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                btCerrar.setEffect(shadow);
                }
        });
        //Removing the shadow when the mouse cursor is off
        btCerrar.addEventHandler(MouseEvent.MOUSE_EXITED, 
        new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                btCerrar.setEffect(null);
            }
        });
        
        
          
        FlowPane pane1 = new FlowPane(Orientation.VERTICAL,15,15);
        FlowPane pane2 = new FlowPane(70,40);
        
         pane1.setStyle("-fx-background-color: #FFC107;");
         pane2.setStyle("-fx-background-color: #FFC107;");

        
        pane1.setAlignment(Pos.CENTER);
        pane2.setAlignment(Pos.CENTER);
        pane2.getChildren().addAll(btCerrar/*,btBuscar*/);
        pane1.getChildren().addAll(materias,cbMaterias,profesores,lvProfesor,pane2);
        
        pane2.setPrefWidth(200);
        Scene escena = new Scene(pane1,300,300);
        
        
        
        stage.setScene(escena);
        stage.show();
    }
    
    public void ButtonClicked(ActionEvent e) throws Exception{
        
        if(e.getSource() == btCerrar){
           
            Login log = new Login();
            log.start(escenario);
        }
    }   
    
    
    /*public static void main(String [] args){
        launch(args);
    }*/
}


/*
import modelo.AgendaProfesor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.*;


public class Alumno extends Application {

    ChoiceBox cbMaterias;
    ChoiceBox cbProfesores;
    
    Label materias;
    Label profesores;
    
    ObservableList<String> profEstructDatos;
    ObservableList<String> profProgEstr;
    ObservableList<String> profMetodos;
    ObservableList<String> profEstructArchivos;
    ObservableList<String> profDiseño;
    ObservableList<String> profPOO;
    
    ListView<String> lvProfesor;
    
    Button btBuscar;
    Button btCerrar;
    
    //AGENDAS
    ArrayList<String> array3;
    ArrayList<String> array4;
    ArrayList<String> array5;
    
    ArrayList<HoraAsesoria> horasAs1;
    
    Stage escenario;
    
    @Override
    public void start(Stage stage) throws Exception {
        //aqui hacemos la parte de las agendas
        array3 = new ArrayList<>();
        array3.add("Lunes"); array3.add("Miercoles");
        
        array4 = new ArrayList<>();
        array4.add("Lunes"); array4.add("Martes"); array4.add("Miercoles"); array4.add("Jueves"); array4.add("Viernes");
        
        array5 = new ArrayList<>();
        array5.add("Miercoles"); array5.add("Viernes");
        
        horasAs1 = new ArrayList<>();
        horasAs1.add(new HoraAsesoria(true,4));
        
        
        //est es la parte del escenario
        escenario = stage;
        escenario.setTitle("Alumno");
        
        btBuscar = new Button("Buscar");
        btCerrar = new Button("Cerrar"+ "\nSesión");
      
        materias = new Label("Materias:");
        profesores = new Label("Profesores:");
        
        materias.setFont(new Font("Calabria",14));
        profesores.setFont(new Font("Calabria",14));
        
        cbProfesores = new ChoiceBox();
        cbMaterias = new ChoiceBox(FXCollections.observableArrayList("Algoritmos y Estructura de Datos",
                "Programación Estructurada","Métodos Numéricos", "Almacenamiento y Estructura de Archivos",
                "Diseño Lógico","Programación Orientada a Objetos"));
        
        
        profEstructDatos = FXCollections.observableArrayList("Martha Mora Torres", "Francisco Javier Zaragoza Martinez");
        profProgEstr = FXCollections.observableArrayList("Lourdes Sanchez Guerrero", "Josue Figueroa Gonzalez","Alejandro Cruz Sandoval");
        profMetodos = FXCollections.observableArrayList("Lourdes Sanchez Guerrero", "Hugo Pablo Leyva","Marco A. Gutiérrez Villegas");
        profEstructArchivos = FXCollections.observableArrayList("Rodrigo Alexander Castro Campos","Irma Fernanda Ardon Pulido");
        profDiseño = FXCollections.observableArrayList("Oscar Alvarado Nava","Eduardo Rodriguez Martinez");
        profPOO = FXCollections.observableArrayList("Oscar Herrera Alcántara", "Lizbeth Gallardo López");
        
        cbMaterias.setValue("Algoritmos y Estructura de Datos");
        cbProfesores.setItems(profEstructDatos);
        cbMaterias.setPrefWidth(200);
        cbProfesores.setPrefWidth(200);
        
        //Se crea el listView con la lista de profesores de ED por default
        lvProfesor = new ListView<String>(profEstructDatos);
        lvProfesor.setPrefSize(200,90);
        
        MultipleSelectionModel<String> lvSelModel = lvProfesor.getSelectionModel(); 
        lvSelModel.setSelectionMode(SelectionMode.SINGLE);
       
        SingleSelectionModel<String> cbSelModel = 
                cbMaterias.getSelectionModel();
                
        cbSelModel.selectedItemProperty().addListener(
                                           new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> cambio,
                    String antVal, String nuevoVal){
                
                switch(nuevoVal){
                    case "Algoritmos y Estructura de Datos":
                        //cbProfesores.setItems(profEstructDatos);                        
                        lvProfesor.setItems(profEstructDatos);
                        break;
                        
                    case "Programación Estructurada":
                        //cbProfesores.setItems(profProgEstr);
                        lvProfesor.setItems(profProgEstr);
                        break;
                        
                    case "Métodos Numéricos":
                        //cbProfesores.setItems(profMetodos);
                        lvProfesor.setItems(profMetodos);
                        break;
                        
                    case "Almacenamiento y Estructura de Archivos":
                        //cbProfesores.setItems(profEstructArchivos);
                        lvProfesor.setItems(profEstructArchivos);
                        break;
                        
                    case "Diseño Lógico":
                        //cbProfesores.setItems(profDiseño);
                        lvProfesor.setItems(profDiseño);
                        break;
                        
                    case "Programación Orientada a Objetos":
                        //cbProfesores.setItems(profPOO);
                        lvProfesor.setItems(profPOO);
                        break;
                }    
            }
        });
        
      /*  esto era la parte hasta donde llegabamos lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> cambio, String viejoValor, String nuevoValor) {
                String selItems = "";
                ObservableList <String> seleccionados = lvSelModel.getSelectedItems();
                
                // Despliega la selección
                //respuesta.setText("La manzana seleccionada es: " + nuevoVal); 
                for(String item : seleccionados){
                    selItems += item;
                    //System.out.println("item: "+item+ "  Selitems: " + selItems);
                    //AgendasProfesor profe = new AgendasProfesor(new Profesor(item,"34879",cbSelModel.getSelectedItem()));
                    //AgendasProfesor profe = new AgendasProfesor(new Profesor(item,"34879"));
                    //profe.start(escenario);
                }
            }
        });
      //esta es la parte de josue que agrego instacia de la clase agenda profesor para asi cargar la agenda cuando selecciona un horario
      lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> cambio, String viejoValor, String nuevoValor) {
                
                AgendaProfesor prof = new AgendaProfesor(nuevoValor);
                try {
                    prof.start(escenario);
                } catch (Exception ex) {
                    Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
      
        
        btCerrar.setOnAction(e -> {
            try {
                ButtonClicked(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
          
        FlowPane pane1 = new FlowPane(Orientation.VERTICAL,15,15);
        FlowPane pane2 = new FlowPane(70,40);
        
        pane1.setAlignment(Pos.CENTER);
        pane2.getChildren().addAll(btCerrar,btBuscar);
        pane1.getChildren().addAll(materias,cbMaterias,profesores,lvProfesor,pane2);
        
        pane2.setPrefWidth(200);
        Scene escena = new Scene(pane1,300,300);
        
        stage.setScene(escena);
        stage.show();
    }
    
    public void ButtonClicked(ActionEvent e) throws Exception{
        
        if(e.getSource() == btCerrar){
           
            Login log = new Login();
            log.start(escenario);
        }
    }   
    //este main se comenta porque ejecutamos desde el login
    /*public static void main(String [] args){
        launch(args);
    }
}
*/