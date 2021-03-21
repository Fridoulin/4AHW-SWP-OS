import java.util.*;

public class sort {
    static Scanner r = new Scanner(System.in);
    static int avgBVGL, avgB, avgIVGL,avgI , avgSVGL, avgS, avgSSVGL, avgSS, medianB, medianBVGL, medianI, medianIVGL, medianS, medianSVGL, medianSS, medianSSVGL,arrLength, rndSize;
    static ArrayList<Long> insertionVergleiche = new ArrayList<>();
    static ArrayList<Long> insertionVerschieben = new ArrayList<>();
    static ArrayList<Long> bubbleVergleriche = new ArrayList<>();
    static ArrayList<Long> bubbleVerschieben = new ArrayList<>();
    static ArrayList<Long> selectionVergleiche = new ArrayList<>();
    static ArrayList<Long> selectionVerschieben = new ArrayList<>();
    static ArrayList<Long> stableVergleiche = new ArrayList<>();
    static ArrayList<Long> stableVerschieben = new ArrayList<>();
    static int[]array = new int[100];

    public static void main(String[] args) {
       // input();
        createArray();
        for (int i = 0; i < 100; i++) {
            bubbleSort(array);
            insertionSort(array);
            selectionSort(array);
            stableSelectionSort(array);
        }
        avg();
        median();
        output();
    }
    static void input(){
        System.out.println("Arraylänge: ");
        arrLength = r.nextInt();
        System.out.println("Randombereich: ");
        rndSize = r.nextInt();
    }

    static int[] createArray(){
        array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
            return array;
        }


    static void bubbleSort(int[] array) {
        long tempVergleiche = 0;
        long tempVerschieben = 0;
        int n;
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
        bubbleVergleriche.add(tempVergleiche);
        bubbleVerschieben.add(tempVerschieben);
    }
    static void insertionSort(int[] array){
        long tempVergleiche = 0;
        long tempVerschieben = 0;
        for(int i = 0; i < array.length; i++){
            int key = array[i];
            int j = i-1;
            while (j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j = j - 1;
                tempVerschieben++;
            }
            tempVergleiche++;
            array[j+1] = key;
        }
        insertionVergleiche.add(tempVergleiche);
        insertionVerschieben.add(tempVerschieben);
    }

    static void selectionSort(int[] array) {
        long tempVergleiche = 0;
        long tempVerschieben = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                tempVergleiche++;
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
            tempVerschieben++;
        }
        selectionVergleiche.add(tempVergleiche);
        selectionVerschieben.add(tempVerschieben);
    }

    static void stableSelectionSort(int[] array) {
        long tempVergleiche = 0;
        long tempVerschieben = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                tempVergleiche++;
                if (array[min] > array[j]) {
                    min = j;
                }
                int key = array[min];
                while (min > i) {
                    array[min] = array[min - 1];
                    min--;
                    tempVerschieben++;
                }
                array[i] = key;
            }
        }
        stableVergleiche.add(tempVergleiche);
        stableVerschieben.add(tempVerschieben);
    }
    static void avg(){
        int tempB = 0, tempI = 0, tempS = 0, tempSS = 0;
        for(int i = 0; i < array.length; i++){
            tempB += array[i];
            tempI += array[i];
            tempS += array[i];
            tempSS += array[i];
        }
        avgB =tempB/bubbleVerschieben.size();
        avgBVGL=tempB/bubbleVergleriche.size();
        avgI=tempI/insertionVerschieben.size();
        avgIVGL=tempI/insertionVergleiche.size();
        avgS=tempS/selectionVerschieben.size();
        avgSVGL=tempS/selectionVergleiche.size();
        avgSS=tempSS/stableVerschieben.size();
        avgSSVGL=tempSS/stableVergleiche.size();


    }
    static void median(){
        medianB = bubbleVerschieben.size()/2;
        medianBVGL = bubbleVergleriche.size()/2;
        medianI = insertionVerschieben.size()/2;
        medianIVGL = insertionVergleiche.size()/2;
        medianS = selectionVerschieben.size()/2;
        medianSVGL = selectionVergleiche.size()/2;
        medianSS = selectionVerschieben.size()/2;
        medianSSVGL = selectionVergleiche.size()/2;

    }
    static void output(){
        System.out.println("");
        System.out.println("Buuble Vergleiche: "+bubbleVergleriche.get(0));
        System.out.println("Buuble Verschieben: "+bubbleVerschieben.get(1));
        System.out.println("Bubble Durchschnitt Vergleiche: "+avgBVGL);
        System.out.println("Bubble Durchschnitt Tauschen: "+avgB);
        System.out.println("Bubble Median Vergleiche: "+medianBVGL);
        System.out.println("Bubble Median Tauschen: "+medianB);

        System.out.println("");
        System.out.println("Insertion Vergleiche: "+insertionVergleiche.get(0));
        System.out.println("Insertion Verschieben: "+insertionVerschieben.get(1));
        System.out.println("Insertion Durchschnitt Vergleiche: "+avgIVGL);
        System.out.println("Insertion Durchschnitt Tauschen: "+avgI);
        System.out.println("Insertion Median Vergleiche: "+medianIVGL);
        System.out.println("Insertion Median Tauschen: "+medianI);

        System.out.println("");
        System.out.println("Selection Vergleiche: "+selectionVergleiche.get(0));
        System.out.println("Selection Verschieben: "+selectionVerschieben.get(1));
        System.out.println("Selection Durchschnitt Vergleiche: "+avgSVGL);
        System.out.println("Selection Durchschnitt Tauschen: "+avgS);
        System.out.println("Selection Median Vergleiche: "+medianSVGL);
        System.out.println("Selection Median Tauschen: "+medianS);

        System.out.println("");
        System.out.println("Stable Selection Vergleiche: "+selectionVergleiche.get(0));
        System.out.println("Stable Selection Verschieben: "+selectionVerschieben.get(1));
        System.out.println("Stable Selection Durchschnitt Vergleiche: "+avgSSVGL);
        System.out.println("Stable Selection Durchschnitt Tauschen: "+avgSS);
        System.out.println("Stable Selection Median Vergleiche: "+medianSSVGL);
        System.out.println("Stable Selection Median Tauschen: "+medianSS);
    }

}
