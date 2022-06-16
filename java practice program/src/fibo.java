public class fibo {
    public static void main(String[] args){
        int n=5,f0=0,f1=1,f2;
        System.out.print(f0+" "+f1);
        for(int i=2;i<=n;i++){
            f2=f0+f1;
            System.out.print(" "+f2);
            f0=f1;
            f1=f2;
        }

    }
}
