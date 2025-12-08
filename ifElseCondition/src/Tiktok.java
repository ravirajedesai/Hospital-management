public class Tiktok {
    int count;
    public void increment(){
        count++;
    }
}
class gfg{
    public static void main(String[] args) throws InterruptedException {
        Tiktok t = new Tiktok();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    t.increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    t.increment();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count: "+t.count);

    }
}
