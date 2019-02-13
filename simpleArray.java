public class Main {

    public static void main(String[] args) {
        int[] array = new int[20];

        for(int i = 0; i < array.length; i++)
            array[i] = i;

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}
