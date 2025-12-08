public class dem {

    public void welcome() {
        System.out.println("WelCome Program");
    }
    public String pen(int a){
        if(a>=10)
        return "You will get Pen";
        else
            return "Insufficient Rupees";
    }
}
    class main1 {
        public static void main(String[] args) {
            dem dem= new dem();
            dem.welcome();
           String s= dem.pen(10);
            System.out.println(s);
        }
    }

