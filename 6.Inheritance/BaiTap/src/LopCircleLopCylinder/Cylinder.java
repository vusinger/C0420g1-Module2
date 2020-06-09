package LopCircleLopCylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return " Cylinder{ " +
                " height=" + height +
                " Volume=" + this.getVolume()+ " }";
    }

    public static void main(String[] args) {
        Circle hinhtru = new Cylinder(10,"red",10);
        System.out.println(hinhtru.toString());
    }
}
