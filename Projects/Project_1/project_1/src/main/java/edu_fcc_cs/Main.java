package edu_fcc_cs;
import java.util.Scanner;


public class Main 
{
    public static void main( String[] args )
    {
        Rectangle larger = new Rectangle(new Point(2,3),new Point(24,19));
        Rectangle smaller = new Rectangle(new Point(7,-5),new Point(18,3));
        Circle bigger = new Circle(new Point(17, 12),6);   
        Circle second = new Circle(new Point(11, 1),3);  
        double x = getInput("Please enter the x value: ");
        double y = getInput("Please enter the y value: ");
        Point point = new Point(x, y);
        boolean for_rectangle = larger.inRectangle(point) || smaller.inRectangle(point);
        boolean for_circle = bigger.inCircle(point) || second.inCircle(point);
        boolean inFigure = for_rectangle && !for_circle;
        if(inFigure){
            System.out.println("The point "+ point.getX() + ", " + point.getY() + " is in the Figure");
        }else{
            System.out.println("Your point is not in the Figure");
        }
    }
    public static double getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }
}
