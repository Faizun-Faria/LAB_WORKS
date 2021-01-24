package midpointlinedrawingalgo;
import java.util.Scanner;
public class MidPointLineDrawingAlgo {
    //x --> original co-ordinates , X ---> converted co-ordinates
    static double x0,y0,x1,y1, X0,Y0,X1,Y1, dX,dY;
    static int originalZone;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 1 if m and c are given.\nType 2 if x0,y0,x1,y1 are given.");
        int num=sc.nextInt();
        if (num==1){
            double m = sc.nextDouble();
            double c = sc.nextDouble();
            findXYPoints(m,c);
        }else{
            System.out.println("Give X0, Y0, X1, Y1");
            x0 = sc.nextDouble();
            y0 = sc.nextDouble();
            x1 = sc.nextDouble();
            y1 = sc.nextDouble();
        }
        originalZone = findZone();
        System.out.println("Zone = "+originalZone);
        convertToZone0();
        System.out.println("Converted x,y: x0,y0,x1,y1 = "+X0+", "+Y0+", "+X1+", "+Y1);
        dX = X1-X0;
        dY = Y1-Y0;
        System.out.println("dX, dY = "+dX+", "+dY);
        midPoint();
    }

    public static void convertToZone0() {
        if(originalZone==1) {
            X0 = y0; Y0 = x0; X1 = y1; Y1 = x1;
        }else if(originalZone==2){
            X0 = y0; Y0 = -x0; X1 = y1; Y1 = -x1;
        }else if(originalZone==3){
            X0 = -x0; Y0 = y0; X1 = -x1; Y1 = y1;
        }else if(originalZone==4){
            X0 = -x0; Y0 = -y0; X1 = -x1; Y1 = -y1;
        }else if(originalZone==5){
            X0 = -y0; Y0 = -x0; X1 = -y1; Y1 = -x1;
        }else if(originalZone==6){
            X0 = -y0; Y0 = x0; X1 = -y1; Y1 = x1;
        }else if(originalZone==7){
            X0 = x0; Y0 = -y0; X1 = x1; Y1 = -y1;
        }else{
            X0 = x0; Y0 = y0; X1 = x1; Y1 = y1;
        }
    }
    
    public static double convertToOriginalZone_X(double X,double Y) {
        double xx = 0;
        if(originalZone==1) {
            xx = Y; 
        }else if(originalZone==2){
            xx = Y; 
        }else if(originalZone==3){
            xx = -X;
        }else if(originalZone==4){
            xx = -X;
        }else if(originalZone==5){
            xx = -Y;
        }else if(originalZone==6){
            xx = -Y;
        }else if(originalZone==7){
            xx = X; 
        }
        return xx;
    }
    
    
    public static double convertToOriginalZone_Y(double X,double Y) {
        double yy = 0;
        if(originalZone==1) {
            yy = X;
        }else if(originalZone==2){
            yy = -X;
        }else if(originalZone==3){
            yy = Y;
        }else if(originalZone==4){
            yy = -Y;
        }else if(originalZone==5){
            yy = -X;
        }else if(originalZone==6){
            yy = X;
        }else if(originalZone==7){
            yy = -Y; 
        }
        return yy;
    }

    private static int findZone() {
        int zone = 8;
        System.out.println("dx and dy");
        double dx = x1 - x0;
        double dy = y1 - y0;
        System.out.println(dx + " " + dy);
        System.out.println("Detecting Zone");
        if (dx >= 0) {
            if (dy >= 0) {
                // dx +ve and dy +ve (0,1)
                if (dx >= dy) {
                    zone = 0;
                } else {
                    zone = 1;
                }
            } else {
                // dx +ve and dy -ve(6,7)
                dy = -dy;
                if (dy >= dx) {
                    zone = 6;
                } else {
                    zone = 7;
                }
            }
        } else {
            if (dy >= 0) {
                // dx -ve and dy +ve(2,3)
                dx = -dx;
                if (dy >= dx) {
                    zone = 2;
                } else {
                    zone = 3;
                }

            } else {
                // dx -ve and dy -ve(4,5)
                dx = -dx;
                dy = -dy;
                if (dx >= dy) {
                    zone = 4;
                } else {
                    zone = 5;
                }
            }
        }
        return zone;
    }

    public static void findXYPoints(double m, double c) {
        System.out.println("Intersecting points at Y axis(x0,y0)");
        x0 = 0;
        y0 = c;
        System.out.println(x0 + " " + y0);
        System.out.println("Intersecting points at X axis (x1,y1)");
        x1 = -(c / m);
        y1 = 0;
        System.out.println(x1 + " " + y1);
    }

    public static void midPoint() {
        double d = 2 * dY - dX;
        double incrE = 2 * dY;
        double incrNE = 2 * (dY - dX);
        System.out.println("dx= " + dX + ",dy= " + dY + ",d= " + d + ",delta_E= " + incrE + ",delta_NE= " + incrNE);
        double x = X0;
        double y = Y0;
        print(x, y, d, convertToOriginalZone_X(x,y),convertToOriginalZone_Y(x,y));
        while (x < X1) {
            if (d <= 0) {
                //choose E
                d += incrE;
                x += 1;
            } else {
                //choose NE
                d += incrNE;
                x += 1;
                y += 1;
            }
            print(x, y, d, convertToOriginalZone_X(x,y),convertToOriginalZone_Y(x,y));
        }
    
    }

    private static void print(double x, double y, double d, double o_X, double o_Y) {
        System.out.println("x:"+x+" y:"+y+" d:"+d+" x_org:"+ o_X+" y_org:"+o_Y);
    }
}
