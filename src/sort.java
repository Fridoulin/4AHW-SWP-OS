import java.util.*;
public class sort {    static Scanner reader = new Scanner(System.in);
    static  int down = 0, temp, index, arraySize, rangeRnd, vergleich, verschieben, vergleichStable, verschiebenStable;

    public static void main(String args[]) {
        long zeittEnde, zeit, zeitAnfang;
        sort s = new sort();
        s.input();
        int arr[] = new int[arraySize];
        int arrDown[] = new int[arraySize];
        int arrRnd[] = new int[arraySize];
        int arrTemp[] = new int[arraySize];

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
        s.binaryInsertionSort(arr);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Binary Insertion Sort aufwärts (0-99): " + zeit);

        zeitAnfang = System.nanoTime();
        s.binaryInsertionSort(arrDown);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Binary Insertion Sort abwärts (99-0): " + zeit);


        zeitAnfang = System.nanoTime();
        s.binaryInsertionSort(arrRnd);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Random Binary Insertion Sort: " + zeit);

        System.out.println("");
        System.out.println("");
        zeitAnfang = System.nanoTime();
        s.selectionSort(arr);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Selection Sort aufwärts (0-99): " + zeit);
        //System.out.println(vergleichStable + "Selection Sort aufwärts (vergleiche)");
        //System.out.println(vergleichStable + "Selection Sort aufwärts (verschoben)");
        //System.out.println("");

        zeitAnfang = System.nanoTime();
        s.selectionSort(arrDown);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Selection Sort abwärts (99-0): " + zeit);
        //System.out.println(vergleichStable + "Selection Sort abwärts (vergleiche)");
        //System.out.println(vergleichStable + "Selection Sort abwärts (verschoben)");
        //System.out.println("");

        zeitAnfang = System.nanoTime();
        s.selectionSort(arrRnd);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Random Selection Sort: " + zeit);
        //System.out.println(vergleichStable + "Selection Sort Random (vergleiche)");
        //System.out.println(vergleichStable + "Selection Sort Random (verschoben)");
        //System.out.println("");

        System.out.println("");
        zeitAnfang = System.nanoTime();
        s.stableSelectionSort(arr, arr.length);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Stable Selection Sort aufwärts (0-99): " + zeit);
        //System.out.println(vergleichStable + "Stable Selection Sort aufwärts (vergleiche)");
        //System.out.println(vergleichStable + "Stable Selection Sort aufwärts (verschoben)");
        //System.out.println("");

        zeitAnfang = System.nanoTime();
        s.stableSelectionSort(arrDown, arrDown.length);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Stable Selection Sort abwärts (99-0): " + zeit);
        //System.out.println(vergleichStable + "Stable Selection Sort abwärts (vergleiche)");
        //System.out.println(vergleichStable + "Stable Selection Sort abwärts (verschoben)");
        //System.out.println("");

        zeitAnfang = System.nanoTime();
        s.stableSelectionSort(arrRnd, arrRnd.length);
        zeittEnde = System.nanoTime();
        zeit = zeittEnde  - zeitAnfang;
        System.out.println("Random Stable Selection Sort: " + zeit);
        //System.out.println(vergleichStable + "Stable Selection Sort Random (vergleiche)");
        //System.out.println(vergleichStable + "Stable Selection Sort Random (verschoben)");
        // s.output(arr, arrDown, arrRnd);
    }
    void input(){
        System.out.println("Größe Array? ");
        arraySize = reader.nextInt();
        System.out.println("In welchem random Bereich? ");
        rangeRnd = reader.nextInt();
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
            int range = rnd.nextInt(rangeRnd);
            index = range;
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
    public void binaryInsertionSort(int arr[]) {
        int length = arr.length;

        for (int i = 1; i < length; ++i) {
            int key = arr[i];
            int insertedPosition = findPosition(arr, 0, i - 1, key);

            for (int j = i - 1; j >= insertedPosition; --j) {
                arr[j + 1] = arr[j];
            }

            arr[insertedPosition] = key;
        }
    }
    public static int findPosition(int[] arr, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
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
    void selectionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                vergleich++;
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            int temp = arr[min_idx];
            verschieben++;
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    static void stableSelectionSort(int[] a, int n)
    {
        for (int i = 0; i < n - 1; i++)
        {
            int min = i;
            for (int j = i + 1; j < n; j++){
                vergleichStable++;
                if (a[min] > a[j])
                    min = j;
            }
            int key = a[min];
            while (min > i)
            {
                verschiebenStable++;
                a[min] = a[min - 1];
                min--;
            }

            a[i] = key;
        }
    }
}

