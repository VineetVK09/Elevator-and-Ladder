package com.company;
import java.util.*;

public class Citizen {
    String name;
    int age;
    String id;


    Scanner sc = new Scanner(System.in);

    public void registercitizen()
    {
        System.out.print("Citizen Name: ");
        this.name = sc.nextLine();
        System.out.print("Age: ");
        this.age = sc.nextInt();
        System.out.println("Unique ID: ");
        this.id = sc.nextLine();
        if(this.age>=18) {
            System.out.println("Citizen Name: " + this.name + ", " + "Age: " + this.age + ", " + "Unique ID: " + this.id);
        }
        else{
            System.out.println("Only above 18 are allowed");

        }


    }
}
