package com.example.java_input;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "maxServlet", value = "/math-servlet")
public class Task2MaxServlet extends HttpServlet {

    private int num1;
    private int num2;
    private int num3;

    public void init() {

        num1=0;
        num2=0;
        num3=0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        getServletContext().getRequestDispatcher("/MathOperations/Task2Max.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        num1=Integer.parseInt(request.getParameter("num1"));
        num2=Integer.parseInt(request.getParameter("num2"));
        num3=Integer.parseInt(request.getParameter("num3"));
        String operation=request.getParameter("operation");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p> num1= " + num1 + "</p>");
        out.println("<p> num2= " + num2 + "</p>");
        out.println("<p> num3= " + num3 + "</p>");
        switch (operation){
            case "max":{
                out.println("<h1> max= " + getMax(num1, num2, num3) + "</h1>");
            }break;
            case "min":{
                out.println("<h1> min= " + getMin(num1, num2, num3) + "</h1>");
            }break;
            case "avg":{
                out.println("<h1> avg= " + getAvg(num1, num2, num3) + "</h1>");
            }break;
        }
        out.println("</body></html>");
    }
    public void destroy() {
    }

    private int getMax(int num1, int num2, int num3){
        int max=num1;
        if(num2>max && num2>num3){
            max=num2;
        }
        else if(num3>max){
            max=num3;
        }
        return max;
    }
    private int getMin(int num1, int num2, int num3){
        int min=num1;
        if(num2<min && num2<num3){
            min=num2;
        }
        else if(num3<min){
            min=num3;
        }
        return min;
    }
    private float getAvg(int num1, int num2, int num3){
        return (num1+num2+num3)/3;
    }
}





