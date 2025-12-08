import java.util.Arrays;

public class arr1 {

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        for (int i : a) {
//            System.out.println(i);
//        }
//        int [][] a;
//        a= new int[2][];
//        a[0]=new int[4];
//        a[1]=new int[3];
//
//        a[0][1]=20;
//        a[0][2]=30;
//        a[1][0]=40;
//        a[1][1]=50;
//        for (int[] i :a){
//        System.out.println(Arrays.toString(i));
//            System.out.println(a[1].length);
    //}
//        int [][]a={{1,2,3,4},{5,6},{7,8,9}};
//        for (int i=0;i<a.length;i++)
//        {
//            for (int j=0;j<a[i].length;j++){
//                System.out.print(a[i][j]);
//            }
//            System.out.println();
//        }
        int[][][] a ={{{1,2,3,4},{5,6},{7,8,9}}};
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                for (int k=0;k<a[i][j].length;k++){
                    System.out.print(a[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
}}

