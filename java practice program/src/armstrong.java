public class armstrong {
    public static void main(String args[]){
       int n=1,sum=0,x,i=n;
       while(i!=0){
           x=i%10;
           sum=sum+(x*x*x);
           i=i/10;
       }
       if(n==sum){
           System.out.println("Armstrong number");
       }else{
           System.out.println("Not an Armstrong number");
       }
    }
}
