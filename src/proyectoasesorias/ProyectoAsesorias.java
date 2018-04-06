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
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.application.*;
import javafx.geometry.Pos;
//import modelo.Alumno;

public class ProyectoAsesorias extends Application {

   /* TextField txtUsuario;
    PasswordField psfPass;
    Label lblOlvidar;
    Label lblUsuario;
    Label lblPass;
    Label lblIniciar;
    Label lblRespuesta;
    Button btnIniciar;
    Label lblRegistrarse;

    HBox hbInisesion;
    HBox hbUserImg;
    HBox hbPassImg;
    HBox hbBtns;
    VBox vbAllHB;

    HashMap<Integer, String> hsPasswords;
    Alumno al;
    ArrayList<String> alPasswords = new ArrayList<>();
    ArrayList<String> alUsers = new ArrayList<>();*/

    /*public static void main(String[] args) {
        launch(args);
    }*/

    @Override
    public void start(Stage escenario) throws Exception {
        escenario.setTitle("Iniciar Sesion");

        FlowPane raiz = new FlowPane(10, 10);
        raiz.setAlignment(Pos.CENTER);
        raiz.setStyle("-fx-background-color: #2DBCC0;");

        Scene escena = new Scene(raiz, 270, 300);
        escenario.setScene(escena);
        
        Label lbl1 = new Label("Proyecto Asesorias");
        lbl1.setAlignment(Pos.CENTER);
        /*Image imUser = new Image("user.png", 25, 25, true, true);
        Image imPass = new Image("lock.png", 25, 25, true, true);
        
        ImageView ivUser = new ImageView(imUser);
        ivUser.setBlendMode(BlendMode.MULTIPLY);
        ivUser.setSmooth(true);
        
        ImageView ivPass = new ImageView(imPass);
        ivPass.setBlendMode(BlendMode.MULTIPLY);
        ivPass.setSmooth(true);

        lblIniciar = new Label("Iniciar Sesion");//Aqui puede ir el logo de la aplicacion 
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
        lblRegistrarse = new Label("Registrarse");
        lblRegistrarse.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        lblRegistrarse.setTextFill(Color.BLUE);
        lblRegistrarse.underlineProperty().set(true);

        lblRegistrarse.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lblRespuesta.setText("Se dio clic en label registrarse");
                Registrate reg = new Registrate();
                try {
                    reg.start(escenario);
                    //Poner aqui el escenario de la pantalla registrarse
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
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

        hbBtns = new HBox(15);
        hbBtns.setAlignment(Pos.CENTER);
        hbBtns.getChildren().addAll(btnIniciar, lblRegistrarse);

        vbAllHB = new VBox(13);
        vbAllHB.setAlignment(Pos.CENTER);

        
        alPasswords.add("2153001419");
        alPasswords.add("2153035791");

        hsPasswords = new HashMap<Integer, String>();
        for (int i = 0; i < alPasswords.size(); i++) {
            hsPasswords.put(alPasswords.get(i).hashCode(), alPasswords.get(i));
        }

        btnIniciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                al = new Alumno();
                if (txtUsuario.getText().length() == 10 && psfPass.getText().length() > 7) {
                    try {
                        //Antes de mandarlo a la pantalla de alumno verificar si es existe el alumno
                        System.out.println("hash del password: " + psfPass.getText().hashCode());
                        verificarAl(escenario);
                        escenario.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (txtUsuario.getText().length() == 5 && psfPass.getText().length() > 7) {
                    //Llevarlo a pantalla de profesor
                    System.out.println("No es alumno");
                } else {
                    System.out.println("Verificar usuario y/o contraseña");
                    lblRespuesta.setText("Verificar usuario y/o contraseña");
                }
                System.out.println("Ususario -> " + txtUsuario.getText() + " Password -> " + psfPass.getText());
            }
        });

        vbAllHB.getChildren().addAll(hbInisesion, hbUserImg, hbPassImg, hbBtns, lblRespuesta, lblOlvidar);
        //raiz.getChildren().addAll(lblIniciar,lblUsuario,txtUsuario,lblPass,psfPass,btnIniciar,btnRegistrarse,lblOlvidar);
        */
        raiz.getChildren().add(lbl1);

        escenario.show();
    }
    
    /*
    public void verificarAl(Stage stage) throws Exception {
        if (hsPasswords.containsKey(psfPass.getText().hashCode())) {
            al.start(stage);
        } else {
            System.out.println("Contraseña Incorrecta");
            lblRespuesta.setText("Contraseña Incorrecta");
        }
    }
    
    public int addPassUser(String usuario, String pass){
        if(alUsers.contains(usuario)){
            System.out.println("Usuario existente");
            return 0;
        }else{
            alUsers.add(usuario);
            alPasswords.add(pass);
        }
        return 1;
    }
    */

}
