#include<iostream>
#include<vector>
using namespace std;
int hcf(int a, int b){
return b == 0? a:hcf(b,a%b);
}
int main(){
int N;
cin>>N;
vector<int> arr(N);
for(int i = 0;i<N;i++){
    cin>>arr[i];
}
cout<<hcf(arr[0],arr[N-1])<<endl;
}
