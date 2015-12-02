/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.PersonaDao;
import Dao.PersonaDaoImpl;
import Model.Persona;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author camilo.posadaa
 */
public class PersonaBean implements Serializable{
    
    private Persona persona;
    private List<Persona> personas;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonas() {
        PersonaDao linkDao =  new PersonaDaoImpl();
        personas = linkDao.mostarPersonas();
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
   
    
    /**
     * Creates a new instance of PersonaBean
     */
    public PersonaBean() {
        //uinicializo a persona
        persona = new Persona();
    }
    
    //Eventos de la vista
    //LLamado desde el boton insertar
    public void insertar(){
        PersonaDao linkDao = new PersonaDaoImpl();
        linkDao.insertarPersona(persona);
        persona = new Persona();
    }
    
    public void modificar(){
        PersonaDao linkDao = new PersonaDaoImpl();
        linkDao.modificarPersona(persona);
        persona = new Persona();
    }
    
    public void elimininar(){
        PersonaDao linkDao = new PersonaDaoImpl();
        linkDao.eliminarPersona(persona);
        persona = new Persona();
    }
    
}
