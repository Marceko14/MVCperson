/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Persona;
import model.SQLPersona;
import views.Persona1;

/**
 *
 * @author marcelo
 */
public class controllerPersona implements ActionListener{
    private Persona person;
    private Persona1 frmPerson;
    private SQLPersona consult;

    public controllerPersona(Persona person, Persona1 frmPerson, SQLPersona consult) {
        this.person = person;
        this.frmPerson = frmPerson;
        this.consult = consult;
        
        
        this.frmPerson.agregar.addActionListener(this);
        this.frmPerson.buscar.addActionListener(this);
        this.frmPerson.modificar.addActionListener(this);
        this.frmPerson.eliminar.addActionListener(this);
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==frmPerson.agregar) {
            person.setNombre(frmPerson.name.getText());
            person.setApellido(frmPerson.apel.getText());
            person.setTelefono(frmPerson.phone.getText());
            person.setDireccion(frmPerson.dir.getText());
            if (consult.registrar(person)) {
                JOptionPane.showMessageDialog(null,"Datos registrados");
                
            } else {
                JOptionPane.showMessageDialog(null, "error al guardar los datos");
            }
            
            
            
        }
        
        
        if (e.getSource()==frmPerson.modificar) {
            person.setId_personas(Integer.parseInt(frmPerson.id.getText()));
            person.setNombre(frmPerson.name.getText());
            person.setApellido(frmPerson.apel.getText());
            person.setTelefono(frmPerson.phone.getText());
            person.setDireccion(frmPerson.dir.getText());
            if (consult.registrar(person)) {
                JOptionPane.showMessageDialog(null,"Datos registrados");
                
            } else {
                JOptionPane.showMessageDialog(null, "error al guardar los datos");
            }
            
            
            
        }
        
        if (e.getSource()==frmPerson.buscar) {
            person.setId_personas(Integer.parseInt(frmPerson.id.getText()));
            
            if (consult.buscar(person)) {
                frmPerson.id.setText(String.valueOf(person.getId_personas()));
                frmPerson.name.setText(person.getNombre());
                frmPerson.apel.setText(person.getApellido());
                frmPerson.phone.setText(person.getTelefono());
                frmPerson.dir.setText(person.getDireccion());
                
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "error al guardar los datos");
            }
            
            
            
        }
         if (e.getSource()==frmPerson.eliminar) {
            person.setId_personas(Integer.parseInt(frmPerson.id.getText()));
            
            if (consult.eliminar(person)) {
                JOptionPane.showMessageDialog(null, "Persona eliminada");
               
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
            
            
            
        }
        
        
        
        
        
        
        
    }
        
        
        
        
}
    
    
    
    
    
    
    
    

