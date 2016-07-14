package ru.dolgiy.model;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Anton on 03.11.2015.
 */
public class Users
{

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
