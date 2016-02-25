package ru.dolgiy.controller;

import ru.dolgiy.model.UserKnowledgeManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anton on 05.02.2016.
 */
public class DeleteUser extends HttpServlet {
    protected void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        int a = Integer.parseInt(request.getParameter("userID"));
        try {
            UserKnowledgeManagement.getInstance().deleteUser(a);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        rd = request.getRequestDispatcher("/getallusers");
        rd.forward(request, response);
    }


}
