class MyClass<T>{
    T ob;

    MyClass(T o){
        ob = o;
        System.out.println(ob);
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass<Integer> ob = new MyClass<Integer>(34);

        MyClass<String> ok = new MyClass<String>("Hello nice to meet you");
    }

}
