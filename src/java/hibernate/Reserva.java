package hibernate;
// Generated 13/04/2016 11:17:37 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Reserva generated by hbm2java
 */
public class Reserva  implements java.io.Serializable {


     private Integer id;
     private Cliente cliente;
     private Filme filme;
     private Boolean confirmou;
     private Date dtReserva;

    public Reserva() {
    }

    public Reserva(Cliente cliente, Filme filme, Boolean confirmou, Date dtReserva) {
       this.cliente = cliente;
       this.filme = filme;
       this.confirmou = confirmou;
       this.dtReserva = dtReserva;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
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




}

