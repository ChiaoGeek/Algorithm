package PriorityQueue;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PriorityQueueTestor {
    public static void main(String[] args) {

        // initialization
        PriorityQueue p_queue = new PriorityQueue();


        // put
        p_queue.put(10,0);
        p_queue.put(9,1);
        p_queue.put(1,2);
        p_queue.put(0,3);
        p_queue.put(11,4);
        p_queue.put(4,5);
        p_queue.put(4,6);
        p_queue.put(4,7);
        p_queue.put(4,8);


        for (int i = 0; i < p_queue.arrList.size(); i++) {
            System.out.print("{Key: ");
            System.out.print(p_queue.arrList.get(i)[0]);
            System.out.print(", ");
            System.out.print("name: ");
            System.out.print(p_queue.arrList.get(i)[1]);
            System.out.print("}");

        }
        System.out.println("");

        // pop
        p_queue.pop();

        for (int i = 0; i < p_queue.arrList.size(); i++) {
            System.out.print("{Key: ");
            System.out.print(p_queue.arrList.get(i)[0]);
            System.out.print(", ");
            System.out.print("name: ");
            System.out.print(p_queue.arrList.get(i)[1]);
            System.out.print("}");

        }
        System.out.println("");


        // changeKey
        p_queue.changeKey(7, 8);

        for (int i = 0; i < p_queue.arrList.size(); i++) {
            System.out.print("{Key: ");
            System.out.print(p_queue.arrList.get(i)[0]);
            System.out.print(", ");
            System.out.print("name: ");
            System.out.print(p_queue.arrList.get(i)[1]);
            System.out.print("}");

        }
        System.out.println("");



        // minHeap
        ArrayList<Integer[]> origin_array_list = new ArrayList<Integer[]>();


        int[][] insert = {{10, 0}, {2, 1}, {3, 2}, {19, 3}, {20, 4}};

        for (int i = 0; i < insert.length; i++) {
            Integer[] test = {Integer.valueOf(insert[i][0]), Integer.valueOf(insert[i][1])};
            origin_array_list.add(test);
        }

        p_queue.heappify(origin_array_list);

        for (int i = 0; i < origin_array_list.size(); i++) {
            System.out.print("{Key: ");
            System.out.print(p_queue.arrList.get(i)[0]);
            System.out.print(", ");
            System.out.print("name: ");
            System.out.print(p_queue.arrList.get(i)[1]);
            System.out.print("}");

        }
        System.out.println("");


    }
}
