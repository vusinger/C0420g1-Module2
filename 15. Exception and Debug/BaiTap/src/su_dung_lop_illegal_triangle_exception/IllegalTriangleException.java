package su_dung_lop_illegal_triangle_exception;

public class IllegalTriangleException extends Exception {
    private double side = 1.0;

    public IllegalTriangleException(double side) {
        super(side + " is larger than other two combined");
    }
}
