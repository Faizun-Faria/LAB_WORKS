package cse423;
import java.util.Scanner;
public class DDA {
    public static double twoDecimalPoint(double dd){
        dd+=0.005;
        dd = 100*dd;
        int k = (int)dd;
        return 1.0*k/100.0;
    }
    public static int maxim(int a, int b){
        if(a>=b) return a;
        else return b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give X1");
        int x1 = sc.nextInt();
        System.out.println("Give Y1");
        int y1 = sc.nextInt();
        System.out.println("Give X2");
        int x2 = sc.nextInt();
        System.out.println("Give Y2");
        int y2 = sc.nextInt();
        int dx = x2-x1;
        int dy = y2-y1;
        double m = 1.0*dy/dx;
        m = twoDecimalPoint(m);
        System.out.println("Slope,m="+m);
        double b = y1 - (m*x1);
        System.out.println("We know that y = mx + b and here b is the intercept on Y-axis.b="+b);
        int step = maxim(dx,dy);
        double [][] XY = new double[step+1][2];
        System.out.println("No of steps="+step);
        XY[0][0] = x1;
        XY[0][1] = y1;
        if (m<=1 && m>=-1){
            for(int i =1; i<=step; i++){
               XY[i][0] = XY[i-1][0]+1;
               XY[i][1] = XY[i-1][1]+m;
               XY[i][1] = twoDecimalPoint(XY[i][1]);
            }
        }else{
            for(int i =1; i<=step; i++){
                XY[i][0] = XY[i-1][0]+(1/m);
                XY[i][0] = twoDecimalPoint(XY[i][0]);
                XY[i][1] = XY[i-1][1]+1;
            }
        } 
        System.out.println("For integer output press 1 and for decimal output press 2");
        int outType = sc.nextInt();
        if(outType==1){
            for(int i =0; i<=step; i++){
                XY[i][0]+=0.5;
                XY[i][1]+=0.5;
                System.out.println("("+(int)XY[i][0]+","+(int)XY[i][1]+")");
            }
        }else if (outType==2){
            for(int i =0; i<=step; i++){
                System.out.println("("+XY[i][0]+","+XY[i][1]+")");
            }
        }
        
    }
    
}
