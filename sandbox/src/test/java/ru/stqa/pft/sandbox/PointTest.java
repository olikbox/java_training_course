package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Olga_Verkhovtseva on 5/15/2017.
 */
public class PointTest {

    @Test //позитивный тест
    public void DistanceTestArea () {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(4, 5);
        Assert.assertEquals(p1.distance(p2), 2.8284271247461903);
    }

    @Test //позитивный тест
    public void DistanceTest () {
        Point p1 = new Point(9, 7);
        Point p2 = new Point(5, 4);
        double d = p1.distance(p2);
        Assert.assertEquals(d, 5.0);
    }

    @Test //негативный тест
    public void NegativeDistanceTest () {
        Point p1 = new Point(9, 7);
        Point p2 = new Point(5, 4);
        assert p1.distance(p2)!=26;
    }
}
