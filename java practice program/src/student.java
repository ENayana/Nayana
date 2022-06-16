public class student {
    student(String name){
        System.out.println("Name:"+name);
    }
    student(int age){

        System.out.println("Age:"+age);
    }
    student(double marks)
    {
        System.out.println("Marks:"+marks);
    }
    public static void main(String[] args){
        student s1=new student("Riya");
        student s2=new student(21);
        student s3=new student(79.8);
    }
}
