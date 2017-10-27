package VO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernate.HibernateUtil;

public class Login {
    // =======================================================================//
    //                           Atributes                                    //
    // =======================================================================//
    private String user;
    private String password;
    
    // =======================================================================//
    //                         Encapsulamentos                                //
    // =======================================================================//
    public String getUser() {
        return user;
    }
    public void setUser(String usuario) {
        user=usuario;
    }
    
    // Encapsulamento para senha
    public String getPassword() {
        return getUser();
    }
    public void setPassword(String senha) {
        password=senha;
    }
    
    // =======================================================================//
    //                            Funções                                     //
    // =======================================================================//
    // Valida login entrado (Local)
    public boolean validarLogin() {        
        if((user.equals("Admin")) && (password.equals("admin@123")))
            return true;
        else if((user.equals("Manager")) && (password.equals("something")))
            return true;
        else if((user.equals("GoDlikE")) && (password.equals("glassfish")))
            return true;
        else if((user.equals("Test")) && (password.equals("123")))
            return true;
        else
            return false;
    }
    
    // Valida login entrado (MySQL)
    public boolean valida_login() {
        // Get data
        String login = this.getUser();
        String senha = this.getPassword();
        
        // Open session and Create Query
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("SELECT L.login, L.senha FROM Login L WHERE L.login='" + login + "'");
        // Save Results
        List row = query.list();
        
        if(row.size() > 0) {
            return (row.get(0) == login) && (row.get(1) == senha);        
        }
        else
            return false;
    }
    
    // =======================================================================//
    //                            Outros                                      //
    // =======================================================================//
}
