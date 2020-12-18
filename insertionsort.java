import java.util.*;
public class sort {
    static Scanner reader = new Scanner(System.in);
    static  int down = 0, temp, index, input;

    public static void main(String args[]) {
        long zeittEnde, zeit, zeitAnfang;
        sort s = new sort();
        s.input();
        int arr[] = new int[input];
        int arrDown[] = new int[input];
        int arrRnd[] = new int[input];
        int arrTemp[] = new int[input];

        s.fill(arr, arrDown, arrRnd, arrTemp);

        zeitAnfang = System.nanoTime();
        s.insertionsort(arr);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde - zeitAnfang;
        System.out.println("Insertionsort aufwärts sortieren (0-99): " + zeit);

        zeitAnfang = System.nanoTime();
        s.insertionsort(arrDown);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde - zeitAnfang;
        System.out.println("Insertionsort aufwärts sortieren (0-99): " + zeit);

        zeitAnfang = System.nanoTime();
        s.insertionsort(arrRnd);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde - zeitAnfang;
        System.out.println("Insertionsort random: " + zeit);
        System.out.println("");

        zeitAnfang = System.nanoTime();
        s.bubbleSort(arr);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Bubblesort aufwärts sortieren (0-99): " + zeit);

        zeitAnfang = System.nanoTime();
        s.bubbleSort(arrDown);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Bubblesort umgekehrt sortier (99-0): "+ zeit);

        zeitAnfang = System.nanoTime();
        s.bubbleSort(arrRnd);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Random Bubblesort: " + zeit);
        System.out.println("");

        zeitAnfang = System.nanoTime();
        s.binarysort(arr);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Binarysort aufwärts (0-99): " + zeit);

        zeitAnfang = System.nanoTime();
        s.binarysort(arrDown);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Binarysort abwärts (99-0): " + zeit);


        zeitAnfang = System.nanoTime();
        s.binarysort(arrRnd);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Random Binarysort: " + zeit);


       // s.output(arr, arrDown, arrRnd);


    }

    void input(){
        System.out.println("In welchem Bereich? ");
        input = reader.nextInt();
    }
    void fill(int[] arr, int[] arrDown, int[] arrRnd, int[] arrTemp){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            arrTemp[i] = i;
        }
        for (int i = 0; i < arrDown.length; i++) {
            arrDown[i] = down;
            down++;
        }
        for (int i = 0; i < arrRnd.length; i++) {
            Random rnd = new Random();
            index = rnd.nextInt(arrTemp.length - i);
            arrRnd[i] = arrTemp[index];
            temp = arrTemp[arrTemp.length - i - 1];
            arrTemp[arrTemp.length - i - 1] = arrTemp[index];
            arrTemp[index] = temp;
        }
    }
    void insertionsort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public void binarysort(int arr[]) {
        for (int i = 1; i < arr.length; i++)
        {
            int x = arr[i];
            int j = Math.abs(
                    Arrays.binarySearch(arr, 0,
                            i, x) + 1);
            System.arraycopy(arr, j,
                    arr, j + 1, i - j);
            arr[j] = x;
        }
    }
    void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
    /*void output(int[] arr, int[] arrDown, int[] arrRnd){
        System.out.println("Insertionsort");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arrDown.length; i++) {
            System.out.print(arrDown[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arrRnd.length; i++) {
            System.out.print(arrRnd[i] + " ");
        }
        System.out.println("");

        System.out.println("Bubblesort");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        for(int i = 0; i < arrDown.length; i++) {
            System.out.print(arrDown[i] + " ");
        }
        System.out.println("");
        for(int i = 0; i < arrRnd.length; i++) {
            System.out.print(arrRnd[i] + " ");
        }
    }*/
}
