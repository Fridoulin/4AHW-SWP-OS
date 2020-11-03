import java.util.Scanner;

public class fib {
    public static void main(String[] args){
        System.out.println(fibkontrolle(20));
    }
    public static int fibkontrolle(int n){
        return fib(n-1, 1, 0);
    }

    public static int fib(int n, int fibzahl1, int fibzahl2){
        if(n<=1){
            return fibzahl1+fibzahl2;
        }
        return fib(n-1, fibzahl1+fibzahl2, fibzahl1);
    }
}
