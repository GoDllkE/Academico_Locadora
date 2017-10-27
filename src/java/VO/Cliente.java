package VO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.HibernateUtil;

public class Cliente  extends AbstractVO implements Padrao {
    //========================================================================//
    //                             Atributos                                  //
    //========================================================================//
    private Integer id;
    private String nome;
    private Integer idade;
    private String genero;
    private String cpf;
    private String rg;
    private String telefone;
    private String endereco;
    public Emprestimo emprestimos;
    public Reserva reservas;
      
    //========================================================================//
    //                      Encapsulamento                                    //
    //========================================================================//
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getIdade() {
        return this.idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public String getGenero() {
        return this.genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getRg() {
        return this.rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //========================================================================//
    //                          Functions                                     //
    //========================================================================//
    
    @Override
    public void create() {
        // Create and open a new instace of class
        hibernate.Cliente cli = new hibernate.Cliente();
        
        // Gather all values from it
        cli.setId(this.getId());
        cli.setNome(this.getNome());
        cli.setIdade(this.getIdade());
        cli.setGenero(this.getGenero());
        cli.setRg(this.getRg());
        cli.setCpf(this.getCpf());
        cli.setEndereco(this.getEndereco());
        cli.setTelefone(this.getTelefone());
        
        // Open session and query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Cliente C ORDER BY C.id desc");
        
        // Save results from query
        List results = query.list();
        
        if (results.size() > 0) {
            hibernate.Cliente clirest = (hibernate.Cliente) results.get(0);
            int some_id = clirest.getId()+1;
            cli.setId(some_id);
        } 
        else
            cli.setId(1);
    
        sessao.beginTransaction();
        sessao.save(cli);
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