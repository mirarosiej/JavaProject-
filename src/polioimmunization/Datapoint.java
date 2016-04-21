/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polioimmunization;



/**
 * Write a description of class Datapoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Datapoint
{
    private Information dim; 
    private int Value;

    public Datapoint(){
        
    }
    @Override 
    public String toString(){
        return " " + Value + " " + dim; 
    }
}

