package dsa.graph;

import java.util.*;

class Edge {
    int src, dest;

    public Edge(int s, int d) {
        this.src = s;
        this.dest = d;
    }
}

public class Graph {
    /************************************************************
     * CREATE GRAPH
     *************************************************************/
    void createGraph(ArrayList<Edge> graph[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Enter number of connections for " + i + ": ");
            int c = sc.nextInt();
            for (int j = 0; j < c; j++) {
                System.out.print("Enter connection for node " + i + ": ");
                graph[i].add(new Edge(i, sc.nextInt()));
            }
        }
    }

    /************************************************************
     * TRAVERSAL
     **********************************************************************/

    void printEdges(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                System.out.println(e.src + " -> " + e.dest);
            }
        }
    }

    void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (Edge e : graph[cur]) {
                if (!vis[e.dest]) {
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }
        }
    }

    void dfs(ArrayList<Edge> graph[], int cur, boolean vis[]) {
        if (vis[cur])
            return;
        System.out.print(cur + " ");
        vis[cur] = true;
        for (Edge e : graph[cur]) {
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    /*************************************************
     * CHECKS WHETHER PATH EXISTS OR
     * NOT*********************************************************
     */
    void printAllPaths(ArrayList<Edge> graph[], int start, int target, String path, boolean vis[]) {
        if (start == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[start].size(); i++) {
            Edge e = graph[start].get(i);
            if (!vis[e.dest]) {
                vis[start] = true;
                printAllPaths(graph, e.dest, target, path + "->" + e.dest, vis);

            }
        }
        vis[start] = false;
    }

    /*************************************************************
     * DETECTS CYCLE
     ******************************************************************/
    void detectCycle(ArrayList<Edge> graph[], int V) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Directed\n2.Undirected");
        int dec = sc.nextInt();
        int count = 0;
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        boolean res = false;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dec == 1) {
                    res = isCycle(graph, i, vis, rec);
                } else {
                    res = isCycleUn(graph, i, -1, vis);
                }
                if (res) {
                    System.out.println("isCycle");
                    count++;
                    break;
                }
            }

        }
        if (count == 0) {
            System.out.println("no cycle detected");
        }

    }

    // cycle detection in directed graphs

    boolean isCycle(ArrayList<Edge> graph[], int cur, boolean[] vis, boolean[] rec) { // directed
        vis[cur] = true; // taking any element and then traversing its neighbours to find whether the
                         // cycle exists or not
        rec[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) { // traversing all the neighbours of the cur
            Edge e = graph[cur].get(i);
            if (rec[e.dest]) { // if an element already is in rec then cycle
                return true;
            }
            if (!vis[e.dest] && isCycle(graph, e.dest, vis, rec)) { // returns the status of the neighbour nodes
                return true;
            }

        }
        rec[cur] = false; // if any element is not contibuting in the cycle then backtracked
        return false;
    }

    // cycle detection in undirected graphs

    boolean isCycleUn(ArrayList<Edge> graph[], int cur, int par, boolean[] vis) { // just check whether the visited node
                                                                                  // is not parent
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (vis[e.dest] && e.dest != par) {
                return true;
            } else if (!vis[i]) {
                if (isCycleUn(graph, e.dest, cur, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*************************************************
     * TOPOLOGICAL SORTING
     *******************************************************************/
    void topsort(ArrayList<Edge> graph[], int V) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) { // start from the first node and helps in disconnected graphs
                topS(graph, vis, st, i);
            }
        }
        while (!st.isEmpty()) { // then the stack will be printed
            System.out.print(st.pop() + " ");
        }
    }

    void topS(ArrayList<Edge> graph[], boolean[] vis, Stack<Integer> st, int cur) {
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) { // if cur has neighbours then this loop will be called
            Edge e = graph[cur].get(i);
            if (!vis[e.dest]) { // if the neighbours are non visited then the func will be called
                topS(graph, vis, st, e.dest);
            }
        }
        st.push(cur); // if the cur has no non-visited nodes,then the cur will be pushed into the
                      // stack
    }

    /*
     * void topK(ArrayList<Edge> graph[],int V){
     * HashMap<Integer,Integer> indegree=new HashMap<>();
     * for(int i=0;i<V;i++){
     * for(int j=0;j<graph[i].size();j++){
     * indegree.put(graph[])
     * }
     * }
     * }
     */
    /*******************************************************
     * MAIN CLASS
     ***************************************************************************/

    public static void main(String[] args) {
        Graph g = new Graph();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[V];
        g.createGraph(graph); // graph creation

        System.out.println("Edges:");
        g.printEdges(graph); // traversal

        System.out.println("Topological Sort"); // topological sorting
        g.topsort(graph, V);

        boolean vis[] = new boolean[V]; // traversal
        Arrays.fill(vis, false);
        System.out.println("BFS Traversal:");
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                g.bfs(graph, V, vis, i);
            }
        }

        Arrays.fill(vis, false);
        System.out.println("\nDFS Traversal:");
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                g.dfs(graph, i, vis);
            }
        }

        // path traversal from starting node to ending node

        Arrays.fill(vis, false);
        System.out.println("\nenter the start and target node");
        int start = sc.nextInt();
        String st = Integer.toString(start);
        g.printAllPaths(graph, start, sc.nextInt(), st, vis);
        g.detectCycle(graph, V);
        sc.close();
    }
}
