class pri1 extends Thread{
    public void run(){
        System.out.println("Running Thread: "+currentThread().getName());
        System.out.println("Priority: "+currentThread().getPriority());
    }
}

public class Priority {
    public static void main(String[] args) {

        pri1 t1= new pri1();
        pri1 t2= new pri1();

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
