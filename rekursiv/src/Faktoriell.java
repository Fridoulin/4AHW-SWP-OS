import java.util.Scanner;

public class Faktoriell {
    static int base, factor, count;

    public static void main(String[] args) {
        input();
        System.out.println(getFactor(base,factor));
    }
    public static void input(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Basis: ");
        base = reader.nextInt();
        if(base < 0){
            System.exit(0);
        }
        System.out.println("Faktor: ");
        factor = reader.nextInt();
        if(factor < 0){
            System.exit(0);
        }
    }

    public static int getFactor(int base, int factor) {
        if (factor == 0) {
            return 1;
        } else {
            return base*getFactor(base,factor-1);
        }
    }



}

