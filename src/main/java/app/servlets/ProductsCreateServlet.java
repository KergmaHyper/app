package app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.entities.Product;
import app.models.ProductsDB;

public class ProductsCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        Product product = new Product(0, name, price);
        int result = ProductsDB.insert(product);
        req.setAttribute("insResult", result);
        resp.sendRedirect("./products");

    }
}
