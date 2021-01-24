package transformation;

import java.lang.Math; 
import java.util.Scanner;

/**
 *
 * @author Faizun
 */
public class Transformation {
    static int ax, ay;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the value of x and y");
        ax = sc.nextInt();
        ay = sc.nextInt();        
        // if right shift, dx (+)ve
        // if upward, dy (+)ve
        translate(36,-42);
        // if anti-clockwise (+)ve, clockwise (-)ve
        rotate(-Math.toRadians(77));
        //scale
        scale(3.3,1.1);
    }

    private static void translate(int dx, int dy) {
        System.out.println("Translation");
        ax += dx;
        ay += dy;
        printInt();
    }

    private static void rotate(double theta) {
        double temp1, temp2;
        System.out.println("Rotation");
        temp1 = ax*Math.cos(theta) - ay*Math.sin(theta);
        temp2 = ax*Math.sin(theta) + ay*Math.cos(theta) ;
        printDouble(temp1,temp2);
        conversion(temp1, temp2);
        printInt();
    }
    
    private static void scale(double x, double y){
        double temp1, temp2;
        System.out.println("Scale");
        temp1 = ax*x;
        temp2 = ay*y;
        printDouble(temp1,temp2);
        conversion(temp1, temp2);
        printInt();
    }
    public static void printInt(){
        System.out.println("("+ax+","+ay+")");
        System.out.println();
        System.out.println();
    }

    private static void conversion(double temp1, double temp2) {
        if(temp1<0) temp1-=0.5;
        else temp1+=0.5;
        if(temp2<0) temp2-=0.5;
        else temp2 +=0.5;       
        ax = (int) temp1;
        ay = (int) temp2;
    }   

    private static void printDouble(double temp1, double temp2) {
        System.out.println("Double values:"+temp1+" "+temp2+"\n");
    }
}
