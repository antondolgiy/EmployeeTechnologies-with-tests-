package ru.dolgiy.controller;

import ru.dolgiy.model.UserKnowledgeManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anton on 12.02.2016.
 */
public class DeleteTech extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        RequestDispatcher rd = null;
        int a =Integer.parseInt(request.getParameter("TechID"));
        try{
            UserKnowledgeManagement.getInstance().deleteTechnology(a);
        }
        catch (Exception e){throw new ServletException(e);}
        rd = request.getRequestDispatcher("/getalltech");
        rd.forward(request,response);
    }

}

