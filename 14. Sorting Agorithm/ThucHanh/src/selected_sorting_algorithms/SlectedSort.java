package selected_sorting_algorithms;

class SlectedSort {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        SlectedSort obj = new SlectedSort();
        int size = arr.length;
        obj.selectedSort(arr,size);
        obj.output(arr,size);
    }

    private void output(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    void selectedSort(int[] arr,int size) {
        int min;
        int index;
        for (int i = 0; i < size-1; i++) {
            min = arr[i];
            index = i;
            for (int j = i+1; j < size; j++) {
                if (arr[j]<min) {
                    min = arr[j];
                    index = j;
                }
            }
            min = arr[i];
            arr[i] = arr[index];
            arr[index] = min;
        }
    }
}
