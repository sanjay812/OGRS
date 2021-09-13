/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebogrs;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sanjay C Karthick
 */
public class Registration extends HttpServlet {

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
          String f_name=request.getParameter("f_name");
            String m_name=request.getParameter("m_name");
            String l_name=request.getParameter("l_name");         
            String gender=request.getParameter("gender");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
            String ph=request.getParameter("phone");
           
            String door = request.getParameter("inputAddress1");
            String street = request.getParameter("inputAddress2");
            String city  = request.getParameter("inputCity");
            String district=request.getParameter("inputDis");
            String state = request.getParameter("inputState");
            String pin = request.getParameter("inputZip");
            
             String email=request.getParameter("email");
            String consumerno=request.getParameter("consumerno");
            String password=request.getParameter("password");
            
             Address addr = new Address(door,street,city,district,state,pin);
            User user =new User(f_name,m_name,l_name,dob,gender,ph,email,consumerno,password);
            Database rdb =new Database();
           
         String result= rdb.insert(user,addr);
         System.out.println(result+ "row inserted successfully");
         String sub="WELCOME";
         String text="Welcome you have successfully registered to EBGS";
               Automaticmail.sendMail(email,sub,text);

                  RequestDispatcher rd = request.getRequestDispatcher("userlog.jsp");
                rd.forward(request,response);
        
            /* TODO output your page here. You may use following sample code. */
             
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
