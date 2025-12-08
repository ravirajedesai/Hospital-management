abstract class abc {
    abstract void show();
    abstract void display();
    void m1(){
        System.out.println("In M1 Method.");
    }
}
class pqr extends abc{

    @Override
    public void show() {
        System.out.println("In show ");
    }

    @Override
    void display() {
        System.out.println("In Display");
    }
}
class xyz{
    public static void main(String[] args) {
        pqr abc= new pqr();
        abc.m1();
        abc.show();
        abc.display();

    }
}