import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employe {
    private String nom;
    private String prenom;
    private double salaire;
    private String date;

    public Employe(String nom, String prenom, double salaire, String date) {
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getSalaire() {
        return salaire;
    }

    public String getDate() {
        return date;
    }

    public void calculerSalaire(double hourlyRate, int hoursWorked) {
    	this.salaire = hourlyRate * hoursWorked;
    }
}

public class GestionnaireEmployes {
    private List<Employe> listeEmployes;

    public GestionnaireEmployes() {
        this.listeEmployes = new ArrayList<>();
    }

    public void ajouterEmploye(Employe employe) {
        listeEmployes.add(employe);
    }

    public void afficherListeEmployes() {
        for (Employe employe : listeEmployes) {
            System.out.println("Nom: " + employe.getNom());
            System.out.println("Prénom: " + employe.getPrenom());
            System.out.println("Salaire: " + employe.getSalaire());
            System.out.println("Date: " + employe.getDate());
            System.out.println();
        }
    }

    public void calculerSalaires() {
        for (Employe employe : listeEmployes) {
        	double hourlyRate = 20.0;
            int hoursWorked = 40;

            employe.calculerSalaire(hourlyRate, hoursWorked);
            System.out.println("Salaire de " + employe.getNom() + " " + employe.getPrenom() + " calculé: " + employe.getSalaire());
        }
    }

    public void supprimerEmploye(String nom, String prenom) {
        Iterator<Employe> iterator = listeEmployes.iterator();
        while (iterator.hasNext()) {
            Employe employe = iterator.next();
            if (employe.getNom().equals(nom) && employe.getPrenom().equals(prenom)) {
                iterator.remove();
                System.out.println("Employé avec le nom " + nom + " et le prénom " + prenom + " supprimé.");
                return;
            }
        }
        System.out.println("Aucun employé trouvé avec le nom " + nom + " et le prénom " + prenom);
    }
}
