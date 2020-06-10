package Colorable;

import Colorable.Shape.Circle;
import Colorable.Shape.Rectangle;
import Colorable.Shape.Shape;
import Colorable.Shape.Square;

public class HamMain {
    public static void main(String[] args) {
        Shape[] arr = new Shape[3];
        arr[0] = new Circle(10);
        arr[1] = new Rectangle(10,20);
        arr[2] = new Square(20);
        for (Shape obj:arr) {
            if (obj instanceof Square) {
                ((Square) obj).howToColor();
            }
            System.out.println(obj.toString());
        }
    }
}
