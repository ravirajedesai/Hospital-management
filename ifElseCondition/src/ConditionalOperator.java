import java.util.Scanner;

public class ConditionalOperator {
    public static void main(String[] args) {

        System.out.println("Enter Number for Day: ");
        Scanner sc = new Scanner(System.in);
        int i= sc.nextInt();
        switch (i){
           case 1:
               System.out.println("Monday");
               break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wensday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Sunday");
        }
    }

}
