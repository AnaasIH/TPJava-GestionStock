import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        int choix;

        System.out.println("=== Gestion des Produits ===");

        while (true) {
            // Affichage du menu
            System.out.println("\n--- MENU ---");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne après le nextInt()

            if (choix == 5) {
                System.out.println("Fin du programme. Au revoir !");
                break; // Quitter la boucle
            }

            switch (choix) {
                case 1:
                    List<Produit> liste = metier.getAll();
                    if (liste.isEmpty()) {
                        System.out.println("La liste des produits est vide.");
                    } else {
                        System.out.println("--- Liste des produits ---");
                        for (Produit p : liste) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Entrez l'ID du produit à rechercher : ");
                    long idRecherche = scanner.nextLong();
                    Produit pTrouve = metier.findById(idRecherche);
                    if (pTrouve != null) {
                        System.out.println("Produit trouvé : " + pTrouve);
                    } else {
                        System.out.println("Aucun produit ne correspond à cet ID.");
                    }
                    break;

                case 3:
                    System.out.println("--- Ajout d'un produit ---");
                    System.out.print("ID : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consommer le saut de ligne
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consommer le saut de ligne
                    System.out.print("Description : ");
                    String desc = scanner.nextLine();
                    System.out.print("Nombre en stock : ");
                    int stock = scanner.nextInt();

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, desc, stock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté avec succès !");
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    long idSuppression = scanner.nextLong();
                    metier.delete(idSuppression);
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
}