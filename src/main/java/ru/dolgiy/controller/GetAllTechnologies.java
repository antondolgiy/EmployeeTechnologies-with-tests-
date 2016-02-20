package ru.dolgiy.controller;

import ru.dolgiy.model.Technologies;
import ru.dolgiy.model.UserKnowledgeManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public class GetAllTechnologies extends HttpServlet {

    protected void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    try{
        RequestDispatcher rd = null;
        List<Technologies> alltechs=UserKnowledgeManagement.getInstance().getAllTechnologies();
        rd =request.getRequestDispatcher("technolist.jsp");
        request.setAttribute("techlist",alltechs);
        rd.forward(request, response);
        for(Technologies t:alltechs){
            int techID=t.getTechId();
            String techName=t.getTechName();
            String techDescr =t.getTechDescription();
            request.setAttribute("techNo",techID);
            request.setAttribute("techName",techName);
            request.setAttribute("techDescription",techDescr);
        rd.forward(request,response);}

    }
    catch (Exception e){throw new ServletException(e);}
    }



    protected void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        try{
            RequestDispatcher rd = null;
            List<Technologies> alltechs=UserKnowledgeManagement.getInstance().getAllTechnologies();
            rd =request.getRequestDispatcher("technolist.jsp");
            request.setAttribute("techlist",alltechs);
           rd.forward(request, response);
            /*for(Technologies t:alltechs){
                int techID=t.getTechId();
                String techName=t.getTechName();
                String techDescr =t.getTechDescription();
                request.setAttribute("techNo",techID);
                request.setAttribute("techName",techName);
                request.setAttribute("techDescription",techDescr);
                rd.forward(request,response);}
           */


        }
        catch (Exception e){throw new ServletException(e);}
    }

}
