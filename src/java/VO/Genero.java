package VO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class Genero extends AbstractVO implements Padrao {
    //========================================================================//
    //                             Atributos                                  //
    //========================================================================//
    private String nome;

    //========================================================================//
    //                      Encapsulamento                                    //
    //========================================================================//

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //========================================================================//
    //                     Functions (NEED ATENTION)                          //
    //========================================================================//
    
    @Override
    public void create() {
        // Create and open a new instace of class
        hibernate.Genero gen = new hibernate.Genero();
        
        // Gather all values from it
        gen.setId(this.getId());
        gen.setNome(this.getNome());
        // gen.setFilmes(this.getFilmes());
        
        // Open session and query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Genero G ORDER BY G.id desc");
        
        // Save results from query
        List results = query.list();
        
        if (results.size() > 0) {
            hibernate.Genero genrest = (hibernate.Genero) results.get(0);
            int some_id = genrest.getId()+1;
            gen.setId(some_id);
        } 
        else
            gen.setId(1);
    
        sessao.beginTransaction();
        sessao.save(gen);
        sessao.getTransaction().commit();
        sessao.close();   
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void search(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //========================================================================//
}



