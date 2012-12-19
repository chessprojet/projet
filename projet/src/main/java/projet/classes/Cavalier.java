package projet.classes;

// Classe Cavalier

public class Cavalier extends Piece {
    
	// Constructeur du Cavalier
	public Cavalier() {	
		super();				// Permet de manipuler les données de la "superclasse"
    }
    
	// Méthode pour l'affichage du Cavalier sur la case
    public String toString() {
    	return "C";
   	}
    
}