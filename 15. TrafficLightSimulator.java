enum TrafficLightColor{
        ZIELONE, ZOLTE, CZERWONE, ZOLTE1
}

class TrafficLightSimulator implements  Runnable{
    private Thread thd;
    private TrafficLightColor tmp;
    boolean stop = false;
    boolean change = false;

    TrafficLightSimulator(){
        tmp = TrafficLightColor.CZERWONE;
        thd = new Thread(this);
        thd.start();
    }

    public void run(){
        while(!stop){
            try{
                switch (tmp){
                    case CZERWONE:
                        Thread.sleep(5000);
                        break;
                    case ZOLTE:
                        Thread.sleep(2000);
                        break;
                    case ZIELONE:
                        Thread.sleep(5000);
                        break;
                    case ZOLTE1:
                        Thread.sleep(2000);
                        break;
                }
            }catch(InterruptedException ex){
                System.out.println(ex);
            }
            changeColor();
        }
    }

    synchronized private void changeColor(){
        switch(tmp){
            case CZERWONE:
                tmp = TrafficLightColor.ZOLTE1;
                break;
            case ZOLTE:
                tmp = TrafficLightColor.CZERWONE;
                break;
            case ZIELONE:
                tmp = TrafficLightColor.ZOLTE;
                break;
            case ZOLTE1:
                tmp = TrafficLightColor.ZIELONE;
        }
        change = true;
        notify();
    }

    synchronized void waitForChange(){
        try{
            while(!change)
                wait();
            change = false;
        }catch (InterruptedException ex){
            System.out.println(ex);
        }
    }

    synchronized TrafficLightColor getColor(){
        TrafficLightColor tmp2;
        if(tmp == TrafficLightColor.ZOLTE1) {
            tmp2 = TrafficLightColor.ZOLTE;
            return tmp2;
        }
        else
            return tmp;
    }

    synchronized void cancel(){
        stop = true;
    }
}

public class Main {

    public static void main(String[] args) {
        TrafficLightSimulator t1 = new TrafficLightSimulator();
        int i = 0;
        do{
            System.out.println(t1.getColor());
            t1.waitForChange();
            i++;
        }while(i < 10);

        t1.cancel();
    }
}
