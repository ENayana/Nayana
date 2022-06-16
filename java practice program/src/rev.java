public class rev {
    public static void main(String[] args){
        int n=12345,rev=0,num;
        while(n!=0){
            num=n%10;
            rev=rev*10+num;
            n=n/10;
        }
        System.out.println("the reverse of a given number is :"+rev);

    }
}
