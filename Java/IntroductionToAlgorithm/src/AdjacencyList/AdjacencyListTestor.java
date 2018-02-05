package AdjacencyList;

public class AdjacencyListTestor {
    public static void main(String[] args) {
        AdjacencyList ad_list = new AdjacencyList(6,6);

        ad_list.addEdgeWeight("0->1w1->2w2");
        ad_list.addEdgeWeight("1->2w9->3w3");
        ad_list.addEdgeWeight("3->2w4->4w13->5w15");
        ad_list.addEdgeWeight("4->5w4");


        for(int i = 0; i < ad_list.graph.length; i++) {
            Edge q = ad_list.graph[i].next;
            System.out.print(ad_list.graph[i].vertex_name);
            while(q != null) {
                System.out.print("->");
                System.out.print(q.adjacency_vertex_name);
                System.out.print("|");
                System.out.print(q.weight);
                q =  q.next;
            }
            System.out.println("");

        }
    }
}
