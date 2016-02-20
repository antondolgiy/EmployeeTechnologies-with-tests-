package ru.dolgiy.controller;

import ru.dolgiy.model.UserKnowledgeManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anton on 12.02.2016.
 */
public class AddTech extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher rd=null;


        if(request.getParameter("techID")!=""&&request.getParameter("techID")!=null&&request.getParameter("techName")!=""
                &&request.getParameter("techName")!=null){
        int a=Integer.parseInt(request.getParameter("techID"));
        String b=request.getParameter("techName");
        String c=request.getParameter("techDescription");
        try{
            UserKnowledgeManagement.getInstance().addNewTechnology(a,b,c);}
        catch (SQLException e){
            rd = request.getRequestDispatcher("SQLError.jsp");
            request.setAttribute("er", e.toString());
            rd.forward(request,response);
        }

        catch (Exception e){throw new ServletException(e);}
        rd=request.getRequestDispatcher("/getalltech");
        rd.forward(request,response)
        ;}
        else{rd=request.getRequestDispatcher("/emtyfield");
            rd.forward(request,response);}

    }
}
