package day24;


public class Demo01
{
    public static void main(String[] args)
    {
        B b1=new B();
        B b2=new B();
        b1.setN(3);
        b1.setN(5);
        int s1=b1.getSum();
        int s2=b2.getSum();
        System.out.println(s1+s2);

    }
}

class B
{
    int n;
    static int sum=0;
    void setN(int n)
    {
        this.n=n;
    }
    int getSum()
    {
        for (int i = 1; i <= n; i++)
            sum=sum+i;
        return sum;
    }
}