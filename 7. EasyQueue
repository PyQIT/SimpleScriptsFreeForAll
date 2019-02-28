import java.util.Scanner;

class Queue{
    int[] tab;
    int putLock,getLock;

    Queue(int size){
        tab = new int[size];
        putLock = getLock = 0;
    }

    void put(int num){
        if(putLock == tab.length)
            System.out.println("Kolejka pełna");
        else
            tab[putLock++] = num;
    }

    int get(){
        if(getLock == putLock) {
            System.out.println("Kolejka pełna");
            return -1;
        }
        return  tab[getLock++];
    }
}

public class App{
    public static void main(String[] args){
        Queue que = new Queue(10);
        int num;
        Scanner userDecision = new Scanner(System.in);

        for(int i = 0; i <= 10; i++){
            num = userDecision.nextInt();
            que.put(num);
        }

        userDecision.close();
        System.out.println();

        for(int i = 0; i <= 10; i++){
            System.out.println(que.get());
        }
    }
}
