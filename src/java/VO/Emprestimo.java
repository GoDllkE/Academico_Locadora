package VO;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.HibernateUtil;

public class Emprestimo  extends AbstractVO implements Padrao {
    //========================================================================//
    //                             Atributos                                  //
    //========================================================================//
    private Integer id;
    private Cliente cliente;
    private Filme filme;
    private Boolean confPagamento;
    private Date dtEntrada;
    private Date dtRetirada;
    private Float valorPago;

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
    
    public Boolean getConfPagamento() {
        return this.confPagamento;
    }
    public void setConfPagamento(Boolean confPagamento) {
        this.confPagamento = confPagamento;
    }
    
    public Date getDtEntrada() {
        return this.dtEntrada;
    }
    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }
    
    public Date getDtRetirada() {
        return this.dtRetirada;
    }    
    public void setDtRetirada(Date dtRetirada) {
        this.dtRetirada = dtRetirada;
    }
    
    public Float getValorPago() {
        return this.valorPago;
    }
    public void setValorPago(Float valorPago) {
        this.valorPago = valorPago;
    }

    //========================================================================//
    //                      Functions (NEED ATENTION)                         //
    //========================================================================//
    
    @Override
    public void create() {
        // Create and open a new instace of class
        hibernate.Emprestimo emp = new hibernate.Emprestimo();
        
        // Gather all values from it
        emp.setId(this.getId());
        // emp.setFilme(this.getFilme());
        // emp.setCliente(this.getCliente());
        emp.setDtEntrada(this.getDtEntrada());
        emp.setDtRetirada(this.getDtRetirada());
        emp.setValorPago(this.getValorPago());
        emp.setConfPagamento(this.getConfPagamento());
        
        // Open session and query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Emprestimo ORDER BY E.id desc");
        
        // Save results from query
        List results = query.list();
        
        if (results.size() > 0) {
            hibernate.Emprestimo emprest = (hibernate.Emprestimo) results.get(0);
            int some_id = emprest.getId()+1;
            emp.setId(some_id);
        } 
        else
            emp.setId(1);
    
        sessao.beginTransaction();
        sessao.save(emp);
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