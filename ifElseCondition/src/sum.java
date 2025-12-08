public class sum {

    static void sum1(int[] no){
        int total=0;
        for (int i:no){
            total=total+i;
        }
        System.out.println("Sum is: "+total);
    }

    public static void main(String[] args) {
        sum.sum1(new int[]{10, 20, 30});

    }

    }

