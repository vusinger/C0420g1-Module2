package TimGiaTrinhoNhatTrongMang;

public class FindMinValue {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + index);
    }

    public static int minValue(int[] arr) {
        int small = arr[0];
        for (int index : arr) {
            if (small > index) { small = index;}
        }
        return small;
    }
}
