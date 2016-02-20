package ru.dolgiy.model;


import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 01.11.2015.
 */
public class UserKnowledgeManagement {
  /*
    public static void main(String[] args) {

try{



           //UserKnowledgeManagement.getInstance().addNewUser(1234,"hodor","hodor","hodor",
             //      Date.valueOf("01.01.1980"), Date.valueOf("01.01.1995"));
    }
catch (Exception e){System.out.println(e);}

    }
    */


    private static UserKnowledgeManagement instance;

    private static Connection connection;
    //private static UserKnowledgeManagement instance =new UserKnowledgeManagement();
    public UserKnowledgeManagement()throws Exception{
        try
        {
            Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection("jdbc:postgresql:DolgiyDB", "postgres", "123");
        }
        catch (SQLException e){System.out.println(e);}
    }
    public static synchronized UserKnowledgeManagement getInstance()throws Exception
    {
        if (instance==null){instance=new UserKnowledgeManagement();}
        return  instance;}

    public List<Users> getAllUsers()throws SQLException{
        List<Users>userses = new ArrayList();
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT user_id,user_name,user_surname,user_adress,dobirth,dohire FROM users;");
            while (resultSet.next()) {
                Users user = new Users();
                user.setUserId(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                user.setUserSurname(resultSet.getString(3));
                user.setUserAdress(resultSet.getString(4));
                user.setUserDOB(resultSet.getDate(5));
                user.setUserDOH(resultSet.getDate(6));

                userses.add(user);
            }
        }
        finally{
            if(resultSet!=null)resultSet.close();
            if(statement!=null)statement.close();
        }
        return userses;
    }
    public List <Users> getUsersByTechID(int techId)throws SQLException {
        List<Users> usersesOfTech = new ArrayList();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT users.user_id,user_name,user_surname FROM users,skillsofusers WHERE users.user_id=skillsofusers.user_id AND tech_id=?;");
            statement.setInt(1, techId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Users userbyTechID = new Users();
                userbyTechID.setUserId(resultSet.getInt(1));
                userbyTechID.setUserName(resultSet.getString(2));
                userbyTechID.setUserSurname(resultSet.getString(3));
                usersesOfTech.add(userbyTechID);
            }

        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();

        }
        return usersesOfTech;
        }


        public Users getUserokByID(int userId)throws SQLException{

        Users userbyid = new Users();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.prepareStatement("SELECT user_id,user_name,user_surname,user_adress,dobirth,dohire FROM users WHERE user_id=?;");
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                userbyid.setUserId(resultSet.getInt(1));
                userbyid.setUserName(resultSet.getString(2));
                userbyid.setUserSurname(resultSet.getString(3));
                userbyid.setUserAdress(resultSet.getString(4));
                userbyid.setUserDOB(resultSet.getDate(5));
                userbyid.setUserDOH(resultSet.getDate(6));

            }

            }
        finally {
            if(resultSet!=null)resultSet.close();
            if(statement!=null)statement.close();

        }
        return userbyid;



    }
    public Technologies getTechByID(int techId)throws SQLException{

        Technologies techbyid = new Technologies();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.prepareStatement("SELECT tech_id,tech_name FROM technologies WHERE tech_id=?;");
            statement.setInt(1, techId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                techbyid.setTechId(resultSet.getInt(1));
                techbyid.setTechName(resultSet.getString(2));
            }

        }
        finally {
            if(resultSet!=null)resultSet.close();
            if(statement!=null)statement.close();

        }
        return techbyid;



    }

    public List<Technologies>getUserTchnologies(int userId)throws SQLException {
        List<Technologies>technologies=new ArrayList();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement("SELECT technologies.tech_id,technologies.tech_name FROM technologies,skillsofusers " +
                    "WHERE technologies.tech_id=skillsofusers.tech_id AND skillsofusers.user_id =?;");
            statement.setInt(1,userId);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Technologies usertech = new Technologies();
                usertech.setTechId(resultSet.getInt(1));
                usertech.setTechName(resultSet.getString(2));
                technologies.add(usertech);

            }

        }
        finally {
            if(resultSet!=null)resultSet.close();
            if(statement!=null)statement.close();
        }
        return technologies;
    }

    public String getUserTechDescription(int userId)throws SQLException {
        String technologies="";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement("SELECT technologies.tech_id,technologies.tech_name FROM technologies,skillsofusers " +
                    "WHERE technologies.tech_id=skillsofusers.tech_id AND skillsofusers.user_id =?;");
            statement.setInt(1,userId);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Technologies usertech = new Technologies();
                usertech.setTechId(resultSet.getInt(1));
                usertech.setTechName(resultSet.getString(2));
                technologies = technologies+","+usertech.getTechName();

            }

        }
        finally {
            if(resultSet!=null)resultSet.close();
            if(statement!=null)statement.close();
        }
        return technologies;
    }

    public List<Technologies>getUnknownUserTchnologies(int userId)throws SQLException {
        List<Technologies>technologies=new ArrayList();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement("SELECT DISTINCT technologies.tech_id,technologies.tech_name FROM technologies,skillsofusers \n" +
                    "WHERE technologies.tech_id NOT IN (SELECT tech_id FROM skillsofusers WHERE user_id=?);");
            statement.setInt(1,userId);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Technologies usertech = new Technologies();
                usertech.setTechId(resultSet.getInt(1));
                usertech.setTechName(resultSet.getString(2));
                technologies.add(usertech);

            }

        }
        finally {
            if(resultSet!=null)resultSet.close();
            if(statement!=null)statement.close();
        }
        return technologies;
    }


    public List<Technologies>getAllTechnologies()throws SQLException{
        ArrayList<Technologies>alltechs = new ArrayList();
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT tech_id,tech_name,tech_descr FROM technologies;");
            while (resultSet.next()){
                Technologies tech = new Technologies();
                tech.setTechId(resultSet.getInt(1));
                tech.setTechName(resultSet.getString(2));
                tech.setTechDescription(resultSet.getString(3));
                alltechs.add(tech);
            }

        }
        finally {
            if(statement!=null)statement.close();
            if(resultSet!=null)resultSet.close();
        }
        return alltechs;

    }

    public void addNewUser (int a,String name,String surname,String adrez, Date dob, Date doh)throws SQLException{
        PreparedStatement statement = null;
        try {
            statement=connection.prepareStatement("INSERT INTO users (user_id,user_name,user_surname,user_adress,dobirth,dohire)VALUES" +
                "(?,?,?,?,?,?); ");
            statement.setInt(1,a);
            statement.setString(2,name);
            statement.setString(3,surname);
            statement.setString(4,adrez);
            statement.setDate(5,(dob));
            statement.setDate(6,(doh));
            statement.execute();
    }

    finally {
            if (statement!=null)statement.close();
        }

    }

    public void addUserSkill(int userId,int techId)throws SQLException{
        PreparedStatement statement=null;
        try {


            statement = connection.prepareStatement("INSERT INTO skillsofusers(user_id,tech_id) VALUES(?,?); ");
            statement.setInt(1, userId);
            statement.setInt(2,techId);
            statement.execute();
        }
        finally {
            if (statement != null) statement.close();
        }
    }

    public void deleteUserSkill(int userId,int techId)throws SQLException{
        PreparedStatement statement=null;
        try{

        statement= connection.prepareStatement("DELETE FROM skillsofusers WHERE user_id=? AND tech_id=?;");
        statement.setInt(1,userId);
        statement.setInt(2,techId);
        statement.execute();
        }
        finally {
            if(statement !=null)statement.close();
        }
        }


    public void  deleteUser(int userId)throws SQLException{
        PreparedStatement statement =null;
        try{
            statement = connection.prepareStatement("DELETE FROM users WHERE user_id=?;");
            statement.setInt(1,userId);
            statement.execute();
        }
        finally {
            if(statement!=null)statement.close();
        }

    }
    public void updateUser(int userId,String name,String surname,String adrez,Date dob, Date doh)throws SQLException{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("UPDATE users SET user_name=?,user_surname=?,user_adress=?,dobirth=?,dohire=? WHERE user_id = ?;");
            statement.setString(1,name);
            statement.setString(2,surname);
            statement.setString(3,adrez);
            statement.setDate(4,dob);
            statement.setDate(5,doh);
            statement.setInt(6,userId);
            statement.execute();
        }
        finally {
            if(statement!=null)statement.close();
        }
        }


    public void addNewTechnology(int a,String b,String c)throws SQLException{
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement("INSERT INTO technologies(tech_id,tech_name,tech_descr) VALUES (?,?,?);");
            statement.setInt(1,a);
            statement.setString(2,b);
            statement.setString(3, c);
            statement.execute();
        }
        finally {
            if(statement!=null)statement.close();
        }


    }
    public void deleteTechnology(int techId)throws SQLException{
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement("DELETE FROM technologies WHERE tech_id=?;");
            statement.setInt(1,techId);
            statement.execute();
        }
        finally {
            if(statement!=null)statement.close();
        }

    }



}
