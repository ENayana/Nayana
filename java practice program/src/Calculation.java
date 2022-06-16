public class Calculation {
    void add(int a,int b){
        int sum=a+b;
        System.out.println("Addition of "+a+" & " +b+ " is: "+sum);
    }
    void sub(int a,int b){
        int sub=a-b;
        System.out.println("Substraction of "+a+" & " +b+ " is: "+sub);
    }
    void mul(int a,int b){
        int mul=a*b;
        System.out.println("Multiplication of "+a+" & " +b+ " is: "+mul);
    }
    void div(int a,int b){
        double div=a/b;
        System.out.println("Division of "+a+" & " +b+ " is: "+div);
    }
    public static void main(String[] args){
        Calculation obj1=new Calculation();
        obj1.add(5,6);
        obj1.sub(10,5);
        obj1.mul(2,5);
        obj1.div(200,10);

    }
}
