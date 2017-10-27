package Servicos;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Filme;


public class Cadastrar_Filme extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Pega por parametros dados
        String nome = request.getParameter("Nome");
        String genero = request.getParameter("Genero");
        String produtora = request.getParameter("Produtora");
        String diretor = request.getParameter("Diretor");
        String dtLanc = request.getParameter("DataLancamento");
        
        // Open a new Instance
        Filme fil = new Filme();
        
        // Fufill our class with the data provided
        fil.setNome(nome);
        
        /* ERROR STACK 
        fil.setGenero(genero);
        fil.setDiretor(diretor);
        fil.setClassificacao(classificacao);
        fil.setProdutora(produtora);
        fil.setDtEstreia(dtLanc);
        */
        
        // Create request dispatcher and session
        RequestDispatcher rd = null;
        HttpSession session = null;
        
        try {
            fil.create();
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
