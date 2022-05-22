public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 1000;
        System.out.println(n);
        while(n>0){
            Thread.sleep(100);
            System.out.println(n-7);

            n-=7;
        }
    }
}
