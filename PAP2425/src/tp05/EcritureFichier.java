package tp05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class EcritureFichier {
	// Définition d'une Ligne
	public record Achat(String prenom, String nom, double montant) {
	};

	/*-
	 * Pour faire le test, il faut adapter le chemin du fichier ci-dessous
	 * 
	 */
	public static void main(String[] args) {
		// crée une liste d'achat
		List<Achat> achats = new ArrayList<>();
		achats.add(new Achat("Didier", "VO", 124.90));
		achats.add(new Achat("Lola", "COOL", 123.77));
		// rajoute les achats à la fin du fichier
		try (var out = new BufferedWriter(new FileWriter("c:\\aaa\\listeAchats.txt", Charset.forName("utf8"), true));) {
			for (var achat : achats)
				out.append(achat.prenom + ";" + achat.nom + ";" + Double.toString(achat.montant) + "\n");
			System.out.println("Fini");
		} catch (IOException e) {
			System.err.println("Ouups erreur: " + e);
		}
	}

}
