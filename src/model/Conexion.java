
package model;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author marcelo
 */
public class Conexion {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DB = "BaseDatos";
    
    public Connection cadena;
    public static Conexion instancia;

    public Conexion() {
        this.cadena = null;
    }
    
    public Connection Conectar(){
        try{
            Class.forName(DRIVER);
            this.cadena = DriverManager.getConnection(URL+DB,USER,PASSWORD);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this.cadena;
    
    }
    
    
    public void Desconectar(){
        try{
            this.cadena.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        
        }
    }
    
    public synchronized static Conexion getInstancia(){
        if (instancia == null) {
            instancia = new Conexion();
            
            
        }
        return instancia;
    
    }

    
    
    
    
}
