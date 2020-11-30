import java.io.OptionalDataException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bubblesort {
    static Scanner reader = new Scanner(System.in);
    static ArrayList<Integer> rndArray = new ArrayList<>();

    public static void main(String[] args) {
        long zeitSequentiellEnde, zeitSequentiell, zeitSequentiellAnfang;
        int size;


        Bubblesort b = new Bubblesort();
        System.out.println("Wieviele Zahlen: ");
        size = reader.nextInt();

        for(int i = 0; i < size; i++) {
            Random rnd = new Random();
            rndArray.add(rnd.nextInt());
        }
        zeitSequentiellAnfang = System.currentTimeMillis();
        b.bubbleSort();
        zeitSequentiellEnde = System.currentTimeMillis();

        System.out.println(rndArray);



        zeitSequentiell = zeitSequentiellEnde - zeitSequentiellAnfang;
        System.out.println(zeitSequentiell + " Millisekunden wurden benötigt");
    }

    static void bubbleSort(){
        int temp;
        for (int i = 0; i < rndArray.size(); i++) {
            for (int j = 0; j < (rndArray.size()-i-1); j++) {
                if (rndArray.get(j) > rndArray.get(j+1)) {
                    temp = rndArray.get(j);
                    rndArray.set(j, rndArray.get(j+1));
                    rndArray.set(j+1, temp);
                }
            }
        }
    }
}
