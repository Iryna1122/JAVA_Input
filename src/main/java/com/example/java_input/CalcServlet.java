package com.example.java_input;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="calcServlet", value = "/calc-servlet")
public class CalcServlet extends HttpServlet {

    private double num1;
    private double num2;
    private String operation;

    public void init() {

        num1=0;
        num2=0;
        operation="";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        getServletContext().getRequestDispatcher("/Calculator/calc.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        num1=Double.parseDouble(request.getParameter("num1"));
        num2=Double.parseDouble(request.getParameter("num2"));
        String operation=request.getParameter("operation");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p> num1= " + num1 + "</p>");
        out.println("<p> num2= " + num2 + "</p>");
        switch (operation){
            case "+": {
                out.println("<h1>" + num1 + " + " + num2 + " = " + (num1 + num2) + "</h1>");
            }
            break;
            case "-": {
                out.println("<h1>" + num1 + " - " + num2 + " = " + (num1 - num2) + "</h1>");
            }
            break;
            case "*": {
                out.println("<h1>" + num1 + " * " + num2 + " = " + (num1 * num2) + "</h1>");
            }
            break;
            case "/": {
                out.println("<h1>" + num1 + " / " + num2 + " = " + (num1 / num2) + "</h1>");
            }
            break;
            case "pow": {
                out.println("<h1>" + num1 + " / " + num2 + " = " + (Math.pow(num1, num2)) + "</h1>");
            }
            break;
            case "%": {
                out.println("<h1>" + num1 + " % " + num2 + " = " + getPercent(num1, num2) + "</h1>");
            }
            break;
        }
        out.println("</body></html>");
    }
    public void destroy() {
    }

    private double getPercent(double num1, double num2){
        double result=(num2/num1)*100;
        return result;
    }

}
