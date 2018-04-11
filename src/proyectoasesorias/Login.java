/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoasesorias;
/**
 *
 * @author Victor Estupiñan
 */
import fachadabd.FachadaBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import modelo.Usuario;
import rolprofesor.RProfesor;

public class Login extends Application {

    String neco;    
    
    TextField txtUsuario;
    PasswordField psfPass;
    Label lblOlvidar;
    Label lblUsuario;
    Label lblPass;
    Label lblIniciar;
    Label lblRespuesta;
    Button btnIniciar;
    Button lblRegistrarse;

    HBox hbInisesion;
    HBox hbUserImg;
    HBox hbPassImg;
    HBox hbBtns;
    VBox vbAllHB;

    HashMap<Integer, String> hsPasswords;
    HashMap<Integer, Usuario> hsUsuarios;
    Alumno al  = new Alumno();
    //RProfesor rProf = new RProfesor();
    
    ArrayList<String> alPasswords = new ArrayList<>();
    ArrayList<String> alUsers = new ArrayList<>();
    ArrayList<Usuario> alUsuario = new ArrayList<>();
    
    FachadaBD f = new FachadaBD();

    public static void main(String[] args) {
        launch(args);
    }
    
    public Login() {        
        //this.alUsers.add("2153001419");
        //this.alUsers.add("2153035791");
    }       

    @Override
    public void start(Stage escenario) throws Exception {                
        escenario.setTitle("Iniciar Sesion");

        FlowPane raiz = new FlowPane(10, 10);
        raiz.setAlignment(Pos.CENTER);
        raiz.setStyle("-fx-background-color: #2DBCC0;");

        Scene escena = new Scene(raiz, 270, 300);
        escenario.setResizable(false);
        escenario.setScene(escena);

        Image imUser = new Image("user.png", 25, 25, true, true);
        Image imPass = new Image("lock.png", 25, 25, true, true);
        
        ImageView ivUser = new ImageView(imUser);
        ivUser.setBlendMode(BlendMode.MULTIPLY);
        ivUser.setSmooth(true);
        
        ImageView ivPass = new ImageView(imPass);
        ivPass.setBlendMode(BlendMode.MULTIPLY);
        ivPass.setSmooth(true);

        lblIniciar = new Label(" ADVIUAM ");//Aqui puede ir el logo de la aplicacion
        lblIniciar.setFont(Font.font("CASTELLAR", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 25));
        //lblIniciar.setFont(Font.font("SEGOE PRINT", FontWeight.MEDIUM, FontPosture.ITALIC, 22));
        //lblIniciar.setFont(Font.font("FORTE", FontWeight.MEDIUM, FontPosture.ITALIC, 22));
        //lblIniciar.setFont(Font.font("HARRINGTON", FontWeight.MEDIUM, FontPosture.ITALIC, 22));
        //lblIniciar.setFont(Font.font("KRISTEN ITC", FontWeight.MEDIUM, FontPosture.ITALIC, 22));
        
        lblUsuario = new Label("", ivUser);
        lblPass = new Label("", ivPass);

        lblOlvidar = new Label("¿Olvidaste tu contraseña?");
        lblRespuesta = new Label();
        lblOlvidar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Poner aqui pantalla para el formulario si olvido la contraseña
                lblRespuesta.setText("Se presiono sobre lblOlvidar");
            }
        });

        txtUsuario = new TextField();
        txtUsuario.setPromptText("Matricula o ECO");
        psfPass = new PasswordField();
        psfPass.setPromptText("Contraseña");

        btnIniciar = new Button("Iniciar Sesion");
        lblRegistrarse = new Button("Registrarse");
        lblRegistrarse.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        //lblRegistrarse.setTextFill(Color.BLUE);
       // lblRegistrarse.underlineProperty().set(true);

        lblRegistrarse.setOnAction((ActionEvent event) -> {
            //lblRespuesta.setText("Se dio clic en label registrarse");
            Registrate reg = new Registrate();
            try {
                reg.start(escenario);
                //Poner aqui el escenario de la pantalla registrarse
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        hbInisesion = new HBox();
        hbInisesion.setAlignment(Pos.CENTER);
        hbInisesion.getChildren().add(lblIniciar);

        hbUserImg = new HBox(5);
        hbUserImg.setAlignment(Pos.CENTER);
        hbUserImg.getChildren().addAll(lblUsuario, txtUsuario);

        hbPassImg = new HBox(5);
        hbPassImg.setAlignment(Pos.CENTER);
        hbPassImg.getChildren().addAll(lblPass, psfPass);
        
        btnIniciar.setScaleX(.7);
        btnIniciar.setScaleY(.7);
        lblRegistrarse.setScaleX(.7);
        lblRegistrarse.setScaleY(.7);
        hbBtns = new HBox();
        hbBtns.setAlignment(Pos.CENTER);
        hbBtns.getChildren().addAll(btnIniciar, lblRegistrarse);

        vbAllHB = new VBox(13);
        vbAllHB.setAlignment(Pos.CENTER);
        
        alPasswords.add("2153001419");
        alPasswords.add("2153035791");

        /*hsPasswords = new HashMap<Integer, String>();
        for (int i = 0; i < alPasswords.size(); i++) {
            hsPasswords.put(alPasswords.get(i).hashCode(), alPasswords.get(i));
        }*/
        
        /*System.out.println(alUsuario.size());
        for(int i = 0 ; i < alUsuario.size() ; i++){
            System.out.println(alUsuario.get(i).getNombre() + " " + alUsuario.get(i).getIdentificador() + " " + alUsuario.get(i).getClavePass());
        }*/
        //Usando el Objeto de Usuario
        /*hsPasswords = new HashMap<Integer, String>();
        for (int i = 0; i < alUsuario.size(); i++){
            hsPasswords.put(alUsuario.get(i).getClavePass().hashCode(), alUsuario.get(i).getClavePass());
        }*/
        
        
        //Con Objetos
        /*hsUsuarios = new HashMap<Integer, Usuario>();
        for (int i = 0; i < alUsuario.size(); i++){
            hsUsuarios.put(alUsuario.get(i).hashCode(), alUsuario.get(i));
        }*/
        
         
                
        btnIniciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {                
                Usuario usuario = new Usuario();
                boolean bandera = false;
                f.connectToAndQueryDatabase("DBProyecto.db");//Conexion a la BD
                
                try {
                    ResultSet rs = f.ejecutaSQLreturnRS("select id, nombre, pass from Tusuarios");
                    while (rs.next()) {
                        if( rs.getString(1).equalsIgnoreCase( txtUsuario.getText() ) ){
                            usuario.setIdentificador( rs.getString(1) );
                            usuario.setNombre( rs.getString(2) );
                            usuario.setClavePass( rs.getString(3) );
                            bandera = true;
                            
                            System.out.println(usuario.getIdentificador() + " " + usuario.getNombre() + " " + usuario.getClavePass());
                            break;
                        }else{
                            bandera = false;
                        }
                        //System.out.println("id= " + rs.getString(1) + " nombre = " + rs.getString(2) + " pass = " + rs.getString(3));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(bandera);
                if(bandera == true){
                    if( (usuario.getIdentificador().length() == 10 || usuario.getIdentificador().length() == 5) && usuario.getClavePass().length() > 7 ){
                    //if (txtUsuario.getText().length() == 10 && psfPass.getText().length() > 7) {
                        setNEco(usuario.getIdentificador());
                        RProfesor rProf = new RProfesor( getNEco() );                    
                        try {
                            //System.out.println("hash del password: " + psfPass.getText().hashCode());
                            //if( bandera == true ){                  
                                if(usuario.getIdentificador().length() == 10 ){
                                    if(usuario.getClavePass().equals(psfPass.getText()))
                                        al.start(escenario);
                                    else
                                        lblRespuesta.setText("Verificar usuario y/o contraseña");                                    
                                }else{
                                    if(usuario.getClavePass().equals(psfPass.getText()))
                                        rProf.start(escenario);
                                    else
                                        lblRespuesta.setText("Verificar usuario y/o contraseña");
                                }
                            //}else{
                            //    lblRespuesta.setText("Usuario no encontrado\nRegistrate");
                            //}   
                            //escenario.close();
                        } catch (Exception ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {                        
                        lblRespuesta.setText("Verificar usuario y/o contraseña");
                    }
                } else {
                    lblRespuesta.setText("Usuario no encontrado\nRegistrate");
                }
                    //System.out.println("Ususario -> " + txtUsuario.getText() + " Password -> " + psfPass.getText());
            }
        });
        
       btnIniciar.setStyle("-fx-font: 22 arial; -fx-base: #E91E63;");
        DropShadow shadow = new DropShadow();
        shadow.setColor(javafx.scene.paint.Color.web("#E91E63"));
        //Adding the shadow when the mouse cursor is on
        btnIniciar.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                btnIniciar.setEffect(shadow);
                }
        });
        //Removing the shadow when the mouse cursor is off
        btnIniciar.addEventHandler(MouseEvent.MOUSE_EXITED, 
        new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                btnIniciar.setEffect(null);
            }
        });
        
        lblRegistrarse.setStyle("-fx-font: 22 arial; -fx-base: #E91E63;");
        DropShadow shadow2 = new DropShadow();
        shadow2.setColor(javafx.scene.paint.Color.web("#E91E63"));
        //Adding the shadow when the mouse cursor is on
        lblRegistrarse.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                lblRegistrarse.setEffect(shadow2);
                }
        });
        //Removing the shadow when the mouse cursor is off
        lblRegistrarse.addEventHandler(MouseEvent.MOUSE_EXITED, 
        new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                lblRegistrarse.setEffect(null);
            }
        });
        
        
        
        
        
        Label lblsaltos =new Label("\n");
        vbAllHB.getChildren().addAll(hbInisesion, lblsaltos, hbUserImg, hbPassImg, hbBtns, lblRespuesta, lblOlvidar);
        //raiz.getChildren().addAll(lblIniciar,lblUsuario,txtUsuario,lblPass,psfPass,btnIniciar,btnRegistrarse,lblOlvidar);
        raiz.getChildren().addAll(vbAllHB);

        escenario.show();
    }

    /*public void verificaPass(Stage stage, String usuario) throws Exception {
        RProfesor rProf = new RProfesor( getNEco() );
        if ( hsPasswords.containsKey(psfPass.getText().hashCode()) ) {
            if(usuario.length() == 10)
                al.start(stage);
            else
                rProf.start(stage);
        } else {
            System.out.println("Contraseña Incorrecta");
            lblRespuesta.setText("Contraseña Incorrecta");
        }
    }*/
    /*public void verificarPass(Stage stage, Usuario usuario) throws Exception{
        RProfesor rProf = new RProfesor( );
        //RProfesor rProf = new RProfesor(getNEco(), alUsuario );
        if( hsPasswords.containsKey( usuario.getClavePass().hashCode() )){
            if(usuario.getIdentificador().length() == 10)
                al.start(stage);
            else
                rProf.start(stage);
        } else {
            System.out.println("Contraseña Incorrecta");
            lblRespuesta.setText("Contraseña Incorrecta");
        }
    }*/
    /*public int verificaUser(String usuario){
        if( alUsers.contains(usuario) ){//Si el HashMap de usuarios contiene el Usuario usuario
            return 1;
        }
        return 0;
    }*/
    
    /*public int verificarUser(Usuario usuario){
        if(alUsuario.contains(usuario)){
            return 1;
        }
        return 0;
    }*/
    
    /*public int addPassUser(String usuario, String pass){
        if( alUsers.contains(usuario) ){
            System.out.println("Usuario existente");
            return 0;
        }else{
            alUsers.add(usuario);
            alPasswords.add(pass);
        }
        return 1;
    }*/
    
    //Con objetos
    /*public int addUser(Usuario usuario){
        if( alUsuario.contains(usuario) ){
            System.out.println("Usuario existente");
            return 0;
        }else{
            alUsuario.add(usuario);
        }
        return 1;
    }*/
    
    /*public ArrayList getUsers(){
        return alUsuario;
    }*/
    /*public void setUsers(ArrayList alUsuario){
        this.alUsuario = alUsuario;
    }*/
        
    public String getNEco(){
        return neco;
    }
    public void setNEco(String neco){
        this.neco = neco;        
    }
}

