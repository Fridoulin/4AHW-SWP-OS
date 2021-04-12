import java.util.*;

public class sortVGL {
    static Scanner r = new Scanner(System.in);
    static ArrayList<Long> insertionVergleiche = new ArrayList<>();
    static ArrayList<Long> insertionVerschieben = new ArrayList<>();
    static ArrayList<Long> insertionZeit = new ArrayList<>();

    static ArrayList<Long> bubbleVergleiche = new ArrayList<>();
    static ArrayList<Long> bubbleVerschieben = new ArrayList<>();
    static ArrayList<Long> bubbleZeit = new ArrayList<>();

    static ArrayList<Long> selectionVergleiche = new ArrayList<>();
    static ArrayList<Long> selectionVerschieben = new ArrayList<>();
    static ArrayList<Long> selectionZeit = new ArrayList<>();

    static ArrayList<Long> stableVergleiche = new ArrayList<>();
    static ArrayList<Long> stableVerschieben = new ArrayList<>();
    static ArrayList<Long> stableZeit = new ArrayList<>();
    static int arrSize, rndSize, loopSize;

    public static void main(String[] args) {
        //program arguments
        for(int i = 0; i < args.length; i++){
            arrSize = Integer.parseInt(args[0]);
            rndSize = Integer.parseInt(args[1]);
            loopSize = Integer.parseInt(args[2]);
        }
        //cmd
/*
        System.out.println("Arraygröße: ");
        arrSize = r.nextInt();
        System.out.println("Randombereich: ");
        rndSize = r.nextInt();
        System.out.println("Wiederholungen");
        loopSize = r.nextInt();
*/
        for(int i = 0; i < 100; i++) {
            int[] array = createArray();
            bubbleSort(copyArray(array));
            insertionSort(copyArray(array));
            selectionSort(copyArray(array));
            stableSelectionSort(copyArray(array));
        }
    }
    static int[] createArray() {
        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
    static int[] copyArray(int[] arrCopy) {
        int[] array = new int[1000];
        for (int i = 0; i < arrCopy.length; i++) {
            array[i] = arrCopy[i];
        }
        return array;
    }
    static void bubbleSort(int[] array) {
        long tempVergleiche = 0;
        long tempVerschieben = 0;
        int n;
        long tempZeitAnfang = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            for (int k = 0; k < (array.length - i); k++) {
                if (array[k] > array[k + 1]) {
                    n = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = n;
                    tempVergleiche++;
                }
                tempVerschieben++;
            }
        }
        long tempZeitEnde = System.nanoTime();
        bubbleZeit.add(tempZeitEnde-tempZeitAnfang);
        bubbleVergleiche.add(tempVergleiche);
        bubbleVerschieben.add(tempVerschieben);
        System.out.println("Bubblesort: ");
        output(bubbleVergleiche, bubbleVerschieben, bubbleZeit);
    }
    static void insertionSort(int[] array){
        long tempVergleiche = 0;
        long tempVerschieben = 0;
        long tempZeitAnfang = System.nanoTime();
        for(int i = 0; i < array.length; i++){
            int key = array[i];
            int j = i-1;
            tempVergleiche++;
            while (j >= 0 && array[j] > key){
                tempVerschieben++;
                array[j+1] = array[j];
                j = j - 1;
            }
            array[j+1] = key;
        }
        long tempZeitEnde = System.nanoTime();
        insertionZeit.add(tempZeitEnde-tempZeitAnfang);
        insertionVergleiche.add(tempVergleiche);
        insertionVerschieben.add(tempVerschieben);
        System.out.println("Interstionsort: ");
        output(insertionVergleiche, insertionVerschieben, insertionZeit);
    }
    static void selectionSort(int[] array) {
        long tempVergleiche = 0;
        long tempVerschieben = 0;
        int n = array.length;
        long tempZeitAnfang = System.nanoTime();
        for (int i = 0; i < n - 1; i++) { int min = i;
            for (int j = i + 1; j < n; j++) {
                tempVergleiche++;
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            if(array[min]!=array[i]){
                tempVerschieben++;
            }
            array[min] = array[i];
            array[i] = temp;
        }
        long tempZeitEnde = System.nanoTime();
        selectionZeit.add(tempZeitEnde-tempZeitAnfang);
        selectionVergleiche.add(tempVergleiche);
        selectionVerschieben.add(tempVerschieben);
        System.out.println("Selectionsort: ");
        output(selectionVergleiche, selectionVerschieben, selectionZeit);
    }
    static void stableSelectionSort(int[] array) {
        long tempVergleiche = 0;
        long tempVerschieben = 0;
        int n = array.length;
        long tempZeitAnfang = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                tempVergleiche++;
                if (array[min] > array[j]) {
                    min = j;
                }
                int key = array[min];
                while (min > i) {
                    tempVerschieben++;
                    array[min] = array[min - 1];
                    min--;
                }
                array[i] = key;
            }
        }
        long tempZeitEnde = System.nanoTime();
        stableZeit.add(tempZeitEnde-tempZeitAnfang);
        stableVergleiche.add(tempVergleiche);
        stableVerschieben.add(tempVerschieben);

        System.out.println("Stable Selcetionsort");
        output(stableVergleiche, stableVerschieben, stableZeit);
    }
    static long avg(ArrayList<Long> array){
        long temp = 0, avg;
        for(int i = 0; i < array.size(); i++){
            temp += array.get(i);
        }
        avg = temp/array.size();
        return avg;
    }
    static long median (ArrayList<Long> array){
        Collections.sort(array);
        long median;
        median = array.get(array.size()/2);
        return median;
    }
    static void output(ArrayList<Long> vergleiche, ArrayList<Long> verschieben, ArrayList<Long> zeit){
        System.out.println("Durchschnitt Vergleiche: "+avg(vergleiche));
        System.out.println("Durchschnitt Verschbiebungen: "+avg(verschieben));
        System.out.println("Median Vergleiche: "+median(vergleiche));
        System.out.println("Median Verschiebungen: "+median(verschieben));
        System.out.println("Zeit in Nanosekunden: "+avg(zeit));
        System.out.println("");
    }
}
