
/**
 *
 * @author Faizun
 */
import java.util.*;
import java.io.*;

public class ConnectedComponents {

    static int[] color;
    static int[] distance;
    static int[] parent;
    static int numberOfVertices;

    static int[][] directedGraph;
    static int source;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the source node?");
        source = sc.nextInt();
        BufferedReader obj = null;
        try {
            String str;
            FileReader fr = new FileReader("final.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            int vertices;
            vertices = Integer.parseInt(str);
            str = obj.readLine();
            int edges;
            edges = Integer.parseInt(str);
            createAdjList(vertices, edges);

            bfsMethod(source);
        } catch (IOException e) {
        }

    }

    static void bfsMethod(int source) {
        numberOfVertices = directedGraph.length;
//        ArrayList<Integer> path[] = new ArrayList[numberOfVertices+1];
//            for(int x =0; x<=numberOfVertices;x++){
//                path[x] = new ArrayList<Integer>();
//            }
        color = new int[numberOfVertices + 1];
        distance = new int[numberOfVertices + 1];
        parent = new int[numberOfVertices + 1];
        Arrays.fill(color, 0);
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        color[source] = 1;//Gray
        distance[source] = 0;
        parent[source] = -1;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        queue.add(source);
        int v;
        int x;
        while (queue.peek() != null) {
            int u = queue.poll();

            x = 1;
            while (directedGraph[u][x] > -1) {
                v = directedGraph[u][x];
                if (color[v] == 0) {
                    color[v] = 1;
                    distance[v] = distance[u] + 1;
                    parent[v] = u;
                    queue.add(v);
                }
                x++;
            }
            color[u] = 2;
        }
        print(color, parent, distance);
    }

    static void print(int[] color, int[] parent, int[] distance) {
        for (int x = 1; x < numberOfVertices; x++) {
            System.out.print(x + " : distance from source - " + distance[x] + ", path -> ");
            for (int y = 0; y < directedGraph[x].length; y++) {
                if (directedGraph[x][y] != -1) {
                    System.out.print(directedGraph[x][y] + ",");
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }

    public static void createAdjList(int vertices, int edge) {
        directedGraph = new int[vertices + 1][vertices + 1];
        BufferedReader obj = null;
        try {
            String str;
            FileReader fr = new FileReader("lab03task01.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            str = obj.readLine();

            for (int x = 0; x <= vertices; x++) {
                directedGraph[x][0] = x; //vertice number
                for (int y = 1; y <= vertices; y++) {
                    directedGraph[x][y] = -1;
                }
            }
            int i = 0;
            while (i < edge) {
                i++;
                str = obj.readLine();
                StringTokenizer st = new StringTokenizer(str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                for (int z = 1; z <= vertices; z++) {
                    if (directedGraph[token1][z] == -1) {
                        directedGraph[token1][z] = token2;
                        break;
                    }
                }

            }
        } catch (IOException e) {
        }
    }
}
