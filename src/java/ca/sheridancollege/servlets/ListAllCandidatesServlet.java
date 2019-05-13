/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.servlets;

import ca.sheridancollege.beans.Candidates;
import ca.sheridancollege.dao.CandidateDetailsDAO;
import com.prog32758.db.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class to handle HTTP GET and POST requests for viewing all candidates
 *
 * @author Harleen Kaur
 */
public class ListAllCandidatesServlet extends HttpServlet {

    /**
     * 
     */
    @Override
    public void init() {
        ServletContext sc = this.getServletContext();
        String driver = sc.getInitParameter("driver");
        String url = sc.getInitParameter("url");
        String database = sc.getInitParameter("database");
        String usermame = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        DBConnector.createConnection(driver, url, database, usermame, password);
    }

    @Override
    public void destroy() {
        Connection conn = DBConnector.getConnection();
        DBConnector.closeJDBCObjects(conn, null);
    }

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CanditateDetailsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CanditateDetailsServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
     * Gets all candidate details from CandidateDetailsDAO and set that as attribute to request and then forward request to jsp to display it
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ArrayList<Candidates> candList = CandidateDetailsDAO.getCandidateInfo();
        request.setAttribute("candList", candList);
        request.getRequestDispatcher("VotingCandidate.jsp")
                .forward(request, response);
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
