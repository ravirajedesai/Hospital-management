public class arr {
    public static void main(String[] args) {
//        int[] a={1,2,3,4,5};
//        a[2]=4;
//        for (int i=0;i<a.length;i++){
//        System.out.println(a[i]);
//        }
//        int [] num=new int[4];
//        num [0]=1;
//        num [1]=10;
//        num [2]=20;
//        num [3]=30;
//        System.out.println(num[3]);
        int num[][]=new int[4][5];
        for (int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                System.out.print(num[i][j]+" ");
            }
            System.out.println( );
        }
    }
}
