/**
 *
 * @author Faizun
 */
import java.util.Arrays;
public class HeapSort {

    int[] arr;
    int heapSize;
    int[] heapArray;
    int indexOfParent;
    int indexOfChild1;
    int indexOfChild2;
    boolean flag = true;
    int[] sortedArray;

    //In this constructor I am just copying the given array into a local array named as "arrayy"
    public HeapSort(int[] arr) {
        this.arr = arr;
        sortedArray = new int[arr.length];
    }

    // Just for printing
    @Override
    public String toString() {
        return Arrays.toString(sortedArray);
    }
    
    public String toString(int [] arrayy) {
        return Arrays.toString(arrayy);
    }
//-------------------------------------------------------------------------------------------------
//----------------------------------------Extract Min----------------------------------------------    

    public void extractMin() {
        for (int x = arr.length, y = 0; x > 1; x--, y++) {
            swap(1, x);
            heapSize--;
            sortedArray[y] = heapArray[x];
            heapArray[x] = Integer.MAX_VALUE;
            buildMinHeap();
        }
        sortedArray[arr.length-1] = heapArray[1];
    }
//-------------------------------------------------------------------------------------------------        
//-----------------------------------------Build Heap----------------------------------------------     

    public void buildHeap() {
        heapSize = arr.length + 1;
        heapArray = new int[heapSize];
        heapArray[0] = -1;
        for (int x = 0; x < heapSize - 1; x++) {
            heapArray[x + 1] = arr[x];
        }
    }
//-------------------------------------------------------------------------------------------------
//---------------------------------------Check Min Heap-------------------------------------------- 

    public void checkMinHeap() {
        indexOfParent = heapSize / 2;
        while (indexOfParent > 0) {
            indexOfChild1 = 2 * indexOfParent;
            indexOfChild2 = 2 * indexOfParent + 1;
            if (indexOfChild2 < heapSize) {
                compareWithTwoChildMin(indexOfParent, indexOfChild1, indexOfChild2);
            } else  {
                compareWithOneChildMin(indexOfParent, indexOfChild1);
            }
            indexOfParent--;
        }
    }
//---------------------------------------------------------------------------------------------   
//-------------------------------------Build Min Heap------------------------------------------ 

    public void buildMinHeap() {
        flag = true;
        indexOfParent = heapSize / 2;
        while (indexOfParent > 0) {
            indexOfChild1 = 2 * indexOfParent;
            indexOfChild2 = 2 * indexOfParent + 1;
            if (indexOfChild2 < heapSize) {
                compareWithTwoChildMin(indexOfParent, indexOfChild1, indexOfChild2);
            } else {
                compareWithOneChildMin(indexOfParent, indexOfChild1);
            }
            indexOfParent--;
        }
        if (flag == false) {
            buildMinHeap();
        }
    }
//-------------------------------------------------------------------------------------------------
//---------------------------------------SwapMethod------------------------------------------------    

    public void swap(int i, int j) {
        heapArray[i] = heapArray[j] + heapArray[i]; 
        heapArray[j] = heapArray[i] - heapArray[j]; 
        heapArray[i] = heapArray[i] - heapArray[j]; 
    }
//-------------------------------------------------------------------------------------------------
//--------------------------------------CompareMethod----------------------------------------------       

    public void compareWithOneChildMin(int i, int j) {
        if (heapArray[i] > heapArray[j]) {
            flag = false;
            swap(i, j);
        }
    }
//-------------------------------------------------------------------------------------------------        
//--------------------------------------CompareMethod----------------------------------------------    

    public void compareWithTwoChildMin(int i, int j, int k) {
        if ((heapArray[i] > heapArray[j]) && (heapArray[i] > heapArray[k])) {
            flag = false;
            if (heapArray[j] > heapArray[k]) {
                swap(i, k);
            }else {
                swap(i, j);
            }
        } else if (heapArray[i] > heapArray[j]) {
            flag = false;
            swap(i, j);
        } else if (heapArray[i] > heapArray[k]) {
            flag = false;
            swap(i, k);
        }
    }
//------------------------------------------------------------------------------------------------    
}
