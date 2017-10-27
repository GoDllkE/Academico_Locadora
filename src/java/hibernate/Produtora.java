package hibernate;
// Generated 13/04/2016 11:17:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Produtora generated by hbm2java
 */
public class Produtora  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private Set filmes = new HashSet(0);

    public Produtora() {
    }

	
    public Produtora(String nome) {
        this.nome = nome;
    }
    public Produtora(String nome, Set filmes) {
       this.nome = nome;
       this.filmes = filmes;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set getFilmes() {
        return this.filmes;
    }
    
    public void setFilmes(Set filmes) {
        this.filmes = filmes;
    }




}

