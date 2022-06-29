package app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.entities.Product;
import app.models.ProductsDB;

public class ProductsEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductsDB.select(id);

        req.setAttribute("product", product);
        getServletContext().getRequestDispatcher("/views/edit.jsp").forward(req,
                resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        Product product = new Product(id, name, price);
        int result = ProductsDB.update(product);
        req.setAttribute("updResult", result);
        resp.sendRedirect("./products");

    }
}
