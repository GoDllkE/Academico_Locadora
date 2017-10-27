package VO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.HibernateUtil;

public class Produtora  extends AbstractVO implements Padrao {
    //========================================================================//
    //                             Atributos                                  //
    //========================================================================//
    private Integer id;
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
        hibernate.Produtora prod = new hibernate.Produtora();
        
        // Gather all values from it
        prod.setId(this.getId());
        prod.setNome(this.getNome());
        // prod.setFilmes(this.getFilmes());
        
        // Open session and query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Produtora P ORDER BY P.id desc");
        
        // Save results from query
        List results = query.list();
        
        if (results.size() > 0) {
            hibernate.Produtora prodrest = (hibernate.Produtora) results.get(0);
            int some_id = prodrest.getId()+1;
            prod.setId(some_id);
        } 
        else
            prod.setId(1);
    
        sessao.beginTransaction();
        sessao.save(prod);
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


