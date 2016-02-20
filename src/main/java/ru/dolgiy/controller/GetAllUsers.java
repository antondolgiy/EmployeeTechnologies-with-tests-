package ru.dolgiy.controller;


import ru.dolgiy.model.UserKnowledgeManagement;
import ru.dolgiy.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * Created by Anton on 08.02.2016.
 */
public class GetAllUsers extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        try {
            RequestDispatcher rd=null;
            List<Users>allusers= UserKnowledgeManagement.getInstance().getAllUsers();
            request.setAttribute("userslist",allusers);
            rd = request.getRequestDispatcher("userlist.jsp");
            rd.forward(request,response);
        }
        catch (Exception e){throw new ServletException(e);}

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        try {
            RequestDispatcher rd=null;
            List<Users>allusers= UserKnowledgeManagement.getInstance().getAllUsers();
            request.setAttribute("userslist",allusers);
            rd = request.getRequestDispatcher("userlist.jsp");
            rd.forward(request,response);
        }
        catch (Exception e){throw new ServletException(e);}

    }


}
