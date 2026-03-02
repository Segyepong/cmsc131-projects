package edu_fcc_cs;

public class Rectangle {
    private Point lleft;
    private Point uright;

    public Rectangle(Point lleft, Point uright){
        this.lleft = lleft;
        this.uright = uright;
    }


    public boolean inRectangle(Point point){
        double x = point.getX();
        double y = point.getY();
        if(x >= lleft.getX() && x<= uright.getX() && y >= lleft.getY() && y <= uright.getY()){
            return true;
        }else{
            return false;
        }
    }
    
}
