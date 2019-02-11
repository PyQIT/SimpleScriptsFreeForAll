import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int userDecision;

        System.out.print("Enter the number to which you want to check the dividers: ");

        Scanner userScanner = new Scanner(System.in);
        userDecision = userScanner.nextInt();

        for(int i = 0; i <= userDecision; i++){
            System.out.print("Dividers for number " + i + ": ");
            for(int j = 1; j <= i;j++) {
                if(i % j == 0)
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
