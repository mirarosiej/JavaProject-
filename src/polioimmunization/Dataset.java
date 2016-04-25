/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polioimmunization;

import polioimmunization.Datapoint;


public class Dataset{
    private Legend[] dimension;
    private Datapoint[] fact;
    
   public Datapoint[] getFact(){
       return fact;
   }
  
}

