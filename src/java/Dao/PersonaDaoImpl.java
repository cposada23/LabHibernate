/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Persona;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author camilo.posadaa
 */
public class PersonaDaoImpl implements PersonaDao{

    @Override
    public List<Persona> mostarPersonas() {
        Session session = null;
        List<Persona> lista = null;
        try{
            //Inicio la session
            session = NewHibernateUtil.getSessionFactory().openSession();
            //Uso el objeto query para llamar el HQL-> Lenguaje de consuilta sobre el modelo del dominio
            Query query = session.createQuery("From Persona");
            lista = (List<Persona>) query.list();
            
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }finally{
            if(session !=null){
                session .close();
            }
        }
        return lista;
    }

    @Override
    public void insertarPersona(Persona persona) {
        Session session = null;
        Transaction  transaction = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            //inicio una nueva transacción
            transaction = session.beginTransaction();
            //Inserto el onjeto
            session.save(persona);
            //Hago commit a la transaccion 
            transaction.commit();
        }catch(HibernateException e){
            transaction.rollback();
        }finally{
            if(session!= null){
                session.close();
            }
        }
    }

    @Override
    public void modificarPersona(Persona persona) {
Session session = null;
        Transaction transaction = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            //inicio una nueva transacción
            transaction = session.beginTransaction();
            //Inserto el onjeto
            session.update(persona);
            //Hago commit a la transaccion 
            transaction.commit();
        }catch(HibernateException e){
            transaction.rollback();
        }finally{
            if(session!= null){
                session.close();
            }
        }   
    }

    @Override
    public void eliminarPersona(Persona persona) {
Session session = null;
        Transaction transaction = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            //inicio una nueva transacción
            transaction = session.beginTransaction();
            //Inserto el onjeto
            session.delete(persona);
            //Hago commit a la transaccion 
            transaction.commit();
        }catch(HibernateException e){
            transaction.rollback();
        }finally{
            if(session!= null){
                session.close();
            }
        }
    }
    
    
}
