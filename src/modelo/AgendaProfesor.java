package modelo;

import javafx.application.Application;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import proyectoasesorias.Alumno;

public class AgendaProfesor extends Application{

    Stage escenario;
    Label etiqueta;
    Label encabezado;
    
    String profe;
    
    TableView<ProyectoEntrada> tvProyecto;
    
    Button btncerrar;
   
    public AgendaProfesor(String cadena){
        profe = cadena;
        etiqueta = new Label(cadena);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        escenario = stage;
        escenario.setTitle("Agenda");  
        
        btncerrar = new Button("Regresar");
        
        //CREACION DE TODAS LA AGENDAS EN BASE AL ARCHIVO DE EXCEL QUE LES PASE DE LOS HORARIOS
        Agenda agMarta = new Agenda();
        agMarta.addDia("Lunes");
        agMarta.addDia("Miercoles"); 
        agMarta.addDia("Viernes");
        agMarta.addHora(new HoraAsesoria(true,4));
        //en esta parte creamos dos objetos uno para el de una a dos y media y otro de dos y media a 4
        Agenda agZaragoza = new Agenda();
        agZaragoza.addDia("Lunes");
        agZaragoza.addDia("Miercoles");
        agZaragoza.addDia("Viernes");
        agZaragoza.addHora(new HoraAsesoria(true,4));
        
        Agenda agZaragoza2 = new Agenda();
        agZaragoza2.addDia("Lunes");
        agZaragoza2.addDia("Miercoles");
        agZaragoza2.addDia("Viernes");
        agZaragoza2.addHora(new HoraAsesoria(true,5));
        
        //estas son las agendas de programacion estructurada
        Agenda agLourdes = new Agenda();
        agLourdes.addDia("Martes");
        agLourdes.addDia("Jueves");
        agLourdes.addHora(new HoraAsesoria(true,2));
        
        Agenda agJosue = new Agenda();
        agJosue.addDia("Lunes"); 
        agJosue.addDia("Miercoles");
        agJosue.addHora(new HoraAsesoria(true,6));
        
        Agenda agAlejandro = new Agenda();
        agAlejandro.addDia("Lunes"); 
        agAlejandro.addDia("Miercoles");
        agAlejandro.addDia("Viernes");
        agAlejandro.addHora(new HoraAsesoria(true,0));
        
        Agenda agAlejandro2 = new Agenda();
        agAlejandro2.addDia("Lunes"); 
        agAlejandro2.addDia("Miercoles");
        agAlejandro2.addDia("Viernes");
        agAlejandro2.addHora(new HoraAsesoria(true,3));
        
        Agenda agAlejandro3 = new Agenda();
        agAlejandro3.addDia("Lunes"); 
        agAlejandro3.addDia("Miercoles");
        agAlejandro3.addDia("Viernes");
        agAlejandro3.addHora(new HoraAsesoria(true,4));
        
        //estas son las agendas de metodos numericos
        Agenda agHugo = new Agenda();
        agHugo.addDia("Lunes");
        agHugo.addDia("Miercoles");
        agHugo.addDia("Viernes");
        agHugo.addHora(new HoraAsesoria(true,9));
        
        Agenda agVillegas = new Agenda();
        agVillegas.addDia("Lunes");
        agVillegas.addDia("Miercoles");
        agVillegas.addDia("Viernes");
        agVillegas.addHora(new HoraAsesoria(true,0));
        
        Agenda agVillegas2 = new Agenda();
        agVillegas2.addDia("Lunes");
        agVillegas2.addDia("Miercoles");
        agVillegas2.addDia("Viernes");
        agVillegas2.addHora(new HoraAsesoria(true,2));
        
        //estas son las agendas para almacenamiento de archivos
        Agenda agRodrigo = new Agenda();
        agRodrigo.addDia("Lunes");
        agRodrigo.addDia("Martes");
        agRodrigo.addDia("Miercoles");
        agRodrigo.addDia("Jueves");
        agRodrigo.addDia("Viernes");
        agRodrigo.addHora(new HoraAsesoria(true,4));
        
        Agenda agRodrigo2 = new Agenda();
        agRodrigo2.addDia("Lunes");
        agRodrigo2.addDia("Miercoles");
        agRodrigo2.addDia("Viernes");
        agRodrigo2.addHora(new HoraAsesoria(true,1));
        
        Agenda agRodrigo3 = new Agenda();
        agRodrigo3.addDia("Lunes");
        agRodrigo3.addDia("Miercoles");
        agRodrigo3.addDia("Viernes");
        agRodrigo3.addHora(new HoraAsesoria(true,2));
        
        Agenda agIrma = new Agenda();
        agIrma.addDia("Miercoles");
        agIrma.addDia("Viernes");
        agIrma.addHora(new HoraAsesoria(true,2));
        
        Agenda agIrma2 = new Agenda();
        agIrma2.addDia("Miercoles");
        agIrma2.addDia("Viernes");
        agIrma2.addHora(new HoraAsesoria(true,3));
        
        Agenda agIrma3 = new Agenda();
        agIrma3.addDia("Miercoles");
        agIrma3.addDia("Viernes");
        agIrma3.addHora(new HoraAsesoria(true,4));
        
        Agenda agIrma4 = new Agenda();
        agIrma4.addDia("Miercoles");
        agIrma4.addDia("Viernes");
        agIrma4.addHora(new HoraAsesoria(true,5));
        
        Agenda agIrma5 = new Agenda();
        agIrma5.addDia("Miercoles");
        agIrma5.addDia("Viernes");
        agIrma5.addHora(new HoraAsesoria(true,6));
        
        //esta es la agenda para diseño logico
        Agenda agNava = new Agenda();
        agNava.addDia("Lunes");
        agNava.addDia("Miercoles");
        agNava.addDia("Viernes");
        agNava.addHora(new HoraAsesoria(true,4));
        
        Agenda agNava2 = new Agenda();
        agNava2.addDia("Lunes");
        agNava2.addDia("Miercoles");
        agNava2.addDia("Viernes");
        agNava2.addHora(new HoraAsesoria(true,5));
        
        Agenda agEduardo = new Agenda();
        agEduardo.addDia("Lunes");
        agEduardo.addDia("Miercoles");
        agEduardo.addDia("Viernes");
        agEduardo.addHora(new HoraAsesoria(true,3));
        
        Agenda agEduardo2 = new Agenda();
        agEduardo2.addDia("Lunes");
        agEduardo2.addDia("Miercoles");
        agEduardo2.addDia("Viernes");
        agEduardo2.addHora(new HoraAsesoria(true,5));
        
        //estas son las agendas para programacion orientada a objetos
        Agenda agAlcantara = new Agenda();
        agAlcantara.addDia("Viernes");
        agAlcantara.addDia("Miercoles");
        agAlcantara.addHora(new HoraAsesoria(true,5));
        
        Agenda agLizbet = new Agenda();
        agLizbet.addDia("Lunes");
        agLizbet.addDia("Miercoles");
        agLizbet.addHora(new HoraAsesoria(true,3));            
        //HASTA AQUÍ LA CREACIÓN DE AGENDAS
        
        FlowPane raizNodo = new FlowPane(10, 10); 
        raizNodo.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(raizNodo, 470, 500);
        escenario.setScene(myScene);   
   
        encabezado = new Label("Agenda " + profe ); 
        
        ObservableList<ProyectoEntrada> projEntradas = FXCollections.observableArrayList( 
            new ProyectoEntrada("7:00-8:30", " ", " ", " ", " "," "), 
            new ProyectoEntrada("8:30-10:00", " ", " ", " ", " "," "), 
            new ProyectoEntrada("10:00-11:30", " ", " ", " ", " "," "),  
            new ProyectoEntrada("11:30-13:00", " ", " ", " ", " "," "),  
            new ProyectoEntrada("13:00-14:30", " ", " ", " ", " "," "),
            new ProyectoEntrada("14:30-16:00", " ", " ", " ", " "," "),
            new ProyectoEntrada("16:00-17:30", " ", " ", " ", " "," "),
            new ProyectoEntrada("17:30-19:00", " ", " ", " ", " "," "),
            new ProyectoEntrada("19:00-20:30", " ", " ", " ", " "," "),
            new ProyectoEntrada("20:30-22:00", " ", " ", " ", " "," ")); 
              
        switch(profe){
          //caso martha mora verifica que los horarios que agendamos coincidad con nuestro proyecto de entradas donde tenemos nuestros horarios
            case "Martha Mora Torres":                
                for(int i = 0; i < agMarta.getDias().size(); i++){
                    System.out.println(agMarta.getDias().size());
                    System.out.println(agMarta.getDias().get(i));
                    switch(agMarta.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agMarta.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agMarta.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agMarta.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agMarta.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agMarta.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }
                break;                
                //caso profe zaragoza hace lo mismo 
            case "Francisco Javier Zaragoza Martinez":                
                for(int i = 0; i < agZaragoza.getDias().size(); i++){
                    System.out.println(agZaragoza.getDias().size());
                    System.out.println(agZaragoza.getDias().get(i));
                    switch(agZaragoza.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agZaragoza.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agZaragoza.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agZaragoza.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agZaragoza.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agZaragoza.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }//esta es la primera parte de 1 a dos y media
                for(int i = 0; i < agZaragoza2.getDias().size(); i++){
                    System.out.println(agZaragoza2.getDias().size());
                    System.out.println(agZaragoza2.getDias().get(i));
                    switch(agZaragoza2.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agZaragoza2.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agZaragoza2.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agZaragoza2.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agZaragoza2.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agZaragoza2.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }//esta es la segunda parte de dos y media a 4
                break;           
            case "Lourdes Sanchez Guerrero":
                for(int i = 0; i < agLourdes.getDias().size(); i++){
                    switch(agLourdes.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agLourdes.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agLourdes.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agLourdes.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agLourdes.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agLourdes.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                break;                
            case "Josue Figueroa Gonzalez":
                for(int i = 0; i < agJosue.getDias().size(); i++){
                    switch(agJosue.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agJosue.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agJosue.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agJosue.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agJosue.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agJosue.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                break;                
            case "Alejandro Cruz Sandoval":
                    for(int i = 0; i < agAlejandro.getDias().size(); i++){
                    System.out.println(agAlejandro.getDias().size());
                    System.out.println(agAlejandro.getDias().get(i));
                    switch(agAlejandro.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agAlejandro.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agAlejandro.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agAlejandro.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agAlejandro.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agAlejandro.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }//esta es la primera parte de las 7 a 8:30 en el horario de excel dice a las 7:45 pero lo manejo con horas completas
                for(int i = 0; i < agAlejandro2.getDias().size(); i++){
                    System.out.println(agAlejandro2.getDias().size());
                    System.out.println(agAlejandro2.getDias().get(i));
                    switch(agAlejandro2.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agAlejandro2.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agAlejandro2.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agAlejandro2.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agAlejandro2.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agAlejandro2.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }//esta es la segunda parte de manejo horas completas es de 12 a 1 pero lo manejo de 11:30 a 13:00
                for(int i = 0; i < agAlejandro3.getDias().size(); i++){
                    System.out.println(agAlejandro3.getDias().size());
                    System.out.println(agAlejandro3.getDias().get(i));
                    switch(agAlejandro3.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agAlejandro3.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agAlejandro3.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agAlejandro3.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agAlejandro3.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agAlejandro3.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }//esta es la tercera parte de 1 a 2:30 son horas completas
                break;                
            case "Hugo Pablo Leyva":
                for(int i = 0; i < agHugo.getDias().size(); i++){
                    switch(agHugo.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agHugo.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agHugo.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agHugo.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agHugo.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agHugo.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                break;                
            case "Marco A. Gutiérrez Villegas":
                for(int i = 0; i < agVillegas.getDias().size(); i++){
                    switch(agVillegas.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agVillegas.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agVillegas.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agVillegas.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agVillegas.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agVillegas.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }//manejo igual aqui horas completas
                for(int i = 0; i < agVillegas2.getDias().size(); i++){
                    switch(agVillegas2.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agVillegas2.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agVillegas2.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agVillegas2.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agVillegas2.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agVillegas2.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                break;                
            case "Rodrigo Alexander Castro Campos":
                for(int i = 0; i < agRodrigo.getDias().size(); i++){
                    switch(agRodrigo.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agRodrigo.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agRodrigo.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agRodrigo.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agRodrigo.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                       case "Viernes":
                            projEntradas.get(agRodrigo.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                for(int i = 0; i < agRodrigo2.getDias().size(); i++){
                    switch(agRodrigo2.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agRodrigo2.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agRodrigo2.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agRodrigo2.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agRodrigo2.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                       case "Viernes":
                            projEntradas.get(agRodrigo2.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                for(int i = 0; i < agRodrigo3.getDias().size(); i++){
                    switch(agRodrigo3.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agRodrigo3.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agRodrigo3.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agRodrigo3.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agRodrigo3.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                       case "Viernes":
                            projEntradas.get(agRodrigo3.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                break;                
            case "Irma Fernanda Ardon Pulido":
                for(int i = 0; i < agIrma.getDias().size(); i++){
                    System.out.println(agIrma.getDias().size());
                    System.out.println(agIrma.getDias().get(i));
                    switch(agIrma.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agIrma.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agIrma.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agIrma.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agIrma.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agIrma.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }//aqui no hubo problema con los horarios
                for(int i = 0; i < agIrma2.getDias().size(); i++){
                    System.out.println(agIrma2.getDias().size());
                    System.out.println(agIrma2.getDias().get(i));
                    switch(agIrma2.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agIrma2.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agIrma2.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agIrma2.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agIrma2.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agIrma2.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }
                for(int i = 0; i < agIrma3.getDias().size(); i++){
                    System.out.println(agIrma3.getDias().size());
                    System.out.println(agIrma3.getDias().get(i));
                    switch(agIrma3.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agIrma3.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agIrma3.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agIrma3.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agIrma3.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agIrma3.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }
                for(int i = 0; i < agIrma4.getDias().size(); i++){
                    System.out.println(agIrma4.getDias().size());
                    System.out.println(agIrma4.getDias().get(i));
                    switch(agIrma4.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agIrma4.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agIrma4.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agIrma4.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agIrma4.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agIrma4.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }
                for(int i = 0; i < agIrma5.getDias().size(); i++){
                    System.out.println(agIrma5.getDias().size());
                    System.out.println(agIrma5.getDias().get(i));
                    switch(agIrma5.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agIrma5.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agIrma5.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agIrma5.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agIrma5.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agIrma5.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }
                }
                break;                
            case "Oscar Alvarado Nava":
                for(int i = 0; i < agNava.getDias().size(); i++){
                    switch(agNava.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agNava.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agNava.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agNava.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agNava.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agNava.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                for(int i = 0; i < agNava2.getDias().size(); i++){
                    switch(agNava2.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agNava2.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agNava2.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agNava2.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agNava2.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agNava2.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                break;                
            case "Eduardo Rodriguez Martinez":
                for(int i = 0; i < agEduardo.getDias().size(); i++){
                    switch(agEduardo.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agEduardo.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agEduardo.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agEduardo.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agEduardo.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agEduardo.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                for(int i = 0; i < agEduardo2.getDias().size(); i++){
                    switch(agEduardo2.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agEduardo2.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agEduardo2.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agEduardo2.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agEduardo2.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agEduardo2.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                break;                
            case "Oscar Herrera Alcántara":
                for(int i = 0; i < agAlcantara.getDias().size(); i++){
                    switch(agAlcantara.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agAlcantara.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agAlcantara.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agAlcantara.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agAlcantara.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agAlcantara.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                break;
         //en esta parte las asesorias de los dos profes es de media hora de duracion pero las maneje igual como horas completas
            case "Lizbeth Gallardo Lopez":
                for(int i = 0; i < agLizbet.getDias().size(); i++){
                    switch(agLizbet.getDias().get(i)){
                        case "Lunes":
                            projEntradas.get(agLizbet.getHoras().get(0).getIndiceHora()).setLunes("Asesoria");
                            break;
                        case "Martes":
                            projEntradas.get(agLizbet.getHoras().get(0).getIndiceHora()).setMartes("Asesoria");
                            break;
                        case "Miercoles":
                            projEntradas.get(agLizbet.getHoras().get(0).getIndiceHora()).setMiercoles("Asesoria");
                            break;
                        case "Jueves":
                            projEntradas.get(agLizbet.getHoras().get(0).getIndiceHora()).setJueves("Asesoria");
                            break;
                        case "Viernes":
                            projEntradas.get(agLizbet.getHoras().get(0).getIndiceHora()).setViernes("Asesoria");
                            break;
                    }          
                }
                break;                                
            default: 
                System.out.println("No se encontró");
                break;
        }
        
        // Crea el table view  
        tvProyecto = new TableView<ProyectoEntrada>(projEntradas);  
 
        // Añade encabezados y especifica cell factories 
        TableColumn<ProyectoEntrada, String> hora = 
         new TableColumn<>("Hora");   
        hora.setCellValueFactory(new PropertyValueFactory<>("hora")); 
        tvProyecto.getColumns().add(hora); 
 
        TableColumn<ProyectoEntrada, String> lunes = 
        new TableColumn<>("Lunes");   
        lunes.setCellValueFactory(new PropertyValueFactory<>("lunes")); 
        tvProyecto.getColumns().add(lunes); 

        TableColumn<ProyectoEntrada, String> martes = 
        new TableColumn<>("Martes");   
        martes.setCellValueFactory(new PropertyValueFactory<>("martes")); 
        tvProyecto.getColumns().add(martes); 
 
        TableColumn<ProyectoEntrada, String> miercoles = 
        new TableColumn<>("Miercoles");   
        miercoles.setCellValueFactory(new PropertyValueFactory<>("miercoles")); 
        tvProyecto.getColumns().add(miercoles); 
 
        TableColumn<ProyectoEntrada, String> jueves = 
        new TableColumn<>("Jueves");   
        jueves.setCellValueFactory(new PropertyValueFactory<>("jueves")); 
        tvProyecto.getColumns().add(jueves); 
  
        TableColumn<ProyectoEntrada, String> viernes = 
        new TableColumn<>("Viernes");   
        viernes.setCellValueFactory(new PropertyValueFactory<>("viernes")); 
        tvProyecto.getColumns().add(viernes); 

        // Tamaño de la table view. 
        tvProyecto.setPrefWidth(430); 
        tvProyecto.setPrefHeight(305); 
        
        TableView.TableViewSelectionModel<ProyectoEntrada> tvSelModelo = tvProyecto.getSelectionModel();                
        
        tvSelModelo.selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> cambio,
                    Number viejoVal, Number nuevoVal) {
                
                ObservableList<TablePosition> olRow = tvSelModelo.getSelectedCells();
                //System.out.println(olRow.get(0).getRow() + ", " + olRow.get(0).getColumn());               
                
                //System.out.println( tvSelModelo.getSelectedCells().get(0).getTableColumn() );
                
                TableColumn column = tvSelModelo.getSelectedCells().get(0).getTableColumn();
                System.out.println(column.getCellData(olRow.get(0).getRow()));
                if( column.getCellData(olRow.get(0).getRow()).equals("Asesoria") ){
                    System.out.println("Enviar Notificacion");
                }else{
                    System.out.println("Selecciona un horario de asesoria valido");
                }
                
                
            }
        });
        
        btncerrar.setOnAction(e->{
            try {
                ButtonClicked(e);
                
            } catch( Exception ex){
                ex.printStackTrace();
            }
        });
        
        FlowPane pane = new FlowPane(30, 30);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(btncerrar);
        
        raizNodo.getChildren().addAll(encabezado, tvProyecto,pane);
        escenario.show();
    }

    private void ButtonClicked(ActionEvent e) throws Exception {
        
        if( e.getSource() == btncerrar ){
            Alumno alum = new Alumno();
            alum.start(escenario);
        }
        
    }
   
    
    
}
