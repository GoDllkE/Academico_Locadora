package VO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.HibernateUtil;


public class Classificacao extends AbstractVO implements Padrao {
    //========================================================================//
    //                             Atributos                                  //
    //========================================================================//
     
     private String descricao;
     private Integer idade;
     
    //========================================================================//
    //                      Encapsulamento                                    //
    //========================================================================//
    
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getIdade() {
        return this.idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    //========================================================================//
    //                       Functions                                        //
    //========================================================================//
    @Override
    public void create() {
        // Create and open a new instace of class
        hibernate.Classificacao clas = new hibernate.Classificacao();
        
        // Gather all values from it
        clas.setIdade(this.idade);
        clas.setDescricao(this.descricao);
        
        // Open session and query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Classificacao C ORDER BY C.id desc");
        
        // Save results from query
        List results = query.list();
        
        if (results.size() > 0) {
            hibernate.Classificacao clasres = (hibernate.Classificacao) results.get(0);
            int some_id = clasres.getId()+1;
            clas.setId(some_id);
        } 
        else
            clas.setId(1);
    
        sessao.beginTransaction();
        sessao.save(clas);
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