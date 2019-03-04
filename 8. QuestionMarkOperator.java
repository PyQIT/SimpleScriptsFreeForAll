import java.util.Scanner;

public class App{
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        String com = s.nextLine();
        s.close();

        String t = com.equals("Hello") ? "Nice" : "Sad";
        System.out.println(t);
    }
}
