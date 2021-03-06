package app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.entities.Product;
import app.models.ProductsDB;

public class ProductsDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductsDB.select(id);
        req.setAttribute("product", product);
        getServletContext().getRequestDispatcher("/views/delete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductsDB.select(id);
        int result = ProductsDB.delete(product);
        req.setAttribute("delResult", result);
        resp.sendRedirect("./products");

        // doGet(req, resp);
    }
}
