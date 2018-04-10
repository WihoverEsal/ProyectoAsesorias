/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadabd;

import java.sql.*;

/**
 *
 * @author VictorEstupiñan
 */
public class FachadaBD {
    private Connection con;
    private ResultSet rs;//Devuelve el conjunto de resultados de una coneccion de datos
    private Statement statement;//sentencia sql
    
    public void connectToAndQueryDatabase(String database) {
        System.out.println("Conectando a la base de datos");
    
        try{
          Class.forName("org.sqlite.JDBC").newInstance();
          //C:\Users\Victor Estupiñan\Documents\NetBeansProjects\ProyectoAsesorias\src\fachadabd
          ///Users/fabianzacate/Documents/pvo brambila/ProyectoAsesorias/src esta es mi ruta con la que trabajo
          this.con = DriverManager.getConnection("jdbc:sqlite:/Users/fabianzacate/Documents/pvo brambila/ProyectoAsesorias/src/fachadabd"+database);
        } catch (InstantiationException ex) {
            System.out.println("Connect: Error en la instanciacion del driver sqlite");
        } catch (IllegalAccessException ex) {
            System.out.println("Connect: Error en el acceso al driver sqlite");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Connect: Class not found exception");
        } catch (SQLException sqle) {
            System.out.println("Connect: SQL exception");
        }
    }
    public void disconnectDatabase(){
        try {
          this.statement.close();
              rs=null;
        } catch (SQLException e ) {
            System.out.println("Error al desconectarse de la base");
        }
            System.out.println("Conexion cerrada a la base de datos");
    }

    public ResultSet ejecutaSQLreturnRS(String SQL) throws SQLException {
        try {
          this.statement = this.con.createStatement();
          rs = this.statement.executeQuery(SQL);
        } catch (SQLException e ) {
          //rs=null;
            System.out.println("SQLRS exception "+e);
        } finally {
          //if (statement != null) {
              //stmt.close();
              //rs=null;
          //}
        }
        return rs;
    }
    public int EjecutaSQLUpdate(String QueryString){
        int updateQuery = 0;
        try{
            statement = this.con.createStatement();
            updateQuery = statement.executeUpdate(QueryString);
        }catch(SQLException sqle){
            System.out.println("EjecutaSQLUpdate: Error al intentar realizar el query");
        }
        return updateQuery;
    }
    public boolean EjecutaSQL(String QueryString){
        boolean updateQuery = false;
        try{
            statement = this.con.createStatement();
            updateQuery = statement.execute(QueryString);
        }catch(SQLException sqle){
            System.out.println("EjecutaSQL: Error al intentar realizar el query " + sqle);
        }
        return updateQuery;
    }
}