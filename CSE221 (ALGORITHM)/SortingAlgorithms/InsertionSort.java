public class InsertionSort{
  public static void main(String [] args){
    int [] arr = {5,4,3,6,7,1,2,8};
    int min;
    for (int k=0;k<arr.length;k++){
      min = arr[k];
      for(int x=k+1; x<arr.length; x++){
        if(arr[x]<arr[k]){
          min = arr[x];
          for(int y =x; y>0; y--){
            arr[y]=arr[y-1];
          }
          arr[k] = min;
        }
      }
    }
    for(int x=0; x<arr.length; x++){
      System.out.print(arr[x]+" ");
    }
    
  }
}