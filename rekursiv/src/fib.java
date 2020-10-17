import java.util.Scanner;

public class fib {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Zahl: ");
        int number = reader.nextInt();
        for(int i = 1; i <=number; i++) {
            System.out.println(fib(i));
        }
        reader.close();
    }


    public static int fib (int numberCur){
        if(numberCur == 1 || numberCur == 2){
            return 1;
        } else { return fib(numberCur-1)+fib(numberCur-2);
        }
    }

}
