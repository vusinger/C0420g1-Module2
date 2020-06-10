package Resizeable;

public class ThucHien {
    public static void main(String[] args) {
        Shape[] arr = new Shape[3];
        arr[0] = new Circle(10);
        arr[1] = new Rectangle(10,20);
        arr[2] = new Square(20);
        for (Shape obj:arr) {
            obj.getSize();
            System.out.println(obj.toString());
        }
        System.out.println("--------After-------");
        for (Shape obj:arr) {
            double size = obj.resize(obj.getSize(),50);
            if (obj instanceof Circle) {
                ((Circle)obj).setSize(size);
            } else if (obj instanceof Rectangle) {
                ((Rectangle)obj).setSize(size);
            } else if (obj instanceof Square) {
                ((Square)obj).setSize(size);
            }
            System.out.println(obj.toString());
        }
    }
}
