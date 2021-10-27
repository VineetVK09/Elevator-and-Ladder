package com.company;

public class Dice {

    public int getnumber(){
        int temp = (Math.random() <= 0.5) ? 1 :2;
        return temp;
    }

    public void print(String n,String h,int points){
        System.out.println(n+" has reached the "+h+" Floor");
        System.out.println("Total Points- "+points);
    }

}

