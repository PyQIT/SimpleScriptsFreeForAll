class Test1{
    int x;

    Test1(int i){
        x = i;
    }

    protected void finalize(){
        System.out.println("Object has been deleted with ID: " + x);
    }

    void generate(int b){
        Test1 a = new Test1(b);
    }
}

public class Main {

    public static void main(String[] args) {
        Test1 n = new Test1(0);

        for(int i = 0; i < 100000; i++)
            n.generate(i);
    }
}
