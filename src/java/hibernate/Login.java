package hibernate;
// Generated 13/04/2016 11:17:37 by Hibernate Tools 4.3.1



/**
 * Login generated by hbm2java
 */
public class Login  implements java.io.Serializable {


     private Integer id;
     private String login;
     private String senha;

    public Login() {
    }

	
    public Login(String senha) {
        this.senha = senha;
    }
    public Login(String login, String senha) {
       this.login = login;
       this.senha = senha;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }




}


