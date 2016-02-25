package ru.dolgiy.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import ru.dolgiy.model.*;


/**
 * Created by Anton on 04.02.2016.
 */
public class UserByID extends HttpServlet {

    protected void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;

        int userID = Integer.parseInt(request.getParameter("userID"));
        try {
            Users userok = UserKnowledgeManagement.getInstance().getUserokByID(userID);
            request.setAttribute("user", userok);
            rd = request.getRequestDispatcher("/userinfo.jsp");
            rd.forward(request,response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        int userID = Integer.parseInt(request.getParameter("userID"));
        try{
            Users userok = UserKnowledgeManagement.getInstance().getUserokByID(userID);
            rd = request.getRequestDispatcher("/userinfo.jsp");
            request.setAttribute("user",userok);

            rd.forward(request, response);}
        catch (SQLException e){
            rd = request.getRequestDispatcher("SQLError.jsp");
            request.setAttribute("er", e.toString());
            rd.forward(request,response);
        }
        catch (Exception e){throw new ServletException(e);}

    }

}
