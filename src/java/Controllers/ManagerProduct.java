/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.Account;
import Models.Category;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author tuan
 */
public class ManagerProduct extends HttpServlet {

    DAO d;

    public void init() {
        d = new DAO();
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        try {
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            if (acc.getIsAdmin() == 1) {
                if (action == null || action == "") {
                    String id = request.getParameter("pid");
                    Product p = d.getproductbyid(id);
                    request.setAttribute("detail", p);
                    List<Product> listMP = d.allproduct();
                    request.setAttribute("listP", listMP);

                    List<Category> listCate = d.allcategory();
                    request.setAttribute("listCate", listCate);

                    List<Account> listaccount = d.allaccount();
                    request.setAttribute("listaccount", listaccount);
                    request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
                }

                if (action.equals("add")) {
                   
                    List<Category> listCate = d.allcategory();
                    request.setAttribute("listCate", listCate);


                    
                    String name = request.getParameter("name");
                    String image = request.getParameter("image");
                    String price = request.getParameter("price");
                    String title = request.getParameter("title");
                    String description = request.getParameter("description");
                    String category = request.getParameter("category");
                    d.addproduct(name, image, price, title, description, category);
                    response.sendRedirect("managerproduct");

                }

            } else {
                response.sendRedirect("login?action=Login");
            }
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
