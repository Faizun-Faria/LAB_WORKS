#include <bits/stdc++.h>
using namespace std;
double n,p,q,x, probability, mean, variance;
void y(){
    cout<<"n (Number of trials)"<<"\n";
    cin>>n;
    cout<<"p (probability of success)"<<"\n";
    cin>>p;
    cout<<"x (number of success in n trials)"<<"\n";
    cin>>x;
    q = 1-p;
    double ncx = 1;
        if(n-x>x){
            for(int i = n-x+1; i<=n; i++){
                ncx*=i;
            }
            for(int i = 1; i<=x; i++){
                ncx/=i;
            }
        }else{
            for(int i = x+1; i<=n; i++){
                ncx*=i;
            }
            for(int i = 1; i<=n-x; i++){
                ncx/=i;
            }
        }
        cout<<"nCx="<<ncx<<"\n";
        double p_power_x = 1.0;
        for(int i = 1; i<=x; i++){
            p_power_x*=p;
        }
        cout<<"p to the power x="<<p_power_x<<"\n";
        double q_power_n_minus_x = 1.0;
        for(int i = 1; i<=n-x; i++){
            q_power_n_minus_x*=q;
        }
        cout<<"q to the power (n-x)="<<q_power_n_minus_x<<"\n";
        probability = ncx*p_power_x*q_power_n_minus_x;
        cout<<"probability, P(x) = "<<probability<<"\n";
}
void m(){
    cout<<"n (Number of trials)"<<"\n";
    cin>>n;
    cout<<"p (probability of success)"<<"\n";
    cin>>p;
    mean = n*p;
    cout<<"Mean = "<<mean<<"\n";
}
void v(){
    cout<<"n (Number of trials)"<<"\n";
    cin>>n;
    cout<<"p (probability of success)"<<"\n";
    cin>>p;
    q = 1 - p;
    variance = n*p*q;
    cout<<"Variance = "<<variance<<"\n";
}
int main(){
    while(true){
        cout<<"Type 1 for probability, 2 for mean, 3 for variance"<<"\n";
        int testcase;
        cin>>testcase;
        if(testcase==1) y();
        else if(testcase==2) m();
        else if(testcase==3) v();
        else break;
    }

}
