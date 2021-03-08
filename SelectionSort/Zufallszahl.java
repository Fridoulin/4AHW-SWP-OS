import java.util.Random; // Importanweisung um auf die Random Klasse zuzugreifen

public class Zufallszahl {

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            Random zufall = new Random(); // neues Random Objekt, namens zufall
            int zufallsZahl = zufall.nextInt(10); //Ganzahlige Zufallszahl zwischen 0 und 10
            int zufallsZahlZwei = zufall.nextInt(100);//Ganze Zufallszahl zwischen 0 und 100

            System.out.println(zufallsZahl);
          //  System.out.println(zufallsZahlZwei);
        }
    }
}