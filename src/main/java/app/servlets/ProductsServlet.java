package app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.entities.Product;
import app.models.ProductsDB;

public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Product> products = ProductsDB.select();

        req.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/views/products.jsp").forward(req,
                resp);
    }

}
