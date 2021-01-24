
import java.util.*;
import java.io.*;

public class Dijkstra {

    static BufferedReader obj;
    static FileReader fr;
    static String str;
    static StringTokenizer st;

    static int numberOfNodes;
    static String[] nameOfCity;
    static int[][] graph;
    static String n1;
    static String n2;
    static int nodeOne;
    static int nodeTwo;
    static int weight;

    static String s;
    static int min;
    static int minIndex;

    static ArrayList<Integer> visitedList = new ArrayList();
    static int[] distance;
    static int[] parent;
    static int source;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createGraph();
        System.out.println("What is the source node?");
        s = sc.nextLine();
        initializing();
        dijkstra();
        print();
    }

    public static void createGraph() {
        obj = null;
        try {
            fr = new FileReader("lab06.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            st = new StringTokenizer(str, " ");
            numberOfNodes = st.countTokens();
            
            nameOfCity = new String[numberOfNodes];
            for (int i = 0; i < numberOfNodes; i++) {
                nameOfCity[i] = st.nextToken();
            }
            graph = new int[numberOfNodes][numberOfNodes];
            for (int i = 0; i < numberOfNodes; i++) {
                for (int j = 0; j < numberOfNodes; j++) {
                    graph[i][j] = 0;
                }
            }
            int l =0;
            while ((str = obj.readLine()) != null) {
                st = new StringTokenizer(str, "\t");
                n1 = st.nextToken();
                nodeOne = Arrays.asList(nameOfCity).indexOf(n1);
                n2 = st.nextToken();
                nodeTwo = Arrays.asList(nameOfCity).indexOf(n2);
                weight = Integer.parseInt(st.nextToken());
                graph[nodeOne][nodeTwo] = weight;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializing() {
        distance = new int[numberOfNodes];
        parent = new int[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        source = Arrays.asList(nameOfCity).indexOf(s);
        distance[source] = 0;
    }

    public static void update(int x) {
        for (int i = 0; i < numberOfNodes; i++) {
            if ((distance[i] > (distance[x] + graph[x][i])) && (!visitedList.contains(i)) && (graph[x][i] != 0)) {
                distance[i] = graph[x][i];
                parent[i] = x;
            }
        }
    }

    public static void findNodeWithMinimumDistance() {
        for (int i = 0; i < numberOfNodes; i++) {
            if (!visitedList.contains(i)) {
                min = distance[i];
                minIndex = i;
                break;
            }
        }
        for (int i = 0; i < numberOfNodes; i++) {
            if ((!visitedList.contains(i)) && (min > distance[i])) {
                min = distance[i];
                minIndex = i;
            }
        }
        visitedList.add(minIndex);
        update(minIndex);
    }

    public static void dijkstra() {
        update(source);
        visitedList.add(source);
        int temp = 1;
        while (temp < numberOfNodes) {
            findNodeWithMinimumDistance();
            temp++;
        }
    }

    public static void print() {
        for (int i = 0; i < numberOfNodes; i++) {
            System.out.print(nameOfCity[i] + " : distance from source node = " + distance[i] + ", path from source node : ");
            int k = i;
            while (parent[k] > 0) {
                System.out.print(nameOfCity[parent[k]] + ",");
                k = parent[k];
            }
            if (graph[source][k] != 0) {
                System.out.print(nameOfCity[source]);
            }
             System.out.println();
        }
    }
}
