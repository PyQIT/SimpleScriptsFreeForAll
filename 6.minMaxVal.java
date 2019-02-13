import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[100];
        int min,max;

        for(int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(1200)-200;

        for(int i = 0; i < array.length; i++)
            System.out.println(array[i] + " ");

        min = max = array[0];

        for(int i = 0; i < array.length; i++){
            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
        }

        System.out.println("The highest value:" + max);
        System.out.println("The lowest value:" + min);
    }
}
