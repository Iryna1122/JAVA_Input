package com.example.java_input;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "textServlet", value = "/text-servlet")
public class TextServlet extends HttpServlet {


    private String text;
    private String vowel;
    private String consonant;
    private String other;
    private int vowelCount;
    private int consonantCount;
    private int otherCount;
    public void init() {
        text="";
        vowel="";
        consonant="";
        other="";
        vowelCount=0;
        consonantCount=0;
        otherCount=0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        getServletContext().getRequestDispatcher("/Text/text2.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        text=request.getParameter("text");

        text=text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char current=text.charAt(i);
            if(Character.isLetter(current)){
                if("aeiou".contains(String.valueOf(current))){
                    vowel+=current;
                    vowelCount++;
                }
                else{
                    consonant+=current;
                    consonantCount++;
                }
            }
            else if("!,.:;'-".contains(String.valueOf(current))){
                other+=current;
                otherCount++;
            }
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p> vowel: " + vowel + "</p>");
        out.println("<p> vowelCount: " + vowelCount + "</p>");
        out.println("<p> consonant: " + consonant + "</p>");
        out.println("<p> consonantCount: " + consonantCount + "</p>");
        out.println("<p> other: " + other + "</p>");
        out.println("<p> otherCount: " + otherCount + "</p>");

        out.println("</body></html>");
    }
    public void destroy() {
    }


}
