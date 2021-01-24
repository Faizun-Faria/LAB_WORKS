/**
 *
 * @author Faizun
 */
import java.io.*;
import java.util.*;
public class AdjacencyMatrix {
    static int arrayLength;
    static int source;
    static int[][] weightGraph;
    static String[] nameOfCity ;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the source node?");
        String sourceS = new String();
        sourceS = sc.nextLine();
        if (sourceS.equals("Newyork")) source = 1;
        else if (sourceS.equals("Washington")) source = 2;
        if(sourceS.equals("California")) source = 3;
        BufferedReader obj;
        obj = null;
        try {
            String str;
            FileReader fr = new FileReader("lab05.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            int nodes;
            StringTokenizer st = new StringTokenizer(str, " ");
            nodes = st.countTokens();
            arrayLength = nodes + 1;
            // Creating an array to store the name of the cities
            nameOfCity = new String[arrayLength];
            for (int x = 1; x < arrayLength; x++) {
                nameOfCity[x] = st.nextToken();
            }
            // Creating a 2D array to save the weights of the graph
            weightGraph = new int[arrayLength][arrayLength];
            for (int x = 0; x < arrayLength; x++) {
                weightGraph[0][x] = x;
                weightGraph[x][0] = x;
            }
            int token;
            int x = 0;
            while ((str = obj.readLine()) != null) {
                x++;
                st = new StringTokenizer(str, " ");
                for (int y = 1; y < arrayLength; y++) {                    
                    token = Integer.parseInt(st.nextToken());
                    weightGraph[y][x] = token;
                }
            }
            Prim p = new Prim();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}