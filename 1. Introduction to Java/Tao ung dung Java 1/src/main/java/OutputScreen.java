public class OutputScreen {
    public static void main(String[] args) {
        System.out.printf("Integer : %d\n", 15);
        System.out.printf("Floating point number with 3 decimal digits: %.4f \n", 1.21312939123);
        System.out.printf("Floating point number with 8 decimal digits: %.8f \n", 1.21312939123);
        System.out.printf("String: %s, integer: %d, float: %.6f \n", "Hello World", 89, 9.231435);
        System.out.printf("Re-order output %4$2s %1$2s %3$2s %2$2s \n", "a", "b", "c", "d");
        System.out.printf("%-12s%-12s%s\n", "Column 1", "Column 2", "Column3");
        System.out.printf("%-12d%-12d%07d\n", 15, 12, 5);
        int a = 2 < 3 ? 2:3;
        switch(a){
        case 1: System.out.print("A");
        break;
        case 2:
        System.out.print("B");
        default:
        System.out.print("C");}

        double delta = 5*5-4*1*2;

        if(delta < 0) {

            System.out.println("X");

        } else if(delta == 0) {

            System.out.println("Y");

        } else {

            System.out.println("Z");

        }
    }
}
