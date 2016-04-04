package ru.dolgiy.model;

/**
 * Created by Anton on 03.11.2015.
 */
public class Technologies
{
    private int techId;
    private String techName;
    private String techDescription;

    public Technologies(){}

    public Technologies(int techId, String techName, String techDescription){
        this.techId=techId;
        this.techName=techName;
        this.techDescription=techDescription;
    }

    public int getTechId(){
        return techId;
    }
    public void setTechId(int techId){
        this.techId=techId;
    }

    public String getTechName(){
        return techName;
    }
    public void setTechName(String techName){
        this.techName=techName;
    }

    public String getTechDescription(){
        return techDescription;
    }
    public void setTechDescription(String techDescription){
        this.techDescription=techDescription;
    }
    public String toString(){
        return "technologia "+techName+" ("+techDescription+") ";
    }
}
