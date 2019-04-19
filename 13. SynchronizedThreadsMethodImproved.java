class MyClass{

    synchronized void test(String name) throws InterruptedException{
        Thread.sleep(400);
        System.out.println(name+ " wywołał funkcję test");
        for(int i = 0; ;i++) {
            if (i == 20000) {
                System.out.println(name + " wartosc interatora: " + i);
                Thread.sleep(200);
                break;
            }
        }
    }
}

class MyThread implements Runnable {
    Thread thrd;

    static MyClass m = new MyClass();

    MyThread(String name) {
        thrd = new Thread(this,name);
        thrd.start();
    }


    @Override
    public void run() {
        System.out.println("Watek " + thrd.getName() + " rozpoczal dzialanie.");

        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(200);
                m.test(thrd.getName());
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
        MyThread mt2 = new MyThread("Watek potomny 2");
        MyThread mt3 = new MyThread("Watek potomny 3");

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



        System.out.println("\nWatek glowny konczy prace.");
    }
}
