public class Main {

    public static void main(String[] args) throws Exception {
    
        System.out.println("To end program press \"T\"");
        
        for(int i = 0; (char)System.in.read() != 'T';i++)
            System.out.println(i);
    }
}
