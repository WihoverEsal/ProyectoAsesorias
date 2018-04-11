/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadabd;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author VictorEstupiñan
 */

public class UsersDefault {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FachadaBD f = new FachadaBD();
            f.connectToAndQueryDatabase("DBProyecto.db");
         /*   f.EjecutaSQL("DROP TABLE Tusuarios");            
            String sql= " CREATE TABLE Tusuarios(\n"
                    + " id text PRIMARY KEY,\n"
                    + " nombre text NOT NULL,\n"
                    + " pass text NOT NULL\n"
                    + ");";
            f.EjecutaSQL(sql);            
            //usuarios ya registrados de esta parte
            f.EjecutaSQL("insert into Tusuarios (id, nombre, pass) values('2153001419', 'Victor Estupiñan', '2153001419');");
            f.EjecutaSQL("insert into Tusuarios (id, nombre, pass) values('2153035791', 'Fabian Galicia', '2153035791');");
            f.EjecutaSQL("insert into Tusuarios (id, nombre, pass) values('12345', 'Martha Mora Torres', '12345678');");*/

            ResultSet rs = f.ejecutaSQLreturnRS("select id, nombre, pass  from Tusuarios ");
            while (rs.next()) {
                System.out.println("id= " + rs.getString(1) + " nombre = " + rs.getString(2) + " pass = " + rs.getString(3));
            }

            f.disconnectDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDefault.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
