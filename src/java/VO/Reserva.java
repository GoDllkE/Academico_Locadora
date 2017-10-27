package VO;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.HibernateUtil;

public class Reserva extends AbstractVO implements Padrao {
    
    //========================================================================//
    //                             Atributos                                  //
    //========================================================================//
    private Integer id;
    private Cliente cliente;
    private Filme filme;
    private Boolean confirmou;
    private Date dtReserva;
   
    //========================================================================//
    //                      Encapsulamento                                    //
    //========================================================================//
    
    public Cliente getCliente() {
        return this.cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Filme getFilme() {
        return this.filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    public Boolean getConfirmou() {
        return this.confirmou;
    }
    public void setConfirmou(Boolean confirmou) {
        this.confirmou = confirmou;
    }
    
    public Date getDtReserva() {
        return this.dtReserva;
    }
    public void setDtReserva(Date dtReserva) {
        this.dtReserva = dtReserva;
    }
    
    //========================================================================//
    //                     Functions (NEED ATENTION)                          //
    //========================================================================//
    
    @Override
    public void create() {
        // Create and open a new instace of class
        hibernate.Reserva rev = new hibernate.Reserva();
        
        // Gather all values from it
        rev.setId(this.getId());
        // rev.setCliente(this.getCliente());
        // rev.setFilme(this.getFilme());
        rev.setDtReserva(this.getDtReserva());
        rev.setConfirmou(this.getConfirmou());
        
        // Open session and query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Produtora P ORDER BY P.id desc");
        
        // Save results from query
        List results = query.list();
        
        if (results.size() > 0) {
            hibernate.Reserva revres = (hibernate.Reserva) results.get(0);
            int some_id = revres.getId()+1;
            rev.setId(some_id);
        } 
        else
            rev.setId(1);
    
        sessao.beginTransaction();
        sessao.save(rev);
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


