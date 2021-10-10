package com.company;
import java.util.*;

public class Hospital {
    String name;
    String pin;
    String id;
    String hid;
    String any;
    String name1;
    String bookid;
    int age;
    String id1;
    int slot;
    int quantity;
    int count=0;



     HashMap<String, String> namepin = new HashMap(); // key,value of hospital name and pin code
     HashMap<String, String> pinname = new HashMap(); // key,value of pin code and hospital name
     HashMap<String, String> pinid = new HashMap(); // key,value of pin code and hospital id
     HashMap<String, String> nameid = new HashMap(); // key,value of hospital name and unique id
     HashMap<String, String> idname = new HashMap(); // key,value of unique id and hospital name
     HashMap<String, Integer> hqcovax = new HashMap(); // key,value of hospital unique id and quantity for covax
     HashMap<String, Integer> hqcovi = new HashMap(); // key,value of hospital unique id and quantity for covi
     HashMap<String, Integer> patientstate = new HashMap(); // key,value of patient id  and status of vaccination(0,1,2)
     HashMap<String, String> patientidname = new HashMap(); // key,value of patient id  and their name
     HashMap<String, String> idvaccine = new HashMap(); // key,value of patient id  and the vaccine they are getting

     int[] covax={0,0};
     int[] covi={0,0};
     Scanner sc = new Scanner(System.in);

    public void register(){
        String a ="123456";
        String b ="789012";

        sc.nextLine();
        System.out.print("Hospital Name: ");
        this.name = sc.nextLine();
        System.out.print("6-Digit Pincode: ");
        this.pin = sc.nextLine();
        namepin.put(this.name,this.pin);
        pinname.put(this.pin,this.name);


        count++;
        if(count==1) {
            System.out.println("Hospital Name: " + this.name + ", " + "Pincode: " + this.pin + ", " + "Unique id: " + a);
            nameid.put(this.name,a);
            idname.put(a,this.name);
            pinid.put(this.pin,a);
        }
        if(count==2){
            System.out.println("Hospital Name: " + this.name + ", " + "Pincode: " + this.pin + ", " + "Unique id: " + b);
            nameid.put(this.name,b);
            idname.put(b,this.name);
            pinid.put(this.pin,b);

        }
    }

    public void addslot()
    {   sc.nextLine();
        System.out.print("Enter Hospital ID: ");
        this.hid=sc.nextLine();
        if(nameid.containsValue(this.hid)) {
            System.out.print("Enter number of slots to be added: ");
            this.slot = sc.nextInt();
            for (int i = 0; i < this.slot; i++) {
                System.out.print("Enter Day Number: ");
                int d = sc.nextInt();
                System.out.print("Enter Quantity: ");
                this.quantity = sc.nextInt();

                System.out.println("Select Vaccine");
                System.out.println("0. Covax");
                System.out.println("1. Covi");
                int s = sc.nextInt();
                if (s == 0) {
                    covax[0] = covax[0] + this.quantity;
                    System.out.println("Slot added by Hospital " + this.hid + " " + "for Day: " + d + ", " + "Available Quantity: " + this.quantity + " " + "of Vaccine Covax");
                    hqcovax.put(this.hid, covax[0]);
                } else if (s == 1) {
                    covi[0] = covi[0] + this.quantity;
                    System.out.println("Slot added by Hospital " + this.hid + " " + "for Day: " + d + ", " + "Available Quantity: " + this.quantity + " " + "of Vaccine Covi");
                    hqcovi.put(this.hid, covi[0]);
                }

            }
        }else{
            System.out.println("Hospital not registered");
        }



    }


    public void listofslot()
    {   sc.nextLine();
        System.out.println("Enter hospital id(123456 or 789012): ");
        String h = sc.nextLine();
        if(nameid.containsValue(h)) {
            if (h.equals("123456")) {
                System.out.println("Day of Firts slot- Vaccine: Covax Available Qty: " + hqcovax.get("123456"));
                System.out.println("Day of Second slot- Vaccine: Covi Available Qty: " + hqcovi.get("123456"));
            } else if (h.equals("789012")) {
                System.out.println("Day of Firts slot- Vaccine: Covax Available Qty: " + hqcovax.get("789012"));
                System.out.println("Day of Second slot- Vaccine: Covi Available Qty: " + hqcovi.get("789012"));
            }
        }
        else
        {
            System.out.println("ID not found");
        }



    }

    public void registercitizen()
    {
        sc.nextLine();
        System.out.print("Citizen Name: ");
        this.name1 = sc.nextLine();
        System.out.print("Unique ID (12-digit): ");
        this.id1 = sc.nextLine();
        System.out.print("Age: ");
        this.age = sc.nextInt();

        if(this.age>=18) {
            patientstate.put(this.id1,0);
            patientidname.put(this.id1,this.name1);
            System.out.println("Citizen Name: " + this.name1 + ", " + "Age: " + this.age + ", " + "Unique ID: " + this.id1);
        }
        else{
            System.out.println("Only above 18 are allowed");

        }


    }

    public void bookslot()
    {   sc.nextLine();
        System.out.print("Enter patient unique id: ");
        this.bookid = sc.nextLine();
        if(patientidname.containsKey(this.bookid)){
            System.out.println("1. Search by area");
            System.out.println("2. Search by Vaccine");
            System.out.println("3. Exit");
            System.out.print("Enter option: ");
            int t = sc.nextInt();
            if(t!=3) {
                if (t == 1) {
                    sc.nextLine();
                    System.out.print("Enter Pincode: ");
                    String pin = sc.nextLine();
                    if (namepin.containsValue(pin)) {
                        System.out.println(pinid.get(pin) + " " + pinname.get(pin));
                        System.out.println("Enter Hospital ID: ");
                        String g = sc.nextLine();
                        System.out.println("0. Day1  Available Qty: " + hqcovax.get(g) + " Vaccine : Covax");
                        System.out.println("1. Day2  Available Qty: " + hqcovi.get(g) + " Vaccine : Covi");
                        System.out.print("Choose slot: ");
                        int l = sc.nextInt();
                        if (l == 0) {
                            System.out.println(patientidname.get(this.bookid) + " Vaccinated with Covax");
                            if (patientstate.get(this.bookid) == 0)
                                patientstate.put(this.bookid, 1);
                            else if (patientstate.get(this.bookid) == 1)
                                patientstate.put(this.bookid, 2);
                            idvaccine.put(this.bookid, "Covax");

                        } else if (l == 1) {
                            System.out.println(patientidname.get(this.bookid) + " Vaccinated with Covi");
                            patientstate.put(this.bookid, 2);
                            idvaccine.put(this.bookid, "Covi");


                        }
                    } else {
                        System.out.println("Hospital not found");
                    }
                } else if (t == 2) {
                    sc.nextLine();
                    System.out.print("Enter Vaccine name: ");
                    String vaccine = sc.nextLine();
                    System.out.println("123456 " + idname.get("123456"));
                    System.out.println("789012 " + idname.get("789012"));
                    System.out.print("Enter hospital ID: ");
                    String idi = sc.nextLine();
                    if (vaccine.equalsIgnoreCase("Covax")) {
                        if (hqcovax.get(idi) == 0) {
                            System.out.println("NO slots available");
                        } else {
                            System.out.println("Available Qty: " + hqcovax.get(idi) + " Vaccine: Covax");
                            System.out.println(patientidname.get(this.bookid) + " Vaccinated with Covax");
                            if (patientstate.get(this.bookid) == 0)
                                patientstate.put(this.bookid, 1);
                            else if (patientstate.get(this.bookid) == 1)
                                patientstate.put(this.bookid, 2);
                            idvaccine.put(this.bookid, "Covax");


                        }


                    } else if (vaccine.equalsIgnoreCase("Covi")) {
                        if (hqcovi.get(idi) == 0) {
                            System.out.println("NO slots available");
                        } else {
                            System.out.println("Available Qty: " + hqcovi.get(idi) + " Vaccine: Covi");
                            System.out.println(patientidname.get(this.bookid) + " Vaccinated with Covi");
                            patientstate.put(this.bookid, 2);
                            idvaccine.put(this.bookid, "Covi");
                        }
                    }else{
                        System.out.println("Vaccine not found");
                    }


                }
            }
            }else{
            System.out.println("ID not found");

        }

        }


        public void vaccinestatus(){
            sc.nextLine();
            System.out.print("Enter patient ID: ");
            String vcid = sc.nextLine();
            if(patientstate.containsKey((vcid))){
                if(patientstate.get(vcid)==0)
                    System.out.println("Citizen Registered");
                else if(patientstate.get(vcid)==1){
                    System.out.println("PARTIALLY VACCINATED");
                    System.out.println("Vaccine given: Covax");
                    System.out.println("Number of doses given: 1");
                    System.out.println("Next Dose due date: 7 days after the previous dose");

                }
                else if(patientstate.get(vcid)==2){
                    System.out.println("FULLY VACCINATED");
                    if(idvaccine.containsValue("Covax")){
                        System.out.println("Vaccine Given: Covax");
                        System.out.println("Number of Doses given: 2");
                    }
                    else if(idvaccine.containsValue("Covi")){
                        System.out.println("Vaccine Given: Covi");
                        System.out.println("Number of Doses given: 1");
                    }
                }
            }else{
                System.out.println("Citizen not Registered");
            }


        }
    }
