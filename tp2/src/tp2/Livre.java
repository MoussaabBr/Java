package tp2;

import java.util.ArrayList;
import java.util.List;

public class Livre {
	private String titre;
	private String auteur;
	private int annee_publication;
	
	//Constructeur
	
	public Livre(String titre, String auteur, int annee_publication) {
		this.titre = titre;
        this.auteur = auteur;
        this.annee_publication = annee_publication;
	}
	
	public void afficherDetails() {
        System.out.println("Titre: " + titre);
        System.out.println("Auteur: " + auteur);
        System.out.println("Année de publication: " + annee_publication);
    }
}

class Bibliotheque {
    private List<Livre> livres;

    // Constructeur
    public Bibliotheque() {
        this.livres = new ArrayList<>();
    }

    // ajout des livres
    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    
    public void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("La bibliothèque est vide.");
        } else {
            System.out.println("Livres dans la bibliothèque:");
            for (Livre livre : livres) {
                livre.afficherDetails();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        
        Bibliotheque bibliotheque = new Bibliotheque();

        // ajout des livres
        Livre livre1 = new Livre("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Livre livre2 = new Livre("1984", "George Orwell", 1949);
        Livre livre3 = new Livre("Pride and Prejudice", "Jane Austen", 1813);

        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);
        bibliotheque.ajouterLivre(livre3);

        // affichage
        bibliotheque.afficherLivres();
    }
}
