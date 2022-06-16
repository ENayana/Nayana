public class except {

        public static void main(String args[])
        {
            try
            {
                int n=10/0;
                System.out.println("division");
            }
            catch (ArithmeticException e)
            {
                System.out.println("error occured");
            }
            finally
            {
                System.out.println("error cleared");
            }
        }
    }

