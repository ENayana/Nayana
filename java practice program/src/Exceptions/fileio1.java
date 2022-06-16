package Exceptions;
import java.io.*;
public class fileio1
{
    public static void main(String args[])
    {
        try
        {
            FileOutputStream f1 = new FileOutputStream("D:\\hello.txt");
            String c = "Hii Everyone ";
            byte b[] = c.getBytes();
            f1.write(b);
            f1.write(100);
            System.out.println(b);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}


