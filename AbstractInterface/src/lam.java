interface lam {
    void abstractFun(int i);
    default void narmalFun(){
        System.out.println("Hello");
    }
}
class test{
    public static void main(String[] args) {
        lam obj=(i)-> System.out.println(2*i);
            obj.abstractFun(5);
            obj.narmalFun();
        }
    }


