package ru.dolgiy.controller;

import ru.dolgiy.model.Technologies;
import ru.dolgiy.model.UserKnowledgeManagement;
import ru.dolgiy.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anton on 20.02.2016.
 */
public class GetUsersByTechID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        int techID = Integer.parseInt(request.getParameter("TechIDtoFind"));
        try {
            List<Users> usersOfTech= UserKnowledgeManagement.getInstance().getUsersByTechID(techID);
            request.setAttribute("UsersOfTech",usersOfTech);
            Technologies techbyid=UserKnowledgeManagement.getInstance().getTechByID(techID);
            request.setAttribute("TechByID",techbyid);
            rd = request.getRequestDispatcher("usersoftech.jsp");
            rd.forward(request,response);
        }
        catch (SQLException e){
            rd = request.getRequestDispatcher("SQLError.jsp");
            request.setAttribute("er", e.toString());
            rd.forward(request,response);
        }
        catch (Exception e){throw new ServletException(e);}



    }
}
