enum TrafficLightColor{
        GREEN, YELLOW, RED, YELLOW1
}

class TrafficLightSimulator implements  Runnable{
    private Thread thd;
    private TrafficLightColor tmp;
    boolean stop = false;
    boolean change = false;

    TrafficLightSimulator(){
        tmp = TrafficLightColor.RED;
        thd = new Thread(this);
        thd.start();
    }

    public void run(){
        while(!stop){
            try{
                switch (tmp){
                    case RED:
                        Thread.sleep(5000);
                        break;
                    case YELLOW:
                        Thread.sleep(2000);
                        break;
                    case GREEN:
                        Thread.sleep(5000);
                        break;
                    case YELLOW1:
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
            case RED:
                tmp = TrafficLightColor.YELLOW1;
                break;
            case YELLOW:
                tmp = TrafficLightColor.RED;
                break;
            case GREEN:
                tmp = TrafficLightColor.YELLOW;
                break;
            case YELLOW1:
                tmp = TrafficLightColor.GREEN;
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
        if(tmp == TrafficLightColor.YELLOW1) {
            tmp2 = TrafficLightColor.YELLOW;
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
