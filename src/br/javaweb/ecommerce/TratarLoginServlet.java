/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.ecommerce;

import br.javaweb.ecommerce.modelo.TrataLoginNegocio;
import br.javaweb.ecommerce.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author escm
 */
public class TratarLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String usuario = request.getParameter("login");
            String senha = request.getParameter("senha");

            Usuario objUsuario = new Usuario();

            objUsuario.setUsuario(usuario);
            objUsuario.setSenha(senha);

            TrataLoginNegocio trataLogin = new TrataLoginNegocio();

            if (trataLogin.verificaLogin(objUsuario)) {

                HttpSession sessao = request.getSession();

                sessao.setAttribute("usuarioSessao", objUsuario);

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet TratarLoginServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Usuario ok " + objUsuario.getUsuario() + "</h1>");
                out.println("<a href=\"catalogoProdutos\">Clique aqui para listar o catalogo de produtos</a>");
                out.println("</body>");
                out.println("</html>");
            } else {

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet TratarLoginServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Usuario ou senha incorreta </h1>");
                out.println("</body>");
                out.println("</html>");
            }

        } finally {
            out.close();
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
