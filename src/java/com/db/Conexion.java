package java.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexis
 */
public class Conexion {
    private Connection conexion;
    private Statement stm;
    private static Conexion instancia;

    public static synchronized Conexion getInstancia(){
        return (instancia == null)?new Conexion():instancia;		
    }
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion=DriverManager.getConnection("jdbc:google:mysql://proyecto-java:dbproyecto-183021:us-central1:proyecto-java/proyecto", "root", "root");
            stm=conexion.createStatement();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
