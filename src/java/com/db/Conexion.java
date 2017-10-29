package com.db;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
    
    public List<Object> db_object(Class<?> claseX) {
        return db_object(claseX, "");
    }
    
    //Función para obtener una lista de un objecto que se desea.
    //El parámetro claseX es el bean que se quiere obtener.
    public List<Object> db_object(Class<?> claseX, String where) {
        List<String> campos = getCamposClase(claseX);
        String camposJoin = String.join(",", campos);
        String nombreClase = claseX.getSimpleName();
        List<Object> listaObjeto = new ArrayList<Object>();
        String clausula_where = "";
        if (!where.equals("")) {
            clausula_where = " WHERE " + where;
        }
        try {
            //Se crea un variable tipo objecto donde contendrá el bean que se desea
            Object claseObjeto;
            //Se recorre la consulta del bean con los campos deseados, en este caso los campos declarados del bean.
            for (ArrayList<String> lista : (db_list_of_lists("SELECT " + camposJoin + " FROM " + nombreClase.toLowerCase() + clausula_where))) {
                claseObjeto = claseX.newInstance();
                //Se recorre los campos declarados del bean.
                for (int contador = 0; contador < campos.size(); contador++) {
                    String nombre = campos.get(contador);
                    String upperCaseName = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                    //Desde aquí se verificará el tipo del campo para así castear el valor.
                    String theType = claseX.getDeclaredMethod("get" + upperCaseName).getReturnType().getName();
                    Object obj = null;
                    if (theType.equals("int")) {
                        obj = Integer.parseInt(lista.get(contador));
                    } else if (theType.equals("float")) {
                        obj = Float.parseFloat(lista.get(contador));
                    } else if (theType.matches("com.model.(.*)")) {
                        obj = db_object(Class.forName(theType),nombre + " = " + lista.get(contador)).get(0);
                    } else {
                        Class<?> theClass = Class.forName(theType);
                        obj = theClass.cast(lista.get(contador));
                    }
                    //Aquí se quiere setear el valor al objeto instanciado del bean.
                    claseX.getMethod("set" + upperCaseName,claseX.getDeclaredMethod("get" + upperCaseName).getReturnType()).invoke(claseObjeto, obj);
                }
                listaObjeto.add(claseObjeto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaObjeto;
    }
    
    public List<String> getCamposClase(Class<?> claseX) {
        List<String> propiedades = new ArrayList<String>();

        // Revisa todos los campos declarados
        for (Field campo : claseX.getDeclaredFields()) {
            // Si el campo es privado, entonces mira los set y get.
            if (Modifier.isPrivate(campo.getModifiers())) {
                String nombre = campo.getName();
                String upperCaseName = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                try {
                    String tipo = campo.getType().getSimpleName();
                    //Para los metodos booleanos deberían ser isProperty y setProperty(propertyType)
                    if (tipo.equals("Boolean") || tipo.equals("boolean")) {
                        if ((claseX.getDeclaredMethod("is" + upperCaseName) != null) && (claseX.getDeclaredMethod("set" + upperCaseName,campo.getType()) != null)) {
                            propiedades.add(nombre);
                        }
                    } else {
                        if ((claseX.getDeclaredMethod("get" + upperCaseName) != null) && (claseX.getDeclaredMethod("set" + upperCaseName,campo.getType()) != null)) {
                            List<String> temp2 = new ArrayList<String>();
                            propiedades.add(nombre);
                        }
                    }
                } catch (NoSuchMethodException | SecurityException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return propiedades;
    }
 }
