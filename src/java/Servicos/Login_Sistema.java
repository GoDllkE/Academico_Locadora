package Servicos;

// =======================================================================//
//                           Libraries                                    //
// =======================================================================//
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// =======================================================================//
//                        Packages Imported                               //
// =======================================================================//
import VO.Login;

public class Login_Sistema extends HttpServlet {

    @SuppressWarnings("UnusedAssignment")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // TODO
        // Get data from input forms on JSP
        String login = request.getParameter("Nome");
        String senha = request.getParameter("Senha");
        
        // Open Instance
        Login log = new Login();
        
        // Set data to Object
        log.setUser(login);
        log.setPassword(senha);
        
        // Control
        RequestDispatcher rd;
        HttpSession session;
        
        // Validate login and data gathered
        if(log.valida_login()) {
            // Validate session
            session = request.getSession(true);
            // Set atribute and value
            session.setAttribute("user", login);
            request.setAttribute("sucessMessage", "Bem vindo!");    
            // Set page to redirect
            rd=request.getRequestDispatcher("index.jsp");
        }
        else {
            // Validate session
            session = request.getSession(false);
            // Set atribute and value
            request.setAttribute("errorMessage", "Usuario ou senha invalidos");
            // Set page to redirect
            rd=request.getRequestDispatcher("entrar.jsp");
        }
        
        
        // Redirect
        rd.forward(request, response);
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

    /**_
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
