#include <bits/stdc++.h>
using namespace std;
double n, probability, mean, variance;
int N;
void y(){
    cout<<"Total number of points"<<"\n";
    cin>>N;
    cout<<"n (Number of trials)"<<"\n";
    cin>>n;
    int cou = 1;
    double p[N+1];
    for(int i = 1; i<= N; i++){
        cout<<"p "<<cou<<"\n";
        cou++;
        cin>>p[i];
    }
    cou = 1;
    double x[N+1];
    for(int i = 1; i<= N; i++){
        cout<<"x "<<cou<<"\n";
        cou++;
        cin>>x[i];
    }
    probability = 1;
    for(int i = 1; i<=n; i++){
        probability*=i;
    }
    for(int i = 1; i<=N; i++){
        for(int j = 1; j <= x[i]; j++){
            probability *= p[i];
        }
        for(int j = 1; j <= x[i]; j++){
            probability /= j;
        }
    }
    cout<<"probability, P(x) = "<<probability<<"\n";
}
void m(){
    cout<<"n (Number of trials)"<<"\n";
    cin>>n;
    double p_i;
    cout<<"p_i "<<"\n";
    cin>>p_i;
    mean = n*p_i;
    cout<<"Mean = "<<mean<<"\n";
}
void v(){
    cout<<"n (Number of trials)"<<"\n";
    cin>>n;
    double p_i;
    cout<<"p_i "<<"\n";
    cin>>p_i;
    variance = n*p_i*(1-p_i);
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
