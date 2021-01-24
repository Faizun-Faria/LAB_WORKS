package lab03;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

import javax.swing.JFrame;

/**
 *
 * @author Faizun
 */
public class Lab03 implements GLEventListener{
    
    private GLU glu;
    static int conv_X1, conv_Y1, conv_X2, conv_Y2;
    
    @Override
    public void init(GLAutoDrawable gld) {
       GL2 gl = gld.getGL().getGL2();
       glu = new GLU();
       gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
       gl.glViewport(-100, -100, 100, 100);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
    }
    @Override
    public void dispose(GLAutoDrawable glad) {
        // Method body 
    }
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        //Method body
    }
    public static void convertToZone0(int zone, int X1, int Y1, int X2, int Y2) {
        conv_X1 = X1;
        conv_Y1 = Y1;
        conv_X2 = X2;
        conv_Y2 = Y2;
        if(zone == 1 || zone ==2 || zone == 4 || zone == 6){
            conv_X1 = Y1;
            conv_Y1 = X1;
            conv_X2 = Y2;
            conv_Y2 = X2;
        }
        if ( zone == 2 || zone == 4 ||zone == 5 || zone == 7 ){
            conv_Y1 = -Y1;
            conv_Y2 = -Y2;
        }
        if (zone == 3 || zone == 4|| zone == 5 || zone == 6){
            conv_X1 = -X1;
            conv_X2 = -X2;
        }
    }
    
    public static int convertToOriginalZone_X(int X,int Y, int originalZone) {
        int xx = X;
        if(originalZone==1) {
            xx = Y; 
        }else if(originalZone==2){
            xx = -Y; 
        }else if(originalZone==3){
            xx = -X;
        }else if(originalZone==4){
            xx = -Y;
        }else if(originalZone==5){
            xx = -X;
        }else if(originalZone==6){
            xx = Y;
        }else if(originalZone==7){
            xx = X; 
        }
        return xx;
    }
      
    public static int convertToOriginalZone_Y(int X, int Y, int originalZone) {
        int yy = Y;
        if(originalZone==1) {
            yy = X;
        }else if(originalZone==2){
            yy = X;
        }else if(originalZone==3){
            yy = Y;
        }else if(originalZone==4){
            yy = -X;
        }else if(originalZone==5){
            yy = -Y;
        }else if(originalZone==6){
            yy = -X;
        }else if(originalZone==7){
            yy = -Y; 
        }
        return yy;
    }

    private static int findZone(int X1, int Y1, int X2, int Y2) {
        int zone = 8;
        int dx = X2 - X1;
        int dy = Y2 - Y1;
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
   

    @Override
   public void display(GLAutoDrawable drawable) {
        
       final GL2 gl = drawable.getGL().getGL2();
        
        //For 0
        
        DrawMPL(gl,-85,-50,-80,50);//B--A
        DrawMPL(gl, -80,50,-20,50);//A--C
        DrawMPL(gl,-85,-50,-25,-50);//B--D
        DrawMPL(gl, -25,-50,-20,50);//D--C

        //For 3
        
        DrawMPL(gl,55,-50,60,50);//J--F
        DrawMPL(gl,0,50,60,50);//E--F
        DrawMPL(gl,0,-50,55,-50);//I--J
        DrawMPL(gl, 30,0,58,0);//G--H
        
   }

    

    private void DrawMPL(GL2 gl, int X1, int Y1, int X2, int Y2) {
        
        gl.glPointSize(3.0f);
        gl.glColor3d(1, 0, 0);
        gl.glBegin (GL2.GL_POINTS);//static field
        int zone = findZone(X1,Y1,X2,Y2);
        convertToZone0(zone,X1,Y1,X2,Y2);
        int dX = conv_X2 - conv_X1;
        int dY = conv_Y2 - conv_Y1;
        int d = 2 * dY - dX;
        int incrE = 2 * dY;
        int incrNE = 2 * (dY - dX);
        int x = conv_X1;
        int y = conv_Y1;
        float X, Y;
        X = (float) convertToOriginalZone_X(x,y,zone);
        Y = (float) convertToOriginalZone_Y(x,y,zone);
        gl.glVertex3f(X,Y,0);
        while (x < conv_X2) {
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
            X = (float) convertToOriginalZone_X(x,y,zone);
            Y = (float) convertToOriginalZone_Y(x,y,zone);
            gl.glVertex3f(X,Y,0);
        }
        gl.glEnd();
    }    
}
