package ru.dolgiy.controller;

import ru.dolgiy.model.UserKnowledgeManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anton on 09.02.2016.
 */
public class DelUserSkill extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        int a = Integer.parseInt(request.getParameter("userID"));
        int b = Integer.parseInt(request.getParameter("tech2delete"));
        String name = request.getParameter("userName");
        String surname = request.getParameter("userSurname");
        try {
            UserKnowledgeManagement.getInstance().deleteUserSkill(a,b);

        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("userID", a);
        request.setAttribute("userName", name);
        request.setAttribute("userSurname", surname);
        rd = request.getRequestDispatcher("/GetUsersTechByID");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        int a = Integer.parseInt(request.getParameter("userID"));
        int b = Integer.parseInt(request.getParameter("tech2delete"));
        String name = request.getParameter("userName");
        String surname = request.getParameter("userSurname");
        try {
            UserKnowledgeManagement.getInstance().deleteUserSkill(a,b);

        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("userID", a);
        request.setAttribute("userName", name);
        request.setAttribute("userSurname", surname);
        rd = request.getRequestDispatcher("/GetUsersTechByID");
        rd.forward(request, response);
    }
}
