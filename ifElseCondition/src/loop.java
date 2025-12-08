class method1 {

    public int add(int n1,int n2){
        return n1+n2;
    }
}
public class loop {
    public static void main(String[] args) {
        method1 m1 = new method1();
        System.out.println("Result is: "+m1.add(4,5));

    }
}
