import java.util.Arrays;
import java.util.ArrayList;

public class HeapSort {

    public static void maxHeap(ArrayList<Integer> arrList, int i) {
        int size = arrList.size();
        int largest = i;
        int left;
        int right;

        while(i >= 0 && i < size) {
            left  = 2 * (i + 1) - 1;
            right = 2 * (i + 1);

            if(left < size && arrList.get(left) > arrList.get(i)) {
                largest = left;
            }

            if(right < size && arrList.get(right) > arrList.get(largest)) {
//                Integer tem = arrList.get(right).intValue();
//                arrList.set(right, arrList.get(largest));
//                arrList.set(largest, tem);
                largest = right;
            }
            if(largest != i) {
                Integer tem = arrList.get(largest);
                arrList.set(largest, arrList.get(i));
                arrList.set(i, tem);
                i = largest;
            }else {
                break;
            }

        }
    }

    public static void buildHeap(ArrayList<Integer> arrList) {
        int size = arrList.size();
        for(int i = (size / 2) - 1; i >= 0; i--) {
            maxHeap(arrList, i);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 10, 1000, 3, 1, 20, 40, 40, 50, 10, 20, 2000, 50000, 10, 1000, 3, 1, 20, 40, 40, 50, 10, 20, 2000, 50000};
//        int[] arr = { 10};

        ArrayList<Integer> arrToArrayList =new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i++) {
            Integer wrapper = arr[i];
            arrToArrayList.add(wrapper);
        }
        buildHeap(arrToArrayList);


        ArrayList<Integer> resArrList = new ArrayList<Integer>();

        for(int i = arrToArrayList.size() - 1; i > 0; i--) {

            resArrList.add(arrToArrayList.get(0));
            arrToArrayList.set(0, arrToArrayList.get(i));
            arrToArrayList.remove(i);

            maxHeap(arrToArrayList, 0);


        }
        resArrList.add(arrToArrayList.get(0));
        System.out.println(Arrays.toString(resArrList.toArray()));





    }
}
//[0, 50000, 2000, 40, 50, 1000, 10, 40, 1, 10, 20, 20, 3]