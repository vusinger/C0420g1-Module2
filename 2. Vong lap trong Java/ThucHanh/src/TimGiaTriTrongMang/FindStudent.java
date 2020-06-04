package TimGiaTriTrongMang;

public class FindStudent {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 15, 6, 9, 3, 10};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }
    public static int minValue(int[] array){
        int index = 0;
        for (int i=0;i<array.length;i++) {
            if (array[index]>array[i]) {
                index = i;
            }
        }
        return index;
    }
}
