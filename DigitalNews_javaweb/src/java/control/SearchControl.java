/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Digital;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchControl", urlPatterns = {"/SearchControl"})
public class SearchControl extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try {
            String txt = request.getParameter("txtSearch");
            String indexPage=request.getParameter("index");
            int index=1;
            try {
              index=Integer.parseInt(indexPage);  
            } catch (Exception e) {
            }
            DAO dao = new DAO();
            int total = dao.count(txt);
            int size = 3;
            int endPage = total / 3;
            if (total % 3 > 0) {
                endPage++;
            }
            Digital top1 = dao.getTop1Title();
            List<Digital> top5 = dao.getLisTop5Articles();
            List<Digital> listS = dao.search(txt,index);
//            for (Digital digital : listS) {
//                digital.setTitle(dao.hightLight(digital.getTitle(), txt));
//            }
            request.setAttribute("top1", top1);
            request.setAttribute("top5", top5);
            request.setAttribute("endP", endPage);
            request.setAttribute("listS", listS);
            request.setAttribute("txtS", txt);
            request.setAttribute("tag", index);
            request.setAttribute("result", total);
            request.getRequestDispatcher("SearchResult.jsp")
                    .forward(request, response);
        } catch (Exception e) {
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
