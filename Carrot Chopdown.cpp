#include<iostream>
#include<vector>
using namespace std;
int main(){
int N,M;
cin>>N>>M;
vector<int> cnt(M+1,0);
for(int x = 1;x<=N;x++){
    int curr;cin>>curr;
    cnt[curr]++;
}
vector<int> psum(M+1,0);
for(int i = 1;i<=M;i++){
    psum[i] = psum[i-1]+cnt[i];
}
int ans = 0;
for(int clen = 1;clen<=M;clen++){
    int carrotlen = psum[M]-psum[clen-1];
    if(2*clen <= M){
        carrotlen += cnt[2*clen];
    }
    ans = max(ans,carrotlen);
}
cout<<ans;
}
