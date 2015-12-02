/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Persona;
import java.util.List;

/**
 *
 * @author camilo.posadaa
 */
public interface PersonaDao {
    public List<Persona> mostarPersonas();
    public void insertarPersona(Persona persona);
    public void modificarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
    
}
