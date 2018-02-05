package PriorityQueue;
import java.util.ArrayList;

public class PriorityQueue {
    ArrayList<Integer[]> arrList;

    public PriorityQueue() {
        this.arrList = new ArrayList<Integer[]>();
    }

    public void percolateUp(int i) {
        while(i > 0 && i < this.arrList.size()) {
            int parent_index = (int) Math.ceil(i/2.0) - 1;
            Integer[] parent_array = this.arrList.get(parent_index);
            Integer[] children_array = this.arrList.get(i);
            if(parent_array[0].intValue() > children_array[0].intValue()) {
                this.arrList.set(parent_index, children_array);
                this.arrList.set(i, parent_array);
                i = parent_index;
            }else {
                break;
            }


        }
    }

    public void minHeap(int i) {
        while(i >= 0 && i < this.arrList.size()) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if(left < this.arrList.size() && this.arrList.get(left)[0].intValue() < this.arrList.get(smallest)[0].intValue()) {
                smallest = left;
            }

            if(right < this.arrList.size() && this.arrList.get(right)[0].intValue() < this.arrList.get(smallest)[0].intValue()) {
                smallest = right;
            }

            if(smallest != i) {
                Integer[] tem = this.arrList.get(i);
                this.arrList.set(i, this.arrList.get(smallest));
                this.arrList.set(smallest, tem);
                i = smallest;
            }else {
                break;
            }

        }
    }

    public void put(int key, int name) {
        Integer[] integerArray = {Integer.valueOf(key), Integer.valueOf(name)};
        this.arrList.add(integerArray);
        this.percolateUp( this.arrList.size() - 1);
    }

    public void changeKey(int key, int name) { // nlgn;
        for (int i = 0; i < this.arrList.size(); i++) {
            if(this.arrList.get(i)[1].intValue() == name) {
                if(this.arrList.get(i)[0].intValue() > key){
                    this.arrList.get(i)[0] = key;
                    this.percolateUp(i);
                    break;
                }

                if(this.arrList.get(i)[0].intValue() < key) {
                    this.arrList.get(i)[0] = key;
                    this.minHeap(i);
                    break;
                }
            }
        }
    }

    public Integer[] pop() {
        Integer[] res = new Integer[2];
        if(this.arrList.size() > 0) {

            res = this.arrList.get(0);
            this.arrList.set(0, this.arrList.get(this.arrList.size() - 1));
            this.arrList.remove(this.arrList.size() - 1);
            this.minHeap(0);

        }
        return res;
    }



}
