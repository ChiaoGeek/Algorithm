import java.util.Arrays;

public class BuildMaxHeap {

    public static void maxheap(int[] arr, int i) {
        int length = arr.length;
        int largest = i;
        int left;
        int right;
        while(i >= 1 && i <= length) {
            left = 2 * i;
            right = 2 * i + 1;
            if(left <= length - 1 && arr[left] > arr[i]) {
                largest = left;
            }
            if(right <= length - 1 && arr[right] > arr[largest]) {
                largest = right;
            }
            if(i != largest) {
                int tem = arr[largest];
                arr[largest] = arr[i];
                arr[i] = tem;
                i = largest;

            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 10, 20, 3, 1, 20, 40, 40, 50, 10, 1000, 2000, 50000};
        int length = arr.length;
        for(int i = (length - 1) / 2; i >= 1; i--) {
            maxheap(arr, i);
        }

        System.out.println(Arrays.toString(arr));



    }

}
