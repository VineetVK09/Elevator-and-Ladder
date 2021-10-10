package com.company;
import java.util.*;

public class Vaccine {
    String vaccine;
    int dose;
    int gap;



    public void addvaccine(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Vaccine Name(Covax or Covi): ");
        this.vaccine=sc.nextLine();
        if(this.vaccine.equalsIgnoreCase("Covax")) {
            System.out.println("Number of doses: 2");
            System.out.println("Gap between Doses: 7 Days");
            System.out.println("Vaccine Name: "+this.vaccine+", " + "Number of Doses: 2" + ", " + "Number of Gap: 7 Days");
        }
        else if(this.vaccine.equalsIgnoreCase("Covi")){
            System.out.println("Number of Doses: 1");
            System.out.println("Vaccine Name: "+this.vaccine+", " + "Number of Doses: 1");
        }


    }


}
