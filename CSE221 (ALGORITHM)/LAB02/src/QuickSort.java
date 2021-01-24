
/**
 *
 * @author Faizun
 */
import java.util.Arrays;
public class QuickSort {
    
    int[] array;
    public QuickSort(int[] arr) {
        array = new int[arr.length];
        for (int x = 0; x < arr.length; x++) {
            array[x] = arr[x];
        }
        quickSort(array, 0, array.length-1);
    }
    
    public void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }
    
    public int partition(int[] a, int p, int q) {
        //sorting
        int x = a[p];
        int i = p;
        for (int j = p + 1; j <= q; j++) {
            if (a[j] <= x) {
                i = i + 1;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[p];
        a[p] = a[i];
        a[i] = t;
        return i;
    }
    public String toString(int [] arr){
        return Arrays.toString(arr);
    }
    
    public String toString(){
        return Arrays.toString(array);
    }
    
}
