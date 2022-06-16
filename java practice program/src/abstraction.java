abstract class abstraction {
        abstract void test1();
    }
    class abst2 extends abstraction {
        void test1() {
            System.out.println("First abstract method");
        }

        class abst1 extends abstraction
        {
            void test1()
            {
                System.out.println("Second abstract method");
            }
        }
    }
    class abst
    {
        public static void main(String args[])
        {
            abst2 d1= new abst2();
            d1.test1();

        }
    }


