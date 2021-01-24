#include <bits/stdc++.h>
using namespace std;
double lambda,n,p, x1,x2, probability, mean, variance;
void y(){
    cout<<"lambda (Average value)"<<"\n";
    cin>>lambda;
    cout<<"Value of x1 and x2 will be same if no range is given\n";
    cout<<"Starting range of X (count or number of occurrence)"<<"\n";
    cin>>x1;
    cout<<"Ending range of X (count or number of occurrence)"<<"\n";
    cin>>x2;
    probability = 0;
    for (int i=x1; i<=x2; i++){
        double lambda_power_x_whole_divided_by_x_factorial = 1;
        if(i==0){
            probability += 1;
            continue;
        }
        for(int j = 1; j<=i; j++){
            lambda_power_x_whole_divided_by_x_factorial *= lambda;
            lambda_power_x_whole_divided_by_x_factorial /= j;
        }
        probability+=lambda_power_x_whole_divided_by_x_factorial;
    }
    cout<<"XOXo"<<probability<<"\n";
    probability *= exp(-lambda);
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

int main(){
    while(true){
        cout<<"Type 1 for probability, 2 for mean"<<"\n";
        int testcase;
        cin>>testcase;
        if(testcase==1) y();
        else if(testcase==2) m();
        else break;
    }

}
