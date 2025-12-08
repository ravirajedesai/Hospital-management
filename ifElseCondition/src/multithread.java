public class multithread extends Thread{
    public void run(){
        System.out.println("MultiThread is running..");
    }
}
class thread2 extends Thread{
    public void run(){
        System.out.println("Thread 2 is running..");
    }
}
class main12 {
    public static void main(String[] args) {
        multithread t1 = new multithread();
        thread2 t2 = new thread2();

        t1.start();
        t2.start();
    }
}