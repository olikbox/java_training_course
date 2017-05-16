package ru.stqa.pft.sandbox;

public class MyFirstProgram1 {
    public static void main(String[] args) {
        System.out.println("Hello!");

        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);

        System.out.println("Расстояние между двумя точками равняется " +p1.distance(p2));
    }

//Moved to Point.java

   // public static double distance(Point p1,Point p2) {
       // return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.x - p1.x));
   // }


}



	