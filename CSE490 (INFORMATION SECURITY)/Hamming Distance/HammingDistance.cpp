#include <bits/stdc++.h>
using namespace std;
int nonMatched;

string decToBin(int dec){
    vector<int> v;
    string bin;
    int cnt=0;
    while(dec>0){
        v.push_back(dec%2);
        dec/=2;
        cnt++;
    }
    for(int i=0; i<4-cnt; i++){
        bin += "0";
    }
    for(int i=v.size()-1; i>=0; i--){
        bin += to_string(v[i]);
    }
    return bin;
}

string hexToBin(char hex){
    int dec;
    dec = (int)hex -(int)'0';
    if(dec > 9 ){
        dec = 10 + (int)hex - (int)'A';
    }
    string bin = decToBin(dec);
    return bin;
}

void compare(char h1, char h2){
    string b1 = hexToBin(h1);
    string b2 = hexToBin(h2);
    for(int i = 0; i < 4; i++){
        if(b1[i]!=b2[i]) nonMatched++;
    }
}

int main(){
    freopen("input.txt", "r", stdin);
    int numOfUser;
    cin>>numOfUser;
    string user[numOfUser];
    string iris_code[numOfUser];

    for(int i = 0; i < numOfUser; i++){
        cin>>user[i];
        cin>>iris_code[i];
    }

    for(int i = 0; i < numOfUser-1; i++){
        for(int j = i+1; j < numOfUser; j++){
            nonMatched = 0;
            for(int k = 0; k < iris_code[i].length(); k++){
                compare(iris_code[i][k], iris_code[j][k]);
            }
            double d = 1.0*nonMatched/(iris_code[i].length()*4);
            cout<<"d("<<user[i]<<","<<user[j]<<") = "<<d<<"\n";
        }
    }
}
