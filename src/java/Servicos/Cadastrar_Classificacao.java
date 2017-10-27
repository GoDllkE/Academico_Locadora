package Servicos;

// =======================================================================//
//                        Packages Imported                               //
// =======================================================================//
import VO.Classificacao;

// =======================================================================//
//                           Libraries                                    //
// =======================================================================//
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Cadastrar_Classificacao extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Pega por parametros dados
        String descricao = request.getParameter("Descricao");
        int idade = Integer.parseInt(request.getParameter("Idade"));
        
        // Open a new Instance
        Classificacao clas = new Classificacao();
        
        // Fufill our class with the data provided
        clas.setDescricao(descricao);
        clas.setIdade(idade);
        
        // Create request dispatcher and session
        RequestDispatcher rd = null;
        HttpSession session = null;
        
        try {
            clas.create();
            session.setAttribute("sucessMessage", "Classificação cadastrada com sucesso!");
        }
        catch (Exception ex){
            String error = (String)ex.getMessage();
            session.setAttribute("errorMessage", error);
        }
        finally {
            rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /*
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

    /*
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

    /*
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
