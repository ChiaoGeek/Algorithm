import java.util.ArrayList;
import AdjacencyList.*;
import PriorityQueue.*;
import java.lang.Integer;

import static java.lang.Integer.*;


public class Dijkstra {

    public static ArrayList<Integer[]> calculate(int index, Vertex[] graph) {
        ArrayList<Integer[]> origin_array_list = new ArrayList<Integer[]>();
        int[] res = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            int key = Integer.MAX_VALUE;
            int name = i;
            Integer[] add_value = {valueOf(key), valueOf(name)};
            origin_array_list.add(add_value);
        }

        int main_index_key = 0;
        int main_index_name = index;
        Integer[] main_index = {valueOf(main_index_key), valueOf(main_index_name)};
        origin_array_list.set(index, main_index);

        Edge p = graph[index].next;
        while (p != null) {
            int change_main_connect_key = p.weight;
            int change_main_connect_name = p.adjacency_vertex_name;
            Integer[] change_main = {valueOf(change_main_connect_key), valueOf(change_main_connect_name)};
            origin_array_list.set(change_main_connect_name, change_main);
            p = p.next;
        }



        // heapify
        PriorityQueue q_queue = new PriorityQueue();
        q_queue.heappify(origin_array_list);
//        q_queue.arrList;



        ArrayList<Integer[]> S = new ArrayList<Integer[]>();

        while (q_queue.arrList.size() > 0) {

            Integer[] pop_value = q_queue.pop(); //extract min
            S.add(pop_value);

            Edge x = graph[pop_value[1].intValue()].next;
            while(x != null){
                for(int m = 0; m < q_queue.arrList.size(); m++) {
                    Integer[] tem = q_queue.arrList.get(m);
                    if (tem[1].intValue() == x.adjacency_vertex_name) {
                        if (tem[0].intValue() > (pop_value[0].intValue() + x.weight)) {
                            q_queue.changeKey(pop_value[0].intValue() + x.weight, tem[1].intValue());
                        }
                        break;
                    }

                }

                x = x.next;

            }


        }

        return S;
    }

    public static void main(String[] args) {

        AdjacencyList ad_list = new AdjacencyList(6,9);

        ad_list.addEdgeWeight("0->1w1->2w12");
        ad_list.addEdgeWeight("1->2w9->3w3");
        ad_list.addEdgeWeight("2->4w5");
        ad_list.addEdgeWeight("3->2w4->4w13->5w15");
        ad_list.addEdgeWeight("4->5w4");

        ArrayList<Integer[]> res = calculate(0, ad_list.graph);

        for (int i = 0; i < res.size(); i++) {
            System.out.print("{Key: ");
            System.out.print(res.get(i)[0]);
            System.out.print(", ");
            System.out.print("name: ");
            System.out.print(res.get(i)[1]);
            System.out.print("}");

        }

    }
}
