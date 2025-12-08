public class teliThread implements Runnable{
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println("Hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class teli1 implements Runnable{
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class telimain{
    public static void main(String[] args) {
            Runnable teliThread= new teliThread();
            Runnable teli1= new teli1();

           Thread t1= new Thread(teliThread);
           Thread t2= new Thread(teli1);

            t1.start();
            t2.start();
    }
}
