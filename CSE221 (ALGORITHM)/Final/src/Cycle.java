/**
 *
 * @author 17201003
 */

import java.io.*;
import java.util.*;
public class Cycle{

    static BufferedReader obj;
    static FileReader fr;
    static String str;
    static StringTokenizer st;

    static int numberOfNodes;
    static String[] nameOfCity;
    static int[][] graph;
    static int[][] weightGraph;

    static boolean bool;
    static int min;
    static int minIndex;
    static int temp;

    static ArrayList<Integer> visitedList = new ArrayList();
    static int size;
    static String edge;
    static String edge2;
    static int node1;
    static int node2;
    static int cost;

    static int index;
    static boolean checkB = false;
    
    public static void main(String[] args) {
        graph();
        sortGraph();
        kruskal();
        print();
    }

    public static void graph() {
        obj = null;
        try {
            fr = new FileReader("input2.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            st = new StringTokenizer(str, " ");
            numberOfNodes = st.countTokens();
            // Creating an array to store the name of the cities
            nameOfCity = new String[numberOfNodes];
            for (int x = 0; x < numberOfNodes; x++) {
                nameOfCity[x] = st.nextToken();
            }
            // Creating a 2D array to save the weights of the graph
            graph = new int[numberOfNodes][numberOfNodes];
            for (int i = 0; i < numberOfNodes; i++) {
                str = obj.readLine();
                st = new StringTokenizer(str, " ");
                for (int j = 0; j < numberOfNodes; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //calculating the size 
            for (int i = 0; i < numberOfNodes - 1; i++) {
                for (int j = i + 1; j < numberOfNodes; j++) {
                    if (graph[i][j] != 0) {
                        size++;
                    }
                }
            }
            weightGraph = new int[size+1][3];
            //creating weightGraph
            for (int i = 0; i < numberOfNodes - 1; i++) {
                for (int j = i + 1; j < numberOfNodes; j++) {
                    if (graph[i][j] != 0) {
                        add(graph[i][j], i, j);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void add(int weight, int node1, int node2) {
        weightGraph[index][0] = weight;
        weightGraph[index][1] = node1;
        weightGraph[index][2] = node2;
        index++;
    }

    public static void sortGraph() {
        for (int i = 0; i < size - 1; i++) {
            bool = false;
            min = weightGraph[i][0];
            for (int j = i + 1; j <= size; j++) {
                if (weightGraph[j][0] < min) {
                    bool = true;
                    min = weightGraph[j][0];
                    minIndex = j;
                }
                if (bool) {
                    swap(minIndex, i);

                }
            }
        }

    }

    public static void swap(int minIndex, int i) {
        temp = weightGraph[minIndex][0];
        weightGraph[minIndex][0] = weightGraph[i][0];
        weightGraph[i][0] = temp;

        temp = weightGraph[minIndex][1];
        weightGraph[minIndex][1] = weightGraph[i][1];
        weightGraph[i][1] = temp;

        temp = weightGraph[minIndex][2];
        weightGraph[minIndex][2] = weightGraph[i][2];
        weightGraph[i][2] = temp;

    }

    public static void print() {
        //System.out.println(edge);
        if(checkB) {
            
            System.out.println("There is a cycle");
            System.out.println(edge2);
        }
        else System.out.println("There is no cycle");
    }

    public static void kruskal() {

        edge = "";
        edge2 ="";
        for (int i = 0; i <= size; i++) {
            node1 = weightGraph[i][1];
            node2 = weightGraph[i][2];
            if (visitedList.contains(node1) && (!visitedList.contains(node2))) {
                cost += weightGraph[i][0];
                edge += "(" + nameOfCity[node1] + "-" + nameOfCity[node2] + ")";
                visitedList.add(node2);
            } else if (visitedList.contains(node2) && (!visitedList.contains(node1))) {
                cost += weightGraph[i][0];
                edge += "(" + nameOfCity[node1] + "-" + nameOfCity[node2] + ")";
                visitedList.add(node1);
            } else if (!visitedList.contains(node1) && (!visitedList.contains(node2))) {
                edge += "(" + nameOfCity[node1] + "-" + nameOfCity[node2] + ")";
                visitedList.add(node1);
                visitedList.add(node2);
                cost += weightGraph[i][0];
            }else if((visitedList.contains(node1)&&visitedList.contains(node2))){
                edge2 += "(" + nameOfCity[node1] + "-" + nameOfCity[node2] + ")";
                checkB =true;
            }
        }
    }
}

