package ru.dolgiy.controller;

import ru.dolgiy.model.Technologies;
import ru.dolgiy.model.UserKnowledgeManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anton on 08.02.2016.
 */
public class GetUsersTechByID extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        int userID = Integer.parseInt(request.getParameter("userID"));
        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        try {
            List<Technologies> usertechnos = UserKnowledgeManagement.getInstance().getUserTchnologies(userID);
            List<Technologies> unknowntechnos = UserKnowledgeManagement.getInstance().getUnknownUserTchnologies(userID);
            rd = request.getRequestDispatcher("usertech.jsp");
            request.setAttribute("unknown", unknowntechnos);
            request.setAttribute("usertech", usertechnos);
            request.setAttribute("username", userName);
            request.setAttribute("usersurname", userSurname);
            request.setAttribute("userID", userID);
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        int userID = Integer.parseInt(request.getParameter("userID"));
        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        try {
            List<Technologies> usertechnos = UserKnowledgeManagement.getInstance().getUserTchnologies(userID);
            List<Technologies> unknowntechnos = UserKnowledgeManagement.getInstance().getUnknownUserTchnologies(userID);
            rd = request.getRequestDispatcher("usertech.jsp");
            request.setAttribute("unknown", unknowntechnos);
            request.setAttribute("usertech", usertechnos);
            request.setAttribute("username", userName);
            request.setAttribute("usersurname", userSurname);
            request.setAttribute("userID", userID);
            rd.forward(request, response);
        }
        catch (SQLException e){
            rd = request.getRequestDispatcher("SQLError.jsp");
            request.setAttribute("er", e.toString());
            rd.forward(request,response);
        }
        catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
