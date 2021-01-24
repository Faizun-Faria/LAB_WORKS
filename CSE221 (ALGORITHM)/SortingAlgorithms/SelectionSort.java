public class SelectionSort{
  public static void main(String [] args){
    int [] arr = {5,4,3,6,7,1,2,8,1};
    int min=0;
    int temp =0;
    int index =0;
    for(int x=0; x<arr.length; x++){
      min = arr[x];
      for (int y = x+1; y<arr.length; y++){
        if(arr[y]<min){
          min = arr[y];
          index = y;
        } 
      }
      if(arr[x]>min){
        temp = arr[index];
        arr[index] = arr[x];
        arr[x]= temp;
      }
    }
    for(int x=0; x<arr.length; x++){
      System.out.print(arr[x]+" ");
    }
  }
}