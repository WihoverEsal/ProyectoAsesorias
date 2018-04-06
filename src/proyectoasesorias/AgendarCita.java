/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoasesorias;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.*;

/**
 *
 * @author Victor Estupiñan
 */
public class AgendarCita {
        
    public static DataInputStream dis;
    public static String ruta = "C:\\Users\\Victor Estupiñan\\Documents\\NetBeansProjects\\ProyectoAsesorias\\HorasAsesoria.txt";                
    
    /*@Override
    public void start(Stage primaryStage) throws Exception {
                
        
    }*/
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String indice ,hora ;
        dis = new DataInputStream(new FileInputStream(ruta));
        
        try {                
            for(int i=0 ; i < 16 ; i++){
                indice = dis.readUTF();
                hora = dis.readUTF();
                System.out.println(indice + " " + hora + "\n");
            }
            dis.close();
        } catch(EOFException ex){
            System.out.println("Se leyeron todos los datos");
        }catch(ClassCastException ccex){
            System.err.println("Error: Falla en el Cast");
        }catch(OptionalDataException ode){
            ode.printStackTrace();
        }catch(IOException ioe){
            System.err.println("Error: Fallo la salida de Datos " + ioe);
            ioe.printStackTrace();
        }
        
        
        ArrayList<HoraAsesoria> alHoras = new ArrayList<>();
        alHoras.add(new HoraAsesoria(true, 6) );
        
        //DiaAsesoria daUno = new DiaAsesoria(alHoras, 0);
        ArrayList<DiaAsesoria> alDiaAs = new ArrayList<>();
        alDiaAs.add(new DiaAsesoria(alHoras, 0));
        
        ArrayList<UEA> alUEA = new ArrayList<>();
        alUEA.add(new UEA("Algoritmos y Estructuras de Datos", 123456, 9));
        
        Agenda agenda1 = new Agenda(alDiaAs);
        
        Profesor pMartha = new Profesor(alUEA, agenda1);
        
        
        
        
            
        
    }
    
}
