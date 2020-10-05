package binaereSuche;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class binaereSuche {
	static Scanner reader = new Scanner(System.in);
	static int suchbereich;
	static int number;
	static boolean gefundenB = false;
	static boolean gefundenS = false;
	static int zahl;
	static int count = 0, countL = 0, countR = 0;
	static int[] zahlen;
	static int middle, zahlL, zahlR;
	static long zeitSequentiellEnde,zeitSequentiellAnfang,zeitSequentiell, zeitBinaer, zeitBinaerAnfang, zeitBinaerEnde;
	public static void main(String[] args) {
		binaereSuche suche = new binaereSuche();
		suche.eingabe();
		suche.rnd();
		suche.binaerSuche();
		suche.sequentielleSuche();
		int sequentiell = new Long(zeitSequentiell).intValue();
		int binaer = new Long(zeitBinaer).intValue();
		int faktor = sequentiell/binaer;
		System.out.println(faktor +" Mal schneller");
				
	}
	void eingabe() {
		System.out.print("Suchbereich: ");
		suchbereich = reader.nextInt();
		zahlen = new int [suchbereich];
		System.out.print("Zahl zum Suchen: ");
		number = reader.nextInt();
	}
	void rnd() {
		Random rnd = new Random();
		for(int i = 0; i < zahlen.length; i++) {
			zahlen[i] = rnd.nextInt(suchbereich);	
		}
		Arrays.sort(zahlen);
		for(int i = 0; i < zahlen.length; i++) {
		//System.out.println(zahlen[i]);
		}
	}
	void binaerSuche() {
		long zeitBinaerAnfang = System.nanoTime();
		middle = zahlen.length / 2;
		int zahlL = zahlen[0], zahlR = zahlen[zahlen.length - 1];
		for (int i = 0; i < zahlen.length; i++) {		
			if (zahlen[middle] == number) {
				gefundenB = true;
				break;
			}
			if (zahlen[middle] > number) {
				zahlR = zahlen[middle];
				zahlen[middle] = (zahlR + zahlL) / 2;
				//System.out.println("Suchbereich > gesuchte Zahl ("+ zahlen[middle] +")" );
				countR++;
			}
			if (zahlen[middle] < number) {
				zahlL = zahlen[middle];
				zahlen[middle] = (zahlR + zahlL) / 2;
				//System.out.println("Suchbereich < gesuchte Zahl ("+ zahlen[middle] + ")");
				countL++;			
			}
			if (zahlL > zahlR) {
				//System.out.println("Zahl wurde nicht gefunden");		
				break;
			}
		}
		if (gefundenB == true) {
			zeitBinaerEnde = System.nanoTime();
			zeitBinaer = zeitBinaerEnde - zeitBinaerAnfang;
			System.out.println(zeitBinaer + " Nanosekunden Binaer");
			System.out.println("Zahl wurde gefunden");
			count = countL + countR;
			System.out.println("Versuche: "+count);
		}
		System.out.println();
	}
	void sequentielleSuche() {
		long zeitSequentiellAnfang = System.nanoTime();
		for (int i = 0; i < zahlen.length; i++) {
			if (zahlen[i] == number) {
				gefundenS = true;
				zeitSequentiellEnde = System.nanoTime();
				zeitSequentiell = zeitSequentiellEnde - zeitSequentiellAnfang;
				System.out.println(zeitSequentiell + " Nanosekunden Seqentiell");
				break;
			}
		}
		if (gefundenS == true) {
			System.out.println("Zahl wurde gefunden");
		} 
		else {
			System.out.println("Zahl wurde nicht gefunden");
		}
	}

}