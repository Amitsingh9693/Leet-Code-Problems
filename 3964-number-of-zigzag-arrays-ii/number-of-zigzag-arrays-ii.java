class Solution {
    int MOD=1000000007;
    public int zigZagArrays(int n, int l, int r) {
        int k=r-l+1;
        int size=2*k;
        long[][] initial=new long[size][1];
        for(int i=1;i<=k;i++){
            initial[i-1][0]=k-i;
            initial[k+i-1][0]=i-1;
        }

        long[][] T=new long[size][size];
        for(int i=1;i<=k;i++){
            for(int u=1;u<i;u++){
                T[k+i-1][u-1]=1;
            }
            for(int u=i+1;u<=k;u++){
                T[i-1][k+u-1]=1;
            }
        }

        long[][] Tn=power(T,n-2);
        long[][] ans=multiply(Tn,initial);

        long total=0;
        for(int i=0;i<size;i++){
            total=(total+ans[i][0])%MOD;
        }
        return (int)total;
    }

    long[][] multiply(long[][] A,long[][] B){
        int rA=A.length;
        int cA=A[0].length;
        int cB=B[0].length;

        long[][] c=new long[rA][cB];
        for(int i=0;i<rA;i++){
            for(int j=0;j<cB;j++){
                long sum=0;
                for(int k=0;k<cA;k++){
                    sum=(sum+A[i][k]*B[k][j])%MOD;
                }
                c[i][j]=sum;
            }
        }
        return c;
    }

    long[][] power(long[][] base,int expo){
        int n=base.length;
        long[][] res=new long[n][n];
        for(int i=0;i<n;i++){
            res[i][i]=1;
        }

        long[][] b=base;
        while(expo>0){
            if(expo%2==1){
                res=multiply(res,b);
            }
            b=multiply(b,b);
            expo/=2;
        }

        return res;
    }
}