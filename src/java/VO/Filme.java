package VO;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.HibernateUtil;
import org.hibernate.Criteria;


public class Filme extends AbstractVO implements Padrao {

    //========================================================================//
    //                             Atributos                                  //
    //========================================================================//
    private Integer id;
    private Classificacao classificacao;
    private Diretor diretor;
    private Genero genero;
    private Produtora produtora;
    private String nome;
    private Date dtEstreia;
    public Reserva reservas;
    public Emprestimo emprestimos;
    
    //========================================================================//
    //                      Encapsulamento                                    //
    //========================================================================//
    
    public Classificacao getClassificacao() {
        return this.classificacao;
    }
    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
    
    public Diretor getDiretor() {
        return this.diretor;
    }
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
    
    public Genero getGenero() {
        return this.genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public Produtora getProdutora() {
        return this.produtora;
    }
    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDtEstreia() {
        return this.dtEstreia;
    }
    public void setDtEstreia(Date dtEstreia) {
        this.dtEstreia = dtEstreia;
    }
    
    public Reserva getReservas() {
        return this.reservas;
    }
    public void setReservas(Reserva reservas) {
        this.reservas = reservas;
    }
    
    public Emprestimo getEmprestimos() {
        return this.emprestimos;
    }
    public void setEmprestimos(Emprestimo emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    //========================================================================//
    //                        ComboBox things                                 //    
    //========================================================================//
    
    public static List<Genero> ComboGenero() {
        // Open session and query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        //Query query = sessao.createQuery("FROM Genero G ORDER BY G.Nome desc");
        //Query query = sessao.createQuery("SELECT G.Nome FROM Genero G ORDER BY G.Nome desc");
        Criteria crit = sessao.createCriteria(Genero.class);
        List<Genero> gen = crit.list();
        return gen;
    }
    
    //========================================================================//
    //                     Functions (NEED ATENTION)                          //
    //========================================================================//
    
    @Override
    public void create() {
        // Create and open a new instace of class
        hibernate.Filme film = new hibernate.Filme();
        
        // Gather all values from it
        film.setId(this.getId());
        film.setNome(this.getNome());
        //film.setDiretor(this.getDiretor());
        //film.setGenero(this.getGenero());
        //film.setProdutora(this.getProdutora());
        //film.setClassificacao(this.getClassificacao());
        film.setDtEstreia(this.getDtEstreia());
        //film.setEmprestimos(this.getEmprestimos());
        //film.setReservas(this.getReservas());
        
        
        // Open session and query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Filme F ORDER BY F.id desc");
        
        // Save results from query
        List results = query.list();
        
        if (results.size() > 0) {
            hibernate.Filme filmrest = (hibernate.Filme) results.get(0);
            int some_id = filmrest.getId()+1;
            film.setId(some_id);
        } 
        else
            film.setId(1);
    
        sessao.beginTransaction();
        sessao.save(film);
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