import java.util.Scanner;

public class fibonacci {
    static Scanner reader = new Scanner(System.in);
    static int end, fibonacciNew = 1, fibonacciOld, count;
    public static void main(String[] args){
        input();
        System.out.println(fibonacci(fibonacciNew));
        //System.out.println(fibonacciOld);
        //System.out.println(end);
    }
    public static void input(){
        System.out.println("Zahl: ");
        end = reader.nextInt();
    }
    public static int fibonacci(int fibonacciNew){
        fibonacciNew = fibonacciOld;
        count++;
        if(end == count){
            return 1;
        }
        /*else {
            fibonacciNew = fibonacciNew+fibonacciOld;
            return fibonacciNew;
        }*/
            return fibonacci((fibonacciNew+fibonacciOld));


    }


}
