package minh_hoa_sap_xep_chen;

public class InsertSort {
    public static void main(String[] args) {
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random()*100);
        }
        insertSort(arr,size);
    }

    private static void insertSort(int[] arr, int size) {
        int temp;
        for (int i = 1; i < size; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                } else break;
            }
            showArray(arr, size);
        }
    }

    private static void showArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
