package modelo;
// En esta clase lo que hacemos es obtener lo que la hora y dias que queremos en base a las clases hora y dia que mandemos  
	 
        import java.util.ArrayList;
	import javafx.beans.property.*;  
	 
	public class ProyectoEntrada { 
	  // Declaración de las propiedades 
	  private SimpleStringProperty hora; 
	  private SimpleStringProperty lunes; 
	  private SimpleStringProperty martes; 
	  private SimpleStringProperty miercoles; 
          private SimpleStringProperty jueves;
          private SimpleStringProperty viernes;
	  
	  // Constructor 
	  ProyectoEntrada(String cad1, String cad2, String cad3, String cad4, String cad5,String cad6) { 
		hora = new SimpleStringProperty(cad1); 
		lunes = new SimpleStringProperty(cad2); 
	        martes = new SimpleStringProperty(cad3); 
	        miercoles = new SimpleStringProperty(cad4); 
                jueves = new SimpleStringProperty(cad5);
                viernes = new SimpleStringProperty(cad6);
	  } 
	 
	  // Getters y setters para las propiedades 
	  public String getHora() { return hora.get(); } 
	  public void setHora(String cad1) { hora.set(cad1); } 
	 
	  public String getLunes() { return lunes.get(); } 
	  public void setLunes(String cad2) { lunes.set(cad2); } 
	 
	  public String getMartes() { return martes.get(); } 
	  public void setMartes(String cad3) { martes.set(cad3); } 
	 
	  public String getMiercoles() { return miercoles.get(); } 
	  public void setMiercoles(String cad4) { miercoles.set(cad4); } 
          
          public String getJueves() { return jueves.get(); } 
	  public void setJueves(String cad5) { jueves.set(cad5); }
          
          public String getViernes() { return viernes.get(); } 
	  public void setViernes(String cad6) { viernes.set(cad6); } 
	}