package edu_fcc_cs;

public class Rectangle {
    private double llx;
    private double lly;
    private double urx;
    private double ury;

    public Rectangle(double llx, double lly, double urx, double ury){
        this.llx = llx;
        this.lly = lly;
        this.urx = urx;
        this.ury = ury;
    }

    public boolean inRectangle(){
        return true;
    }
    
}
