class MyThread implements Runnable {
    Thread thrd;

    MyThread(String name) {
        thrd = new Thread(this,name);
        thrd.start();
    }

    @Override
    public void run() {
        System.out.println("Watek " + thrd.getName() + " rozpoczal dzialanie.");

        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("\n" + thrd.getName() + " jest wykonywany, wartosc licznika: " + count);

            }
        } catch (InterruptedException ex) {
            System.out.println("Watek glowny zostal przerwany");
        }
        System.out.println(thrd.getName() + " kończy działanie");
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("\nWatek glowny rozpoczal dzialanie");
        MyThread mt = new MyThread("Watek potomny 1");

        for(int i = 0; i < 30; i++){
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
