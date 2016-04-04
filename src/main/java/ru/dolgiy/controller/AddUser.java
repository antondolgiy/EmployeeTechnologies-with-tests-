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
public class AddUser extends HttpServlet {

    //int a,String name,String surname,String adrez, Date dob, Date doh
    protected void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        if(request.getParameter("userID")!=""&&request.getParameter("userID")!=null&&
         request.getParameter("userName")!="" &&request.getParameter("userName")!=null&&
         request.getParameter("userSurname")!="" &&request.getParameter("userSurname")!=null&&
         request.getParameter("DateofBirth")!="" &&request.getParameter("DateofBirth")!=null&&
         request.getParameter("DateofHire")!="" &&request.getParameter("DateofHire")!=null)
         {

        int a = Integer.parseInt(request.getParameter("userID"));
        String name = request.getParameter("userName");
        String surname = request.getParameter("userSurname");
        String adrez = request.getParameter("userAdress");
        Date dob = Date.valueOf(request.getParameter("DateofBirth"));
        Date doh =Date.valueOf(request.getParameter("DateofHire"));
        try{
            UserKnowledgeManagement.getInstance().addNewUser(a, name, surname, adrez, dob, doh);}
        catch (SQLException e){
            rd = request.getRequestDispatcher("SQLError.jsp");
            request.setAttribute("er", e.toString());
            rd.forward(request,response);
        }
        catch (Exception e){throw new ServletException(e);}
        rd =request.getRequestDispatcher("/getallusers");
        rd.forward(request,response);}
        else{rd=request.getRequestDispatcher("/emtyfield");
            rd.forward(request,response);}
    }


}
