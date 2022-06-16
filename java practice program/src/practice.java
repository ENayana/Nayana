public class practice {
   private String accname;
   private long accno;
   private double accbal;
   public void deposit(double amt){
       if(amt>0){
       accbal=accbal+amt;
       System.out.println("sucessful" +amt);
       }else{
           System.out.println("falied"+amt);
       }
   }
    public void withdraw(double amt){
        if(amt>0){
            accbal=accbal-amt;
            System.out.println("sucessful" +amt);
        }else{
            System.out.println("falied"+amt);
        }
    }
    public void currentbal(){
       System.out.println("cuurent balance"+accbal);
    }
    public practice(long accno,String accname,double accbal){
       this.accno=accno;
       this.accname=accname;
       this.accbal=accbal;
    }
}
