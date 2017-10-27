package VO;

import hibernate.HibernateUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;

public class Diretor extends AbstractVO implements Padrao {
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
    //                          Functions                                     //
    //========================================================================//
    
    @Override
    public void create() {
        // Create and open a new instace of class
        hibernate.Diretor drt = new hibernate.Diretor();
        
        // Gather all values from it
        drt.setId(this.getId());
        drt.setNome(this.getNome());
        
        // Open session and query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Diretor F ORDER BY F.id desc");
        
        // Save results from query
        List results = query.list();
        
        if (results.size() > 0) {
            hibernate.Diretor drtrest = (hibernate.Diretor) results.get(0);
            int some_id = drtrest.getId()+1;
            drt.setId(some_id);
        } 
        else
            drt.setId(1);
    
        sessao.beginTransaction();
        sessao.save(drt);
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