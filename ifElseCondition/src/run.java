class thread1 implements Runnable{

    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("Thread1 is running..");

            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
class thread21 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Thread 2 is running..");
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            }
        }
    }

public class run {
    public static void main(String[] args) {

        Runnable obj1= new thread1();
        Runnable obj2= new thread21();

        Thread t1= new Thread(obj1);
        Thread t2= new Thread(obj2);

        t1.start();
        t2.start();
    }
}
