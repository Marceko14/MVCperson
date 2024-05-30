/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcelo
 */
public class SQLPersona extends Conexion{
    
    //METODO PARA REGISTRAR PERSONA
    public boolean registrar(Persona per){
        PreparedStatement ps = null;
        Connection con = Conectar();
        String sql = "INSERT INTO Personas(nombre,apellido,telefono,direccion) VALUES(?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getTelefono());
            ps.setString(4, per.getDireccion());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
            
            
        }
    }
    
    
    
    
    //METODO PARA MODIFICAR PERSONA
    
    public boolean modificar(Persona per){
        PreparedStatement ps = null;
        Connection con = Conectar();
        String sql = "UPDATE Personas SET nombre=?, apellido=?, telefono=?, direccion=? WHERE id_personas=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getTelefono());
            ps.setString(4, per.getDireccion());
            ps.setInt(5,per.getId_personas());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
            
            
        }
        
    }
    
    
    
    //FIN DEL METODO PARA MODIFICAR PERSONA
    
    
    public boolean buscar(Persona per){
        PreparedStatement ps = null;
        Connection con = Conectar();
        ResultSet rs = null;
        String sql = "SELECT * FROM Personas WHERE id_personas=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, per.getId_personas());
            rs = ps.executeQuery();
            if (rs.next()) {
                per.setId_personas(rs.getInt("id_personas"));
                per.setNombre(rs.getString("nombre"));
                per.setApellido(rs.getString("apellido"));
                per.setTelefono(rs.getString("telefono"));
                per.setDireccion(rs.getString("direccion"));
                return true;
            }
            return false;
        } catch(SQLException e){
            System.err.println(e);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
     public boolean eliminar(Persona per){
        PreparedStatement ps = null;
        Connection con = Conectar();
        String sql = "DELETE FROM Personas WHERE id_personas=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,per.getId_personas());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
            
            
        }
        
    }
    
    
    
    
    
    
    
    
    
        
}
    
    
    
    
    
    
    

