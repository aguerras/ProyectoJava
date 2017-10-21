package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class Conexion {
    private Connection conexion;
    private Statement stm;
    private static Conexion instancia;
    //Singleton
    public static synchronized Conexion getInstancia(){
        return (instancia == null)?new Conexion():instancia;		
    }
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Conexión a DB de Google
            conexion = DriverManager.getConnection("jdbc:mysql://146.148.78.170:3306/proyecto", "root", "root");
            stm = conexion.createStatement();
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
    
    //Función para obtener un solo dato de una consulta.
    public String db_string (String query, String nulo) {
        try{
            String result = "";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                result = rs.getString(1);
            }
            if (result.equals("")) {
                return nulo;
            }
            return result;
        } catch(SQLException e) {
            
        }
        return nulo;
    }
    
    //Función para obtener una lista de una consulta
    public ArrayList<String> db_list (String query) {
        ArrayList<String> result = new ArrayList<String>();
        try{
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString(1));
            }
            
        } catch(SQLException e) {
            
        }
        return result;
    }
    
    //Función para obtener una lista de listas de una consulta
    public ArrayList<ArrayList> db_list_of_lists (String query) {
        ArrayList<ArrayList> result = new ArrayList<ArrayList>();
        try{
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<String>();
                ResultSetMetaData metaData = rs.getMetaData();
                int count = metaData.getColumnCount();
                for (int i = 1 ; i <= count ; i++) {
                    row.add(rs.getString(i));
                }
                result.add(row);
            }
            
        } catch(SQLException e) {
            
        }
        return result;
    }
    
    //Función para ejecutar Inserts, updates y delete
    public void db_exec (String exec) {
        try{
            stm.executeUpdate(exec);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 }
