package com.company;
import java.util.*;



public class Main{

    public static void main(String[] args) {
        int count=0;
        int counter=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("##  Welcome to the COWIN App menu  ##");
        System.out.println("1.Add Vaccine");
        System.out.println("2.Register Hospital( Maximum 2 )");
        System.out.println("3.Register Citizen");
        System.out.println("4.Add Slot for Vaccination");
        System.out.println("5.Book Slot for Vaccination");
        System.out.println("6.List all slots for a hospital");
        System.out.println("7.Check Vaccination Status");
        System.out.println("8.Exit");
        System.out.println("Vaccine Needs To be Registered First: Please press 1");
        System.out.println("After Vaccine Registration  Hospital registration needs to be done");

        Vaccine vc = new Vaccine();
        Hospital hs = new Hospital();
        while(true) {
            System.out.println("------------------------------------");
            System.out.print("Choose one option: ");
            String n = sc.nextLine();
            if (n.equals("8")) {
                break;
            } else if (n.equals("1")) {
                for(int j=0; j<2; j++){
                    if(counter<2){
                System.out.println("--------Add Vaccine--------");
                counter++;
                vc.addvaccine();
                    }else{
                        System.out.println("The Vaccines are Registered ");
                    }
                }
            } else if (n.equals("2")) {
                for(int i=0; i<2;i++) {
                    if (count < 2) {
                        System.out.println("--------Register Hospital-------");
                        count++;
                        hs.register();
                    } else {
                        System.out.println("Cannot select again");
                    }
                }

            }else if(n.equals("4"))
            {
                hs.addslot();
            }
            else if (n.equals("6")) {
                hs.listofslot();

            }
            else if(n.equals("3")){
                hs.registercitizen();
            }
            else if(n.equals("5")){
                hs.bookslot();
            }
            else if(n.equals("7")){
                hs.vaccinestatus();
            }
        }


    }
}
