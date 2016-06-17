/**
 * ПОЧИТАТЬ
 *over+overloading
 *
 * visitor
 * double Dispatch
 *
 *
 * */
public class Test {
    public static void main(String[] args) {

        System.out.println(new B().f());
    }
}

class C extends B {
    private int k =3;
    public C() {
        System.out.println("C");
    }
}

class B extends A{
    private int k =2;
    public int f(){
       return super.k;
    }
    public B() {
        System.out.println("B");
    }
}

class A{
    protected int k =1;
    public A() {
        System.out.println("A");
    }
}
