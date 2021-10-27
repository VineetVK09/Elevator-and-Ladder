package com.company;

import java.util.Scanner;

public class Game extends Dice {
    private String name;

    public void start(){
        Scanner sc = new Scanner(System.in);
        Dice d = new Dice();
        Promotion p = new Promotion();
        Demotion dem = new Demotion();

        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13};

        int count = 0;
        int i=-1;
        int point=0;
        System.out.println("Enter The Player Name and hit Enter:");
        name = sc.nextLine();
        System.out.println("The Game setup is Ready");

        while(i<14){

            if(i==13)
                break;

            System.out.println("Hit Enter to Roll the Dice");
            sc.nextLine();
            int t=d.getnumber();
            System.out.println("Dice gave "+t);
            if(t==2 && count==0){
                System.out.println("Game cannot start until you get 1");
                continue;
            }else if(t==1 && count==0){
                count++;
            }

            if(t==1){
                i++;
                if(i==2){
                    System.out.println("Player position Floor- "+arr[i]);
                    i= p.elevator(i);
                    point= p.ladderpoint(point);
                    print(name,"Elevator",point);

                }

                else if(i==5){
                    System.out.println("Player position Floor- "+arr[i]);
                    i=dem.snake(i);
                    point = dem.snakepoint(point);
                    print(name,"Snake",point);
                }

                else if(i==8){
                    System.out.println("Player position Floor- "+arr[i]);
                    i=p.ladder(i);
                    point = p.ladderpoint(point);
                    print(name,"Ladder",point);
                }
                else if(i==11){
                    System.out.println("Player position Floor- "+arr[i]);
                    i=dem.snake(i,8);
                    point=dem.snakepoint(point,4);
                    print(name,"KING COBRA",point);
                }


                System.out.println("Player position Floor- " + arr[i]);
                System.out.println(name + " has reached an Empty Floor");
                point++;
                System.out.println("Total points = "+point);
                System.out.println();


            }
            else if(t==2){
                if(i==12){
                    System.out.println("Player cannot move");
                    continue;
                }
                i=i+2;
                if(i==2){
                    System.out.println("Player position Floor- "+arr[i]);
                    i= p.elevator(i);
                    point= p.ladderpoint(point);
                    print(name,"Elevator",point);

                }

                else if(i==5){
                    System.out.println("Player position Floor- "+arr[i]);
                    i=dem.snake(i);
                    point = dem.snakepoint(point);
                    print(name,"Snake",point);
                }

                else if(i==8){
                    System.out.println("Player position Floor- "+arr[i]);
                    i=p.ladder(i);
                    point = p.ladderpoint(point);
                    print(name,"Ladder",point);
                }
                else if(i==11){
                    System.out.println("Player position Floor- "+arr[i]);
                    i=dem.snake(i,8);
                    point=dem.snakepoint(point,4);
                    print(name,"KING COBRA",point);
                }


                System.out.println("Player position Floor- " + arr[i]);
                System.out.println(name + " has reached an Empty Floor");
                point++;
                System.out.println("Total points = "+point);
                System.out.println();


            }


        }
        System.out.println("GAME OVER");
        System.out.println(name+" accumulated "+point+ " points");






    }
}


