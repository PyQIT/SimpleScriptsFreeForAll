class MyThread implements Runnable {
    private String thrdName;

    MyThread(String name) {
        thrdName = name;
    }

    @Override
    public void run() {
        System.out.println("Watek " + thrdName + " rozpoczal dzialanie.");

        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(800);
                System.out.println("\n" + thrdName + " jest wykonywany, wartosc licznika: " + count);

            }
        } catch (InterruptedException ex) {
            System.out.println("Watek glowny zostal przerwany");
        }
        System.out.println(thrdName + " kończy działanie");
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("\nWatek glowny rozpoczal dzialanie");
        MyThread mt = new MyThread("Watek potomny 1");

        Thread newThread = new Thread(mt);

        newThread.start();

        for(int i = 0; i < 50; i++){
            System.out.print(".");
            try{
                Thread.sleep(200);
            }catch(InterruptedException ex){
                System.out.println("\nWatek glowny zostal przerwany");
            }
        }
        System.out.println("\nWatek glowny konczy prace.");
    }
}
