package lab_quiz2;
import java.util.*;
public class Lab_Quiz2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input
        int numberOfProcess = sc.nextInt();
        int [] burstTime = new int[numberOfProcess];
        int [] remainingTime = new int[numberOfProcess];
        int [] arrivalTime = new int[numberOfProcess];
        int totalTime=0;
        for(int i=0; i<numberOfProcess; i++){
            burstTime[i] = sc.nextInt();
            remainingTime[i] = burstTime[i];
            totalTime+=remainingTime[i];
        }
        for(int i=0; i<numberOfProcess; i++){
            arrivalTime[i] = sc.nextInt();
        }
        
        // process
        int time=0;
        int index=0;
        while(totalTime>0){
            int mx= -1;
            for(int i =0; i<numberOfProcess; i++){
                if((remainingTime[i]>mx)&&(arrivalTime[i]<=time)){
                    mx= remainingTime[i];
                    index= i;
                }else if((remainingTime[i]==mx)&&(arrivalTime[i]<=time)){
                    mx= remainingTime[i];
                    index= i;
                }
            }
            int pInd= index+1;
            System.out.println("P"+pInd);
            time++;
            remainingTime[index]--;
            totalTime--;
        }
        
    }
    
}
