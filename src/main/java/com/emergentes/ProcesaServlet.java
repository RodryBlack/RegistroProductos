
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String producto=request.getParameter("producto");
        String categoria=request.getParameter("categoria");
        String existencia=request.getParameter("existencia");
        double precio= Double.parseDouble(request.getParameter("precio"));
        
        Producto pro= new Producto();
        
        pro.setProducto(producto);
        pro.setCategoria(categoria);
        pro.setExistencia(existencia);
        pro.setPrecio(precio);
        
        ////colocar al objeto per como atributo de reques
        request.setAttribute("producto", pro);
        
        ////Deribamos el control a salida.jsp incluye al objeto request
        request.getRequestDispatcher("salida.jsp").forward(request, response);
    }


}
