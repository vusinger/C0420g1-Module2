package Resizeable;

public abstract class Shape implements Resizeable {
    public abstract double getSize();
    @Override
    public double resize(double size, double percent) {
        return  size*(1+percent/100);
    }
}
