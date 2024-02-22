import java.util.Scanner;
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
        Scanner input = new Scanner(System.in);

        System.out.print("Enter hourly rate: ");
        double hourlyRate = input.nextDouble();

        System.out.print("Enter hours worked: ");
        int hoursWorked = input.nextInt();

        for (Employe employe : listeEmployes) {
            employe.calculerSalaire(hourlyRate, hoursWorked);
            System.out.println("Salaire de " + employe.getNom() + " " + employe.getPrenom() +
                    " calculé: " + employe.getSalaire());
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

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static GestionnaireEmployes employeeManager = new GestionnaireEmployes();

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();

            choice = getUserChoice();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployeeList();
                    break;
                case 3:
                    calculateSalaries();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 0:
                    System.out.println("Exiting the Employee Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\nEmployee Management System");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee List");
        System.out.println("3. Calculate Salaries");
        System.out.println("4. Remove Employee");
        System.out.println("0. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private static void addEmployee() {
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary;
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number for salary.");
            scanner.next(); // Consume the invalid input
        }
        salary = scanner.nextDouble();

        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter employee start date: ");
        String date = scanner.nextLine();

        Employe newEmployee = new Employe(name, surname, salary, date);
        employeeManager.ajouterEmploye(newEmployee);
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployeeList() {
        System.out.println("\nCurrent Employee List:");
        employeeManager.afficherListeEmployes();
    }

    private static void calculateSalaries() {
        System.out.println("\nCalculating Salaries:");
        employeeManager.calculerSalaires();
    }

    private static void removeEmployee() {
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter the name of the employee to remove: ");
        String name = scanner.nextLine();

        System.out.print("Enter the surname of the employee to remove: ");
        String surname = scanner.nextLine();

        employeeManager.supprimerEmploye(name, surname);
    }
}
