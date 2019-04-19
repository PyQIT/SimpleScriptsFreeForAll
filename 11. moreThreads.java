class MyThread implements Runnable {
    Thread thrd;

    MyThread(String name) {
        thrd = new Thread(this,name);
    }

    @Override
    public void run() {
        System.out.println("Watek " + thrd.getName() + " rozpoczal dzialanie.");

        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(2000);
                System.out.println("\n" + thrd.getName() + " jest wykonywany, wartosc licznika: " + count);

            }
        } catch (InterruptedException ex) {
            System.out.println("Watek glowny zostal przerwany");
        }
        System.out.println(thrd.getName() + " kończy działanie");
    }
}

class MyThread2 implements Runnable {
    Thread thrd;

    MyThread2(String name) {
        thrd = new Thread(this,name);
        thrd.start();
    }

    @Override
    public void run() {
        System.out.println("Watek " + thrd.getName() + " rozpoczal dzialanie.");

        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(1500);
                System.out.println("\n" + thrd.getName() + " jest wykonywany, wartosc licznika: " + count);

            }
        } catch (InterruptedException ex) {
            System.out.println("Watek glowny zostal przerwany");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("\nWatek glowny rozpoczal dzialanie");
        MyThread mt = new MyThread("Watek potomny 1");
        MyThread mt2 = new MyThread("Watek potomny 2");
        MyThread mt3 = new MyThread("Watek potomny 3");

        MyThread2 mt4 = new MyThread2("Watek potomny 4");
        MyThread2 mt5 = new MyThread2("Watek potomny 5");
        MyThread2 mt6 = new MyThread2("Watek potomny 6");

        mt.thrd.start();
        mt2.thrd.start();
        mt3.thrd.start();


        do{
            System.out.print(".");
            try{
                Thread.sleep(500);
            }catch(InterruptedException ex){
                System.out.println("\nWatek glowny zostal przerwany");
            }
        }while( mt.thrd.isAlive() ||
                mt2.thrd.isAlive() ||
                mt3.thrd.isAlive());

        try{

            mt4.thrd.setPriority(Thread.MAX_PRIORITY);
            mt5.thrd.setPriority(Thread.MIN_PRIORITY);

            mt4.thrd.start();
            mt5.thrd.start();
            mt6.thrd.start();

            System.out.println(mt4.thrd.getPriority());
            System.out.println(mt5.thrd.getPriority());
            System.out.println(mt6.thrd.getPriority());


            mt4.thrd.join();
            System.out.println("Watek 4 zakonczyl dzialanie");
            mt5.thrd.join();
            System.out.println("Watek 5 zakonczyl dzialanie");
            mt6.thrd.join();
            System.out.println("Watek 6 zakonczyl dzialanie");
        }catch(InterruptedException ex){
            System.out.println("Watek glowny doznal problemu");
        }

        System.out.println("\nWatek glowny konczy prace.");
    }
}
