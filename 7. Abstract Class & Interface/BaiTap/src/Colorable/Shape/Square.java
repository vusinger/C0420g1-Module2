package Colorable.Shape;

public class Square extends Shape implements Colorable{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void howToColor() {
        System.out.println("Square: Color all four sides");
    }

    @Override
    public double getsize() {
        return this.side*this.side;
    }

    @Override
    public String toString() {
        return "Square Size :"+this.getsize();
    }
}
