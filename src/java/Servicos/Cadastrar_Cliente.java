package Servicos;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Cliente;
import javax.servlet.http.HttpSession;

public class Cadastrar_Cliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Pega por parametros dados
        String nome = request.getParameter("Nome");
        int idade = Integer.parseInt(request.getParameter("Idade"));
        String genero = request.getParameter("Genero");
        String cpf = request.getParameter("CPF");
        String rg = request.getParameter("RG");
        String tel = request.getParameter("Telefone");
        String end = request.getParameter("Endereco");
        
        // Open a new Instance
        Cliente cli = new Cliente();
        
        // Fufill our class with the data provided
        cli.setNome(nome);
        cli.setIdade(idade);
        cli.setGenero(genero);
        cli.setCpf(cpf);
        cli.setRg(rg);
        cli.setTelefone(tel);
        cli.setEndereco(end);
        
        // Create request dispatcher and session
        RequestDispatcher rd = null;
        HttpSession session = null;
        
        try {
            cli.create();
            session.setAttribute("sucessMessage", "Cliente cadastrado com sucesso!");
        }
        catch (Exception ex){
            session.setAttribute("errorMessage", ex.getMessage());
        }
        finally {
            rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
