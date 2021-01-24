/**
 *
 * @author Faizun
 */
import java.util.*;
public final class Prim extends AdjacencyMatrix {
    int test = 0;
    int arrayLength = super.arrayLength;
    int[] key;
    int[] parent;
    int source = super.source;
    String[] nameOfCity = super.nameOfCity;
    ArrayList<Integer> listOfIndex;
    int[][] weightGraph = super.weightGraph;
    int y;

    public Prim() {
        //Setting the initial key and parent
        key = new int[arrayLength];
        parent = new int[arrayLength];
        for (int k = 0; k < arrayLength; k++) {
            key[k] = Integer.MAX_VALUE;
            parent[k] = -1;
        }
        //Adding the index into an arrayList
        listOfIndex = new ArrayList();
        for (int k = 1; k < arrayLength; k++) {
            listOfIndex.add(k);
        }
        key[source] = 0;
        while (listOfIndex.size() > 0) {
            updateKeyOfAdjacentNode();
        }
        print(source);
    }
    public void updateKeyOfAdjacentNode() {
        y = extractMinimum();
        for (int x = 1; x < arrayLength; x++) {
            if ((key[x] > weightGraph[y][x]) &&
                    (weightGraph[y][x] != 0) && listOfIndex.contains(x)) {
                key[x] = weightGraph[y][x];
                parent[x] = y;
            }
        }
    }

    public int extractMinimum() {
        test++;
        if (test == 1) {
            return source;
        }
        int minNodeIndex = 0;
        int minNode = listOfIndex.get(minNodeIndex);
        for (int i = 1; i < listOfIndex.size(); i++) {
            if (key[listOfIndex.get(i)] < key[minNode]) {
                minNode = listOfIndex.get(i);
                minNodeIndex = i;
            }
        }
        listOfIndex.remove(minNodeIndex);
        return minNode;
        
    }
    
    public void print( int point) {
        System.out.print("("+nameOfCity[point]+"-");
        for(int i=0; i<arrayLength; i++) {
            if(parent[i]==point) {
                System.out.print(nameOfCity[i]+")");
                if(i!=arrayLength-1) {
                    System.out.print(",");
                    print(i);
                }
            }
        }
    }

    
    
   /*public void print() {
        int i = source;
        for (int x = 1; x < arrayLength-1; x++) {
            System.out.print(nameOfCity[i]+"-");
            for (int y = 1; y < arrayLength; y++) {
                if (parent[y] == i) {
                    System.out.println(parent[y]);
                    System.out.println(i);
                    System.out.println(y);
                    i = y;
                }else{
                    break;
                }
            }
            System.out.print(nameOfCity[i]);
            System.out.println();
        }
    } 
    public void print(){
    for (int x = 1; x < arrayLength; x++) {
    System.out.println(key[x]);
            System.out.println(parent[x]);
        }
    }*/
/* Newyork   Washington  California
    0         3750    3923 
    3750        0     1227 
    3923      1227     0    */
    
    
}
