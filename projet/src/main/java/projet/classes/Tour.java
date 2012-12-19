package projet.classes;

//Classe Tour

public class Tour extends Piece {

	// Constructeur de la Tour
	public Tour() {	
		super();				// Permet de manipuler les données de la "superclasse"
	}

	// Méthode pour l'affichage de la Tour sur la case
	public String toString() {
		return "T";
	}

}