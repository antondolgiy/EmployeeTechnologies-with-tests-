package ru.dolgiy.controller;

import ru.dolgiy.model.UserKnowledgeManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Anton on 05.02.2016.
 */
public class UpdateUser extends HttpServlet {
    protected void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;

        int a = Integer.parseInt(request.getParameter("userID"));
        String name = request.getParameter("edName");
        String surname = request.getParameter("edSurname");
        String adrez = request.getParameter("edAdress");
        Date dob = Date.valueOf(request.getParameter("edDOB"));
        Date doh =Date.valueOf(request.getParameter("edDOH"));
        try{
            UserKnowledgeManagement.getInstance().updateUser(a, name, surname, adrez, dob, doh);}
        catch (SQLException e){
            rd = request.getRequestDispatcher("SQLError.jsp");
            request.setAttribute("er", e.toString());
            rd.forward(request,response);
        }
        catch (Exception e){throw new ServletException(e);}
        rd =request.getRequestDispatcher("/getallusers");
        rd.forward(request,response);

    }
}
