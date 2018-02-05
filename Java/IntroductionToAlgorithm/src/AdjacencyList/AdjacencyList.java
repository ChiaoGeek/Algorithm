package AdjacencyList;

public class AdjacencyList {
    private int vertext_num;
    private int edge_num;

    public Vertex[] graph;


    public AdjacencyList(int vertext_num, int edge_num) {
        this.vertext_num = vertext_num;
        this.edge_num = edge_num;
        this.graph = new Vertex[this.vertext_num];
        for(int i = 0; i < this.graph.length; i++) {
            this.graph[i] = new Vertex();
            this.graph[i].vertex_name = i ;
            this.graph[i].next = null;
        }

    }

    public void addEdgeWeight(String str) { // 0->1*2->2*2
        String[] strArray = str.split("->");
        int vertex_name = Integer.parseInt(strArray[0]);
        for(int i = 1; i < strArray.length; i++) {
            Edge q = this.graph[vertex_name].next;
            if(q == null) {
                this.graph[vertex_name].next = new Edge();
                String[] ad_weight = strArray[i].split("w");
                this.graph[vertex_name].next.adjacency_vertex_name = Integer.parseInt(ad_weight[0]);
                this.graph[vertex_name].next.weight = Integer.parseInt(ad_weight[1]);
                this.graph[vertex_name].next.next = null;
            }else {
                while(q != null){
                    if(q.next != null) {
                        q = q.next;
                    }else {
                        break;
                    }
                }
                q.next = new Edge();
                String[] ad_weight = strArray[i].split("w");
                q.next.adjacency_vertex_name = Integer.parseInt(ad_weight[0]);
                q.next.weight = Integer.parseInt(ad_weight[1]);
                q.next.next = null;

            }


        }
    }
}
