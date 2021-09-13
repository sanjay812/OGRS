/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebogrs;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
public class Grievancesubmit extends HttpServlet {

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
         String region_no=request.getParameter("rno");
            String section_no=request.getParameter("sno");
            String ward_no=request.getParameter("wno");         
            String house_no=request.getParameter("hno");
             LocalDateTime g_date = LocalDateTime.now();
            String desc=request.getParameter("desc");
            String category= request.getParameter("category");
            String status = "Pending";
            grievance g = new grievance(region_no,section_no,ward_no,house_no,g_date,desc,category,status);
            Database gr = new Database();
            
           String output = gr.insertgrievance(g); 
           HttpSession session = request.getSession();
            String email=(String) session.getAttribute("email");
            String staffmail = gr.getStaffmail(ward_no);
           if(output =="success")
            {
                String msg="Your grievance has been submitted successfully...";
                String sub ="Acknowledgement";
                Automaticmail.sendMail(email,sub,msg);
                String msg2 = "Look into your grievances list that are to be rectified";
                String sub2 = "Notification";
                Automaticmail.sendMail(staffmail,sub2,msg2);
            }
            else
            { 
            String msg="There is an error in submitting your grievance...";
            String sub ="Acknowledgement";
            Automaticmail.sendMail(email,sub,msg);
                
            }
          RequestDispatcher rd=request.getRequestDispatcher("userwelcome.jsp");  
           rd.include(request,response);  
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
