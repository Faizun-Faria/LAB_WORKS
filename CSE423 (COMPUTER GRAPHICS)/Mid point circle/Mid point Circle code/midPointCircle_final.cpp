#include <bits/stdc++.h>
using namespace std;

void drawEightPoints(int xc,int yc,int addx,int addy) {
    cout << xc + addx << "\t" << yc + addy << endl;
    // for other 7 points
    // cout << " " << xc - addx << " " << yc + addy << endl;
    // cout << " " << xc + addx << " " << yc - addy << endl;
    // cout << " " << xc - addx << " " << yc - addy << endl;
    // cout << " " << xc + addy << " " << yc + addx << endl;
    // cout << " " << xc - addy << " " << yc + addx << endl;
    // cout << " " << xc + addy << " " << yc - addx << endl;
    // cout << " " << xc - addy << " " << yc - addx << endl;
}

void drawCircle(int xc, int yc, int r) {
    int p = 1 - r, addx = 0, addy = r;
    cout << addx << "\t" << addy << "\t" << p << "\t";
    drawEightPoints(xc, yc, addx, addy);

    while(addx < addy){
        addx++;
        if (p < 0) {
            p += 2 * addx + 1;
        }
        else{
            addy--;
            p += 2 * (addx - addy) + 1;
        }
        cout << addx << "\t" << addy << "\t" << p << "\t";
        drawEightPoints(xc, yc, addx, addy);
    }
}

int main() {
    int x, y, r;
    cout << "Enter the co-ordinate of center:\n";
    cout << "Enter x: "; cin >> x;
    cout << "Enter y: "; cin >> y;
    cout << "Enter r (Radius): "; cin >> r;
    cout << "x'\ty'\tD\tx\ty\n";
    cout << "-----------------------------------\n";
    drawCircle(x, y, r);
}
