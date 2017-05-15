package ru.stqa.pft.sandbox;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Olga_Verkhovtseva on 5/15/2017.
 */
public class Point {
    public double x; // абсцисса точки
    public double y; // ордината точки


    //Конструктор
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {
        return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
    }
}