package edu_fcc_cs;

public class Circle {
    private Point center;
    private double centerX;
    private double centerY;
    private double radius;

    public Circle(Point center, double radius){
        this.center = center;
        this.centerX = center.getX();
        this.centerY = center.getY();
        this.radius = radius;
    }

    public boolean inCircle(Point point){
        double dx = point.getX() - centerX;
        double dy = point.getY() - centerY;
        return dx * dx + dy * dy <= radius * radius;
    }
}
