package ru.dolgiy.model;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Anton on 03.11.2015.
 */
public class Users
{
/*
    public static void main(String[] args) {
        Users userok = null;
        Users usero4ek=null;
        try {
             userok = new Users(1033,"Furmanov","Dmitriy","USSR",new java.util.Date(1978,8,11),new java.util.Date(2014,4,1));

             usero4ek = new Users(1034,"Furmanoff","Dimon","USSR",new SimpleDateFormat("yyyy.MM.dd").parse("1978.09.11"),
                    new SimpleDateFormat("yyyy.MM.dd").parse("2014.05.01"));

        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println(userok.toString());
       System.out.println(usero4ek.toString());
    }
*/
    private int userId;
    private String userName;
    private String userSurname;
    private String userAdress;
    private Date userDOB;
    private Date userDOH;

    public Users(){}

    public Users(int userId, String userName, String userSurname, String userAdress)
    {   this.userId=userId;
        this.userName=userName;
        this.userSurname=userSurname;
        this.userAdress=userAdress;

    }

    public Users(int userId, String userName, String userSurname, String userAdress, Date userDOB, Date userDOH)
    {   this.userId=userId;
        this.userName=userName;
        this.userSurname=userSurname;
        this.userAdress=userAdress;
        this.userDOB = userDOB;
        this.userDOH =userDOH;
    }

    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId)
    {this.userId=userId;}

    public String getUserName(){
    return userName;
}
    public void setUserName(String userName){
        this.userName=userName;
    }

    public String getUserSurname(){
        return userSurname;
    }
    public void setUserSurname(String userSurname){
        this.userSurname=userSurname;
    }

    public String getUserAdress(){
        return userAdress;
    }
    public void setUserAdress(String userAdress){
        this.userAdress=userAdress;
    }

    public Date getDateOfBirth() {
        return userDOB;}
    public void setUserDOB(Date userDOB)
    {this.userDOB = userDOB;}

    public Date getDateOfHire()
    {return userDOH;}
    public void setUserDOH(Date userDOH)
    {this.userDOH =userDOH;}

    public String toString(){
        return "id"+userId+" "+userName+" "+userSurname+" adress:"+userAdress+" born:"+ DateFormat.getDateInstance(DateFormat.SHORT).format(userDOB)+
           " at service since:"+ DateFormat.getDateInstance(DateFormat.SHORT).format(userDOH);
    }



}
