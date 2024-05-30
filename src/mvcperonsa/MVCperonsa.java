/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvcperonsa;

import controller.controllerPersona;
import javax.swing.JOptionPane;
import model.Conexion;
import model.Persona;
import model.SQLPersona;
import views.Persona1;

/**
 *5778
 * @author marcelo
 */
public class MVCperonsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona = new Persona();
        SQLPersona sqlPersona = new SQLPersona();
        Persona1 persona1 = new Persona1(); // Cambia 'persona' a 'Persona' con mayúscula inicial
        controllerPersona controllerPersona1 = new controllerPersona(persona, persona1, sqlPersona);
        
        persona1.setVisible(true);
        
        
        
        
    }
    
}
