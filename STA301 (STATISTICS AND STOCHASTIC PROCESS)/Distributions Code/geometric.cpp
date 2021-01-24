#include <bits/stdc++.h>
using namespace std;
double p,x, probability, mean, variance;
void y(){
    cout<<"p (probability of success)"<<"\n";
    cin>>p;
    cout<<"x (number of success in n trials)"<<"\n";
    cin>>x;
    probability = 1;
    double one_minus_p = 1-p;
    for(int i=1; i<=x-1; i++){
        probability *=one_minus_p;
    }
    probability *= p;
    cout<<"probability, P(x) = "<<probability<<"\n";
}
void m(){
    cout<<"p (probability of success)"<<"\n";
    cin>>p;
    mean = 1/p;
    cout<<"Mean = "<<mean<<"\n";
}
void v(){
    cout<<"p (probability of success)"<<"\n";
    cin>>p;
    variance = 1/(p*p);
    variance *= (1-p);
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
