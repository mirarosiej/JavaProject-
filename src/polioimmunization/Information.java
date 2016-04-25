/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polioimmunization;


public class Information{ 
    private String PUBLISHSTATE; 
    private String REGION;
    private String GHO; 
    private String WORLDBANKINCOMEGROUP;
    private int YEAR;
    private String COUNTRY; 
   
    public Information(){
       
    }
   
    public int getYEAR(){
       return YEAR; 
    }
    
    public String getCountry(){
        return COUNTRY; 
    }
    
    
    @Override 
    public String toString(){
        return " " + PUBLISHSTATE; 
    }
}

